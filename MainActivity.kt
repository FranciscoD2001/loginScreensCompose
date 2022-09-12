package com.example.screenslogincompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUI(applicationContext)
            TextUrlExample()
        }
    }
}
@Composable
fun LoginUI(context: Context){

    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back!",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Left,
            fontSize = 32.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        Text(
            text = "Please sign in to your account",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Left,
            fontSize = 32.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Enter your email or Phone")},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            shape = RoundedCornerShape(30.dp),
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("Enter your password")},
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(30.dp)
        )
        Text(
            text = "Forget Password?",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Left,
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        Button(
            onClick = {}, shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(text = "Sign Up")
        }
        Button(
            onClick = {}, shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(text = "Sign In with Google")
        }
//        Button(onClick = {}) {
//            Image(
//                painterResource(id = R.drawable.ic_cart),
//                contentDescription ="Cart button icon",
//                modifier = Modifier.size(20.dp))
//
//            Text(text = "Add to cart",Modifier.padding(start = 10.dp))
//        }
    }
}
@Composable
fun TextUrlExample() {
    val text = buildAnnotatedString {
        append("Don't have an Account? ")
        pushStringAnnotation("URL", "https://www.develou.com")
        withStyle(
            SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("Sign In")
        }
        pop()
    }
    val uriHandler = LocalUriHandler.current
    Box(
        Modifier.fillMaxSize()
            .padding(bottom = 10.dp, top = 350.dp),
        contentAlignment = Alignment.Center
    ) {
        ClickableText(text, style = MaterialTheme.typography.body2) { offset ->
            text.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                uriHandler.openUri(annotation.item)
            }
        }
    }
}
//@Composable
//fun ButtonWithIcon() {
//    Button(onClick = {}) {
//        Image(
//            painterResource(id = R.drawable.ic_cart),
//            contentDescription ="Cart button icon",
//            modifier = Modifier.size(20.dp))
//
//        Text(text = "Add to cart",Modifier.padding(start = 10.dp))
//    }
//}
//@Composable
//fun ButtonWithColor(){
//    Button(onClick = {
//        //your onclick code
//    },
//        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray))
//
//    {
//        Text(text = "Button with gray background",color = Color.White)
//    }
//}
