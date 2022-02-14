package OO18visitorpattern;

/**
 *
 * @author pieterkoopman
 */
public class WeightVisitor implements Visitor {
    private double totalWeight = 0.0;
    @Override
    public void visit(Book book) {
        totalWeight += book.getWeight();
    }

    @Override
    public void visit(DVD dvd) {
        totalWeight += 0.11;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Total weight = " + totalWeight + "Kg";
    }
}
