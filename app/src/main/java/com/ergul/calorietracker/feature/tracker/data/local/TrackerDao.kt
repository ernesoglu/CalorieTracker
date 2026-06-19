package com.ergul.calorietracker.feature.tracker.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ergul.calorietracker.feature.tracker.data.local.entity.TrackedFoodEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TrackerDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(trackedFoodEntity: TrackedFoodEntity)

    @Delete
    suspend fun deleteTrackedFood(trackedFoodEntity: TrackedFoodEntity)
    
    @Query("SELECT * FROM tracked_food_table WHERE date = :date")
    fun getFoodsForDate(date: String): Flow<List<TrackedFoodEntity>>
}
