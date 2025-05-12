// AdManager.java
package com.argiusgaming.suwey;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdManager {
    private InterstitialAd interstitialAd;
    private final Context context;
    private final String interstitialAdId;

    public AdManager(Context context, String interstitialAdId) {
        this.context = context.getApplicationContext();
        this.interstitialAdId = interstitialAdId;
    }

    // Add this method to set the loaded interstitial ad
    public void setInterstitialAd(InterstitialAd interstitialAd) {
        this.interstitialAd = interstitialAd;
    }

    public void loadBannerAd(AdView adView) {
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void loadInterstitialAd(InterstitialAdLoadCallback loadCallback) {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(context, interstitialAdId, adRequest, loadCallback);
    }

    public void showInterstitialAd(Activity activity, FullScreenContentCallback callback) {
        if (interstitialAd != null) {
            interstitialAd.setFullScreenContentCallback(callback);
            interstitialAd.show(activity);
        }
    }
}