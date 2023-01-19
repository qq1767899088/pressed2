package com.example.myapplication_
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import dev.jeziellago.compose.markdowntext.MarkdownText 
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import android.os.Environment;
import java.io.File
import com.mukesh.MarkDown                                           import java.net.URL

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication_.ui.theme.MyApplication_Theme

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication_Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

fun setContent(composeView:ComposeView,word:String){
    /*
composeView.apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                MaterialTheme {
                    Text("Hello Compose!")
                }
            }
        }
	*/
	    composeView.setContent {
                MaterialTheme {
                    Greeting(word)
                }
			        }
			}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
    Text(text = "start...")
    val f:File = File(Environment.getExternalStorageDirectory().getPath()
    + "/123.txt");
			/*
                        MarkDown(                                        name,
			                                    modifier = Modifier.fillMaxSize()                            )
							    */
							    val markdown = name  
												    MarkdownText(markdown = markdown)  
    Text(text = "end!!!")
							    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplication_Theme {
        Greeting("Android")
    }
}
