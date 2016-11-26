package com.example.kevinzhang.soulcastproto;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

public class AudioRecorder {

    private static MediaRecorder mMediaRecorder;
    private static MediaPlayer mMediaPlayer;
    private static File mAudioFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
        "audio_test.mp4");
    public boolean mHasAudioRecordingBeenStarted = false;
    private long recordingStartedTimeInMillis;
    private long recordingFinishedTimeInMillis;

    public AudioRecorder(){
        mMediaRecorder =  new MediaRecorder();
        mMediaPlayer = new MediaPlayer();
    }

    public void startRecording(){
        try{
            setRecorder();
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            recordingStartedTimeInMillis = System.currentTimeMillis();
            mHasAudioRecordingBeenStarted = true;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stopRecording(){
        try {
            mMediaRecorder.stop();
            recordingFinishedTimeInMillis = System.currentTimeMillis();
        } catch (RuntimeException ex){

        }
        mMediaRecorder.reset();
        mHasAudioRecordingBeenStarted = false;
        long recordingTimeDifference = recordingFinishedTimeInMillis - recordingStartedTimeInMillis;
        if (recordingTimeDifference > 500){
            //start playing
            startPlaying();
        }
    }

    public void startPlaying(){
        try {
            mMediaPlayer.setDataSource(mAudioFile.getAbsolutePath());
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mMediaPlayer.reset();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setRecorder(){
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        mMediaRecorder.setAudioSamplingRate(44100);
        mMediaRecorder.setAudioEncodingBitRate(96000);
        mMediaRecorder.setOutputFile(mAudioFile.getAbsolutePath());
    }
}
