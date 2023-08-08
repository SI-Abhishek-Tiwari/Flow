package com.packagename.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

 fun getNotes(): Flow<Note> {
    val list = listOf(
        Note(1,false,"First","First Description"),
        Note(2,true,"Second","Second Description"),
        Note(3,true,"Third","Second Description")
    )

    return list.asFlow()

}

data class Note(val id: Int,val isActive: Boolean,val title:String,val description : String)
data class FormattedNote(val isActive: Boolean, val title: String, val description: String)