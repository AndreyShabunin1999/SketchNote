package com.anshabunin.sketchnote.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name = "dateTime")
    var dateTime: String = "",
    @ColumnInfo(name = "subtitle")
    var subtitle: String = "",
    @ColumnInfo(name = "noteText")
    var noteText: String = "",
    @ColumnInfo(name = "imagePath")
    var imagePath: String = "",
    @ColumnInfo(name = "color")
    var color: String = "",
    @ColumnInfo(name = "webLink")
    var webLink: String = ""
)
