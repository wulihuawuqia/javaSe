package com.multithread;

import lombok.extern.slf4j.Slf4j;

/**
 * program javaSe
 * <p>
 * description 死锁样例
 *
 * @author wuqia
 * @date 2022-04-09 23:16
 **/
@Slf4j
public class DeadLockDemo {

    /**
     * 资源一
     */
    public static byte[] resource = new byte[0];

    /**
     * 资源二
     */
    public static byte[] resourceTwo = new byte[0];


    public static void main(String[] args) {
        new Thread(() -> {
            // 同步获取资源1
            synchronized (resource) {
                log.error("{}::获取资源1", Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 同步获取资源2
                synchronized (resourceTwo) {
                    log.error("{}::获取资源2", Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程1").start();

        new Thread(() -> {
            // 同步获取资源2
            synchronized (resource) {
                log.error("{}::获取资源2", Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 同步获取资源1
                synchronized (resourceTwo) {
                    log.error("{}::获取资源1", Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"线程2").start();

    }

}
