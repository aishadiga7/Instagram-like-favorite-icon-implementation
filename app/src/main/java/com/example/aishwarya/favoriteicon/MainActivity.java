package com.example.aishwarya.favoriteicon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements AnimationStopListener {


    private ImageView greyFavIcon;
    private ImageView orangeFavIcon;
    private View circleBackground;
    private static final DecelerateInterpolator DECCELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final AccelerateInterpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
    private GestureDetector detector;

// Add this inside onCreate()


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orangeFavIcon = (ImageView) findViewById(R.id.bookmark);
        greyFavIcon = (ImageView) findViewById(R.id.heart);
        circleBackground = findViewById(R.id.circleBg);
        detector = new GestureDetector(this, new GestureListener());
        greyFavIcon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }

        });
    }



    @Override
    public void onAnimationStop() {
    }

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }



        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (greyFavIcon.getVisibility() == View.GONE) {
                greyFavIcon.setVisibility(View.VISIBLE);
                orangeFavIcon.setVisibility(View.GONE);
                circleBackground.setVisibility(View.GONE);
                AnimationUtils.heart(circleBackground, greyFavIcon, orangeFavIcon);

            } else {
                AnimationUtils.heart(circleBackground, greyFavIcon, orangeFavIcon);
            }

            return true;
        }
    }

}
