package com.codigo.wl.questao3;

import com.codigo.wl.questao3.entidade.People;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    
    private BlockingQueue<People> queue;
    
    public Consumer(BlockingQueue<People> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        
        while (queue.remainingCapacity() > 0) {
            System.out.println("Queue size: " + queue.size() +
                    ", restando a capacidade : " + queue.remainingCapacity()
            + "  " + queue.toString());
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalizado" + queue.toString());
    }
}