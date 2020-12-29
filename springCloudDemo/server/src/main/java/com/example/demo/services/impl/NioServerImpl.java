package com.example.demo.services.impl;

import com.example.demo.services.NioServer;
import com.netflix.servo.util.ThreadFactories;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.*;

/**
 * @Author: tangdy
 * @Date: 2020/12/9 14:36
 * @Vision: 1.0
 */
public class NioServerImpl implements NioServer {

    public void read(){
        SelectorProvider provider = SelectorProvider.provider();
        ByteBuffer bb1 = ByteBuffer.allocate(48);
        try {
            FileChannel fileChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
            int status = fileChannel.read(bb1);
            while (status==-1){
                bb1.flip();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        ThreadFactories.withName("a");
        Executor executor = new ThreadPoolExecutor(5,10,10, TimeUnit.MINUTES,new LinkedBlockingDeque<Runnable>(),new ThreadPoolExecutor.AbortPolicy());
//        executor.execute(()->{i++;});
    }
}
