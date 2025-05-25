package com.example.to_do_list.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_do_list.domain.model.Todo
import com.example.to_do_list.domain.repository.TodoRepository
import com.example.to_do_list.domain.usecase.AddToUseCase
import com.example.to_do_list.domain.usecase.DeleteAllTodoUseCase
import com.example.to_do_list.domain.usecase.DeleteTodoUseCase
import com.example.to_do_list.domain.usecase.GetTodoUseCase
import com.example.to_do_list.domain.usecase.ToggleTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// UI 상태를 관리하는 ViewModel - UseCase를 주입받아 사용
@HiltViewModel
class TodoViewModel @Inject constructor (
    private val getTodoUseCase: GetTodoUseCase,
    private val addToUseCase: AddToUseCase,
    private val toggleTodoUseCase: ToggleTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase,
    private val deleteAllTodoUseCase: DeleteAllTodoUseCase
) : ViewModel(){

    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
    val todoList: StateFlow<List<Todo>> = _todoList

    fun loadTools(){
        viewModelScope.launch {
            _todoList.value = getTodoUseCase()
        }
    }

    fun addTodo(title: String){
        viewModelScope.launch {
            val newTodo = Todo(title = title)
            addToUseCase(newTodo)
            loadTools()
        }
    }

    fun toggleTodo(id: Int){
        viewModelScope.launch {
            toggleTodoUseCase(id)
            loadTools()
        }
    }

    fun deleteTodo(id: Int){
        viewModelScope.launch{
            deleteTodoUseCase(id)
            loadTools()
        }
    }

    fun clearTools(){
        viewModelScope.launch {
            deleteAllTodoUseCase()
            loadTools()
        }
    }
}