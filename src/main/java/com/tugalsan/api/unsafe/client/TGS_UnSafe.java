package com.tugalsan.api.unsafe.client;

import com.tugalsan.api.executable.client.*;

public class TGS_UnSafe {

    public static void of(TGS_Executable exe) {
        try {
            if (exe != null) {
                exe.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
