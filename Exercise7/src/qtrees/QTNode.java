
package qtrees;

import java.io.Writer;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public interface QTNode {
    public abstract void fillBitmap( int x, int y, int width, Bitmap bitmap );
    public void writeNode( Writer out );
}
