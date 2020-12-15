package Trabajo;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Programa extends JFrame{

	
	public Programa () {
		
		setBounds(300,150,200,160);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LaminaPrograma lam=new LaminaPrograma();
		add(lam);
	}
	
	
}

class LaminaPrograma extends JPanel{

	public LaminaPrograma() {
		
		
		screen=new JButton("Screen");
		
		screen.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy hh mm ss a");
				// TODO Auto-generated method stub
				try {
					
					Calendar now = Calendar.getInstance();
			        Robot robot = new Robot();
			        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(getX()+300,getY()+150,850,600));
			        ImageIO.write(screenShot, "JPG", new File("E:\\Curso Java\\"+formatter.format(now.getTime())+".jpg"));
			        System.out.println(formatter.format(now.getTime()));
					
//				BufferedImage image = new Robot().createScreenCapture(new Rectangle(ventana.getBounds()));
//				ImageIO.write(image, "png", new File("E:/Curso Java" + c));
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
				
			
		});
		
		add(screen);
		
	}

	private JButton screen;

}



