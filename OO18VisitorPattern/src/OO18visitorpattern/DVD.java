package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public class DVD extends Item {

  protected final double duration;
  protected final int count;

  public DVD(double duration, int count, String name, double price) {
    super(name, price);
    this.duration = duration;
    this.count = count;
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }

  @Override
  public String toString() {
    return String.format("DVD: %s, %d discs, %1.2f euro", name, count, price);
  }

  public double getDuration() {
    return duration;
  }

  public int getCount() {
    return count;
  }
}
