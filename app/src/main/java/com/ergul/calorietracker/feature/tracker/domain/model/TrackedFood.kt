package com.ergul.calorietracker.feature.tracker.domain.model

import java.time.LocalDate

data class TrackedFood(
    val id: Int? = null,
    val name: String,
    val calories: Int,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val mealType: MealType,
    val amount: Int,
    val date: LocalDate
)