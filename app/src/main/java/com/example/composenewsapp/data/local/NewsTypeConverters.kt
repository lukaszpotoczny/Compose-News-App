package com.example.composenewsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.composenewsapp.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverters {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(str: String): Source {
        return str.split(",").let { Source(id = it[0], name = it[1]) }
    }
}