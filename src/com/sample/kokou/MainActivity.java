package com.sample.kokou;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MainActivity extends Activity {
    private NumericView displayView;
    private Button upButton;
    private Button downButton;
    private ContinuouslyUp upper;
    private ContinuouslyDown downer;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        displayView = (NumericView)findViewById(R.id.displayView);
        upButton    = (Button)findViewById(R.id.upButton);
        downButton  = (Button)findViewById(R.id.downButton);
        
        upButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView.up();
            }
        });
        upButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                upper = new ContinuouslyUp(displayView); 
                upper.execute();
                return true;
            }
        });
        upButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ( upper != null ) upper.cancel(true);
                return false;
            }
        });
        
        downButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                displayView.down();
            }
        });
        downButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                downer = new ContinuouslyDown(displayView);
                downer.execute();
                return false;
            }
        });
        downButton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if ( downer != null ) downer.cancel(true);
                return false;
            }
        });
    }
}