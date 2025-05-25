package com.example.to_do_list.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

// RoomDatabase 선언 - TodoEntity를 관리하며 TodoDao를 노출
@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase : RoomDatabase(){
    abstract fun todoDao(): TodoDao
}