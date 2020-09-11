package com.example.krolchansk.model

//import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.android.synthetic.main.fragment_call.view.*


class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
        val database = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://krolchansk-fdea7.firebaseio.com/new_user")

        database.child("Token: ").child("phone").setValue(token)
        applicationContext.getSharedPreferences("Token: ", Context.MODE_PRIVATE).edit().putString("Token: ", token).commit()

    }

    fun gg(): String{
        return applicationContext.getSharedPreferences("Token: ", Context.MODE_PRIVATE).getString("Token: ", "") ?: ""
    }
    //dL6wrJnT5z5DoQpvzeV9qG:APA91bH8DEhWcU5tFzKOkrwRC84ZFfy2MLzR70_J5kEnWvZR298UIJFuRIFNZg98fBq-uEnWJJwPVZZ--BtRMFK7S3XRLe5woUyb4hu50vmgmj7jCa8PZSD_iuitZGBc6oUcb7Ut5_61


}
