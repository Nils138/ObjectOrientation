package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public class InternationalPostage implements Visitor {

  private double postage = 0.0;

  @Override
  public void visit(Book book) {
    if (book.getPrice() < 50.00) {
      postage += book.getWeight() < 0.1 ? 4.00 : 12.50;
    }
  }

  @Override
  public void visit(DVD dvd) {
    postage += 2.50;
  }

  public double getPostage() {
    return postage;
  }

  @Override
  public String toString() {
    return String.format("International postage %1.2feuro", postage);
  }
}

