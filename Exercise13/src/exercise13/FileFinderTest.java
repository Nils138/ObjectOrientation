package exercise13;

import java.io.IOException;

/**
 *
 * @author Nils Kimman s1007368
 * @author ole ten Hove s1007616
 */
public class FileFinderTest implements Runnable {
    private static String root = "";
    /**
     * Constructor which is used by new threads
     *
     * @param root
     */
    public FileFinderTest(String root) {
        try {
            String goal = "txt.test";
            this.root = root;
            FileFinder ff = new FileFinder(root);
//            FileFinderSeq ff = new FileFinderSeq(root);
            ff.findFile(goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            //System.err.println( e );
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        root = "D:\\Netbeans";
        FileFinderTest();
    }

    /**
     * Function which finds a file
     */
    public static void FileFinderTest() {
        try {
            String goal = "txt.test";
            FileFinder ff = new FileFinder(root);
            ff.findFile(goal);
//            System.out.println(goal + " not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        FileFinderTest();
    }
}
