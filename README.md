# custom progress dialog

<b>Show progress dialog</b>

          
    CustomProgessDialog customProgessDialog = new CustomProgessDialog(context);
    customProgessDialog.setProgressColor(this.getResources().getColor(R.color.colorPrimary));
    customProgessDialog.setTextColor(this.getResources().getColor(R.color.colorPrimary));
    customProgessDialog.setCancelable(false);
    customProgessDialog.show();

<b>dismiss/cancel the progress dialog</b><br/>


    customProgessDialog.dismiss();
