package com.example.demo.heartbeat;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomHeartbeat implements HeartbeatSensor {
    private final SecureRandom random = new SecureRandom();
    @Override
    public int get() {
        return this.random.nextInt(40,230);
    }
}
