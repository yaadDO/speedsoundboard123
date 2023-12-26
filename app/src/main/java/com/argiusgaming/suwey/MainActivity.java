package com.argiusgaming.suwey;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private MediaPlayer mediaPlayer;
    private InterstitialAd mInterstitialAd;
    TextView counterText;
    long sec = 44;

    boolean isActive = false;


    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isActive = true;

        final Button soundButton1 = findViewById(R.id.soundButton1);
        final Button soundButton2 = findViewById(R.id.soundButton2);
        final Button soundButton3 = findViewById(R.id.soundButton3);
        final Button soundButton4 = findViewById(R.id.soundButton4);
        final Button soundButton5 = findViewById(R.id.soundButton5);
        final Button soundButton6 = findViewById(R.id.soundButton6);
        final Button soundButton7 = findViewById(R.id.soundButton7);
        final Button soundButton8 = findViewById(R.id.soundButton8);
        final Button soundButton9 = findViewById(R.id.soundButton9);
        final Button soundButton10 = findViewById(R.id.soundButton10);
        final Button soundButton11 = findViewById(R.id.soundButton11);
        final Button soundButton12 = findViewById(R.id.soundButton12);
        final Button soundButton13 = findViewById(R.id.soundButton13);
        final Button soundButton14 = findViewById(R.id.soundButton14);
        final Button soundButton15 = findViewById(R.id.soundButton15);
        final Button soundButton16 = findViewById(R.id.soundButton16);
        final Button soundButton17 = findViewById(R.id.soundButton17);
        final Button soundButton18 = findViewById(R.id.soundButton18);
        final Button soundButton19 = findViewById(R.id.soundButton19);
        final Button soundButton20 = findViewById(R.id.soundButton20);
        final Button soundButton21 = findViewById(R.id.soundButton21);
        final Button soundButton22 = findViewById(R.id.soundButton22);
        final Button soundButton23 = findViewById(R.id.soundButton23);
        final Button soundButton24 = findViewById(R.id.soundButton24);
        final Button soundButton25 = findViewById(R.id.soundButton25);
        final Button soundButton27 = findViewById(R.id.soundButton27);
        final Button soundButton28 = findViewById(R.id.soundButton28);
        final Button soundButton29 = findViewById(R.id.soundButton29);
        final Button soundButton30 = findViewById(R.id.soundButton30);
        final Button soundButton31 = findViewById(R.id.soundButton31);

        MobileAds.initialize(this, initializationStatus -> {});
        loadAds();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
       mAdView = findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       mAdView.loadAd(adRequest);
       counterText = findViewById(R.id.counter);
        loadAds();
        showads();

        soundButton1.setOnClickListener(v -> {
                playSound(R.raw.sound1);
        });

        soundButton2.setOnClickListener(v -> {
                playSound(R.raw.sound2);
        });

        soundButton3.setOnClickListener(v -> {
            playSound(R.raw.sound3);
        });

        soundButton4.setOnClickListener(v -> {
            playSound(R.raw.sound4);
        });

        soundButton5.setOnClickListener(v -> {
            playSound(R.raw.sound5);
        });

        soundButton6.setOnClickListener(v -> {
           playSound(R.raw.sound6);
        });
        soundButton7.setOnClickListener(v -> {
            playSound(R.raw.sound7);

        });

        soundButton8.setOnClickListener(v -> {
                playSound(R.raw.sound8);

        });
        soundButton9.setOnClickListener(v -> {
                playSound(R.raw.sound9);
        });

        soundButton10.setOnClickListener(v -> {
                playSound(R.raw.sound10);
        });
        soundButton11.setOnClickListener(v -> {
                playSound(R.raw.sound11);
        });

        soundButton12.setOnClickListener(v -> {
                playSound(R.raw.sound12);
        });
        soundButton13.setOnClickListener(v -> {
                playSound(R.raw.sound13);
        });

        soundButton14.setOnClickListener(v -> {
                playSound(R.raw.sound14);
        });
        soundButton15.setOnClickListener(v -> {
                playSound(R.raw.sound15);
        });

        soundButton16.setOnClickListener(v -> {
                playSound(R.raw.sound16);
        });
        soundButton17.setOnClickListener(v -> {
                playSound(R.raw.sound17);
        });

        soundButton18.setOnClickListener(v -> {
                playSound(R.raw.sound18);
        });
        soundButton19.setOnClickListener(v -> {
                playSound(R.raw.sound19);
        });

        soundButton20.setOnClickListener(v -> {
                playSound(R.raw.sound20);
        });
        soundButton21.setOnClickListener(v -> {
                playSound(R.raw.sound21);
        });

        soundButton22.setOnClickListener(v -> {
                playSound(R.raw.sound22);
        });
        soundButton23.setOnClickListener(v -> {
                playSound(R.raw.sound23);
        });

        soundButton24.setOnClickListener(v -> {
                playSound(R.raw.sound24);
        });
        soundButton25.setOnClickListener(v -> {
                playSound(R.raw.sound25);
        });
        soundButton27.setOnClickListener(v -> {
                playSound(R.raw.sound27);
        });
        soundButton28.setOnClickListener(v -> {
                playSound(R.raw.sound28);
        });
        soundButton29.setOnClickListener(v -> {
                playSound(R.raw.sound29);
        });
        soundButton30.setOnClickListener(v -> {
                playSound(R.raw.sound30);
        });
        soundButton31.setOnClickListener(v -> {
                playSound(R.raw.sound31);
        });
    }

    private void playSound(int soundResourceId) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, soundResourceId);
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive = false;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }



    private void showads() {
        if (isActive) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                           if (isActive){
                               if (mInterstitialAd != null){
                                   mInterstitialAd.show(MainActivity.this);
                                   mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                       @Override
                                       public void onAdDismissedFullScreenContent() {
                                           super.onAdDismissedFullScreenContent();
                                           mInterstitialAd = null;
                                           loadAds();
                                           showads();
                                       }

                                       @Override
                                       public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                           super.onAdFailedToShowFullScreenContent(adError);
                                           mInterstitialAd = null;
                                           loadAds();
                                           showads();
                                       }
                                   });
                               }else{
                                  showads();
                               }
                           }
                        }
                    });
                }
            }, sec * 1000);
        }
    }



    private void loadAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-9354629606296819/4216506249", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }


}
