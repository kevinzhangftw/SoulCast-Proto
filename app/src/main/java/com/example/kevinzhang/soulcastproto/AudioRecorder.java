package com.example.kevinzhang.soulcastproto;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

public class AudioRecorder {

    private static MediaRecorder mMediaRecorder;
    private static File mAudioFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
        "audio_test.mp4");

    public AudioRecorder(MediaRecorder mediaRecorder){
        mMediaRecorder = mediaRecorder;
    }

    public void startRecording(){
        setRecorder();
    }

    public void stopRecording(){
        try {
            mMediaRecorder.stop();
        } catch (RuntimeException ex){

        }
        mMediaRecorder.reset();
        mMediaRecorder.release();
    }

    public void startPlaying(){

    }

    public void stopPlaying(){

    }

    private void setRecorder(){
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        mMediaRecorder.setOutputFile(mAudioFile.getAbsolutePath());
        try{
            mMediaRecorder.prepare();
            mMediaRecorder.start();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
