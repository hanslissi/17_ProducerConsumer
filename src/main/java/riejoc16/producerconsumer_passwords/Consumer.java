/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riejoc16.producerconsumer_passwords;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johannesriedmueller
 */
public class Consumer extends Thread{
    private ArrayList<Password> queue;

    public Consumer(ArrayList<Password> queue) {
        this.queue = queue;
    }

    public void guessPassword(){
        
    }
    
    @Override
    public void run() {
        while(true){
            if(!queue.isEmpty()){
                
            }
            else{
                this.notify();
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}
