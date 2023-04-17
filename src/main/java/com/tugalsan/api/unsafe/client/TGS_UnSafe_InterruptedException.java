package com.tugalsan.api.unsafe.client;

public class TGS_UnSafe_InterruptedException extends RuntimeException {

    public TGS_UnSafe_InterruptedException(InterruptedException e) {
        super(e);
    }

}
