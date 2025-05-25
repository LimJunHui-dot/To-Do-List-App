package com.example.to_do_list.domain.usecase

import com.example.to_do_list.domain.model.Todo
import com.example.to_do_list.domain.repository.TodoRepository

// 할 일 목록을 조회하는 UseCase
class GetTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(): List<Todo> = repository.getTodos()
}