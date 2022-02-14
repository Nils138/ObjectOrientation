package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public interface Visitor {
  void visit(Book book);
  void visit(DVD dvd);
  default void visit(ShoppingCart cart) {
    for (Item i : cart.getItems()) {
      i.accept(this);
    }
  }
  default void visit(GiftBox box) {
    for (Item i : box.getItems()) {
      i.accept(this);
    }
  }
}
