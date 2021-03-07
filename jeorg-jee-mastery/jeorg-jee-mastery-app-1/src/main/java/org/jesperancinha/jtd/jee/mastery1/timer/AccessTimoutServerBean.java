package org.jesperancinha.jtd.jee.mastery1.timer;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLACK;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@Named
@Singleton
public class AccessTimoutServerBean {

    private String result;

    @Inject
    private AccessTimeoutBean accessTimeoutBean;

    public void startTestOne() throws ExecutionException, InterruptedException {
        final ExecutorService accessImmediateTimeoutExecutorService = Executors.newFixedThreadPool(1);

        final Future<String> task11 = accessImmediateTimeoutExecutorService.submit(() -> {
            try {
                return accessTimeoutBean.accessImmediateTimeout();
            } catch (Exception e) {
                return e.getMessage();
            }
        });
        this.result = BLACK.getPText(task11.get());
        accessImmediateTimeoutExecutorService.shutdown();
        accessImmediateTimeoutExecutorService.awaitTermination(2, TimeUnit.SECONDS);
    }

    public void startTest() throws ExecutionException, InterruptedException {

        result = "";
        final ExecutorService accessImmediateTimeoutExecutorService = Executors.newFixedThreadPool(2);

        final Future<String> task11 = accessImmediateTimeoutExecutorService.submit(() -> {
            try {
                return accessTimeoutBean.accessImmediateTimeout();
            } catch (Exception e) {
                return e.getMessage();
            }
        });
        final Future<String> task12 = accessImmediateTimeoutExecutorService.submit(() -> {
            try {
                return accessTimeoutBean.accessImmediateTimeout();
            } catch (Exception e) {
                return e.getMessage();
            }
        });
        this.result += BLUE.getPText("Testing with AccessTimeout = 0");
        this.result += BLACK.getPText(task11.get());
        this.result += BLACK.getPText(task12.get());

        final Future<String> task21 = accessImmediateTimeoutExecutorService.submit(() -> {
            try {
                return accessTimeoutBean.accessIndefiniteTimeout();
            } catch (Exception e) {
                return e.getMessage();
            }
        });
        final Future<String> task22 = accessImmediateTimeoutExecutorService.submit(() -> {
            try {
                return accessTimeoutBean.accessIndefiniteTimeout();
            } catch (Exception e) {
                return e.getMessage();
            }
        });

        this.result += BLUE.getPText("Testing with AccessTimeout = -1");
        this.result += BLACK.getPText(task21.get());
        this.result += BLACK.getPText(task22.get());

        final Future<String> task31 = accessImmediateTimeoutExecutorService.submit(() -> {
            try {
                return accessTimeoutBean.accessOneSecondTimeout();
            } catch (Exception e) {
                return e.getMessage();
            }
        });
        final Future<String> task32 = accessImmediateTimeoutExecutorService.submit(() -> {
            try {
                return accessTimeoutBean.accessOneSecondTimeout();
            } catch (Exception e) {
                return e.getMessage();
            }
        });

        this.result += BLUE.getPText("Testing with AccessTimeout = 1 second");
        this.result += BLACK.getPText(task31.get());
        this.result += BLACK.getPText(task32.get());

        accessImmediateTimeoutExecutorService.shutdown();
        accessImmediateTimeoutExecutorService.awaitTermination(2, TimeUnit.SECONDS);

    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
