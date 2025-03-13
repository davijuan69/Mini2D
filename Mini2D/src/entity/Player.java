package entity;

import main.Gamepanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    Gamepanel gp;
    KeyHandler KeyH;

    public Player(Gamepanel gp, KeyHandler KeyH) {
        this.gp = gp;
        this.KeyH = KeyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/AtrasBoceto.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/CentralBoceto.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseIzquierda.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBase.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(KeyH.upPressed){
            direction = "up";
            y -= speed;
        }
        else if(KeyH.downPressed){
            direction = "down";
            y += speed;
        }
        else if(KeyH.leftPressed){
            direction = "left";
            x -= speed;
        }
        else if(KeyH.rightPressed){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.WHITE);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch (direction){
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
