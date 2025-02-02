package com.example.massproject_test.data.di

import com.example.massproject_test.data.repository.HomeRepositoryImpl
import com.example.massproject_test.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}