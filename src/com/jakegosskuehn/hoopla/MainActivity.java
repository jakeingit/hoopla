
package com.jakegosskuehn.hoopla;

import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends Activity {
    
    private SoundPool soundPool;  
    boolean loaded = false;
    boolean songloaded = false;
    private int hoopla_sound;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setContentView(R.layout.activity_main);
        //View view = findViewById(R.id.toptext);
//        view.setOnTouchListener(this);
 //uncomment these lines below so it will HONK with text... nut will not HONK with noise.. fuck
        // addListenerOnButton();
        // Set the hardware buttons to control the music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                    int status) {
                loaded = true;
//                Toast.makeText(MainActivity.this,
//                        "FULLY LOADED TO HONK!!!", Toast.LENGTH_SHORT).show();
            }
        });
        
        hoopla_sound = soundPool.load(this, R.raw.hoopla, 1);

        
        
        Toast.makeText(MainActivity.this,
                "Hoopla.exe.gif.mp3 Loaded", Toast.LENGTH_SHORT).show();

    }
    
    public void amazinghonks(View view)
    {
        
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        
       
        
        boolean uno = (loaded);

        //plays if it is loaded
        if(uno)
        {
            soundPool.play(hoopla_sound, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played hooplasound");
        }      
        
        hooplaanimation();
    }

    public void waitTimer()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            Log.e("Test", "SLEEP 1000");
        }
    }
    
    class Starter implements Runnable {
        public void run() {
             animation.start();
         }
     }
    
    public void hooplaanimation()
    {
        animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.h1), 50);
        animation.addFrame(getResources().getDrawable(R.drawable.h2), 50);
        animation.addFrame(getResources().getDrawable(R.drawable.h3), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.h4), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.h5), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.h6), 150);
        animation.addFrame(getResources().getDrawable(R.drawable.h7), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.h8), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.h3), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.h2), 50);
        animation.addFrame(getResources().getDrawable(R.drawable.h1), 50);
        animation.setOneShot(true);
       
        ImageButton imageView = (ImageButton) findViewById(R.id.imageButton1);
//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(80, 90);
//        params.alignWithParent = true;
//        params.addRule(RelativeLayout.CENTER_IN_PARENT);       

//        imageView.setLayoutParams(params);
        imageView.setImageDrawable(animation);
        imageView.post(new Starter());
        
        
        
        
        

        // Start the animation (looped playback by default).
//        rocketAnimation.start();
        
     /*   hp1.setImageResource(R.drawable.h1);   
        waitTimer();
        hp1.setImageResource(R.drawable.h2);  
        hp1.setImageResource(R.drawable.h3);
        waitTimer();
        hp1.setImageResource(R.drawable.h4);
        waitTimer();
        hp1.setImageResource(R.drawable.h5);
        waitTimer();
        hp1.setImageResource(R.drawable.h6);
        waitTimer();
        hp1.setImageResource(R.drawable.h7);
        waitTimer();
        hp1.setImageResource(R.drawable.h8);*/

    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

}
