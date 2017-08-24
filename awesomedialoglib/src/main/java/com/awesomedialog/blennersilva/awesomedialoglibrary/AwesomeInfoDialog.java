package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;

/**
 * Created by blennersilva on 23/08/17.
 */

public class AwesomeInfoDialog extends AwesomeDialogBuilder<AwesomeInfoDialog> {

    private Button positiveButton;
    private Button negativeButton;

    public AwesomeInfoDialog(Context context) {
        super(context);
    }

    {
        positiveButton = findView(R.id.btDialogYes);
        negativeButton = findView(R.id.btDialogNo);
    }

    public AwesomeInfoDialog setPositiveButton(@Nullable final Closure selectedYes) {
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedYes != null) {
                    selectedYes.exec();
                }

                hide();
            }
        });

        return this;
    }

    public AwesomeInfoDialog setNegativeButton(@Nullable final Closure selectedNo) {
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedNo != null) {
                    selectedNo.exec();
                }

                hide();
            }
        });

        return this;
    }

    public AwesomeInfoDialog setPositiveButtonColorTextAndTextColor(int buttonBackground, int textColor, String text) {
        if (positiveButton != null) {
            positiveButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
            positiveButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
            positiveButton.setText(text);
            positiveButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeInfoDialog setNegativeButtonColorTextAndTextColor(int buttonBackground, int textColor, String text) {
        if (negativeButton != null) {
            negativeButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
            negativeButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
            negativeButton.setText(text);
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }


    @Override
    protected int getLayout() {
        return R.layout.dialog_info;
    }
}
