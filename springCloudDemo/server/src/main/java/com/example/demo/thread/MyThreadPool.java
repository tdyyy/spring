package com.example.demo.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: tangdy
 * @Date: 2020/12/9 15:53
 * @Vision: 1.0
 */
public class MyThreadPool {
    private static int coreSize=5;
    private static int maxSize=10;
    private static int curSize=0;
    private Set wokers = new HashSet();
    private  ArrayBlockingQueue<Runnable> workQue = new ArrayBlockingQueue<Runnable>(100);

    public  void excute(Runnable runnable){
        //如果队列满了 遗弃掉任务
        if(workQue.size()>=100){
            return;
        }
        // 如果线程满了加入队列
        if(curSize>=maxSize&&workQue.offer(runnable)){
            return;
        }
        //线程数小于核心线程数 直接执行
        if(curSize<coreSize){
            addWork(runnable);
        }else if(workQue.size()>=80) {
            addWork(null);
        }


    }

    /**
     * 任务执行
     * @param runnable
     * @return
     */
    private  boolean runWoker(Runnable runnable){
        boolean status = false;
        //
        while (runnable!=null||((runnable = workQue.poll())!=null)){
            runnable.run();
            status = true;
        }
        return status;
    }
    class Worker implements Runnable{
        public Runnable runnable;
        @Override
        public void run(){
            runWoker(runnable);
        }
        public Worker(Runnable runnable){
            this.runnable=runnable;
        }
    }
    private Boolean addWork(Runnable runnable){
        if(wokers.size()>=maxSize){
            return false;
        }else {
            Worker worker = new Worker(runnable);
            wokers.add(worker);
            worker.run();
            return true;
        }
    }


}
