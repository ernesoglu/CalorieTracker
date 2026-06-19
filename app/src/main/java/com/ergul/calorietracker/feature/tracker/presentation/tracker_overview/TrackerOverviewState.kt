package com.ergul.calorietracker.feature.tracker.presentation.tracker_overview

import com.ergul.calorietracker.feature.tracker.domain.model.TrackedFood
import java.time.LocalDate

data class TrackerOverviewState(
    val date: LocalDate = LocalDate.now(),
    val trackedFoods: List<TrackedFood> = emptyList(),
    val totalCalories: Int = 0,
    val totalProtein: Int = 0,
    val totalCarbs: Int = 0,
    val totalFat: Int = 0,
)