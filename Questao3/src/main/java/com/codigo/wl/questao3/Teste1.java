package com.codigo.wl.questao3;

import com.codigo.wl.questao3.entidade.People;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Date  06/10/2017 @Time 22:34:11
 * @author Wellington Lins Claudino Duarte   
 * @mail wellingtonlins2013@gmail.com
 */ 
public class Teste1 {

public static void main(String[] args) {
        ArrayBlockingQueue<People> queue = new ArrayBlockingQueue(5);

        for (int i = 1; i <= 4; i++) {
            queue.offer(new People(i, "People " + i));
        }
         System.out.println(queue.toString());
        for (int i = 1; i < 8; i++) {
            System.out.println("Trying to add to queue: People " + i
                    + " and the result was " + queue.offer(new People(i, "People " + i)));
        }
        queue.element().setStatusAttendance(true);
        System.out.println(queue.toString());
    }
}