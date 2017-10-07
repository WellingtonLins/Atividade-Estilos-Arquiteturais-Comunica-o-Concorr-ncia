package com.codigo.wl.questao3;

import com.codigo.wl.questao3.entidade.People;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<People> queue;

    public Producer(BlockingQueue<People> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 1; i < 8; i++) {
            System.out.println("Tentando inserir : People " + i
                    + " resultado " + queue.offer(new People(i, "People " + i)));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
