package OO18visitorpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pieterkoopman
 */
public class OO18VisitorPattern {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    OO18VisitorPattern o = new OO18VisitorPattern();
    o.run();
  }

  private void run() {
    ShoppingCart cart = new ShoppingCart();
    cart.add(new Book(0.8, "Douglas Hofstadter", "Godel, Escher, Bach", 17.99));
    cart.add(new Book(0.1, "J. K. Rowling", "Sorcerer's Stone", 12.35));
    cart.add(new DVD(2.28, 1, "Spectre", 14.99));
    Item [] adams = {new Book(0.5,"Adams","The Hitchhiker's Guide to the Galaxy",14.99),
                     new Book(0.5,"Adams","The Restaurant at the End of the Universe",14.99)};
    cart.add(new GiftBox(Arrays.asList(adams),"Hitchhiker's Guide",19.99));

    System.out.println(cart);

    WeightVisitor weight = new WeightVisitor();
    cart.accept(weight);
    System.out.println(weight);

    LocalPostage paostage = new LocalPostage();
    cart.accept(paostage);
    System.out.println(paostage);

    InternationalPostage postageInt = new InternationalPostage();
    cart.accept(postageInt);
    System.out.println(postageInt);
    
    Price price = new Price();
    cart.accept(price);
    System.out.println("total price = " + price.getPrice());
    
    CountVisitor count = new CountVisitor();
    cart.accept(count);
    System.out.println(count);
    
    countBooksAndDVDs(cart);
    
    Counter counter = new Counter();
    counter.count(cart.getItems());
    System.out.println(counter);
  }
  
  private static void countBooksAndDVDs(ShoppingCart cart) { // Bah
    int books = 0;
    int dvds  = 0;
    for (Item item: cart.getItems()) {
      if (item.getClass() == Book.class)
        books += 1;
      else if (item.getClass() == DVD.class)
        dvds += 1;
      else if (item.getClass() == GiftBox.class) {
        GiftBox box = (GiftBox) item;
        for (Item subItem: box.getItems())
          if (subItem.getClass() == Book.class)
            books += 1;
          else if (subItem.getClass() == DVD.class)
            dvds += 1;
          else if (subItem.getClass() == GiftBox.class) {
            throw new IllegalArgumentException("No recursive GiftBoxes please");
          }
      }
    }
    System.out.println("countBooksAndDVDs found " + books + " books, and " + dvds + " DVDs.");
  }
  
  private class Counter {
    int books = 0;
    int dvds  = 0;

    private void count (List<Item> items) {
      for (Item i: items)
        count(i);
    }
    private void count(Book b) { books += 1; }
    private void count(DVD  d) { dvds  += 1; }
    private void count(GiftBox box) {count(box.getItems());}
    private void count(Item i) {
      if (i instanceof Book)    // also ugly, needed in count (List<Item> items)
        count ((Book) i);
      else if (i instanceof DVD)
        count ((DVD) i);
      else if (i instanceof GiftBox)
        count ((GiftBox) i);
      else
        throw new IllegalArgumentException("Unknown Item subtype " + i.getClass());
    }

    @Override
    public String toString() {
      return "Counter found " + books + " books and " + dvds + " dvds.";
    }
  }
}
