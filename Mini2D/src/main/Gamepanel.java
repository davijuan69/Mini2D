package main;

import javax.swing.JPanel;
import java.awt.*;

public class Gamepanel extends JPanel {
    // ajustes de pantalla
    final int originalTileSize = 32; //32x32
    final int scale = 2;
    final int tileSize = originalTileSize * scale; //64x64
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    public Gamepanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

}
