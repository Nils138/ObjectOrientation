/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OO18visitorpattern;

import java.util.List;

/**
 *
 * @author pieterkoopman
 */
public class GiftBox extends Item {
  private final List<Item> items;

  public GiftBox(List<Item> items, String name, double price) {
    super(name, price);
    this.items = items;
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }

  public List<Item> getItems() {
    return items;
  }
}
