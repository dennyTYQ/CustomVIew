package com.tyqtest.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_main);
        final ViewOfQuade viewOfQuade = (ViewOfQuade) findViewById(R.id.myView);
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewOfQuade.reset();
            }
        });
        viewOfQuade.startAnim();
*//*
        setContentView(R.layout.main);
        WaveView waveView = (WaveView) findViewById(R.id.WaveView);
        waveView.startAnim();*/
      //  setContentView(new MyView(this));
       // setContentView(new SeconView(this));
       // setContentView(new personView(this));
       // setContentView(new ViewMicrophone(this));
       // setContentView(new RegionView(this));
       // setContentView(new ViewOfRotate(this));
//        setContentView(new Star(this));
        //setContentView(new ViewOfXfermode(this));
        /*
        setContentView(R.layout.layout_main1);
        ViewOfPS viewOfPS = (ViewOfPS) findViewById(R.id.ps);*/
        setContentView(R.layout.layout_card);



    }
}
