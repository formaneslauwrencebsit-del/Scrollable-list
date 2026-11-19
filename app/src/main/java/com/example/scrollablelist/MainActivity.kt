package com.example.scrollablelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.scrollablelist.ui.theme.ScrollableListTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableListTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                    ) {
                        MyApp()
                        }
                    }
                }
            }
        }
@Composable
fun MyApp() {
    val jokes = arrayListOf<JokeModel>(
        JokeModel(
            id = 1,
            question = "What is it when an elephant sits on your fence?",
            answer = "Time to get a new fence",
            answerIsVisible = true

        ),
        JokeModel(
            id = 2,
            question = "What is red and smells like blue paint?",
            answer = "Red paint",
            answerIsVisible = true

        ),
        JokeModel(
            id = 3,
            question = "Why did the student eat his homework?",
            answer = "Because the teacher said it was a piece of cake",
            answerIsVisible = true
        ),
        JokeModel(
            id = 4,
            question = "Why did the computer go to the doctor?",
            answer = "Because it had a virus",
            answerIsVisible = true
        ),
        JokeModel(
            id = 5,
            question = "Why was the math book sad?",
            answer = "Because it had too many problems ",
            answerIsVisible = true
        )


    )
    LazyColumn() {
        items(jokes.size) { index ->
            Joke1(jokeModel = jokes[index])
        }
    }

}



@Composable
fun Joke1(jokeModel: JokeModel) {

     Column {
        Text(text = jokeModel.id.toString())
        Text(
            text = jokeModel.question,
            modifier = Modifier.padding(16.dp),
            color = Color.Black,
            fontSize = 8.em,
            fontWeight = FontWeight.Bold,
            lineHeight = 1.em,
            textAlign = TextAlign.Center


        )
        if (jokeModel.answerIsVisible) {
            Text(text = jokeModel.answer)
        }
    }
}

data class JokeModel(val id: Int,
                     val question: String,
                     val answer: String,
                     val answerIsVisible: Boolean){


}



