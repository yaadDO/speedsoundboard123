package com.argiusgaming.suwey;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {
    private MediaPlayer mediaPlayer;

    public void playSound(Context context, int soundResourceId) {
        stopCurrentSound();
        mediaPlayer = MediaPlayer.create(context, soundResourceId);
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void stopCurrentSound() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void release() {
        stopCurrentSound();
    }
}