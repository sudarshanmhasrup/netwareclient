package com.netwareclient.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import com.netwareclient.android.networkRequests.TestConnection

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val test = TestConnection()
        repeat(1000) {
            test.networkRequest()
        }
    }
}