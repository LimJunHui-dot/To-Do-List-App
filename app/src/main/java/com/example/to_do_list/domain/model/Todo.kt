package com.example.to_do_list.domain.model

// 도메인 모델 : 앱 전반에서 사용할 순수 데이터 클래스
data class Todo (
    val id: Int = 0,
    val title: String,
    val isDone: Boolean = false
)