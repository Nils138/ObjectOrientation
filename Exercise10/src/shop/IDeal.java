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
public class IDeal implements PaymentMethod {

    String bank;
    int account, pin;

    public IDeal(String bank, int accountNumber, int pinNumber) {
        this.bank = bank;
        this.account = accountNumber;
        this.pin = pinNumber;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with card %d of %s\n", amount, account, pin);
        return true;
    }

    @Override
    public String toString() {
        return "IDeal payment at bank " + bank + "with number: " + account;
    }
}
