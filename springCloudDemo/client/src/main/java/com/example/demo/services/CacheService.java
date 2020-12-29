package com.example.demo.services;

/**
 * @Author: tangdy
 * @Date: 2020/12/14 10:57
 * @Vision: 1.0
 */
public interface CacheService {
    public <T> T get(String key);
    public boolean set(String key,Object obj,int timeout);
    public boolean lock(String key,Object obj,int timeout);
    public long publish(String channel, String message);
    public long subscription(String channel, String message);
    public boolean rLock(String name,long waitTime, long leaseTime);
    public void rUnLock(String name);

}
