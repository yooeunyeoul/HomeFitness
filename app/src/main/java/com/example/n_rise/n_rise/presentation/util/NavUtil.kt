package com.example.n_rise.n_rise.presentation.util

import android.os.Bundle
import androidx.navigation.NavType
import com.example.n_rise.n_rise.domain.model.Program
import com.google.gson.Gson

abstract class JsonNavType<T> : NavType<T>(isNullableAllowed = false) {
    abstract fun fromJsonParse(value: String): T
    abstract fun T.getJsonParse(): String

    override fun get(bundle: Bundle, key: String): T? =
        bundle.getString(key)?.let { parseValue(it) }

    override fun parseValue(value: String): T = fromJsonParse(value)

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putString(key, value.getJsonParse())
    }
}

class ProgramArgType : JsonNavType<Program>() {
    override fun fromJsonParse(value: String): Program {
        return Gson().fromJson(value, Program::class.java)
    }

    override fun Program.getJsonParse(): String {
        return Gson().toJson(this)
    }

}