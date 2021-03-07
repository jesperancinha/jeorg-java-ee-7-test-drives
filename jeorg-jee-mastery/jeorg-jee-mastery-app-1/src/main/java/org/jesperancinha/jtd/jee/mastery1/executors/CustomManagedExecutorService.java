package org.jesperancinha.jtd.jee.mastery1.executors;

import javax.enterprise.concurrent.ManagedExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class CustomManagedExecutorService extends ThreadPoolExecutor implements ManagedExecutorService {
    public CustomManagedExecutorService(int nThreads) {
        super(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        super.submit(task);
        return super.submit(task);
    }
}
