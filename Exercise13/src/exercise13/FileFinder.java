package exercise13;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Nils Kimman s1007368
 * @author ole ten Hove s1007616
 */
public class FileFinder {

    private final File rootDir;
    private static boolean done;

    public FileFinder(String root) throws IOException {
        rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory");
        }
    }

    public void findFile(String file) {
        find(rootDir, file);
    }

    private void find(File rootDir, String fileName) {
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!done) {
                    if (file.getName().equals(fileName)) {
                        System.out.println("Found at: " + file.getAbsolutePath());
                        done = true;
                        return;
                    } else if (file.isDirectory()) {
                        if (java.lang.Thread.activeCount() < 256) {
                            Thread thread = new Thread(new FileFinderTest(file.toString()));
                            thread.start();
                        }
                    }
                }
            }
        }
    }
}
