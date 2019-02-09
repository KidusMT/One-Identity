package com.gdg.app.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.Toast;

import com.gdg.app.MvpApp;
import com.gdg.app.R;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by KidusMT.
 */

public final class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        if (context != null) {
            ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.show();
            if (progressDialog.getWindow() != null) {
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.progress_dialog);
            progressDialog.setIndeterminate(true);
            return progressDialog;
        } else {
            return null;
        }


    }

    @SuppressLint("all")
    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static void toast(String msg) {
        Toast.makeText(MvpApp.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void hideKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static String getFileName(Uri uri, Context context) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    public static RequestBody toRequestBody(String request) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), request);
    }

    public static String getErrorMessage(Throwable throwable) {
        if (throwable instanceof SocketTimeoutException) {
            return "Please try again.";
        } else if (throwable instanceof IOException) {
            return "Please connect to the internet.";
        } else if (throwable instanceof com.jakewharton.retrofit2.adapter.rxjava2.HttpException) {
            int code = ((com.jakewharton.retrofit2.adapter.rxjava2.HttpException) throwable).response().code();
            if (code >= 400 && code < 404) {
                return MvpApp.getContext().getString(R.string.error_invalid_credential);
            } else if (code == 404) {
                return MvpApp.getContext().getString(R.string.error_file_does_not_exist);
            } else if (code == 500) {
                return MvpApp.getContext().getString(R.string.error_server_error);
            } else if (code == 503) {
                return MvpApp.getContext().getString(R.string.error_server_unreachable);
            } else {

                return MvpApp.getContext().getString(R.string.error_something_wrong_happend);
            }
        }
        return "";
    }
}
