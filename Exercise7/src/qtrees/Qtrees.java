package qtrees;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Qtrees {

    public static void main(String[] args) {
        try {
            String test_text = "10011010001010010001010101100011000101000000";
            StringReader input = new StringReader(test_text);
            //binary to quad tree
            QTree qt = new QTree(input);
            //quad tree to binary
            qt.writeQTree(new PrintWriter(System.out)); //equals test_text
            
            System.out.println(""); //newline
            
            Bitmap bitmap = new Bitmap(8, 8);
            //quad tree to bitmap
            qt.fillBitmap(bitmap);
            System.out.println(bitmap);
            //bitmap to quadtree
            QTree qt2 = new QTree(bitmap);
            //and back to bitmap to check
            qt2.fillBitmap(bitmap);
            System.out.println(bitmap);
        } catch (IOException ex) {
            Logger.getLogger(Qtrees.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
