/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riejoc16.producerconsumer_passwords;

/**
 *
 * @author johannesriedmueller
 */
public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }
    
    public boolean check(String otherPassword){
        return password.equals(otherPassword);
    }
}
