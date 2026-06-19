package com.ergul.calorietracker.feature.tracker.presentation.tracker_overview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ergul.calorietracker.feature.tracker.domain.usecase.TrackerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class TrackerOverviewViewModel @Inject constructor(
    private val trackerUseCases: TrackerUseCases
) : ViewModel() {

    var state by mutableStateOf(TrackerOverviewState())
        private set

    private var getFoodsForDateJob: Job? = null

    init {
        getFoodsForDateJob(LocalDate.now())
    }

    fun onEvent(event: TrackerOverviewEvent) {
        when (event) {
            is TrackerOverviewEvent.OnNextDayClick -> {
                val newDate = state.date.plusDays(1)
                getFoodsForDateJob(newDate)
            }

            is TrackerOverviewEvent.OnPreviousDayClick -> {
                val newDate = state.date.minusDays(1)
                getFoodsForDateJob(newDate)
            }

            is TrackerOverviewEvent.OnDeleteTrackedFoodClick -> {
                viewModelScope.launch {
                    trackerUseCases.deleteTrackedFood(event.trackedFood)
                }
            }
        }
    }

    private fun getFoodsForDateJob(date: LocalDate) {
        getFoodsForDateJob?.cancel()

        getFoodsForDateJob = trackerUseCases.getTrackedFoodForDate(date).onEach { foods ->
            val caloriesSum = foods.sumOf { it.calories }
            val proteinSum = foods.sumOf { it.protein }
            val carbsSum = foods.sumOf { it.carbs }
            val fatSum = foods.sumOf { it.fat }

            state = state.copy(
                date = date,
                trackedFoods = foods,
                totalCalories = caloriesSum,
                totalProtein = proteinSum,
                totalCarbs = carbsSum,
                totalFat = fatSum
            )
        }.launchIn(viewModelScope)

    }
}