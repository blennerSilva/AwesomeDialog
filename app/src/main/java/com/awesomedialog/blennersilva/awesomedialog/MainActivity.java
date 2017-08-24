package com.awesomedialog.blennersilva.awesomedialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeInfoDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeProgressDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnError = (Button) findViewById(R.id.btnError);
        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showErrorDialog();
            }
        });

        Button btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoDialog();
            }
        });

        Button btnProgress = (Button) findViewById(R.id.btnProgress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgressDialog();
            }
        });
    }

    private void showErrorDialog() {
        new AwesomeErrorDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogErrorBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
                .setCancelable(true)
                .setButtonColorTextAndTextColor(R.color.dialogErrorBackgroundColor, R.color.white, getString(R.string.dialog_ok_button))
                .setErrorButton(new Closure() {
                    @Override
                    public void exec() {

                    }
                }).show();
    }

    private void showInfoDialog() {
        new AwesomeInfoDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogInfoBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
                .setCancelable(true)
                .setPositiveButtonColorTextAndTextColor(R.color.dialogInfoBackgroundColor, R.color.white, getString(R.string.dialog_yes_button))
                .setNegativeButtonColorTextAndTextColor(R.color.dialogInfoBackgroundColor, R.color.white, getString(R.string.dialog_no_button))
                .setPositiveButton(new Closure() {
                    @Override
                    public void exec() {

                    }
                })
                .setNegativeButton(new Closure() {
                    @Override
                    public void exec() {

                    }
                })
                .show();
    }

    private void showProgressDialog(){
        new AwesomeProgressDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogProgressBackgroundColor)
                .setCancelable(true)
                .setProgressBarColor(R.color.white)
                .show();
    }
}
