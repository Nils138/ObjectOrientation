/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class GreyNode implements QTNode{
    private QTNode[] children;
    private String binary;
    
    
    public GreyNode(int x, int y, int width, Bitmap bitmap) {
        this.children = new QTNode[4];
        readBitmap(x, y, width, bitmap, 0);
        readBitmap(x+width, y, width, bitmap, 1);
        readBitmap(x+width, y+width, width, bitmap, 2);
        readBitmap(x, y+width, width, bitmap, 3);
    }
    
    private void readBitmap(int x, int y, int width, Bitmap bitmap, int c) {
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
            children[c] = new BlackLeaf();
        else if (white)
            children[c] = new WhiteLeaf();
        else
            children[c] = new GreyNode(x, y, width/2, bitmap);
    }
    
    public GreyNode(String input) { //need to return string to higher levels
        this.children = new QTNode[4];
        this.binary = input;
        for (int i = 0; i < 4; i++) {
            if (binary.charAt(0) == '1'){
                GreyNode child = new GreyNode(binary.substring(1));
                this.children[i] = child;
                binary = child.getBinary();
            }
            else if (binary.charAt(1) == '1'){
                binary = binary.substring(2);
                this.children[i] = new WhiteLeaf();
            }
            else if (binary.charAt(1) == '0'){
                binary = binary.substring(2);
                this.children[i] = new BlackLeaf();
            }
        }
    }
    
    public String getBinary() {
        return this.binary;
    }
    
    @Override
    public void fillBitmap( int x, int y, int width, Bitmap bitmap ){
        children[0].fillBitmap(x, y, width/2, bitmap);
        children[1].fillBitmap(x+width/2, y, width/2, bitmap);
        children[2].fillBitmap(x+width/2, y+width/2, width/2, bitmap);
        children[3].fillBitmap(x, y+width/2, width/2, bitmap);
    }
    
    @Override
    public void writeNode( Writer out ){
        try {
                out.write("1");
            } catch (IOException ex) {
                Logger.getLogger(GreyNode.class.getName()).log(Level.SEVERE, null, ex);
            }
        for (int i = 0; i < children.length; i++) {
            children[i].writeNode(out);
        }
    }
}
