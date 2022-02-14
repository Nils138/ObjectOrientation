package exercise6;

import java.util.*;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Solver implements Visited {
    // A queue for maintaining graphs that are not visited yet.

    Queue<Configuration> toExamine = new LinkedList();
    ArrayList<Configuration> visited = new ArrayList<>();

    public Solver(Configuration g) {
        toExamine.add(g);
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            if (next.isSolution()) {
                showPath(next);
                return "Success!";
            } else {
                if (!visited.contains(next)) {
                    visited.add(next);
                    next.successors().forEach((succ) -> {
                        toExamine.add(succ);
                    });
                }
            }
        }
        return "Failure!";
    }

    public void showPath(Configuration solution) {
        List<Configuration> path = solution.pathFromRoot();
        for (int i = path.size()-1; i >= 0; i--) {
                System.out.println(path.get(i));
        }
        System.out.println(solution);
    }

    @Override
    public boolean contains(Configuration con) {
        return visited.stream().anyMatch((item) -> (con.equals(item)));
    }

    @Override
    public void add(Configuration con) {
        visited.add(con);
    }
}
