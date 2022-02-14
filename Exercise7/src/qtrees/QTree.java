package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QTree {

    static QTNode root;

    public QTree(Reader input) throws IOException {
        root = readQTree(input);
    }

    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
    }

    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree(Writer sb) {
        root.writeNode(sb);
        try {
            sb.flush();
        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static QTNode readQTree(Reader input) throws IOException {
        int index = input.read();
        String binary = "";
        while (index >= 0) {
            binary += (char) index;
            index = input.read();
        }
        if (binary.charAt(0) == '1')
            root = new GreyNode(binary.substring(1));
        else
            if (binary.charAt(1) == '1')
                root = new WhiteLeaf();
            else if (binary.charAt(1) == '0')
                root = new BlackLeaf();
        return root;
    }

    public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
        boolean white = true, black = true;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (bitmap.getBit(x+i, y+j))
                    black = false;
                else
                    white = false;
            }
        }
        if (black)
            root = new BlackLeaf();
        else if (white)
            root = new WhiteLeaf();
        else
            root = new GreyNode(x, y, width/2, bitmap);
        return root;
    }

}
