package com.example.to_do_list.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Todo 테이블에 접근하는 DAO(Data Access Object)
interface TodoDao{
    @Query("SELECT * FROM todos")
    suspend fun getAllTools() : List<TodoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    @Query("UPDATE todos SET isDone = :isDone WHERE id = :id")
    suspend fun updateTodoStatus(id: Int, isDone: Boolean)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Query("DELETE FROM todos")
    suspend fun deleteAll()
}