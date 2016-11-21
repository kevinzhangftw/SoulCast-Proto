package com.example.kevinzhang.soulcastproto;

import android.media.MediaRecorder;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

public class AudioRecorder {

    private static MediaRecorder mMediaRecorder;
    private static File mAudioFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),
        "audio_test.mp4");
    public boolean mHasAudioRecordingBeenStarted = false;

    public AudioRecorder(MediaRecorder mediaRecorder){
        mMediaRecorder = mediaRecorder;
    }

    public void startRecording(){
        try{
            setRecorder();
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            mHasAudioRecordingBeenStarted = true;
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stopRecording(){
        try {
            mMediaRecorder.stop();
        } catch (RuntimeException ex){

        }
        mMediaRecorder.reset();
        mHasAudioRecordingBeenStarted = false;
    }

    public void startPlaying(){

    }

    public void stopPlaying(){

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
