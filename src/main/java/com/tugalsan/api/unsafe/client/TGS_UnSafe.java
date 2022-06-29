package com.tugalsan.api.unsafe.client;

public class TGS_UnSafe {

    public static void of(TGS_UnSafeExecutable exe) {
        try {
            if (exe != null) {
                exe.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
