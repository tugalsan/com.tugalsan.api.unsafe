package com.tugalsan.api.unsafe.client;

import com.tugalsan.api.compiler.client.*;
import com.tugalsan.api.executable.client.*;

public class TGS_UnSafe {

    public static RuntimeException createException(CharSequence className, CharSequence funcName, Object errorContent) {
        throw new RuntimeException("CLASS[" + className + "] -> FUNC[" + funcName + "] -> ERR: " + errorContent);
    }

    public static void catchMeIfUCan(CharSequence className, CharSequence funcName, Object errorContent) {
        throw createException(className, funcName, errorContent);
    }

    public static <R> R catchMeIfUCanReturns(CharSequence className, CharSequence funcName, Object errorContent) {
        throw createException(className, funcName, errorContent);
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
        execute(exe, exception, null);
    }

    public static void execute(TGS_UnSafeExecutable exe, TGS_ExecutableType1<Exception> exception, TGS_Executable finalExe) {
        try {
            if (exe != null) {
                exe.execute();
            }
        } catch (Exception e) {
            if (exception == null) {
                throw new RuntimeException(e);
            }
            exception.execute(e);
        } finally {
            if (finalExe != null) {
                finalExe.execute();
            }
        }
    }

    public static <R> R compile(TGS_UnSafeCompiler<R> cmp) {
        return compile(cmp, null);
    }

    public static <R> R compile(TGS_UnSafeCompiler<R> cmp, TGS_CompilerType1<R, Exception> exception) {
        return compile(cmp, exception, null);
    }

    public static <R> R compile(TGS_UnSafeCompiler<R> cmp, TGS_CompilerType1<R, Exception> exception, TGS_Executable finalExe) {
        try {
            return cmp.compile();
        } catch (Exception e) {
            if (exception == null) {
                throw new RuntimeException(e);
            }
            return exception.compile(e);
        } finally {
            if (finalExe != null) {
                finalExe.execute();
            }
        }
    }

    public static void doNothing() {
    }

    public static <R> R returnNull() {
        return null;
    }
}
