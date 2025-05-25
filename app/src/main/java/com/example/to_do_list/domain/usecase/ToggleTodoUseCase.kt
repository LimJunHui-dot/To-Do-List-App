package com.example.to_do_list.domain.usecase

import com.example.to_do_list.domain.repository.TodoRepository

// 할 일 완료 여부를 토굴하는 UseCase
class ToggleTodoUseCase(private val repository: TodoRepository){
    suspend operator fun invoke(id: Int) = repository.toggleTodo(id)
}