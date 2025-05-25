package com.example.to_do_list.domain.usecase

import com.example.to_do_list.domain.model.Todo
import com.example.to_do_list.domain.repository.TodoRepository

// 새 할 일을 추가하는 UseCase
class AddToUseCase(private val repository: TodoRepository){
    suspend operator fun invoke(todo: Todo) = repository.addTodo(todo)
}