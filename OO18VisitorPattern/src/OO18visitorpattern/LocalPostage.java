package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public class LocalPostage implements Visitor {

  private double postage = 0.0;

  @Override
  public void visit(Book book) {
    if (book.getPrice() < 25.00) {
      postage += book.getPrice() < 25.00 ? 1.40 : 2.50;
    }
  }

  @Override
  public void visit(DVD dvd) {
    postage += 1.50;
  }

  public double getPostage() {
    return postage;
  }

  @Override
  public String toString() {
    return String.format("Local postage %1.2feuro", postage);
  }
}
