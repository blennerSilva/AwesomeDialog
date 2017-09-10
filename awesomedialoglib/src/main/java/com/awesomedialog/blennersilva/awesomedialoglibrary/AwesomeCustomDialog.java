package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.ClosureEdit;

/**
 * Created by eminsr on 23/08/17.
 */

public class AwesomeCustomDialog extends AwesomeDialogBuilder<AwesomeCustomDialog> {

    private Button customButton;
    private Button negativeButton;
    private Button doneButton;
    private EditText editText;

    public AwesomeCustomDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogCustomBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white);
        setNegativeButtonbackgroundColor(R.color.dialogCustomBackgroundColor);
        setCustomButtonbackgroundColor(R.color.dialogCustomBackgroundColor);
        setDoneButtonbackgroundColor(R.color.dialogCustomBackgroundColor);
        setEditTextUnderlineColor(R.color.dialogCustomBackgroundColor);
    }

    {
        customButton = findView(R.id.btDialogYes);
        negativeButton = findView(R.id.btDialogNo);
        doneButton = findView(R.id.btDialogDone);
        editText = findView(R.id.dialog_edittext);
    }


    public AwesomeCustomDialog setCustomButtonClick(@Nullable final ClosureEdit selectedCustom) {
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (selectedCustom != null) {
                  if(selectedCustom.exec(editText))
                      hide();
              }else
                  hide();
            }
        });

        return this;
    }

    public AwesomeCustomDialog setNegativeButtonClick(@Nullable final Closure selectedNo) {
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

    public AwesomeCustomDialog setDoneButtonClick(@Nullable final Closure selectedDone) {
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


    public AwesomeCustomDialog showCustomButton(boolean show) {
        if (customButton != null) {
            customButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeCustomDialog showNegativeButton(boolean show) {
        if (negativeButton != null) {
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeCustomDialog showDoneButton(boolean show) {
        if (doneButton != null) {
            doneButton.setVisibility(View.VISIBLE);
        }

        return this;
    }


    public AwesomeCustomDialog setCustomButtonbackgroundColor(int buttonBackground) {
        if (customButton != null) {
            customButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeCustomDialog setCustomButtonTextColor(int textColor) {
        if (customButton != null) {
            customButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }

        return this;
    }

    public AwesomeCustomDialog setCustomButtonText(String text) {
        if (customButton != null) {
            customButton.setText(text);
            customButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeCustomDialog setNegativeButtonbackgroundColor(int buttonBackground) {
        if (negativeButton != null) {
            negativeButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeCustomDialog setNegativeButtonText(String text) {
        if (negativeButton != null) {
            negativeButton.setText(text);
            negativeButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeCustomDialog setNegativeButtonTextColor(int textColor) {
        if (negativeButton != null) {
            negativeButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }

        return this;
    }

    public AwesomeCustomDialog setDoneButtonbackgroundColor(int buttonBackground) {
        if (doneButton != null) {
            doneButton.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeCustomDialog setDoneButtonText(String text) {
        if (doneButton != null) {
            doneButton.setText(text);
            doneButton.setVisibility(View.VISIBLE);
        }

        return this;
    }

    public AwesomeCustomDialog setDoneButtonTextColor(int textColor) {
        if (doneButton != null) {
            doneButton.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }

        return this;
    }

    public AwesomeCustomDialog setEditTextUnderlineColor(int textUnderlineColor) {

        if (editText != null) {
            Drawable drawable = editText.getBackground();
            drawable.setColorFilter(ContextCompat.getColor(getContext(), textUnderlineColor), PorterDuff.Mode.SRC_ATOP);
            if (Build.VERSION.SDK_INT > 16) {
                editText.setBackground(drawable); // set the new drawable to EditText
            } else {
                editText.setBackgroundDrawable(drawable); // use setBackgroundDrawable because setBackground required API 16
            }
        }

        return this;
    }

    public AwesomeCustomDialog setEditTextColor(int editTextColor) {

        if (editText != null) {
            editText.setTextColor(ContextCompat.getColor(getContext(),editTextColor));
        }

        return this;
    }


    @Override
    protected int getLayout() {
        return R.layout.dialog_custom;
    }
}
