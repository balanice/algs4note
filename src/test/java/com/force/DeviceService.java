package com.force;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class DeviceService {

    @Test
    public void schedule() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        ScheduledFuture<?> future = service.scheduleWithFixedDelay(new MyTask(), 10, 10, TimeUnit.SECONDS);
        try {
            Thread.sleep(100000);
            future.cancel(false);
            System.out.println("cancel task");
            Thread.sleep(100000);
//            service.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyTask implements Runnable {

        public void run() {
            System.out.println("la");
        }
    }
}
