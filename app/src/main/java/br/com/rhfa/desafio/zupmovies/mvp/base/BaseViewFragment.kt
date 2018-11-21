package br.com.rhfa.desafio.zupmovies.mvp.base

import android.content.Intent
import android.os.Bundle


interface BaseViewFragment : BaseView {

    fun gotoNextScreen(cls: Class<*>)

    fun gotoNextScreen(cls: Class<*>, requestCode: Int)

    fun gotoNextScreen(cls: Class<*>, dataBundle: String, keyBundle: String)

    fun gotoNextScreen(cls: Class<*>, bundle: Bundle)

    fun gotoNextScreen(cls: Class<*>, bundle: Bundle, requestCode: Int)

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)

}