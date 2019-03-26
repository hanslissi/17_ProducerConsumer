/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riejoc16.producerconsumer_passwords;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author johannesriedmueller
 */
public class Producer extends Thread {

    private ArrayList<Password> queue;

    public Producer(ArrayList<Password> queue) {
        this.queue = queue;
    }

    public void addToQueue(Password password) {
        queue.add(password);
    }

    public Password createNewPassword() {
        System.out.print("Enter a password: ");
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        return new Password(password);
    }

    @Override
    public void run() {
        while (true) {
            addToQueue(createNewPassword());
            synchronized (queue) {
                queue.notify();
            }
        }
    }

}
