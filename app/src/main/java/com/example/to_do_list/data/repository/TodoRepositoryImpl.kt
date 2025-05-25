package com.example.to_do_list.data.repository

import com.example.to_do_list.data.local.TodoDao
import com.example.to_do_list.domain.model.Todo
import com.example.to_do_list.data.mapper.toDomain
import com.example.to_do_list.data.mapper.toEntity
import com.example.to_do_list.domain.repository.TodoRepository

// TodoRepository 구현체 - Room Dao를 사용해 실제 데이터 처리
class TodoRepositoryImpl(private val dao: TodoDao) : TodoRepository {

    override suspend fun getTodos(): List<Todo> {
        return dao.getAllTools().map { it.toDomain() }
    }

    override suspend fun addTodo(todo: Todo) {
        dao.insertTodo(todo.toEntity())
    }

    override suspend fun toggleTodo(id: Int) {
        val current = dao.getAllTools().find { it.id == id }
        current?.let {
            dao.updateTodoStatus(id, !it.isDone)
        }
    }

    override suspend fun deleteTodo(id: Int) {
        dao.getAllTools().find{it.id == id}?.let {
            dao.deleteTodo(it)
        }
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}