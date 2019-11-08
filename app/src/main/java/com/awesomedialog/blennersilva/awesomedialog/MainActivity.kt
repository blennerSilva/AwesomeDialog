package com.awesomedialog.blennersilva.awesomedialog

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.awesomedialog.blennersilva.awesomedialoglibrary.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnError.setOnClickListener { showErrorDialog() }

        btnInfo.setOnClickListener { showInfoDialog() }

        btnProgress.setOnClickListener { showProgressDialog() }

        btnWarning.setOnClickListener { showWarningDialog() }

        btnNotice.setOnClickListener { showNoticeDialog() }

        btnSuccess.setOnClickListener { showSuccessDialog() }
    }

    private fun showErrorDialog() {
        AwesomeErrorDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show()
    }

    private fun showInfoDialog() {
        AwesomeInfoDialog(this).setPositiveButtonText(getString(R.string.dialog_ok_button), false).show()
    }

    private fun showProgressDialog() {
        AwesomeProgressDialog(this).show()
    }

    private fun showWarningDialog() {
        AwesomeWarningDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show()
    }

    private fun showNoticeDialog() {
        AwesomeNoticeDialog(this).setButtonText(getString(R.string.dialog_ok_button)).show()
    }

    private fun showSuccessDialog() {
        AwesomeSuccessDialog(this).setPositiveButtonText(getString(R.string.dialog_ok_button)).show()
    }
}
