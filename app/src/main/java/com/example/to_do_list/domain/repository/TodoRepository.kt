package com.example.to_do_list.domain.repository

import com.example.to_do_list.domain.model.Todo

// 도메인 계층의 Repository 인터페이스
// 실제 구현은 data 계층에서 이루어짐
interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun addTodo(todo: Todo)
    suspend fun toggleTodo(id: Int)
    suspend fun deleteTodo(id: Int)
    suspend fun deleteAll()
}