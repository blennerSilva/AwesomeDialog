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

class AwesomeNoticeDialog(context: Context) : AwesomeDialogBuilder<AwesomeNoticeDialog>(context) {
    private var btDialogOk: Button = findView(R.id.btDialogOk)
    private var dialogBody: RelativeLayout = findView(R.id.dialog_body)

    override val layout: Int
        get() = R.layout.dialog_notice

    init {

        setColoredCircle(R.color.dialogNoticeBackgroundColor)
        setDialogIconAndColor(R.drawable.ic_notice, R.color.white)
        setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor)
        setCancelable(true)
    }

    fun setDialogBodyBackgroundColor(color: Int): AwesomeNoticeDialog {
        dialogBody.background.setColorFilter(ContextCompat.getColor(context!!, color), PorterDuff.Mode.SRC_IN)
        return this
    }

    fun setNoticeButtonClick(selecteOk: Closure?): AwesomeNoticeDialog {
        btDialogOk.setOnClickListener {
            selecteOk?.exec()
            hide()
        }
        return this
    }

    fun setButtonBackgroundColor(buttonBackground: Int): AwesomeNoticeDialog {
        btDialogOk.background.setColorFilter(ContextCompat.getColor(context!!, buttonBackground), PorterDuff.Mode.SRC_IN)
        return this
    }

    fun setButtonTextColor(textColor: Int): AwesomeNoticeDialog {
        btDialogOk.setTextColor(ContextCompat.getColor(context!!, textColor))
        return this
    }

    fun setButtonText(text: String): AwesomeNoticeDialog {
        btDialogOk.text = text
        btDialogOk.visibility = View.VISIBLE
        return this
    }
}
