package com.awesomedialog.blennersilva.awesomedialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeErrorDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeInfoDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeNoticeDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeProgressDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeSuccessDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeWarningDialog;
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

        Button btnWarning = (Button) findViewById(R.id.btnWarning);
        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWarningDialog();
            }
        });

        Button btnNotice = (Button) findViewById(R.id.btnNotice);
        btnNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNoticeDialog();
            }
        });

        Button btnSuccess = (Button) findViewById(R.id.btnSuccess);
        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSuccessDialog();
            }
        });
    }

    private void showErrorDialog() {
        new AwesomeErrorDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show();
    }

    private void showInfoDialog() {
        new AwesomeInfoDialog(this).setPositiveButtonText(getString(R.string.dialog_ok_button)).show();
//        new AwesomeInfoDialog(this)
//                .setPositiveButtonText("PositiveButton")
//                .setNeutralButtonText("NeutralButton")
//                .setNeutralButtonClick(new Closure() {
//                    @Override
//                    public void exec() {
//                        Log.d("TEST","Neutral click");
//                    }
//                })
//                .setNegativeButtonText("NegativeButton")
//                .show();

    }

    private void showProgressDialog() {
        new AwesomeProgressDialog(this).show();
    }

    private void showWarningDialog() {
        new AwesomeWarningDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show();
    }

    private void showNoticeDialog() {
        new AwesomeNoticeDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show();
    }

    private void showSuccessDialog() {
        new AwesomeSuccessDialog(this).setPositiveButtonText(getString(R.string.dialog_ok_button)).show();
    }
}
