package com.ergul.calorietracker.feature.tracker.data.repository

import com.ergul.calorietracker.feature.tracker.data.local.TrackerDao
import com.ergul.calorietracker.feature.tracker.data.local.entity.toTrackedFood
import com.ergul.calorietracker.feature.tracker.data.local.entity.toTrackedFoodEntity
import com.ergul.calorietracker.feature.tracker.domain.model.TrackedFood
import com.ergul.calorietracker.feature.tracker.domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TrackerRepositoryImpl(
    private val trackerDao: TrackerDao,
) : TrackerRepository {
    override fun getFoodByDate(date: LocalDate): Flow<List<TrackedFood>> {
        val dateString = date.format(DateTimeFormatter.ISO_LOCAL_DATE)

        return trackerDao.getFoodsForDate(dateString).map { entities ->
            entities.map { it.toTrackedFood() }
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) =
        trackerDao.insertTrackedFood(food.toTrackedFoodEntity())

    override suspend fun deleteTrackedFood(food: TrackedFood) =
        trackerDao.deleteTrackedFood(food.toTrackedFoodEntity())
}