# custom progress dialog

<b>To show</b><br/>
CustomProgessDialog customProgessDialog = new CustomProgessDialog(context);
customProgessDialog.setProgressColor(this.getResources().getColor(R.color.colorPrimary));
customProgessDialog.setTextColor(this.getResources().getColor(R.color.colorPrimary));
customProgessDialog.setCancelable(false);
customProgessDialog.show();

<b>To dismiss/cancel</b><br/>
customProgessDialog.dismiss();
