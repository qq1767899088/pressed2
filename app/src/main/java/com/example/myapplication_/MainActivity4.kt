package com.example.myapplication_
import java.lang.Thread
import java.util.UUID
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Checkbox
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.compose.foundation.text.selection.DisableSelection
import android.text.method.LinkMovementMethod
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import android.text.format.DateFormat
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.unit.sp
//import java.text.DateFormat
import java.util.Date

/*
import io.noties.markwon.MarkwonConfiguration
import io.noties.markwon.html.MarkwonHtmlRenderer
import io.noties.markwon.html.TagHandler
import io.noties.markwonspans.MarkwonSpansFactory
import io.noties.markwon.utils.MarkdownUtil
*/
import androidx.compose.runtime.*
import androidx.compose.ui.text.buildAnnotatedString
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.text.AnnotatedString
import android.text.Spanned;
import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.buildSpanned
//import androidx.compose.ui.text.withStyle
import io.noties.markwon.core.CorePlugin
import io.noties.markwon.html.HtmlPlugin
import io.noties.markwon.ext.latex.JLatexMathPlugin
import io.noties.markwon.Markwon;
import android.content.Context;
import android.media.projection.MediaProjectionManager
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import dev.jeziellago.compose.markdowntext.MarkdownText 
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

var MyServicemeta = false
var isExternal = false
val MY_TEXT_COLOR = Color(0xFFAAAAAA)
val DARK_COLOR= Color(0xFF333333)
val DARK_COLOR2= Color(0xFF666666)
val DARK_COLOR3= Color(0xFF888888)
val MY_TEXT_STYLE = TextStyle(
    color = MY_TEXT_COLOR,
    fontSize = 16.sp,
    fontWeight = FontWeight.Bold
)

//var text2=mutableStateOf("sothisis thesolution")
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
	/*
	screenshot2(this);
val manager = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
startActivityForResult(manager.createScreenCaptureIntent(), 22222)
*/



    }
}

fun screenshot2(m:Context){
}
fun screenshot(){
/*
val manager = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
startActivityForResult(manager.createScreenCaptureIntent(), REQUEST_MEDIA_PROJECTION)
*/
}


fun setContent(composeView:ComposeView,word:String){
setContent(composeView,word,0)
}
fun setContent(composeView:ComposeView,word:String,indicator:Int = 0){
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
MyServicemeta = !MyServicemeta
	    composeView.setContent {
                MaterialTheme {
val heartbeat4 by rememberUpdatedState(MyService.heartbeat2)
val connectState2 by rememberUpdatedState(MyService.connectstate)
val currentTime2 by rememberUpdatedState(System.currentTimeMillis())
Column{
Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

    Text(
        text = DateFormat.format("hh:mm:ss a", currentTime2).toString(),
       // style = MaterialTheme.typography.h5
style = MY_TEXT_STYLE
    )
    Text(connectState2 +"\n"+heartbeat4,style = MY_TEXT_STYLE)
    }
if(indicator == 0){
                    Greeting(word)
}else if(indicator == 2){
                    Greeting2(word)
}else{
val checkState = MutableList(JSONArray(word).length()/2) { false }
                    Greeting3(word,checkState)
}
}
                }
			        }
			}
data class TodoItem(
    val description: String,
    val money: Int,
    val isSolved: Int,
    val id: Int
)

