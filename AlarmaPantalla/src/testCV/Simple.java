package testCV;

import java.awt.MouseInfo;
import javax.swing.*;  
import java.awt.event.*; 
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
public class Simple implements ActionListener{  
    private JTextField tf1,tf2,tf3,tf4;  
    private JButton b1,b2,b3;
    private JLabel lb1,lb2,lb3,lb4;
    private boolean selector, alarma;
    private Comparador ventana;
    private Rectangle rectanguloActivo;
    Simple(){  
        this.selector = false;
        this.ventana = new Comparador(0,0,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.rectanguloActivo=new Rectangle(0,0,(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        this.alarma = false;
        JFrame f= new JFrame();  
        
        tf1=new JTextField();  
        tf1.setBounds(50,50,50,20);  
        tf1.setText("0");
        tf2=new JTextField();  
        tf2.setBounds(50,100,50,20);
        tf2.setText("0");
        tf3=new JTextField();  
        tf3.setBounds(150,50,50,20);
        tf3.setText(Integer.toString((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()));
        tf4=new JTextField();  
        tf4.setBounds(150,100,50,20); 
        tf4.setText(Integer.toString((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
        
        
        b3=new JButton("Rectángulo");  
        b3.setBounds(50,150,150,20);  
        b1=new JButton("On");  
        b1.setBounds(50,200,60,50);  
        b2=new JButton("Off");  
        b2.setBounds(140,200,60,50);  
        
        
        lb1=new JLabel("X1");
        lb1.setBounds(50,30,50,20);
        lb2=new JLabel("Y1");
        lb2.setBounds(50,80,50,20);
        lb3=new JLabel("X2");
        lb3.setBounds(150,30,50,20);
        lb4=new JLabel("Y2");
        lb4.setBounds(150,80,50,20);
                
                
        b1.addActionListener(this);  
        b2.addActionListener(this); 
        b3.addActionListener(this);
        
        f.add(tf1);f.add(tf2);f.add(b3);f.add(b1);f.add(b2);f.add(lb1);f.add(lb2);f.add(lb3);f.add(lb4);f.add(tf3);f.add(tf4);
        f.setSize(250,300);  
        f.setLayout(null);  
        f.setVisible(true);  
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }         
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==b1){  
            this.alarma=true; 
            System.out.println("alarma on");
        }else if(e.getSource()==b2){  
            this.alarma=false;
            System.out.println("alarma off");
        } else if (e.getSource()==b3){
            this.ventana.setX1(Integer.valueOf(tf1.getText()));
            this.ventana.setX2(Integer.valueOf(tf3.getText()));
            this.ventana.setY1(Integer.valueOf(tf2.getText()));
            this.ventana.setY2(Integer.valueOf(tf4.getText()));
            this.rectanguloActivo=this.ventana.seccionador();
        }  
    }
    public boolean getAlarma(){
        return this.alarma;
    }
    public Rectangle getRectanguloActivo(){
        return this.rectanguloActivo;
    }
    /*public void mouseClicked(MouseInfo e){
        System.out.println("mouseInfo");
        if(selector&&this.tf1.getText().equals("Elegir primer punto")){
            System.out.println("1er punto");
            this.x1=e.getPointerInfo().getLocation().x;
            this.y1=e.getPointerInfo().getLocation().y;
            tf1.setText(this.x1+";"+this.y1);
        } else if (selector && this.tf2.getText().equals("Elegir segundo punto")){
            System.out.println("2do punto");
            this.x2=e.getPointerInfo().getLocation().x;
            this.y2=e.getPointerInfo().getLocation().y;
            tf2.setText(this.x2+";"+this.y2);
            this.selector=false;
        }
    }*/

} 


