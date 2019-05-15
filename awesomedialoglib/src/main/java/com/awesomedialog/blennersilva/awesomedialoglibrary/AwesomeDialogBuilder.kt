package com.awesomedialog.blennersilva.awesomedialoglibrary

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * Created by blennersilva on 23/08/17.
 */

abstract class AwesomeDialogBuilder<T>(context: Context){

    private lateinit var dialog: Dialog
    private lateinit var dialogView: View

    private lateinit var dialogIcon: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvMessage: TextView
    private lateinit var coloredCircle: RelativeLayout
    var context: Context? = null

    protected abstract val layout: Int

    init {
        createDialog(AlertDialog.Builder(context))
        this.context = context
    }

    fun createDialog(dialogBuilder: AlertDialog.Builder) {
        dialogView = LayoutInflater.from(dialogBuilder.context).inflate(layout, null)
        dialog = dialogBuilder.setView(dialogView).create()

        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        }

        dialogIcon = findView(R.id.dialog_icon)
        tvTitle = findView(R.id.dialog_title)
        tvMessage = findView(R.id.dialog_message)
        coloredCircle = findView(R.id.colored_circle)
    }

    fun setTitle(@StringRes title: Int): T {
        return setTitle(string(title))
    }

    fun setTitle(title: CharSequence): T {
        this.tvTitle.text = title
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun setMessage(@StringRes message: Int): T {
        return setMessage(string(message))
    }

    fun setMessage(message: CharSequence): T {
        tvMessage.text = message
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun setColoredCircle(color: Int): T {
        coloredCircle.background.setColorFilter(ContextCompat.getColor(context!!, color), PorterDuff.Mode.SRC_IN)
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun setDialogIconAndColor(icon: Int, iconColor: Int): T {
        val alertIcon = AnimationUtils.loadAnimation(context, R.anim.rubber_band)
        dialogIcon.startAnimation(alertIcon)
        dialogIcon.setImageDrawable(drawableColorChange(context, icon, iconColor))
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun setDialogIconOnly(icon: Int): T {
        val alertIcon = AnimationUtils.loadAnimation(context, R.anim.rubber_band)
        dialogIcon.startAnimation(alertIcon)
        dialogIcon.setImageResource(icon)
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    fun show(): Dialog? {
        try {
            if (context is Activity) {
                if (!(context as Activity).isFinishing) {
                    dialog.show()
                }
            } else {
                dialog.show()
            }
        } catch (e: Exception) {
            Log.e("[AwSDialog:showAlert]", "Erro ao exibir alert")
        }

        return dialog
    }

    fun hide(): Dialog {
        try {
            dialog.dismiss()
        } catch (e: Exception) {
            Log.d("[AwSDialog : dismiss]", " Erro ao remover diálogo (%s)")
        }

        dialog.dismiss()
        return dialog
    }

    fun setCancelable(cancelable: Boolean): T {
        dialog.setCancelable(cancelable)
        @Suppress("UNCHECKED_CAST")
        return this as T
    }

    protected fun string(@StringRes res: Int): String {
        return dialogView.context.getString(res)
    }

    protected fun <ViewClass : View> findView(id: Int): ViewClass {
        @Suppress("UNCHECKED_CAST")
        return dialogView.findViewById<View>(id) as ViewClass
    }

    companion object {

        fun drawableColorChange(context: Context?, icon: Int, color: Int): Drawable? {
            val drawable: Drawable?

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                drawable = context!!.getDrawable(icon)
            } else {
                drawable = context!!.resources.getDrawable(icon)
            }

            drawable?.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_IN)

            return drawable
        }
    }
}
