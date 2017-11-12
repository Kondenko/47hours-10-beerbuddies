package com.vladimirkondenko.beerbuddies.presentation

import android.support.v4.app.DialogFragment
import android.view.ViewGroup


abstract class BaseDialogFragment : DialogFragment() {

    override fun onResume() {
        val params = dialog.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = params as android.view.WindowManager.LayoutParams
        super.onResume()
    }

}