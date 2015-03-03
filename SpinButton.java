package com.example.jd505_000.sudokusolver;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.Button;

/**
 * Created by jd505_000 on 3/2/2015.
 */
public class SpinButton extends Button
{
    AnimationSet set;
    Animation spinAnimation;

    int xAxis = 0;
    int yAxis = 0;

    public SpinButton(Context context, AttributeSet atts)
    {
        super(context, atts);

        //set = new AnimationSet(true);
        spinAnimation = new RotateAnimation(0f,360f,0,0);
        spinAnimation.setDuration(1000);
        //set.addAnimation(spinAnimation);
    }

    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        spinAnimation = new RotateAnimation(0f,360f,xNew/2,yNew/2);
        spinAnimation.setDuration(1000);
        //set.addAnimation(spinAnimation);

    }

    public void spin()
    {
        this.startAnimation(spinAnimation);
    }


}
