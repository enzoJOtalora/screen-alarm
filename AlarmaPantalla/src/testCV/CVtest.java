package testCV;

import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;
public class CVtest {
   
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        Simple application = new Simple();
        while(true){
        //boolean stopper = false;
        //System.out.println("El programa suena una alerta cuando hay cambios en la esquina superior derecha de la pantalla.");
        //System.out.println("Su ejecución dura 8 horas o hasta que se cierre el ejecutable.");
        if(application.getAlarma()){
            Rectangle rect = application.getRectanguloActivo();
            BufferedImage cap1 = robot.createScreenCapture(rect);
            TimeUnit.SECONDS.sleep(1);
            BufferedImage cap2 = robot.createScreenCapture(rect);
            bufferedImagesEqual(cap1,cap2);
            System.out.println("Comparación hecha");   
        } else {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("En espera");
        }
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
    }
}




