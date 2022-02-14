package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public abstract class Item implements Visitable {

  protected final String name;
  protected final double price;

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format("%s %1.2f euro", name, price);
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }
}
