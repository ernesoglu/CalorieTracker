package com.ergul.calorietracker.feature.tracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracked_food_table")
data class TrackedFoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val calories: Int,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val mealType: String,
    val amount: Int,
    val date: String
)