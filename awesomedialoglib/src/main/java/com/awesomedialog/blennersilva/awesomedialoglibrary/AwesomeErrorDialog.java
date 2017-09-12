package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;

/**
 * Created by blennersilva on 21/08/17.
 */

@SuppressWarnings("WeakerAccess")
public class AwesomeErrorDialog extends AwesomeDialogBuilder<AwesomeErrorDialog> {
    private Button btDialogOk;
    private RelativeLayout dialogBody;

    public AwesomeErrorDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogErrorBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white);
        setButtonBackgroundColor(R.color.dialogErrorBackgroundColor);
        setCancelable(true);
    }

    {
        btDialogOk = findView(R.id.btDialogOk);
        dialogBody = findView(R.id.dialog_body);
    }

    public AwesomeErrorDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeErrorDialog setErrorButtonClick(@Nullable final Closure selecteOk) {
        btDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selecteOk != null) {
                    selecteOk.exec();
                }

                hide();
            }
        });
        return this;
    }

    public AwesomeErrorDialog setButtonBackgroundColor(int buttonBackground) {
        if (btDialogOk != null) {
            btDialogOk.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }
        return this;
    }

    public AwesomeErrorDialog setButtonTextColor(int textColor) {
        if (btDialogOk != null) {
            btDialogOk.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }
        return this;
    }

    public AwesomeErrorDialog setButtonText(String text) {
        if (btDialogOk != null) {
            btDialogOk.setText(text);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_error;
    }
}