fun initializeCheckedState(todos: List<TodoItem>): MutableList<Boolean> {
    return MutableList(todos.size) { false }
}
@Composable
fun Greeting3(jsonString:String,checkedState2: MutableList<Boolean>) {
val hint by rememberUpdatedState(MyServicemeta)
var checkedState by remember{mutableStateOf(checkedState2)}
val jsonArray = JSONArray(jsonString)
if(hint){
checkedState = remember{MutableList(jsonArray.length()/2) { false }}
checkedState[0] = false
 MyServicemeta = !MyServicemeta
/*
checkedState.clear()
checkedState.addAll(listOf(false,false,false,false,false))
*/
//MyService.meta = false
}
//var checked by remember { mutableStateOf(false) }
// Convert the JSONArray to a list of TodoItem objects
val todos: List<TodoItem> = (0 until jsonArray.length()/2).map { index ->
    val item = jsonArray.getJSONObject(index*2)
    val item2 = jsonArray.getJSONObject(index*2 + 1)
    TodoItem(
        item.getString("content") + "\n\n" + item2.getString("content"),
        //item.getString("role")
index*2,
0,
0
    )
}

// Define a mutable state for the checked status of each item
//val checkedState = remember { mutableStateListOf<Boolean>() }

// Initialize the checked state for each item to false
//todos.forEach { _ -> checkedState.add(false) }

    // Create JSONObject of checked Todos' money and id
val uuid = remember { UUID.randomUUID().toString() }
var i by remember { mutableStateOf(0) }
var isEnabled = checkedState.contains(true)
val buttonColors = if (isEnabled) { // Check if the button is enabled
    ButtonDefaults.buttonColors(backgroundColor = DARK_COLOR2,disabledBackgroundColor =DARK_COLOR3,  contentColor = Color.White)
} else {
    ButtonDefaults.buttonColors(backgroundColor = DARK_COLOR3,contentColor = Color.Gray)
}
val checkedText = checkedState.joinToString(separator = ", ") { if (it) "true" else "false" }
    Button(
        onClick = {
            val checkedTodos = todos.filterIndexed { index, _ -> !checkedState[index] }
            val jsonArray2 = JSONArray()
            
            checkedTodos.forEach { todo ->
    val item = jsonArray.getJSONObject(todo.money)
    val item2 = jsonArray.getJSONObject(todo.money + 1)
                
                jsonArray2.put(item)
                jsonArray2.put(item2)
            }
 val jsonString = jsonArray2.toString()
Thread{
MyService.mConnectedThread2.write(jsonString.toByteArray(Charsets.UTF_8),4);
}.start()
//i = jsonArray.getJSONObject(0).getInt("id")
            
         //   Log.d("Greeting2", "Checked Todos as JSON: $jsonArray")
        },
        //enabled = checkedState.contains(true)
    enabled = isEnabled,
    colors = ButtonDefaults.buttonColors(backgroundColor = DARK_COLOR2,disabledBackgroundColor =DARK_COLOR3,  contentColor = MY_TEXT_COLOR)
    ) {
        Text(checkedText + hint.toString())
    }
// Create a list of checkboxes using the LazyColumn Composable
LazyColumn(
    content = {
        todos.forEachIndexed { index, todo ->
            item {
Row(
    modifier = Modifier.clickable { checkedState[index] = !checkedState[index]
},
    verticalAlignment = Alignment.CenterVertically
) {
                Checkbox(
                    checked = checkedState[index],
colors = CheckboxDefaults.colors(
        checkedColor = DARK_COLOR2,
        uncheckedColor = MY_TEXT_COLOR,
        checkmarkColor = DARK_COLOR3
    ),
                    onCheckedChange = { checkedState[index] = it }
                )
Text(text ="#" + todo.money.toString()+ ":\n\n" + todo.description+ "\n\n" ,style = MY_TEXT_STYLE)
}
            }
        }
    }
)
    
}
@Composable
fun Greeting2(jsonString:String) {
val jsonArray = JSONArray(jsonString)
//var checked by remember { mutableStateOf(false) }
// Convert the JSONArray to a list of TodoItem objects
val todos: List<TodoItem> = (0 until jsonArray.length()).map { index ->
    val item = jsonArray.getJSONObject(index)
    TodoItem(
        item.getString("description"),
        item.getInt("money"),
        item.getInt("isSolved"),
        item.getInt("id")
    )
}

// Define a mutable state for the checked status of each item
val checkedState = remember { mutableStateListOf<Boolean>() }

// Initialize the checked state for each item to false
todos.forEach { _ -> checkedState.add(false) }

    // Create JSONObject of checked Todos' money and id
val uuid = remember { UUID.randomUUID().toString() }
var i by remember { mutableStateOf(0) }
var isEnabled = checkedState.contains(true)
val buttonColors = if (isEnabled) { // Check if the button is enabled
    ButtonDefaults.buttonColors(backgroundColor = DARK_COLOR2,disabledBackgroundColor =DARK_COLOR3,  contentColor = Color.White)
} else {
    ButtonDefaults.buttonColors(backgroundColor = DARK_COLOR3,contentColor = Color.Gray)
}
    Button(
        onClick = {
            val checkedTodos = todos.filterIndexed { index, _ -> checkedState[index] }
            val jsonArray = JSONArray()
            
            checkedTodos.forEach { todo ->
                val jsonObject = JSONObject().apply {
                    put("money", todo.money)
                    put("id", todo.id)
                }
                
                jsonArray.put(jsonObject)
            }
 val jsonString = jsonArray.toString()
Thread{
MyService.mConnectedThread2.write(jsonString.toByteArray(Charsets.UTF_8),3);
}.start()
i = jsonArray.getJSONObject(0).getInt("id")
            
         //   Log.d("Greeting2", "Checked Todos as JSON: $jsonArray")
        },
        //enabled = checkedState.contains(true)
    enabled = isEnabled,
    colors = ButtonDefaults.buttonColors(backgroundColor = DARK_COLOR2,disabledBackgroundColor =DARK_COLOR3,  contentColor = MY_TEXT_COLOR)
    ) {
        Text("Create JSON of checked Todos' money and id" + i.toString())
    }
// Create a list of checkboxes using the LazyColumn Composable
LazyColumn(
    content = {
        todos.forEachIndexed { index, todo ->
            item {
Row(
    modifier = Modifier.clickable { checkedState[index] = !checkedState[index] },
    verticalAlignment = Alignment.CenterVertically
) {
                Checkbox(
                    checked = checkedState[index],
colors = CheckboxDefaults.colors(
        checkedColor = DARK_COLOR2,
        uncheckedColor = MY_TEXT_COLOR,
        checkmarkColor = DARK_COLOR3
    ),
                    onCheckedChange = { checkedState[index] = it }
                )
Text(text = todo.description + " $: " + todo.money.toString(),style = MY_TEXT_STYLE)
}
            }
        }
    }
)
    
}
@Composable
fun Greeting(name: String) {
val currentTime by rememberUpdatedState(System.currentTimeMillis())
val heartbeat3 by rememberUpdatedState(MyService.heartbeat2)
val firstChar = name.substring(0, 1)
    val restString = name.substring(1)
var text2 by remember { mutableStateOf("sothisis thesolution") }
var heartBeat by remember { mutableStateOf("heartBeat") }
var connectState by remember { mutableStateOf("connectionState") }
if(firstChar == "1"){text2=restString}else if(firstChar == "0"){heartBeat=restString}else{connectState=restString}
/*
val myMap = remember {
        hashMapOf(
            "0" to heartBeat,
            "1" to text2
        )
}
myMap[firstChar]=restString
*/

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
/*
      //  DisableSelection {
Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

    Text(text = "start...")
    Text(
        text = DateFormat.format("hh:mm:ss a", currentTime).toString(),
        style = MaterialTheme.typography.h5
    )
    }
    Text(connectState +" "+heartbeat3)
//}
*/
    Text(text = "start...",style = MY_TEXT_STYLE)
SelectionContainer {
    val f:File = File(Environment.getExternalStorageDirectory().getPath()
    + "/123.txt");
			/*
                        MarkDown(                                        name,
			                                    modifier = Modifier.fillMaxSize()                            )
							    */
/*
							    val markdown = name  
												    MarkdownText(markdown = markdown)  
*/
val context = LocalContext.current
    val markwon = Markwon.builder(context)
    //val markwon = remember { Markwon.builder(context)
            .usePlugin(CorePlugin.create())
.usePlugin(MarkwonInlineParserPlugin.create())
.usePlugin(JLatexMathPlugin.create(40.0f, object : JLatexMathPlugin.BuilderConfigure {
    override fun configureBuilder(builder: JLatexMathPlugin.Builder) {
        // ENABLE inlines
        builder.inlinesEnabled(true)
    }
}))
.usePlugin(HtmlPlugin.create())
            .build()
//}

    val spanned:Spanned = markwon.toMarkdown(name)
//text2 = name
/*
val annotatedString = buildAnnotatedString {
        append(spanned)
    }
    Text(text = annotatedString)
//Text(text = AnnotatedString(markwon.toMarkdown(name)))
text2 = name
AndroidView(
        factory = { 
            TextView(context).apply {
                
                // render markdown in the TextView
                markwon.setMarkdown(this,text2)
            }
        }, 
        modifier = Modifier.fillMaxSize().padding(16.dp)
    )
val value = name
LaunchedEffect(value) {
            markwon.setMarkdown(
                (AndroidView(
                    factory = {
                        TextView(context)
                    },
                    update = {
                        markwon.setMarkdown(it, spanned)
                        //markwon.setMarkdown(it, value)
                    },
                    modifier = androidx.compose.ui.Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    key = value // Use the value parameter as the key
                ) as TextView),
                value
            )
        }
*/
AndroidView(factory = {
            TextView(context).apply{
 //movementMethod = LinkMovementMethod.getInstance()
setTextIsSelectable(true)

}
        }, update = {
            markwon.setMarkdown(it, text2)
/*
            markwon.setMarkdown(it, text2,object : MarkwonConfiguration() {
    override fun configureSpansFactory(builder: MarkwonSpansFactory.Builder) {
        builder.remove(HtmlPlugin::class.java)
               .add(HtmlPlugin.create())}})
*/
        })
}
    Text(text = "end!!!",style = MY_TEXT_STYLE)
							    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplication_Theme {
        Greeting("Android")
    }
}
