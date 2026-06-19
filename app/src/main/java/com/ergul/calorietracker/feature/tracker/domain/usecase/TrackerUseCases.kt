package com.ergul.calorietracker.feature.tracker.domain.usecase

data class TrackerUseCases(
    val getTrackedFoodForDate: GetTrackedFoodForDate,
    val trackFood: TrackFood,
    val deleteTrackedFood: DeleteTrackedFood
)