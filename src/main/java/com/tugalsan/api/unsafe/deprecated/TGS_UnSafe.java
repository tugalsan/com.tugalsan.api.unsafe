package com.tugalsan.api.unsafe.deprecated;

import com.tugalsan.api.callable.client.TGS_CallableType1;
import com.tugalsan.api.runnable.client.TGS_Runnable;
import com.tugalsan.api.runnable.client.TGS_RunnableType1;
import java.util.concurrent.Callable;

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

    //-------------------- INTERRUPTED EXCEPTION ----------------
    public static void throwIfInterruptedException(Exception e) throws InterruptedException {
        if (e instanceof InterruptedException) {// U NEED THIS SO STRUCTURED SCOPE CAN ABLE TO SHUT DOWN
            throw (InterruptedException) e;
        }
    }

    public static void run(TGS_UnSafeRunnable exe) throws InterruptedException {
        run(exe, null);
    }

    public static void run(TGS_UnSafeRunnable exe, TGS_RunnableType1<Exception> exception)throws InterruptedException  {
        run(exe, exception, null);
    }

    public static void run(TGS_UnSafeRunnable exe, TGS_RunnableType1<Exception> exception, TGS_Runnable finalExe) throws InterruptedException {
        try {
            if (exe != null) {
                exe.run();
            }
        } catch (Exception e) {
            throwIfInterruptedException(e);
            if (exception == null) {
                throw new RuntimeException(e);
            }
            exception.run(e);
        } finally {
            if (finalExe != null) {
                finalExe.run();
            }
        }
    }

    public static <R> R call(Callable<R> cmp) throws InterruptedException {
        return call(cmp, null);
    }

    public static <R> R call(Callable<R> cmp, TGS_CallableType1<R, Exception> exception) throws InterruptedException {
        return call(cmp, exception, null);
    }

    public static <R> R call(Callable<R> cmp, TGS_CallableType1<R, Exception> exception, TGS_Runnable finalExe)throws InterruptedException  {
        try {
            return cmp.call();
        } catch (Exception e) {
            throwIfInterruptedException(e);
            if (exception == null) {
                throw new RuntimeException(e);
            }
            return exception.call(e);
        } finally {
            if (finalExe != null) {
                finalExe.run();
            }
        }
    }
}
