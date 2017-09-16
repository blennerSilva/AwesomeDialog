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

public class AwesomeInfoDialog extends AwesomeDialogBuilder<AwesomeInfoDialog> {

    private Button positiveButton;
    private Button negativeButton;
    private Button neutralButton;
    private RelativeLayout dialogBody;

    public AwesomeInfoDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogInfoBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white);
        setPositiveButtonbackgroundColor(R.color.dialogInfoBackgroundColor);
        setNegativeButtonbackgroundColor(R.color.dialogInfoBackgroundColor);
        setNeutralButtonbackgroundColor(R.color.dialogInfoBackgroundColor);
        setCancelable(true);
    }

    {
        positiveButton = findView(R.id.btDialogYes);
        negativeButton = findView(R.id.btDialogNo);
        neutralButton = findView(R.id.btDialogNeutral);
        dialogBody = findView(R.id.dialog_body);
    }

    public AwesomeInfoDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeInfoDialog setPositiveButtonClick(@Nullable final Closure selectedYes) {
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

    public AwesomeInfoDialog setNegativeButtonClick(@Nullable final Closure selectedNo) {
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

    public AwesomeInfoDialog setNeutralButtonClick(@Nullable final Closure selectedNeutral) {
        neutralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedNeutral != null) {
                    selectedNeutral.exec();
                }

                hide();
            }
        });

        return this;
    }


    public AwesomeInfoDialog setPositiveButtonbackgroundColor(int buttonBackground) {
        if (positiveButton != null) {
            positiveButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeInfoDialog setPositiveButtonTextColor(int textColor) {
        if (positiveButton != null) {
            positiveButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }

        return this;
    }

    public AwesomeInfoDialog setPositiveButtonText(String text) {
        if (positiveButton != null) {
            positiveButton.setText(text);
            positiveButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeInfoDialog setNegativeButtonbackgroundColor(int buttonBackground) {
        if (negativeButton != null) {
            negativeButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeInfoDialog setNegativeButtonText(String text) {
        if (negativeButton != null) {
            negativeButton.setText(text);
        }

        return this;
    }

    public AwesomeInfoDialog setNegativeButtonTextColor(int textColor) {
        if (negativeButton != null) {
            negativeButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeInfoDialog setNeutralButtonbackgroundColor(int buttonBackground) {
        if (neutralButton != null) {
            neutralButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeInfoDialog setNeutralButtonText(String text) {
        if (neutralButton != null) {
            neutralButton.setText(text);
        }

        return this;
    }

    public AwesomeInfoDialog setNeutralButtonTextColor(int textColor) {
        if (neutralButton != null) {
            neutralButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
            neutralButton.setVisibility(View.VISIBLE);
        }

        return this;
    }


    @Override
    protected int getLayout() {
        return R.layout.dialog_info;
    }
}
