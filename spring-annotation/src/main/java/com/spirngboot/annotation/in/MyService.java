package com.spirngboot.annotation.in;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    
    @LogExecutionTime
    public void serve() {
        // Simulate a delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

