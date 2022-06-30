package com.tugalsan.api.unsafe.client;

import com.tugalsan.api.compiler.client.*;
import com.tugalsan.api.executable.client.*;

public class TGS_UnSafe {

    public static void catchMeIfUCan(CharSequence className, CharSequence funcName, Object errorContent) {
        throw new RuntimeException("CLASS[" + className + "] -> FUNC[" + funcName + "] -> ERR: " + errorContent);
    }

    public static <R> R catchMeIfUCanReturns(CharSequence className, CharSequence funcName, Object errorContent) {
        throw new RuntimeException("CLASS[" + className + "] -> FUNC[" + funcName + "] -> ERR: " + errorContent);
    }

    public static RuntimeException catchMeIfUCan(Throwable t) {
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
        return compile(cmp, null);
    }

    public static <R> R compile(TGS_UnSafeCompiler<R> cmp, TGS_CompilerType1<R, Exception> exception) {
        try {
            return cmp.compile();
        } catch (Exception e) {
            if (exception == null) {
                throw new RuntimeException(e);
            }
            return exception.compile(e);
        }
    }
}
