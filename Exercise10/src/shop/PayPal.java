/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class PayPal implements PaymentMethod {

    String email, address, password;

    public PayPal(String email, String address, String password) {
        this.email = email;
        this.address = address;
        this.password = password;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with email %d living at %s\n", amount, email, address);
        return true;
    }

    @Override
    public String toString() {
        return "IDeal payment from emali " + email + "with password: " + password;
    }
}
