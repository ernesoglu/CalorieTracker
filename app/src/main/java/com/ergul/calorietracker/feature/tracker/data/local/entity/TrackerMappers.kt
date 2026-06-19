package com.ergul.calorietracker.feature.tracker.data.local.entity

import com.ergul.calorietracker.feature.tracker.domain.model.MealType
import com.ergul.calorietracker.feature.tracker.domain.model.TrackedFood
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE // Format: YYYY-MM-DD

fun TrackedFoodEntity.toTrackedFood(): TrackedFood {
    return TrackedFood(
        id = id,
        name = name,
        calories = calories,
        carbs = carbs,
        protein = protein,
        fat = fat,
        mealType = MealType.valueOf(mealType),
        amount = amount,
        date = LocalDate.parse(date, dateFormatter) // Converts String back to LocalDate
    )
}

fun TrackedFood.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        id = id,
        name = name,
        calories = calories,
        carbs = carbs,
        protein = protein,
        fat = fat,
        mealType = mealType.name,
        amount = amount,
        date = date.format(dateFormatter) // Saves LocalDate as String ("2026-05-15")
    )
}