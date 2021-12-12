package com.example.Doggo2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DogDao {

    @Query ("Select* FROM Pups")
    fun getAll(): Flow<List<DogEntityClass>>

    @Insert
    suspend fun addPal(dogEntityClass: DogEntityClass)

}