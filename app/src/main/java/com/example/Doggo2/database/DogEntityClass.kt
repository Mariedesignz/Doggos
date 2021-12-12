package com.example.Doggo2.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Pups")

data class DogEntityClass (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "ID")
    val id: Int = 0,

    @ColumnInfo (name = "Data")
    val imageUrl: String,

        )
