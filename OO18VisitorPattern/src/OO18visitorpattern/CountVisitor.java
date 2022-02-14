package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public class CountVisitor implements Visitor {
  private int books = 0;
  private int dvds  = 0;
  @Override
  public void visit(Book book) {
    books += 1;
  }
  @Override
  public void visit(DVD dvd) {
    dvds += 1;
  }
/*
@Override
  public void visit(ShoppingCart cart) {
    visit(cart);
  }
*/
  public int getBooks() {
    return books;
  }
  public int getDVDs() {
    return dvds;
  }
  @Override
  public String toString() {
    return "CountVisitor{" + "books = " + books + ", dvds = " + dvds + '}';
  }
}
