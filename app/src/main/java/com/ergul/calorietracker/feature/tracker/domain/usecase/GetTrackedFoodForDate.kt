package com.ergul.calorietracker.feature.tracker.domain.usecase

import com.ergul.calorietracker.feature.tracker.domain.model.TrackedFood
import com.ergul.calorietracker.feature.tracker.domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class GetTrackedFoodForDate @Inject constructor(
    private val repository: TrackerRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodByDate(date)
    }
}