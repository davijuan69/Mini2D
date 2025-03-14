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
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/AtrasBocetoAni2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/AtrasBocetoAni1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/AtrasBocetoAni2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/AtrasBocetoAni3.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/AtrasBocetoAni4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/CentralBocetoAni2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/CentralBocetoAni1.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/CentralBocetoAni2.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/CentralBocetoAni3.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/CentralBocetoAni4.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseIzquierdaAni2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseIzquierdaAni1.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseIzquierdaAni2.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseIzquierdaAni3.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseIzquierdaAni4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseAni2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseAni1.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseAni2.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseAni3.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/PerfilBaseAni4.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(KeyH.upPressed || KeyH.downPressed || KeyH.leftPressed || KeyH.rightPressed){
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
            spriteCounter++;
            if(spriteCounter == 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 3;
                }
                else if(spriteNum == 3){
                    spriteNum = 4;
                }
                else if(spriteNum == 4){
                    spriteNum = 5;
                }
                else if(spriteNum == 5){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        if(!KeyH.upPressed && !KeyH.downPressed && !KeyH.leftPressed && !KeyH.rightPressed){
            spriteNum = 1;
        }


    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                if(spriteNum == 3){
                    image = up3;
                }
                if(spriteNum == 4){
                    image = up4;
                }
                if(spriteNum == 5){
                    image = up5;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                if(spriteNum == 3){
                    image = down3;
                }
                if(spriteNum == 4){
                    image = down4;
                }
                if(spriteNum == 5){
                    image = down5;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if(spriteNum == 3){
                    image = left3;
                }
                if(spriteNum == 4){
                    image = left4;
                }
                if(spriteNum == 5){
                    image = left5;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right4;
                }
                if(spriteNum == 5){
                    image = right5;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
