package org.jesperancinha.jtd.jee.mastery1.executors;

public class MainCustomManagedExecutorService extends CustomManagedExecutorService {
    public MainCustomManagedExecutorService(int nThreads) {
        super(nThreads);
    }

    public MainCustomManagedExecutorService() {
        this(2);
    }
}
