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

class AwesomeWarningDialog(context: Context) : AwesomeDialogBuilder<AwesomeWarningDialog>(context) {
    private var btDialogOk: Button = findView(R.id.btDialogOk)
    private var dialogBody: RelativeLayout = findView(R.id.dialog_body)

    override val layout: Int
        get() = R.layout.dialog_warning

    init {
        setColoredCircle(R.color.dialogWarningBackgroundColor)
        setDialogIconAndColor(R.drawable.ic_dialog_warning, R.color.black)
        setButtonBackgroundColor(R.color.dialogWarningBackgroundColor)
        setCancelable(true)
    }

    fun setDialogBodyBackgroundColor(color: Int): AwesomeWarningDialog {
        dialogBody.background.setColorFilter(ContextCompat.getColor(context!!, color), PorterDuff.Mode.SRC_IN)
        return this
    }


    fun setWarningButtonClick(selecteOk: Closure?): AwesomeWarningDialog {
        btDialogOk.setOnClickListener {
            selecteOk?.exec()
            hide()
        }
        return this
    }

    fun setButtonBackgroundColor(buttonBackground: Int): AwesomeWarningDialog {
        btDialogOk.background?.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        return this
    }

    fun setButtonTextColor(textColor: Int): AwesomeWarningDialog {
        btDialogOk.setTextColor(ContextCompat.getColor(context!!, textColor))
        return this
    }

    fun setButtonText(text: String, allCaps: Boolean = true): AwesomeWarningDialog {
        btDialogOk.text = text
        btDialogOk.visibility = View.VISIBLE
        btDialogOk.isAllCaps = allCaps
        return this
    }
}
