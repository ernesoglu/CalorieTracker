package com.ergul.calorietracker.feature.tracker.domain.usecase

import com.ergul.calorietracker.feature.tracker.domain.model.TrackedFood
import com.ergul.calorietracker.feature.tracker.domain.repository.TrackerRepository
import javax.inject.Inject

class DeleteTrackedFood @Inject constructor(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(food: TrackedFood) {
        repository.deleteTrackedFood(food)
    }
}