/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public class Price  implements Visitor {
  private double price = 0.0;

  public double getPrice() {
    return price;
  }

  @Override
  public void visit(Book book) {
    price += book.getPrice();
  }

  @Override
  public void visit(DVD dvd) {
    price += dvd.getPrice();
  }

  @Override
  public void visit(GiftBox box) {
    price += box.getPrice(); // not the price of the items!
  }
}
