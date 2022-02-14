package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public class Book extends Item {
    protected final double weight;
    protected final String author;

    public Book(double weight, String author, String title, double price) {
        super(title, price);
        this.weight = weight;
        this.author = author;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
        return String.format("Book: %s, %s %1.2f euro", author, name, price);
    }

    public double getWeight() {
        return weight;
    }

    public String getAuthor() {
        return author;
    }
}
