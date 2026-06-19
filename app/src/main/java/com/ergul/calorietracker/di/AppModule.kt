package com.ergul.calorietracker.di

import androidx.room.Room
import com.ergul.calorietracker.Application
import com.ergul.calorietracker.feature.tracker.data.local.TrackerDao
import com.ergul.calorietracker.feature.tracker.data.local.TrackerDatabase
import com.ergul.calorietracker.feature.tracker.data.repository.TrackerRepositoryImpl
import com.ergul.calorietracker.feature.tracker.domain.repository.TrackerRepository
import com.ergul.calorietracker.feature.tracker.domain.usecase.DeleteTrackedFood
import com.ergul.calorietracker.feature.tracker.domain.usecase.GetTrackedFoodForDate
import com.ergul.calorietracker.feature.tracker.domain.usecase.TrackFood
import com.ergul.calorietracker.feature.tracker.domain.usecase.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideTrackerDatabase(app: Application): TrackerDatabase {
        return Room.databaseBuilder(
            context = app,
            klass = TrackerDatabase::class.java,
            name = "tracker_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTrackerDao(db: TrackerDatabase): TrackerDao {
        return db.trackerDao
    }

    @Provides
    @Singleton
    fun provideTrackerRepository(trackerDao: TrackerDao): TrackerRepository {
        return TrackerRepositoryImpl(trackerDao)
    }

    @Provides
    @Singleton
    fun provideTrackerUseCases(trackerRepository: TrackerRepository): TrackerUseCases {
        return TrackerUseCases(
            GetTrackedFoodForDate(trackerRepository),
            TrackFood(trackerRepository),
            DeleteTrackedFood(trackerRepository)
        )
    }
}