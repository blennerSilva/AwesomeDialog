package com.awesomedialog.blennersilva.awesomedialoglibrary

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure

/**
 * Created by blennersilva on 21/08/17.
 */

class AwesomeErrorDialog(context: Context) : AwesomeDialogBuilder<AwesomeErrorDialog>(context) {
    private var btDialogOk: Button = findView(R.id.btDialogOk)
    private var dialogBody: RelativeLayout = findView(R.id.dialog_body)

    override val layout: Int
        get() = R.layout.dialog_error

    init {
        setColoredCircle(R.color.dialogErrorBackgroundColor)
        setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
        setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
        setCancelable(true)
    }

    fun setDialogBodyBackgroundColor(color: Int): AwesomeErrorDialog {
        dialogBody.background.setColorFilter(ContextCompat.getColor(context!!, color), PorterDuff.Mode.SRC_IN)
        return this
    }

    fun setErrorButtonClick(selecteOk: Closure?): AwesomeErrorDialog {
        btDialogOk.setOnClickListener {
            selecteOk?.exec()
            hide()
        }
        return this
    }

    fun setButtonBackgroundColor(buttonBackground: Int): AwesomeErrorDialog {
        btDialogOk.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        return this
    }

    fun setButtonTextColor(textColor: Int): AwesomeErrorDialog {
        btDialogOk.setTextColor(ContextCompat.getColor(context!!, textColor))
        return this
    }

    fun setButtonText(text: String, allCaps: Boolean = true): AwesomeErrorDialog {
        btDialogOk.text = text
        btDialogOk.visibility = View.VISIBLE
        btDialogOk.isAllCaps = allCaps
        return this
    }
}
