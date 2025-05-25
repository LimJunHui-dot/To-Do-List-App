package com.example.to_do_list.di

import android.app.Application
import androidx.room.Room
import com.example.to_do_list.data.local.TodoDao
import com.example.to_do_list.data.local.TodoDatabase
import com.example.to_do_list.data.repository.TodoRepositoryImpl
import com.example.to_do_list.domain.repository.TodoRepository
import com.example.to_do_list.domain.usecase.AddToUseCase
import com.example.to_do_list.domain.usecase.DeleteAllTodoUseCase
import com.example.to_do_list.domain.usecase.DeleteTodoUseCase
import com.example.to_do_list.domain.usecase.GetTodoUseCase
import com.example.to_do_list.domain.usecase.ToggleTodoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

// Hilt을 사용한 의존성 주입을 구성하는 AppModule
// 앱 전반에 걸쳐 필요한 객체를 Singleton 범위로 제공
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Room Database 인스턴스 제공
    // @param app Application Context
    // @return TodoDatabase 인스턴스
    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase{
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    // TodoDao 제공 - RoomDatabase에서 Dao 인스턴스 추출
    // @param db TodoDatabase
    // @return TodoDao
    @Provides
    fun provideTodoDao(db: TodoDatabase): TodoDao = db.todoDao()

    // Repository 구현체 주입 - TodoDao를 이용해 구현된 RepositoryImpl 반환
    // @param dao TodoDao
    // @return TodoRepository
    @Provides
    @Singleton
    fun provideTodoRepository(dao: TodoDao): TodoRepository{
        return TodoRepositoryImpl(dao)
    }

    // UseCase 객체를 주입 - 각각의 도메인 기능들을 캡슐화한 유스케이스
    @Provides
    fun provideGetTodoUseCase(repository: TodoRepository) = GetTodoUseCase(repository)

    @Provides
    fun provideAddToUseCase(repository: TodoRepository) = AddToUseCase(repository)

    @Provides
    fun provideToggleTodoUseCase(repository: TodoRepository) = ToggleTodoUseCase(repository)

    @Provides
    fun provideDeleteTodoUseCase(repository: TodoRepository) = DeleteTodoUseCase(repository)

    @Provides
    fun provideDeleteAllTodoUseCase(repository: TodoRepository) = DeleteAllTodoUseCase(repository)
}