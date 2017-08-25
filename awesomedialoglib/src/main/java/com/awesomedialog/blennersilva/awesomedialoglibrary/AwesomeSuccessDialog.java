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

public class AwesomeSuccessDialog extends AwesomeDialogBuilder<AwesomeSuccessDialog> {

    private Button positiveButton;
    private Button negativeButton;
    private Button doneButton;

    public AwesomeSuccessDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogSuccessBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_dialog_success, R.color.white);
        setPositiveButtonbackgroundColor(R.color.dialogSuccessBackgroundColor);
        setPositiveButtonText(context.getString(R.string.dialog_yes_button));
        setPositiveButtonTextColor(R.color.white);
        setNegativeButtonbackgroundColor(R.color.dialogSuccessBackgroundColor);
        setNegativeButtonText(context.getString(R.string.dialog_no_button));
        setNegativeButtonTextColor(R.color.white);
        setDoneButtonbackgroundColor(R.color.dialogSuccessBackgroundColor);
        setDoneButtonText(context.getString(R.string.dialog_no_button));
        setDoneButtonTextColor(R.color.white);
    }

    {
        positiveButton = findView(R.id.btDialogYes);
        negativeButton = findView(R.id.btDialogNo);
        doneButton = findView(R.id.btDialogDone);
    }

    public AwesomeSuccessDialog setPositiveButton(@Nullable final Closure selectedYes) {
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

    public AwesomeSuccessDialog setNegativeButton(@Nullable final Closure selectedNo) {
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


    public AwesomeSuccessDialog setPositiveButtonbackgroundColor(int buttonBackground) {
        if (positiveButton != null) {
            positiveButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
            positiveButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setPositiveButtonTextColor(int textColor) {
        if (positiveButton != null) {
            positiveButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
            positiveButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setPositiveButtonText(String text) {
        if (positiveButton != null) {
            positiveButton.setText(text);
            positiveButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setNegativeButtonbackgroundColor(int buttonBackground) {
        if (negativeButton != null) {
            negativeButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setNegativeButtonText(String text) {
        if (negativeButton != null) {
            negativeButton.setText(text);
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setNegativeButtonTextColor(int textColor) {
        if (negativeButton != null) {
            negativeButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setDoneButtonbackgroundColor(int buttonBackground) {
        if (doneButton != null) {
            doneButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
            doneButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setDoneButtonText(String text) {
        if (doneButton != null) {
            doneButton.setText(text);
            doneButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setDoneButtonTextColor(int textColor) {
        if (doneButton != null) {
            doneButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
            doneButton.setVisibility(View.VISIBLE);
        }

        return this;
    }


    @Override
    protected int getLayout() {
        return R.layout.dialog_success;
    }
}
