package com.tugalsan.api.unsafe.server;

import com.tugalsan.api.callable.client.TGS_CallableType1;
import com.tugalsan.api.runnable.client.TGS_Runnable;
import com.tugalsan.api.runnable.client.TGS_RunnableType1;
import com.tugalsan.api.unsafe.client.TGS_UnSafeRunnable;
import java.util.concurrent.Callable;

public class TS_UnSafe {

    public static void throwIfInterruptedException(Exception e) {
        if (e instanceof InterruptedException) {// U NEED THIS SO STRUCTURED SCOPE CAN ABLE TO SHUT DOWN
            Thread.currentThread().interrupt();
        }
    }

    public static void run(TGS_UnSafeRunnable exe) {
        run(exe, null);
    }

    public static void run(TGS_UnSafeRunnable exe, TGS_RunnableType1<Exception> exception) {
        run(exe, exception, null);
    }

    public static void run(TGS_UnSafeRunnable exe, TGS_RunnableType1<Exception> exception, TGS_Runnable finalExe) {
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

    public static <R> R call(Callable<R> cmp) {
        return call(cmp, null);
    }

    public static <R> R call(Callable<R> cmp, TGS_CallableType1<R, Exception> exception) {
        return call(cmp, exception, null);
    }

    public static <R> R call(Callable<R> cmp, TGS_CallableType1<R, Exception> exception, TGS_Runnable finalExe) {
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
