package cm.aptoide.pt.ethereumapiexample;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class NewAccountFragment extends DialogFragment {

  private OnDeleteAccountConfirmedListener listener;

  interface OnDeleteAccountConfirmedListener {
    void onDeleteAccountConfirmed();
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    listener = (OnDeleteAccountConfirmedListener) context;
  }

  @Override
  public void onDetach() {
    listener = null;
    super.onDetach();
  }

  @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
    alertDialogBuilder.setTitle("Delete Account");
    alertDialogBuilder.setMessage("Are you sure?");
    //null should be your on click listener
    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialogInterface, int i) {
        listener.onDeleteAccountConfirmed();
      }
    });
    alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

      @Override public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
      }
    });

    return alertDialogBuilder.create();
  }
}
