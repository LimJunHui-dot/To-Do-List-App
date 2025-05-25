package com.example.to_do_list.data.mapper

import com.example.to_do_list.data.local.TodoEntity
import com.example.to_do_list.domain.model.Todo

// Entity -> Domain 모델 변환
fun TodoEntity.toDomain(): Todo{
    return Todo(
        id = this.id,
        title = this.title,
        isDone = this.isDone
    )
}

// Domian -> Entity 모델 변환
fun Todo.toEntity(): TodoEntity{
    return TodoEntity(
        id = this.id,
        title = this.title,
        isDone = this.isDone
    )
}