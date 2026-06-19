package com.ergul.calorietracker.feature.tracker.presentation.tracker_overview

import com.ergul.calorietracker.feature.tracker.domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    object OnNextDayClick: TrackerOverviewEvent()
    object OnPreviousDayClick: TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
}