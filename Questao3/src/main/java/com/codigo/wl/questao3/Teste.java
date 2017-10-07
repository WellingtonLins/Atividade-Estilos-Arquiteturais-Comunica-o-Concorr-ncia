package com.codigo.wl.questao3;

import com.codigo.wl.questao3.entidade.People;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Date 06/10/2017 @Time 18:00:37
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class Teste {

    private double gx(double x) {
        return 2 * x;
    }

    private double fx(double x) {
        return 0.8333 * Math.exp(-x);
    }

    private double hx(double x) {
        return 0.3 * Math.pow(x, x);
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<People> queue = new ArrayBlockingQueue(5);
        ArrayBlockingQueue<People> queue2 = new ArrayBlockingQueue(5);

        for (int i = 1; i <= 5; i++) {
            queue.offer(new People(i, "People " + i));
        }

        System.out.println("Queue1\n"+ queue.toString());

        for (int i = 1; i <= 5; i++) {
            People p = queue.peek();
            p.setStatusAttendance(true);
            queue2.offer(p);
        }

//        queue.element().setStatusAttendance(true);
        System.out.println("Queue2\n = " + queue2.toString());

    }
}
