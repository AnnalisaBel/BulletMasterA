package com.example.bulletmaster;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class StartActivity extends AppCompatActivity {

    private Intent intgotolev;
    private Button butstartgame;
    private MediaPlayer startsong;
    private VideoView vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //transizione che svanisce
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.activity_start);

        butstartgame = findViewById(R.id.butstartgame);

        //bottone reso operativo dopo dei secondi
        butstartgame.setEnabled(false);
        new CountDownTimer(5000, 10) { //Set Timer for 5 seconds
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                butstartgame.setEnabled(true);
            }
        }.start();

        //azione del bottone impostata per cambio di activity
        butstartgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intgotolev = new Intent(StartActivity.this, LevelsActivity.class);
                startsong.release();
                startActivity(intgotolev);



            }
        });

        //animazione del bottone che compare lentamente
       /* Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        butstartgame.startAnimation(aniFade);

        this.RunAnimation();*/



       startsong = MediaPlayer.create(StartActivity.this, R.raw.ssbb);
        startsong.start();



        vid = findViewById(R.id.videoView);



        this.playVideo(vid);
        this.RunAnimation();
    }

    public void playVideo(View v) {

        MediaController m = new MediaController(this);
        vid.setMediaController(m);
        Uri u = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videobullet);

        vid.setVideoURI(u);

        vid.start();
    }//Your code herek

    /*TO DO
        testo che scorre dall'alto verso il basso
        bottone lo posso utilizzare appena compare DONE
        cambiare activity in maniera fluida DONE
         */

    //animazione testo
    private void RunAnimation()
    {
       TextView st = findViewById(R.id.textstart);
       Animation transl = new TranslateAnimation(0,0,-900,50);
        transl.setDuration(10000);
        st.startAnimation(transl);

        Animation aniFade = new AlphaAnimation(1/100,8);
        aniFade.setDuration(30000);
        butstartgame.startAnimation(aniFade);


        /* Animation a = AnimationUtils.loadAnimation(this, R.anim.translate); //Creo un oggetto Animation che ottengo caricando il file xml scale in cui è presente l'animazione che voglio ottenere
        a.reset(); //??
        TextView tv = (TextView) findViewById(R.id.textstart); //definisco l'oggetto da animare, che è un TextView
        tv.clearAnimation(); //??
        tv.startAnimation(a); //animo l'oggetto*/
    }

    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("----main activity---onStart---");
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

    }





    }


