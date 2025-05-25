package com.example.to_do_list.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Room DB 저장을 위한 Entity 정의
@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val isDone: Boolean = false
)