package testCV;

import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;

public class Comparador{
    private int x1,y1,x2,y2,boundX,boundY;
    private boolean validator;
    Comparador(int x1, int y1, int x2, int y2){
        this.x1=x1;
        this.x2=x2;
        this.y1=y1;
        this.y2=y2;
        this.boundX=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.boundY=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.validator=true;
    }
    
    public void setX1(int x1){
        this.x1=x1;
    }
    public void setX2(int x2){
        this.x2=x2;
    }
    public void setY1(int y1){
        this.y1=y1;
    }
    public void setY2(int y2){
        this.y2=y2;
    }
    
    
    public Rectangle seccionador(){
        int X,Y,width,height;
        if(this.x1>this.x2){
            X=this.x2;
            width=this.x1-this.x2;
        } else {
            X=this.x1;
            width=this.x2-this.x1;
        }
        
        if(this.y1>this.y2){
            Y=this.y2;
            height=this.y1-this.y2;
        } else {
            Y=this.y1;
            height=this.y2-this.y1;
        }
        if(X+width>this.boundX){
            width=boundX-X;
        }
        if(Y+height>this.boundY){
            height=boundY-Y;
        }
        return new Rectangle(X,Y,width,height);
    }
}
    
    

    /*public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        //boolean stopper = false;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        //System.out.println("El programa suena una alerta cuando hay cambios en la esquina superior derecha de la pantalla.");
        //System.out.println("Su ejecución dura 8 horas o hasta que se cierre el ejecutable.");
        int i = 0;
        int[] pos = {3*screenWidth/4,0,1*screenWidth/4,screenHeight/12};
        Rectangle rect = new Rectangle(pos[0], pos[1], pos[2], pos[3]);
        while(i<691200){
        BufferedImage cap1 = robot.createScreenCapture(rect);
        TimeUnit.SECONDS.sleep(1);
        i++;
        BufferedImage cap2 = robot.createScreenCapture(rect);
        System.out.println(bufferedImagesEqual(cap1,cap2));
        }
    }
    public static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
    if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                if (img1.getRGB(x, y) != img2.getRGB(x, y)){
                    Toolkit.getDefaultToolkit().beep();
                    return false;
                }
            }
        }
    } else {
        Toolkit.getDefaultToolkit().beep();
        return false;
    }
    return true;
    }*/

