package com.example.to_do_list.domain.usecase

import com.example.to_do_list.domain.repository.TodoRepository

// 특정 할 일을 삭제하는 UseCase
class DeleteTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(id: Int) = repository.deleteTodo(id)
}