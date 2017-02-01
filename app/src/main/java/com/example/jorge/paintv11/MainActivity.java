package com.example.jorge.paintv11;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Vista vista = new Vista(this);
        setContentView(vista);
    }

    class Vista extends View {
        float x = 0;
        float y = 0;
        String accion = "accion";
        Path path = new Path();

        public Vista(Context context){
            super(context);
        }

        public int getRandomColor(){
            Random rnd = new Random();
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }

        public void onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setColor(getRandomColor());


            if(accion=="down")
                path.moveTo(x,y);
            if(accion=="move")
                path.lineTo(x,y);
            canvas.drawPath(path,paint);
        }

        public boolean onTouchEvent (MotionEvent e){
            x = e.getX();
            y = e.getY();

            if(e.getAction() == MotionEvent.ACTION_DOWN)
                accion = "down";
            if(e.getAction() == MotionEvent.ACTION_MOVE)
                accion = "move";

            invalidate();
            return true;
        }

    }
}
