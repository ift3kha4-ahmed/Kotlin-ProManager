package com.example.promanager.utils

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import java.util.*

class LocaleHelper {


    fun setLocale(context:Context,language: String):Context{
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            return updateResource(context,language)
        }else{
            return updateResourceLegacy(context,language)
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    fun updateResource(context: Context, language:String):Context{


        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        return context.createConfigurationContext(config)
    }

    fun updateResourceLegacy(context: Context,language: String):Context{
        val locale = Locale(language)
        Locale.setDefault(locale)

        val resource = context.resources
        val config = resource.configuration
        config.locale=locale
        config.setLayoutDirection(locale)
        resource.updateConfiguration(config,resource.displayMetrics)
        return context

    }

}