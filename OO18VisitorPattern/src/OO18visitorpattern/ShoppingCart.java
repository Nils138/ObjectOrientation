/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OO18visitorpattern;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author pieterkoopman
 */
public class ShoppingCart implements Visitable {
    protected List<Item> items;

    public ShoppingCart() {
        items = new LinkedList<>();
    }
    
    public void add(Item item) {
        items.add(item);
    }

  public List<Item> getItems() {
    return items;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    return items.toString();
  }
}
