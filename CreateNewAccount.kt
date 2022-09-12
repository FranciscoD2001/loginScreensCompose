package com.example.screenslogincompose

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screenslogincompose.ui.theme.ScreensLoginComposeTheme

class CreateNewAccount : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateAccountUI(applicationContext)
        }
    }
}

@Composable
fun CreateAccountUI(context: Context){

    var name by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var phone by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create new Account!",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Left,
            fontSize = 32.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        Text(
            text = "Please fill in the form to continue",
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Left,
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text("Full Name")},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            shape = RoundedCornerShape(30.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Email address")},
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "email")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            shape = RoundedCornerShape(30.dp)
        )
        OutlinedTextField(
            value = phone,
            onValueChange = {phone = it},
            label = { Text("Phone Number")},
            leadingIcon = {
                Icon(Icons.Default.Phone, contentDescription = "phone")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            shape = RoundedCornerShape(30.dp)
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
            text = "You have an Account?",
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
            Text(text = "Sign In with Google")
        }
    }
}
