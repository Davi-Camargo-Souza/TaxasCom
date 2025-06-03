package com.davicamargo.taxascom.utils;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class TextUtil {
    public static void tremerTextView(TextView textView) {
        Animation shake = new TranslateAnimation(0, 10, 0, 0);
        shake.setDuration(100); // duração de 100ms por ciclo
        shake.setRepeatCount(5); // número de repetições
        shake.setRepeatMode(Animation.REVERSE); // vai e volta

        textView.startAnimation(shake);
    }
}
