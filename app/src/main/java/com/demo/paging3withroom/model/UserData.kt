package com.demo.paging3withroom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Rohith S
 * UserData defines all the primitive types of each user object like date, explanation, media_type, title, url
 */
@Entity(tableName = "userdata")
data class UserData(

    @ColumnInfo(name = "date")
    val date: String?,
    @ColumnInfo(name = "explanation")
    val explanation: String?,
    @ColumnInfo(name = "media_type")
    val media_type:String?,
    @ColumnInfo(name = "title")
    val title: String,
    @PrimaryKey
    @ColumnInfo(name = "url")
    val url: String = "" )

