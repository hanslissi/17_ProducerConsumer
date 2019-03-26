/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riejoc16.producerconsumer_passwords;

import java.util.ArrayList;

/**
 *
 * @author johannesriedmueller
 */
public class ProducerConsumer {
    
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        ArrayList<Password> queue = new ArrayList<>();
        queue.add(new Password("hello"));
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        new Thread(producer, "Producer").start();
        new Thread(consumer1, "Consumer1").start();
    }
}
