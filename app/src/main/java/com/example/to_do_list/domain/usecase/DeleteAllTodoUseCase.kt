package com.example.to_do_list.domain.usecase

import com.example.to_do_list.domain.repository.TodoRepository

// 모든 할 일을 삭제하는 UseCase
class DeleteAllTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke() = repository.deleteAll()
}