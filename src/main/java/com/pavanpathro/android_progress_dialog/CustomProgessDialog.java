package com.pavanpathro.android_progress_dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Pavan on 24/03/18.
 */

public class CustomProgessDialog extends ProgressDialog {

    private int progressColor;
    private int textColor;
    private String message;
    private TextView textViewMessage;
    private LinearLayout transitionsContainer;
    private Animation zoomAnimation;
    private Context context;
    private ImageView imageViewLoader;

    public CustomProgessDialog(Context context) {
        super(context);
        this.context = context;
    }

    public CustomProgessDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public void setProgressColor(int color) {
        progressColor = color;
    }

    public void setTextColor(int color) {
        textColor = color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_progress_dialog);

        transitionsContainer = findViewById(R.id.transitionsContainer);

        zoomAnimation = AnimationUtils.loadAnimation(context, R.anim.zoom);

        if (progressColor == 0) {
            progressColor = getContext().getResources().getColor(R.color.colorPrimary);
        }

        if (textColor == 0) {
            textColor = getContext().getResources().getColor(R.color.colorPrimary);
        }

        if (message == null || message.isEmpty()) {
            message = getContext().getString(R.string.please_wait_1);
        }

        imageViewLoader = findViewById(R.id.imageViewLoader);
        imageViewLoader.setVisibility(View.INVISIBLE);

        textViewMessage = findViewById(R.id.textViewMessage);
        textViewMessage.setTextColor(textColor);
        textViewMessage.setText(message);

        loadingAnimation();
        loaderAnimation();

//        ProgressBar progressBar = findViewById(R.id.progressBar);
//        progressBar.getIndeterminateDrawable().setColorFilter(progressColor, PorterDuff.Mode.MULTIPLY);
//        progressBar.setVisibility(View.GONE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(transitionsContainer);
        }
    }

    private void loadingAnimation() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

//                imageViewLoader.setVisibility(View.INVISIBLE);

                if (textViewMessage.getText().toString().contains(" . . .")) {
                    textViewMessage.setText(getContext().getString(R.string.please_wait_1));
                } else if (textViewMessage.getText().toString().contains(" . .")) {
                    textViewMessage.setText(getContext().getString(R.string.please_wait_3));
                } else if (textViewMessage.getText().toString().contains(" .")) {
                    textViewMessage.setText(getContext().getString(R.string.please_wait_2));
                } else {
                    textViewMessage.setText(getContext().getString(R.string.please_wait_1));
                }

//                imageViewLoader.setVisibility(View.VISIBLE);
//                imageViewLoader.startAnimation(zoomAnimation);

                loadingAnimation();
            }
        }, 800);
    }

    private void loaderAnimation() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageViewLoader.setVisibility(View.VISIBLE);
                imageViewLoader.startAnimation(zoomAnimation);


                loaderAnimation();
            }
        }, 2400);
    }

}
