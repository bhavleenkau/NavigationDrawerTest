package navdrawer.test.com.navigationdrawertest.others;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ProgressBar;


/**
 * Created by touchstone on 04-04-2016.
 */
public class MyAlertDialog {

    private static ProgressDialog progressDialog;
    ProgressBar progressBar;

    public static void noInternetDialog(Activity loginActivity) {

        android.app.AlertDialog dialog;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(loginActivity);
        builder.setMessage("Please make sure this device is Connected to Data Connection")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        // Create the MyAlertDialog object and return it
        dialog = builder.create();
        dialog.show();
    }

    public static void closeAlertDialog() {

        if (progressDialog != null)
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();

            }

    }

    public static void showAlertDialog(Context loginActivity, String msg) {
        android.app.AlertDialog dialog;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(loginActivity);
        builder.setMessage(msg)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        // Create the MyAlertDialog object and return it
        dialog = builder.create();
        dialog.show();
    }

    public static void showAlertDialogForGps(final Activity googleMapActivity, String s) {

        android.app.AlertDialog dialog;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(googleMapActivity);
        builder.setMessage(s)
                .setPositiveButton("Turn On", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        googleMapActivity.startActivity(gpsOptionsIntent);
                    }

                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        // Create the MyAlertDialog object and return it
        dialog = builder.create();
        dialog.show();
    }
}
