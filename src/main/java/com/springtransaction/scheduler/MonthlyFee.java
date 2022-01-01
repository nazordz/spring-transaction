package com.springtransaction.scheduler;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class MonthlyFee {
    
    /**
     * Property fixedDelay will run your method after '5' second when previous is executed
     * Property initialDelay will make your method running after delay for '2' second
     */
    // @Scheduled(fixedDelay = 5000, initialDelay = 2000)
    // public void checkDelay() {
    //     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //     System.out.println("Task executed at: " + dateFormat.format(System.currentTimeMillis()));
    // }

    /**
     * Property fixedRate will run your method every '1' second, but it's not asynchronously.
     * if you want to asynchronously, you need add annotation @EnableAsync on the top of class
     * and annotation @Async on the top of method.
     * @throws InterruptedException
     */
    // @Async
    // @Scheduled(fixedRate = 1000)
    // public void checkRate() throws InterruptedException {
    //     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //     System.out.println("Task executed at: " + dateFormat.format(System.currentTimeMillis()));

        // for demo. just like `setTimeout()` in js
        // Thread.sleep(10000);
    // }

    /**
     * Cron job running daily for every 2am
     */
    // @Scheduled(cron = "0 2 * * *")
    // public void runDaily() {
        
    // }
}
