package com.example.to_do_list.domain.repository

import com.example.to_do_list.domain.model.Todo

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun addTodo(todo: Todo)
    suspend fun toggleTodo(id: Int)
    suspend fun deleteTodo(id: Int)
    suspend fun deleteAll()
}