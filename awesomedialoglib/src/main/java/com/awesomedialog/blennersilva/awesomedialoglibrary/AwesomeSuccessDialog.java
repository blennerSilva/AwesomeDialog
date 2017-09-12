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
 * Created by blennersilva on 23/08/17.
 */

public class AwesomeSuccessDialog extends AwesomeDialogBuilder<AwesomeSuccessDialog> {

    private Button positiveButton;
    private Button negativeButton;
    private Button doneButton;
    private RelativeLayout dialogBody;

    public AwesomeSuccessDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogSuccessBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_success, R.color.white);
        setNegativeButtonbackgroundColor(R.color.dialogSuccessBackgroundColor);
        setPositiveButtonbackgroundColor(R.color.dialogSuccessBackgroundColor);
        setDoneButtonbackgroundColor(R.color.dialogSuccessBackgroundColor);
    }

    {
        positiveButton = findView(R.id.btDialogYes);
        negativeButton = findView(R.id.btDialogNo);
        doneButton = findView(R.id.btDialogDone);
        dialogBody = findView(R.id.dialog_body);
    }

    public AwesomeSuccessDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeSuccessDialog setPositiveButtonClick(@Nullable final Closure selectedYes) {
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

    public AwesomeSuccessDialog setNegativeButtonClick(@Nullable final Closure selectedNo) {
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

    public AwesomeSuccessDialog setDoneButtonClick(@Nullable final Closure selectedDone) {
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedDone != null) {
                    selectedDone.exec();
                }

                hide();
            }
        });

        return this;
    }

    public AwesomeSuccessDialog showPositiveButton(boolean show) {
        if (positiveButton != null) {
            positiveButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog showNegativeButton(boolean show) {
        if (negativeButton != null) {
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog showDoneButton(boolean show) {
        if (doneButton != null) {
            doneButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeSuccessDialog setPositiveButtonbackgroundColor(int buttonBackground) {
        if (positiveButton != null) {
            positiveButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeSuccessDialog setPositiveButtonTextColor(int textColor) {
        if (positiveButton != null) {
            positiveButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
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
        }

        return this;
    }

    public AwesomeSuccessDialog setDoneButtonbackgroundColor(int buttonBackground) {
        if (doneButton != null) {
            doneButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
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
        }

        return this;
    }


    @Override
    protected int getLayout() {
        return R.layout.dialog_success;
    }
}
