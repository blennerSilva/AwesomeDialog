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
	compile 'com.github.blennerSilva:AwesomeDialog:2.0.5'
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
                .setNeutralButtonText(getString(R.string.dialog_neutral_button))
                .setNeutralButtonbackgroundColor(R.color.dialogInfoBackgroundColor)
                .setNeutralButtonTextColor(R.color.white)
                .setNegativeButtonText(getString(R.string.dialog_no_button))
                .setNegativeButtonbackgroundColor(R.color.dialogInfoBackgroundColor)
                .setNegativeButtonTextColor(R.color.white)
                .setPositiveButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        //click
                    }
                })
                .setNeutralButtonClick(new Closure() {
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
                .setColoredCircle(R.color.dialogNoticeBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_notice, R.color.white)
                .setCancelable(true)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor)
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

# Screenshots

## Info
<img src="https://github.com/blennerSilva/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/info.png" width="300" >

## Error
<img src="https://github.com/blennerSilva/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/error.png" width="300" >

## Progress
<img src="https://github.com/blennerSilva/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/progress.png" width="300" >

## Warning
<img src="https://github.com/blennerSilva/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/warning.png" width="300" >

## Notice
<img src="https://github.com/blennerSilva/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/notice.png" width="300" >

## Success
<img src="https://github.com/blennerSilva/AwesomeDialog/blob/master/awesomedialoglib/extras/screenshots/success.png" width="300" >

## License

[MIT](http://opensource.org/licenses/MIT)

Copyright (c) 2017-present, Blenner Silva

-- 
