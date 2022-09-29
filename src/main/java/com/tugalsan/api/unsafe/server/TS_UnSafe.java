package com.tugalsan.api.unsafe.server;

import com.tugalsan.api.compiler.client.*;
import com.tugalsan.api.executable.client.*;
import com.tugalsan.api.unsafe.client.*;
import java.util.concurrent.locks.*;

public class TS_UnSafe {

    public static <R> R compileSafe(TGS_UnSafeCompiler<R> cmp, TGS_CompilerType1<R, Exception> exception) {
        var lock = new ReentrantLock();
        lock.lock();
        return TGS_UnSafe.compile(cmp, exception, () -> lock.unlock());
    }

    public static void executeSafe(TGS_UnSafeExecutable exe, TGS_ExecutableType1<Exception> exception) {
        var lock = new ReentrantLock();
        lock.lock();
        TGS_UnSafe.execute(exe, exception, () -> lock.unlock());
    }
}
