package com.example.kevinzhang.soulcastproto;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;

import java.io.File;

/**
 * Created by ambar on 11/26/16.
 */

public class AudioUploader {
    TransferUtility mTransferUtility;

    public AudioUploader(TransferUtility transferUtility){
        mTransferUtility = transferUtility;
    }

    public void upload(File audiofile){
        mTransferUtility.upload(
            "soulcasttest",
            audiofile.getName(),
            audiofile
        );
    }
}
