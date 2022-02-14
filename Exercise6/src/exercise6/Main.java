package exercise6;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Main
{
    public static void main(String[] args) {
        int [] game2 = {2,3,6, 1,5,9, 4,7,8};
        int [] game = {1,3,6, 8,2,4, 5,9,7};

        SlidingGame s = new SlidingGame (game, null);
        System.out.println(s);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
