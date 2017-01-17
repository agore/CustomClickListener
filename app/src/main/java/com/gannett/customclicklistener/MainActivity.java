package com.gannett.customclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imgPicture;
    private TextView txtCaption;
    private ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPicture = (ImageView) findViewById(R.id.img1);
        txtCaption = (TextView) findViewById(R.id.tv1);

        layout = (ViewGroup) findViewById(R.id.activity_main);

        layout.setOnTouchListener(new View.OnTouchListener() {

            private float ix, iy;
            private float cx, cy;
            private boolean dragging = false;
            private float slop = ViewConfiguration.get(MainActivity.this).getScaledTouchSlop();

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ix = motionEvent.getRawX();
                        iy = motionEvent.getRawY();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        cx = motionEvent.getRawX();
                        cy = motionEvent.getRawY();

                        if (Math.abs(cx - ix) > slop || Math.abs(cy - iy) > slop) {
                            dragging = true;
                        }
                        return true;

                    case MotionEvent.ACTION_UP:
                        if (!dragging) {
                            if (txtCaption.getVisibility() == View.VISIBLE) {
                                txtCaption.setVisibility(View.GONE);
                            } else {
                                txtCaption.setVisibility(View.VISIBLE);
                            }
                        } else {
                            dragging = false;
                            Toast.makeText(MainActivity.this, "Swiped", Toast.LENGTH_SHORT).show();
                        }

                        return true;
                }


                return false;
            }
        });

    }
}
