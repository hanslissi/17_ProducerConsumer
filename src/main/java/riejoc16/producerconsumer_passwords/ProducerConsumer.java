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
        Producer producer = new Producer(queue);
        producer.run();
        
    }
}
