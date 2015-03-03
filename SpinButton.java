package com.example.jd505_000.sudokusolver;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

/**
 * Created by jd505_000 on 3/2/2015.
 */
public class SpinButton extends Button
{
    AnimationSet introset;

    Animation spinAnimation;
    Animation scaleUpAnimation;

    public SpinButton(Context context, AttributeSet atts)
    {
        super(context, atts);

        introset = new AnimationSet(true);

    }


    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);


        float scaleX = this.getScaleX();
        float scaleY = this.getScaleY();

        spinAnimation = new RotateAnimation(0f,360f,xNew/2,yNew/2);
        spinAnimation.setDuration(500);

        scaleUpAnimation = new ScaleAnimation(scaleX,2*scaleX,
                scaleY,2*scaleY,xNew/2,yNew/2);
        scaleUpAnimation.setDuration(500);



        introset.addAnimation(spinAnimation);
        introset.addAnimation(scaleUpAnimation);

    }

    public void spin()
    {
         this.startAnimation(introset);
    }


}
