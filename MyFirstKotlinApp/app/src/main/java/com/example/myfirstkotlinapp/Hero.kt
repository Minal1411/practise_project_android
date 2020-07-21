package com.example.myfirstkotlinapp

import java.io.Serializable
//if we want to pass this class object through intent we have implement serializable interface
class Hero(val name:String,val realName:String):Serializable