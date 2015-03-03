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
 *
 * simple class that extends button and sets up a couple of
 * different animations based on the size of the button
 */
public class SpinButton extends Button
{
    AnimationSet set;

    Animation spinAnimation;
    Animation scaleUpAnimation;

    public SpinButton(Context context, AttributeSet atts)
    {
        super(context, atts);
        set = new AnimationSet(true);
    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        float scaleX = this.getScaleX();
        float scaleY = this.getScaleY();

        //rotates the button 360 degrees
        spinAnimation = new RotateAnimation(0f,360f,xNew/2,yNew/2);
        spinAnimation.setDuration(500);

        //scale animation from original size to 3x size
        scaleUpAnimation = new ScaleAnimation(scaleX,32*scaleX,
                scaleY,3*scaleY,xNew/2,yNew/2);
        scaleUpAnimation.setDuration(500);

        //adds the animations to the set
        set.addAnimation(spinAnimation);
        set.addAnimation(scaleUpAnimation);

    }

    //plays the spin animation
    public void spin()
    {
         this.startAnimation(set);
    }


}
