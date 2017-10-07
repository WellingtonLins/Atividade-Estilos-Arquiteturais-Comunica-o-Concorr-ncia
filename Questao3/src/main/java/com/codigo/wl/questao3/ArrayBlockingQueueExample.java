package com.codigo.wl.questao3;

import com.codigo.wl.questao3.entidade.People;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        // Capacidade para 5
        BlockingQueue<People> queue1 = new ArrayBlockingQueue<>(5);
    
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        
        threadExecutor.execute(new Consumer(queue1));
        threadExecutor.execute(new Producer(queue1));
    
  
        threadExecutor.shutdown();

    }
}