package com.example.businesscard

import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Profile(
                        name = "Faysa Ryestitha Etsuko",
                        title = "Android Developer Extraordinaire",
                        phoneNumber = "+6282321438696",
                        socialMedia = "@faysarystitha",
                        email = "faysarystitha@gmail.com"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Profile(
            name = "Faysa Ryestitha Etsuko",
            title = "Android Developer Extraordinaire",
            phoneNumber = "+6282321438696",
            socialMedia = "@faysarystitha",
            email = "faysarystitha@gmail.com"
        )
    }
}

@Composable
fun Profile(name: String, title: String, phoneNumber: String, socialMedia: String, email: String) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Data(name = name, title = title)
        Contacts(phoneNumber = phoneNumber, socialMedia = socialMedia, email = email)
    }
}

@Composable
fun Data(name: String, title: String, modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .background(Color(rgb(0, 123, 161)))
        )
        Text(
            text = name,
            fontSize = 30.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            fontSize = 22.sp,
            color = Color(rgb(0, 123, 161)),
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Contacts(phoneNumber: String, socialMedia: String, email: String) {
    val call = painterResource(R.drawable.call)
    val share = painterResource(R.drawable.share)
    val mail = painterResource(R.drawable.email)

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = call,
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
            )
            Text(
                text = phoneNumber,
                fontSize = 15.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = share,
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
            )
            Text(
                text = socialMedia,
                fontSize = 15.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = mail,
                contentDescription = null,
                modifier = Modifier
                    .size(17.dp)
            )
            Text(
                text = email,
                fontSize = 15.sp
            )
        }
    }
}
