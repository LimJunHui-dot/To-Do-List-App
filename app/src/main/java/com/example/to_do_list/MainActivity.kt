package com.example.to_do_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_do_list.presentation.todo.TodoScreen
import com.example.to_do_list.presentation.viewmodel.TodoViewModel
import com.example.to_do_list.ui.theme.TODO_ListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TodoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                Surface {
                    TodoApp(viewModel)
                }
            }
        }
    }
}

@Composable
fun TodoApp(viewModel: TodoViewModel){
    LaunchedEffect(Unit) {
        viewModel.loadTools()
    }
    TodoScreen(viewModel)
}

@Preview(showBackground = true)
@Composable
fun TodoAppPreview(){
    // Preview에서는 ViewModel 사용 생략
}