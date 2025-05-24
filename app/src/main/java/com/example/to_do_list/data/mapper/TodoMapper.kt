package com.example.to_do_list.data.mapper

import com.example.to_do_list.data.local.TodoEntity
import com.example.to_do_list.domain.model.Todo

fun TodoEntity.toDomain(): Todo{
    return Todo(
        id = this.id,
        title = this.title,
        isDone = this.isDone
    )
}

fun Todo.toEntity(): TodoEntity{
    return TodoEntity(
        id = this.id,
        title = this.title,
        isDone = this.isDone
    )
}