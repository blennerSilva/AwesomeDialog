# AwesomeDialog

This library is a set of simple wrapper classes that was created to help you easily make SCLA like dialogs.

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AwesomeDialog-green.svg?style=true)](https://android-arsenal.com/details/1/6109)

## Gradle

add jitpack to your project

```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
    }
}
```  

compile on your dependencies

```
dependencies {
	compile 'com.github.eminsr:AwesomeDialog:master-SNAPSHOT'
}
```


# Wiki

## General
[sample module](https://github.com/blennerSilva/AwesomeDialog/tree/master/app/src/main/java/com/awesomedialog/blennersilva/awesomedialog).

### Dialog Types

Each Dialog has its own top color, icon, title and message + its own featured. There are 6 types of dialogs available:
* [AwesomeInfoDialog](#awesomeinfodialog)
* [AwesomeErrorDialog](#awesomeerrordialog)
* [AwesomeProgressDialog](#awesomeprogressdialog)
* [AwesomeWarningDialog](#awesomewarningdialog)
* [AwesomeNoticeDialog](#awesomenoticedialog)
* [AwesomeSuccessDialog](#awesomesuccessdialog)
* [AwesomeCustomDialog](#awesomecustomdialog)
* [AwesomeWebDialog](#awesomewebdialog)

#### AwesomeInfoDialog
You can set posite and negative buttons here. Closures can be individually set for each button (onClick of any
button with closure the button will be dismissed).

```java
 new AwesomeInfoDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogInfoBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
                .setCancelable(true)
                .setPositiveButtonText(getString(R.string.dialog_yes_button))
                .setPositiveButtonbackgroundColor(R.color.dialogInfoBackgroundColor)
                .setPositiveButtonTextColor(R.color.white)
                .setNegativeButtonText(getString(R.string.dialog_no_button))
                .setNegativeButtonbackgroundColor(R.color.dialogInfoBackgroundColor)
                .setNegativeButtonTextColor(R.color.white)
                .setPositiveButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        //click
                    }
                })
                .setNegativeButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        //click
                    }
                })
                .show();

```
#### AwesomeErrorDialog
Display an Error dialog with one button

```java
  new AwesomeErrorDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogErrorBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_error, R.color.white)
                .setCancelable(true).setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogErrorBackgroundColor)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setErrorButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        // click
                    }
                })
                .show();
    }
```
#### AwesomeProgressDialog
Display a Progress Dialog

```java
 new AwesomeInfoDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogInfoBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
                .setCancelable(true)
                .show();

```
#### AwesomeWarningDialog
Display Warning to user with or without button

```java
new AwesomeWarningDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogWarningBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_warning, R.color.white)
                .setCancelable(true)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogWarningBackgroundColor)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setWarningButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        // click
                    }
                })
                .show();

```
#### AwesomeNoticeDialog
Display notice to user

```java
new AwesomeNoticeDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogNoticeBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_notice, R.color.white)
                .setCancelable(true)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setNoticeButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        // click
                    }
                })
                .show();
```

#### AwesomeSuccessDialog
Displays a success message, with max of three buttons

```java
new AwesomeSuccessDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogSuccessBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
                .setCancelable(true)
                .setPositiveButtonText(getString(R.string.dialog_yes_button))
                .setPositiveButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
                .setPositiveButtonTextColor(R.color.white)
                .setNegativeButtonText(getString(R.string.dialog_no_button))
                .setNegativeButtonbackgroundColor(R.color.dialogSuccessBackgroundColor)
                .setNegativeButtonTextColor(R.color.white)
                .setPositiveButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        //click
                    }
                })
                .setNegativeButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        //click
                    }
                })
                .show();
```

#### AwesomeCustomDialog
Displays a message, a textedit and max of three buttons

```java
new AwesomeCustomDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setColoredCircle(R.color.dialogCustomBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
                .setCancelable(true)
                .setEditTextUnderlineColor(R.color.dialogCustomBackgroundColor)
                .setEditTextColor(R.color.dialogCustomBackgroundColor)
                .setCustomButtonText(getString(R.string.dialog_ok_button))
                .setCustomButtonClick(new ClosureEdit() {
                    @Override
                    public Boolean exec(EditText editText) {
                        //click

                        return false;//return true; to hide the dialog
                    }
                })
                .setDoneButtonText(getString(R.string.dialog_done_button))
                .setDoneButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        //click

                    }
                })
                .show();
```

#### AwesomeWebDialog
Displays a message that contains html tags and max of one button
setMessage now accepts Spanned and you can set the max height of the textview that shows the message and make it scrollable.

```java
new AwesomeWebDialog(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.app_name)
                .setMessageMovementWithMaxHight(300)
                .setCancelable(true)
                .setColoredCircle(R.color.dialogWebBackgroundColor)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogWebBackgroundColor)
                .setWebButtonClick(new Closure() {
                    @Override
                    public void exec() {

                    }
                })
                .show();
```

Web icon: By Yannick
<div>Icons made by <a href="https://www.flaticon.com/authors/yannick" title="Yannick">Yannick</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>



# Screenshots

## Info
<img src="https://github.com/eminsr/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/info.png" width="300" >

## Error
<img src="https://github.com/eminsr/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/error.png" width="300" >

## Progress
<img src="https://github.com/eminsr/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/progress.png" width="300" >

## Warning
<img src="https://github.com/eminsr/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/warning.png" width="300" >

## Notice
<img src="https://github.com/eminsr/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/notice.png" width="300" >

## Success
<img src="https://github.com/eminsr/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/success.png" width="300" >

## Custom with EditText
<img src="https://github.com/eminsr/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/custom.png" width="300" >
