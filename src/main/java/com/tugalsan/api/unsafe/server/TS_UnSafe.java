package com.tugalsan.api.unsafe.server;

import com.tugalsan.api.compiler.client.TGS_CompilerType1;
import com.tugalsan.api.executable.client.TGS_ExecutableType1;
import static com.tugalsan.api.unsafe.client.TGS_UnSafe.compile;
import static com.tugalsan.api.unsafe.client.TGS_UnSafe.execute;
import com.tugalsan.api.unsafe.client.TGS_UnSafeCompiler;
import com.tugalsan.api.unsafe.client.TGS_UnSafeExecutable;
import java.util.concurrent.locks.ReentrantLock;

public class TS_UnSafe {

    public static <R> R compileSafe(TGS_UnSafeCompiler<R> cmp, TGS_CompilerType1<R, Exception> exception) {
        var lock = new ReentrantLock();
        lock.lock();
        return compile(cmp, exception, () -> lock.unlock());
    }

    public static void executeSafe(TGS_UnSafeExecutable exe, TGS_ExecutableType1<Exception> exception) {
        var lock = new ReentrantLock();
        lock.lock();
        execute(exe, exception, () -> lock.unlock());
    }
}
