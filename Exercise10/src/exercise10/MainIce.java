/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise10;

/**
 *
 * @author Nils Kimman s107368
 * @author Ole ten Hove s1007616
 */
public class MainIce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ice icecream1 = new ChocolateDip(new WhippedCream(new VanillaIce()));
        System.out.println(icecream1.description());
        System.out.println(icecream1.price());
        Ice icecream2 = new Sprinkles(new WhippedCream(new ChocolateDip(new YoghurtIce())));
        System.out.println(icecream2.description());
        System.out.println(icecream2.price());
    }

}
