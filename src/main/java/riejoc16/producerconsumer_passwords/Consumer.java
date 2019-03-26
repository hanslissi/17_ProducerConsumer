/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riejoc16.producerconsumer_passwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johannesriedmueller
 */
public class Consumer extends Thread {

    private ArrayList<Password> queue;

    public Consumer(ArrayList<Password> queue) {
        this.queue = queue;
    }

    public void guessPassword(Password password) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("./files/pwlist.txt")));
            String line = "";
            Password toGuess = password;
            boolean guessed = false;
            while ((line = br.readLine()) != null) {
                if (toGuess.check(line)) {
                    System.out.println("Guessed Password! " + line);
                    guessed = true;
                }
            }
            if (!guessed) {
                System.out.println("Didn't guess password");
            }

        } catch (Exception ex) {
            System.out.println("File Error");
        }
    }

    @Override
    public void run() {
        Password toGuess = null;
        while (true) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    toGuess = queue.get(0);
                    queue.remove(0);
                } else {
                    System.out.println(Thread.currentThread().getName()+" waits now.");
                    try {
                        queue.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println(Thread.currentThread().getName()+" gets back to work.");
                }
            }
            if (toGuess != null) {
                System.out.println(Thread.currentThread().getName()+" is guessing password: "+toGuess.getPassword());
                guessPassword(toGuess);
                toGuess = null;
            }

        }
    }

}
