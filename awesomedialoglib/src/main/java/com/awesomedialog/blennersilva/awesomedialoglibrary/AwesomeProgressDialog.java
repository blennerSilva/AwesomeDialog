package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/**
 * Created by blennersilva on 23/08/17.
 */

public class AwesomeProgressDialog extends AwesomeDialogBuilder<AwesomeProgressDialog> {

    private ProgressBar progressBar;
    private RelativeLayout dialogBody;

    public AwesomeProgressDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogProgressBackgroundColor);
        setProgressBarColor(R.color.white);
    }

    {
        progressBar = findView(R.id.dialog_progress_bar);
        dialogBody = findView(R.id.dialog_body);
    }

    public AwesomeProgressDialog setDialogBodyBackgroundColor(int color){
        if (dialogBody != null) {
            dialogBody.getBackground().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        }

        return this;
    }

    public AwesomeProgressDialog setProgressBarColor(int color) {
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), color), PorterDuff.Mode.SRC_IN);
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_progress;
    }
}
