package com.awesomedialog.blennersilva.awesomedialoglibrary;


import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;

/**
 * Created by eminsozuer on 11/09/2017.
 */

public class AwesomeWebDialog extends AwesomeDialogBuilder<AwesomeWebDialog> {
    private Button btDialogOk;

    public AwesomeWebDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogWebBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_web, R.color.white);
        setButtonBackgroundColor(R.color.dialogWebBackgroundColor);
        setCancelable(true);
    }

    {
        btDialogOk = findView(R.id.btDialogOk);
    }

    public AwesomeWebDialog setWebButtonClick(@Nullable final Closure selecteOk) {
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

    public AwesomeWebDialog setButtonBackgroundColor(int buttonBackground) {
        if (btDialogOk != null) {
            btDialogOk.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }
        return this;
    }

    public AwesomeWebDialog setButtonTextColor(int textColor) {
        if (btDialogOk != null) {
            btDialogOk.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }
        return this;
    }

    public AwesomeWebDialog setButtonText(String text) {
        if (btDialogOk != null) {
            btDialogOk.setText(text);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_web;
    }
}
