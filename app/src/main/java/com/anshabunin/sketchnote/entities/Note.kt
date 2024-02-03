package com.anshabunin.sketchnote.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "dateTime")
    val dateTime: String?,
    @ColumnInfo(name = "subtitle")
    val subtitle: String?,
    @ColumnInfo(name = "noteText")
    val noteText: String?,
    @ColumnInfo(name = "imagePath")
    val imagePath: String?,
    @ColumnInfo(name = "color")
    val color: String?,
    @ColumnInfo(name = "webLink")
    val webLink: String?
)
