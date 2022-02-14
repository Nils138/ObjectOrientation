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
public abstract class Ice {

    protected abstract String description();

    protected abstract int price();

    protected String giveDescription() {
        return "Unknown Ice";
    }
}
