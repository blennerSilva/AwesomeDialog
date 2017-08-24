package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by blennersilva on 23/08/17.
 */

@SuppressWarnings({"unchecked", "WeakerAccess"})
public abstract class AwesomeDialogBuilder<T extends AwesomeDialogBuilder> {

    private Dialog dialog;
    private View dialogView;

    private ImageView dialogIcon;
    private TextView tvTitle;
    private TextView tvMessage;
    private RelativeLayout coloredCircle;
    private Context context;

    public AwesomeDialogBuilder(Context context) {
        createDialog(new AlertDialog.Builder(context));
        setContext(context);
    }

    public void createDialog(AlertDialog.Builder dialogBuilder) {
        dialogView = LayoutInflater.from(dialogBuilder.getContext()).inflate(getLayout(), null);
        dialog = dialogBuilder.setView(dialogView).create();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        dialogIcon = findView(R.id.dialog_icon);
        tvTitle = findView(R.id.dialog_title);
        tvMessage = findView(R.id.dialog_message);
        coloredCircle = findView(R.id.colored_circle);
    }

    protected abstract int getLayout();

    public T setTitle(@StringRes int title) {
        return setTitle(string(title));
    }

    public T setTitle(CharSequence title) {
        if (tvTitle != null) {
            tvTitle.setText(title);
        }

        return (T) this;
    }

    public T setMessage(@StringRes int message) {
        return setMessage(string(message));
    }

    public T setMessage(CharSequence message) {
        if (tvMessage != null) {
            tvMessage.setText(message);
        }

        return (T) this;
    }

    public T setColoredCircle(int color) {
        if (coloredCircle != null) {
            coloredCircle.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return (T) this;
    }

    public T setDialogIconAndColor(int icon, int iconColor) {
        if (dialogIcon != null) {
            Animation alertIcon = AnimationUtils.loadAnimation(getContext(), R.anim.rubber_band);
            dialogIcon.startAnimation(alertIcon);

            dialogIcon.setImageDrawable(drawableColorChange(getContext(), icon, iconColor));
        }

        return (T) this;
    }

    public Dialog show() {
        dialog.show();
        return dialog;
    }

    public Dialog hide() {
        dialog.dismiss();
        return dialog;
    }

    public T setCancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
        return (T) this;
    }

    protected String string(@StringRes int res) {
        return dialogView.getContext().getString(res);
    }

    public static Drawable drawableColorChange(Context context, int icon, int color) {
        Drawable drawable;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = context.getDrawable(icon);
        } else {
            drawable = context.getResources().getDrawable(icon);
        }

        if (drawable != null) {
            drawable.setColorFilter(ContextCompat.getColor(context, color), PorterDuff.Mode.SRC_IN);
        }

        return drawable;
    }

    protected <ViewClass extends View> ViewClass findView(int id) {
        return (ViewClass) dialogView.findViewById(id);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
