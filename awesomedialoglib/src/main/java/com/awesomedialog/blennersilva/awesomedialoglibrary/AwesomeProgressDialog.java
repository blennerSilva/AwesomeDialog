package com.awesomedialog.blennersilva.awesomedialoglibrary;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.widget.ProgressBar;

/**
 * Created by blennersilva on 23/08/17.
 */

public class AwesomeProgressDialog extends AwesomeDialogBuilder<AwesomeProgressDialog> {

    private ProgressBar progressBar;

    public AwesomeProgressDialog(Context context) {
        super(context);

        setColoredCircle(R.color.dialogProgressBackgroundColor);
        setProgressBarColor(R.color.white);
    }

    {
        progressBar = findView(R.id.dialog_progress_bar);
    }

    public AwesomeProgressDialog setProgressBarColor(int color) {
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.white), PorterDuff.Mode.SRC_IN);
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.dialog_progress;
    }
}
