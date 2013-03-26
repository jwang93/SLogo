package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.font.TextLayout;
import util.Paintable;


/**
 * paints a reference grid for the area the given graphics2D pen is responsible for
 * 
 * @author Zhen Gou
 * @author David Winegar
 * 
 */

public class Grid implements Paintable {
    private static final int DASH_VALUE = 8;
    private int myCanvasHeight;
    private int myCanvasWidth;
    private int myFrequency;
    private final Font myFont = new Font("Default", Font.PLAIN, 12);
    private final int myYoffset = 8;
    private final int myXoffset = 3;

    /**
     * instantiates the grid with bounds and frequency of lines.
     * 
     * @param bounds of grid
     * @param frequency of lines in pixels
     */
    public Grid (Dimension bounds, int frequency) {
        myCanvasHeight = (int) bounds.getHeight();
        myCanvasWidth = (int) bounds.getWidth();
        myFrequency = frequency;

    }

    @Override
    public void paint (Graphics2D pen) {

        paintVerticalLines(pen);
        paintHorizontalLines(pen);
        pen.setStroke(new BasicStroke());

    }

    /**
     * paints all vertical lines
     */
    private void paintVerticalLines (Graphics2D pen) {
        int segmentSize = myCanvasWidth / myFrequency;
        Stroke drawingStroke =
                new BasicStroke(1, BasicStroke.CAP_BUTT,
                                BasicStroke.JOIN_BEVEL, 0, new float[] {DASH_VALUE}, 0);
        new BasicStroke();
        pen.setStroke(drawingStroke);
        pen.setColor(Color.black);
        for (int i = 1; i < myFrequency + 1; ++i) {
            int myX = 0 + i * segmentSize;
            pen.drawLine(myX, 0, myX, myCanvasHeight);
            TextLayout text = new TextLayout("" + (myX - myCanvasWidth / 2),
                                             myFont, pen.getFontRenderContext());
            text.draw(pen, myX + myXoffset, myCanvasHeight - myYoffset);

        }

    }

    /**
     * paints all horizontal lines
     */
    private void paintHorizontalLines (Graphics2D pen) {
        int segmentSize = myCanvasHeight / myFrequency;
        Stroke drawingStroke =
                new BasicStroke(1, BasicStroke.CAP_BUTT,
                                BasicStroke.JOIN_BEVEL, 0, new float[] {DASH_VALUE}, 0);
        pen.setStroke(drawingStroke);
        pen.setColor(Color.black);
        for (int i = 0; i < myFrequency + 1; ++i) {
            int myY = 0 + i * segmentSize;
            pen.drawLine(0, myY, myCanvasWidth, myY);
            TextLayout text = new TextLayout("" + (myCanvasHeight / 2 - myY),
                                             myFont, pen.getFontRenderContext());
            text.draw(pen, 0 + myXoffset, myY + myYoffset * 2);

        }

    }

}
