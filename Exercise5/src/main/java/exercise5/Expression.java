package exercise5;

import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public abstract class Expression {

    Map<String, Double> store = new HashMap<>();
    
    abstract Expression pe();
    
    abstract double eval(Map<String, Double> store);
}
