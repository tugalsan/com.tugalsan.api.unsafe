package com.tugalsan.api.unsafe.client;

import com.tugalsan.api.executable.client.*;

public class TGS_UnSafe {

    public static void catchMeIfUCan(CharSequence className, CharSequence funcName, Object errorContent) {
        throw new RuntimeException("CLASS[" + className + "] -> FUNC[" + funcName + "] -> ERR: " + errorContent);
    }

    public static <R> R catchMeIfUCanReturns(CharSequence className, CharSequence funcName, Object errorContent) {
        throw new RuntimeException("CLASS[" + className + "] -> FUNC[" + funcName + "] -> ERR: " + errorContent);
    }

    public static void catchMeIfUCan(Throwable t) {
        throw new RuntimeException(t);
    }

    public static <R> R catchMeIfUCanReturns(Throwable t) {
        throw new RuntimeException(t);
    }

    public static void execute(TGS_UnSafeExecutable exe) {
        execute(exe, null);
    }

    public static void execute(TGS_UnSafeExecutable exe, TGS_ExecutableType1<Exception> exception) {
        try {
            if (exe != null) {
                exe.execute();
            }
        } catch (Exception e) {
            if (exception == null) {
                throw new RuntimeException(e);
            }
            exception.execute(e);
        }
    }

    public static <R> R compile(TGS_UnSafeCompiler<R> cmp) {
        try {
            return cmp.compile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated //DO U REALLY NEED IT?
    public static <R, A> R compile(A inputA, TGS_UnSafeCompilerType1<R, A> cmp) {
        try {
            return cmp.compile(inputA);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated //DO U REALLY NEED IT?
    public static <R, A, B> R compile(A inputA, B inputB, TGS_UnSafeCompilerType2<R, A, B> cmp) {
        try {
            return cmp.compile(inputA, inputB);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated //DO U REALLY NEED IT?
    public static <R, A, B, C> R compile(A inputA, B inputB, C inputC, TGS_UnSafeCompilerType3<R, A, B, C> cmp) {
        try {
            return cmp.compile(inputA, inputB, inputC);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated //DO U REALLY NEED IT?
    public static <R, A, B, C, D> R compile(A inputA, B inputB, C inputC, D inputD, TGS_UnSafeCompilerType4<R, A, B, C, D> cmp) {
        try {
            return cmp.compile(inputA, inputB, inputC, inputD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
