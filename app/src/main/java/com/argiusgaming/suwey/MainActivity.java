package com.argiusgaming.suwey;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final long INTERSTITIAL_AD_DELAY_MS = 44000; // 44 seconds
    private static final String INTERSTITIAL_AD_ID = "ca-app-pub-9354629606296819/4216506249";

    private AdManager adManager;
    private SoundManager soundManager;
    private Handler adHandler;
    private AdView adView;

    private final List<SoundButton> soundButtons = Arrays.asList(
            new SoundButton(R.id.soundButton1, R.raw.sound1),
            new SoundButton(R.id.soundButton2, R.raw.sound2),
            new SoundButton(R.id.soundButton3, R.raw.sound3),
            new SoundButton(R.id.soundButton4, R.raw.sound4),
            new SoundButton(R.id.soundButton5, R.raw.sound5),
            new SoundButton(R.id.soundButton6, R.raw.sound6),
            new SoundButton(R.id.soundButton7, R.raw.sound7),
            new SoundButton(R.id.soundButton8, R.raw.sound8),
            new SoundButton(R.id.soundButton9, R.raw.sound9),
            new SoundButton(R.id.soundButton10, R.raw.sound10),
            new SoundButton(R.id.soundButton11, R.raw.sound11),
            new SoundButton(R.id.soundButton12, R.raw.sound12),
            new SoundButton(R.id.soundButton13, R.raw.sound13),
            new SoundButton(R.id.soundButton14, R.raw.sound14),
            new SoundButton(R.id.soundButton15, R.raw.sound15),
            new SoundButton(R.id.soundButton16, R.raw.sound16),
            new SoundButton(R.id.soundButton17, R.raw.sound17),
            new SoundButton(R.id.soundButton18, R.raw.sound18),
            new SoundButton(R.id.soundButton19, R.raw.sound19),
            new SoundButton(R.id.soundButton20, R.raw.sound20),
            new SoundButton(R.id.soundButton21, R.raw.sound21),
            new SoundButton(R.id.soundButton22, R.raw.sound22),
            new SoundButton(R.id.soundButton23, R.raw.sound23),
            new SoundButton(R.id.soundButton24, R.raw.sound24),
            new SoundButton(R.id.soundButton25, R.raw.sound25),
            new SoundButton(R.id.soundButton27, R.raw.sound27),
            new SoundButton(R.id.soundButton28, R.raw.sound28),
            new SoundButton(R.id.soundButton29, R.raw.sound29),
            new SoundButton(R.id.soundButton30, R.raw.sound30),
            new SoundButton(R.id.soundButton31, R.raw.sound31)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDependencies();
        setupSoundButtons();
        setupAds();
        scheduleInterstitialAd();
    }

    private void initializeDependencies() {
        MobileAds.initialize(this, status -> {});
        soundManager = new SoundManager();
        adManager = new AdManager(this, INTERSTITIAL_AD_ID);
        adHandler = new Handler();
        adView = findViewById(R.id.adView);
    }

    private void setupSoundButtons() {
        for (SoundButton soundButton : soundButtons) {
            Button button = findViewById(soundButton.buttonId);
            button.setOnClickListener(v -> soundManager.playSound(this, soundButton.soundResourceId));
        }
    }

    private void setupAds() {
        adManager.loadBannerAd(adView);
        loadInterstitialAd();
    }

    private void loadInterstitialAd() {
        adManager.loadInterstitialAd(new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                adManager.setInterstitialAd(interstitialAd);
            }
        });
    }

    private void scheduleInterstitialAd() {
        adHandler.postDelayed(() -> runOnUiThread(this::showInterstitialAd), INTERSTITIAL_AD_DELAY_MS);
    }

    private void showInterstitialAd() {
        adManager.showInterstitialAd(this, new FullScreenContentCallback() {
            @Override
            public void onAdDismissedFullScreenContent() {
                loadInterstitialAd();
                scheduleInterstitialAd();
            }

            @Override
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                loadInterstitialAd();
                scheduleInterstitialAd();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        soundManager.release();
        adHandler.removeCallbacksAndMessages(null);
    }

    private static class SoundButton {
        final int buttonId;
        final int soundResourceId;

        SoundButton(int buttonId, int soundResourceId) {
            this.buttonId = buttonId;
            this.soundResourceId = soundResourceId;
        }
    }
}