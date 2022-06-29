package com.tugalsan.api.unsafe.client;

public class TGS_UnSafe {

    public static void catchMeIfUCan(CharSequence className, CharSequence funcName, Object errorContent) {
        throw new RuntimeException("CLASS[" + className + "] -> FUNC[" + funcName + "] -> ERR: " + errorContent);
    }

        public static void catchMeIfUCan(Throwable t) {
        throw new RuntimeException(t);
    }

    public static void of(TGS_UnSafeExecutable exe) {
        try {
            if (exe != null) {
                exe.execute();
            }
        } catch (Exception e) {
            catchMeIfUCan(e);
        }
    }
}
