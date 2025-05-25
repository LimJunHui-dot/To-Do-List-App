package com.example.to_do_list.presentation.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.to_do_list.presentation.viewmodel.TodoViewModel

@Composable
fun TodoScreen(viewModel: TodoViewModel){
    val todos by viewModel.todoList.collectAsState()
    var input by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            BasicTextField(
                value = input,
                onValueChange = {input = it},
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            Button(onClick = {
                if(input.isNotBlank()){
                    viewModel.addTodo(input)
                    input = ""
                }
            }) {
                Text("추가")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        todos.forEach { todo ->
            Row (
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = todo.title,
                    modifier = Modifier.weight(1f)
                )
                Row {
                    Checkbox(
                        checked = todo.isDone,
                        onCheckedChange = {viewModel.toggleTodo(todo.id)}
                    )
                    IconButton(onClick = {viewModel.deleteTodo(todo.id)}) {
                        Icon(Icons.Default.Delete, contentDescription = "삭제")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {viewModel.clearTools()}) {
            Text("모두 삭제")
        }
    }
}