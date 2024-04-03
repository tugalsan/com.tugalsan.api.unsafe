package com.tugalsan.api.unsafe.client;

public class TGS_UnSafe {

    public static RuntimeException toRuntimeException(CharSequence className, CharSequence funcName, Object errorContent) {
        return new RuntimeException(TGS_UnSafe.class + ".toRuntimeException->CLASS[" + className + "] -> FUNC[" + funcName + "] -> ERR: " + errorContent);
    }

    public static void thrw(CharSequence className, CharSequence funcName, Object errorContent) {
        throw toRuntimeException(className, funcName, errorContent);
    }

    public static <R> R thrwReturns(CharSequence className, CharSequence funcName, Object errorContent) {
        throw toRuntimeException(className, funcName, errorContent);
    }

    public static void thrw(Throwable t) {
        throw new RuntimeException(t);
    }

    public static <R> R thrwReturns(Throwable t) {
        throw new RuntimeException(t);
    }

    public static void runNothing() {
    }

    public static <R> R callNull() {
        return null;
    }

    public static <R> R callValue(R result) {
        return result;
    }
}
