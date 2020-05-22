package com.example.velic.day_30_1_alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment3 extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Выберите правильный ответ")
                .setCancelable(true)
                .setPositiveButton("Мяу",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                //dialog.cancel();
                                Toast.makeText(getActivity(), "Вы нажали на кнопку мяу",
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                .setNeutralButton("Гав",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                //dialog.cancel();
                                Toast.makeText(getActivity(), "Вы нажали на кнопку гав",
                                        Toast.LENGTH_LONG).show();
                            }
                        })
                .setNegativeButton("Сам дурак!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                //dialog.cancel();
                                Toast.makeText(getActivity(), "Вы нажали на кнопку дурак",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

        return builder.create();
    }
}
