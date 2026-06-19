package com.ergul.calorietracker.feature.tracker.domain.repository

import com.ergul.calorietracker.feature.tracker.domain.model.TrackedFood
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrackerRepository {

    fun getFoodByDate(date: LocalDate): Flow<List<TrackedFood>>

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)
}