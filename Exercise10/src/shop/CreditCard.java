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
public class CreditCard implements PaymentMethod {

    int number;
    String date;

    public CreditCard(String date, int number) {
        this.date = date;
        this.number = number;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay %1.2f with card %d of %s\n", amount, number, date);
        return true;
    }

    @Override
    public String toString() {
        return "CreditCard payment with number: " + number;
    }
}
