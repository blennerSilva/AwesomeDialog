package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.ClosurePicker;

/**
 * Created by eminsr on 13/09/2017.
 */

public class AwesomePickerDialog extends AwesomeDialogBuilder<AwesomePickerDialog> {
    private Button btDialogOk;
    private ImageView iBack, iForward, iContent;
    private TextView tvBelowMessage;
    private RelativeLayout rPicker;
    private int[] images;
    private String[] messages;
    private int current = 0, max;
    private Boolean hasMessage = false;

    public AwesomePickerDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogPickerBackgroundColor);
        setDialogIconAndColor(R.drawable.ic_notice, R.color.white);
        setPickerButtonBackgroundColor(R.color.dialogPickerBackgroundColor);
        setBackButtonBackgroundColor(R.color.dialogPickerBackgroundColor);
        setForwardButtonBackgroundColor(R.color.dialogPickerBackgroundColor);
        setCancelable(true);
    }

    {
        rPicker = findView(R.id.dialog_picker);
        btDialogOk = findView(R.id.btDialogOk);
        iBack = findView(R.id.dialog_back);
        iForward = findView(R.id.dialog_forward);
        iContent = findView(R.id.dialog_content);
        tvBelowMessage = findView(R.id.dialog_content_message);
        iBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (current != 0) {
                    current--;
                    iContent.setImageResource(images[current]);
                    if (hasMessage)
                        tvBelowMessage.setText(messages[current]);
                } else {
                    current = max;
                    iContent.setImageResource(images[current]);
                    if (hasMessage)
                        tvBelowMessage.setText(messages[current]);
                }

            }
        });
        iForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current != max) {
                    current++;
                    iContent.setImageResource(images[current]);
                    if (hasMessage)
                        tvBelowMessage.setText(messages[current]);
                } else {
                    current = 0;
                    iContent.setImageResource(images[current]);
                    if (hasMessage)
                        tvBelowMessage.setText(messages[current]);
                }
            }
        });
    }

    public AwesomePickerDialog setPickerButtonClick(@Nullable final ClosurePicker selecteOk) {
        btDialogOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selecteOk != null) {
                    selecteOk.exec(current);
                }

                hide();
            }
        });
        return this;
    }

    public AwesomePickerDialog setPickerContent(int[] images, @Nullable String[] messages) {

        this.images = images;
        max = images.length - 1;
        iContent.setImageResource(images[current]);
        if (messages != null) {
            hasMessage = true;
            this.messages = messages;
            tvBelowMessage.setVisibility(View.VISIBLE);
            tvBelowMessage.setText(messages[current]);
        }
        return this;
    }

    public AwesomePickerDialog setContentHeight(int dp) {

        if (rPicker != null) {

            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            dp = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));

            rPicker.getLayoutParams().height = dp;
        }

        return this;
    }


    public AwesomePickerDialog setPickerButtonBackgroundColor(int buttonBackground) {
        if (btDialogOk != null) {
            btDialogOk.getBackground().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }
        return this;
    }

    public AwesomePickerDialog setButtonTextColor(int textColor) {
        if (btDialogOk != null) {
            btDialogOk.setTextColor(ContextCompat.getColor(getContext(), textColor));
        }
        return this;
    }

    public AwesomePickerDialog setPickerButtonText(String text) {
        if (btDialogOk != null) {
            btDialogOk.setText(text);
            btDialogOk.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public AwesomePickerDialog setBackButtonBackgroundColor(int buttonBackground) {
        if (iBack != null) {
            iBack.getDrawable().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }
        return this;
    }

    public AwesomePickerDialog setForwardButtonBackgroundColor(int buttonBackground) {
        if (iForward != null) {
            iForward.getDrawable().setColorFilter(ContextCompat.getColor(getContext(), buttonBackground), PorterDuff.Mode.SRC_IN);
        }
        return this;
    }

    public AwesomePickerDialog setContentMessageColor(int textColor) {

        if (tvBelowMessage != null) {

        }
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_picker;
    }
}

