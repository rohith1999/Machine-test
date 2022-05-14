package com.demo.paging3withroom

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * @author Rohith S
 * MyRoomRetroApplication is the application class that is annotated with
 * @HiltAndroidApp starts the code generation of the Hilt components and also generates a base class
 * for your application that uses those generated components.
 */
@HiltAndroidApp
class MyRoomRetroApplication: Application() {

}