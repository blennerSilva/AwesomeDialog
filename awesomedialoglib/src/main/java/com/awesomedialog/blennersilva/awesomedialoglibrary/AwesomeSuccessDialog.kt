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

class AwesomeSuccessDialog(context: Context) : AwesomeDialogBuilder<AwesomeSuccessDialog>(context) {

    private var positiveButton: Button? = findView(R.id.btDialogYes)
    private var negativeButton: Button? = findView(R.id.btDialogNo)
    private var doneButton: Button? = findView(R.id.btDialogDone)
    private var dialogBody: RelativeLayout = findView(R.id.dialog_body)


    override val layout: Int
        get() = R.layout.dialog_success

    init {
        setColoredCircle(R.color.dialogSuccessBackgroundColor)
        setDialogIconAndColor(R.drawable.ic_success, R.color.white)
        setNegativeButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
        setPositiveButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
        setDoneButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
    }

    fun setDialogBodyBackgroundColor(color: Int): AwesomeSuccessDialog {
        dialogBody.background.setColorFilter(ContextCompat.getColor(context!!, color), PorterDuff.Mode.SRC_IN)
        return this
    }

    fun setPositiveButtonClick(selectedYes: Closure?): AwesomeSuccessDialog {
        positiveButton!!.setOnClickListener {
            selectedYes?.exec()
            hide()
        }
        return this
    }

    fun setNegativeButtonClick(selectedNo: Closure?): AwesomeSuccessDialog {
        negativeButton!!.setOnClickListener {
            selectedNo?.exec()
            hide()
        }
        return this
    }

    fun setDoneButtonClick(selectedDone: Closure?): AwesomeSuccessDialog {
        doneButton!!.setOnClickListener {
            selectedDone?.exec()
            hide()
        }
        return this
    }

    fun showPositiveButton(show: Boolean): AwesomeSuccessDialog {
        if (positiveButton != null) {
            positiveButton!!.visibility = View.VISIBLE
        }
        return this
    }

    fun showNegativeButton(show: Boolean): AwesomeSuccessDialog {
        if (negativeButton != null) {
            negativeButton!!.visibility = View.VISIBLE
        }
        return this
    }

    fun showDoneButton(show: Boolean): AwesomeSuccessDialog {
        if (doneButton != null) {
            doneButton!!.visibility = View.VISIBLE
        }
        return this
    }

    fun setPositiveButtonbackgroundColor(buttonBackground: Int): AwesomeSuccessDialog {
        if (positiveButton != null) {
            positiveButton!!.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        }
        return this
    }

    fun setPositiveButtonTextColor(textColor: Int): AwesomeSuccessDialog {
        if (positiveButton != null) {
            positiveButton!!.setTextColor(ContextCompat.getColor(context!!, textColor))
        }
        return this
    }

    fun setPositiveButtonText(text: String): AwesomeSuccessDialog {
        if (positiveButton != null) {
            positiveButton!!.text = text
            positiveButton!!.visibility = View.VISIBLE
        }
        return this
    }

    fun setNegativeButtonbackgroundColor(buttonBackground: Int): AwesomeSuccessDialog {
        if (negativeButton != null) {
            negativeButton!!.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        }
        return this
    }

    fun setNegativeButtonText(text: String): AwesomeSuccessDialog {
        if (negativeButton != null) {
            negativeButton!!.text = text
            negativeButton!!.visibility = View.VISIBLE
        }
        return this
    }

    fun setNegativeButtonTextColor(textColor: Int): AwesomeSuccessDialog {
        if (negativeButton != null) {
            negativeButton!!.setTextColor(ContextCompat.getColor(context!!, textColor))
        }
        return this
    }

    fun setDoneButtonbackgroundColor(buttonBackground: Int): AwesomeSuccessDialog {
        if (doneButton != null) {
            doneButton!!.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        }
        return this
    }

    fun setDoneButtonText(text: String): AwesomeSuccessDialog {
        if (doneButton != null) {
            doneButton!!.text = text
            doneButton!!.visibility = View.VISIBLE
        }
        return this
    }

    fun setDoneButtonTextColor(textColor: Int): AwesomeSuccessDialog {
        if (doneButton != null) {
            doneButton!!.setTextColor(ContextCompat.getColor(context!!, textColor))
        }
        return this
    }
}
