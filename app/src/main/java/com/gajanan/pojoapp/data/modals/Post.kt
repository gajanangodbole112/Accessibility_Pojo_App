package com.gajanan.pojoapp.data.modals

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "post_table")
@Parcelize
data class Post(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val body: String? = null,
    val title: String? = null,
    val userId: Int? = null
) : Parcelable
