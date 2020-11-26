package com.awesomedialog.blennersilva.awesomedialoglibrary

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure

/**
 * Created by blennersilva on 23/08/17.
 */

class AwesomeInfoDialog(context: Context) : AwesomeDialogBuilder<AwesomeInfoDialog>(context) {

    private var dialogBody: RelativeLayout = findView(R.id.dialog_body)
    private var positiveButton: Button? = null
    private var negativeButton: Button? = null
    private var neutralButton: Button? = null


    override val layout: Int
        get() = R.layout.dialog_info

    init {
        setColoredCircle(R.color.dialogInfoBackgroundColor)
        setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
        setPositiveButtonbackgroundColor(R.color.dialogInfoBackgroundColor)
        setNegativeButtonbackgroundColor(R.color.dialogInfoBackgroundColor)
        setNeutralButtonbackgroundColor(R.color.dialogInfoBackgroundColor)
        setCancelable(true)
    }

    init {
        positiveButton = findView(R.id.btDialogYes)
        negativeButton = findView(R.id.btDialogNo)
        neutralButton = findView(R.id.btDialogNeutral)
    }

    fun setDialogBodyBackgroundColor(color: Int): AwesomeInfoDialog {
        dialogBody.background.setColorFilter(ContextCompat.getColor(context!!, color), PorterDuff.Mode.SRC_IN)

        return this
    }

    fun setPositiveButtonClick(selectedYes: Closure?): AwesomeInfoDialog {
        positiveButton!!.setOnClickListener {
            selectedYes?.exec()
            hide()
        }
        return this
    }

    fun setNegativeButtonClick(selectedNo: Closure?): AwesomeInfoDialog {
        negativeButton!!.setOnClickListener {
            selectedNo?.exec()
            hide()
        }
        return this
    }

    fun setNeutralButtonClick(selectedNeutral: Closure?): AwesomeInfoDialog {
        neutralButton!!.setOnClickListener {
            selectedNeutral?.exec()
            hide()
        }
        return this
    }


    fun setPositiveButtonbackgroundColor(buttonBackground: Int): AwesomeInfoDialog {
        if (positiveButton != null) {
            positiveButton!!.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        }

        return this
    }

    fun setPositiveButtonTextColor(textColor: Int): AwesomeInfoDialog {
        if (positiveButton != null) {
            positiveButton!!.setTextColor(ContextCompat.getColor(context!!, textColor))
        }
        return this
    }

    fun setPositiveButtonText(text: String, allCaps: Boolean = true): AwesomeInfoDialog {
        if (positiveButton != null) {
            positiveButton!!.text = text
            positiveButton!!.visibility = View.VISIBLE
            positiveButton?.isAllCaps = allCaps
        }

        return this
    }

    fun setNegativeButtonbackgroundColor(buttonBackground: Int): AwesomeInfoDialog {
        if (negativeButton != null) {
            negativeButton!!.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        }

        return this
    }

    fun setNegativeButtonText(text: String, allCaps: Boolean = true): AwesomeInfoDialog {
        if (negativeButton != null) {
            negativeButton!!.text = text
            negativeButton?.isAllCaps = allCaps
        }
        return this
    }

    fun setNegativeButtonTextColor(textColor: Int): AwesomeInfoDialog {
        if (negativeButton != null) {
            negativeButton!!.setTextColor(ContextCompat.getColor(context!!, textColor))
            negativeButton!!.visibility = View.VISIBLE
        }
        return this
    }

    fun setNeutralButtonbackgroundColor(buttonBackground: Int): AwesomeInfoDialog {
        if (neutralButton != null) {
            neutralButton!!.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        }
        return this
    }

    fun setNeutralButtonText(text: String, allCaps: Boolean = true): AwesomeInfoDialog {
        if (neutralButton != null) {
            neutralButton!!.text = text
            negativeButton?.isAllCaps = allCaps
        }
        return this
    }

    fun setNeutralButtonTextColor(textColor: Int): AwesomeInfoDialog {
        if (neutralButton != null) {
            neutralButton!!.setTextColor(ContextCompat.getColor(context!!, textColor))
            neutralButton!!.visibility = View.VISIBLE
        }
        return this
    }
}
