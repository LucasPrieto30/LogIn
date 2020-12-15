package Trabajo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

public class InterfazLogIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PantallaLogIn login=new PantallaLogIn();
		
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
	
	}

}

class PantallaLogIn extends JFrame{
	
	public PantallaLogIn (){
		
		
		setBounds(500,250,640,430);
		setTitle("Log in");
		URL icono1=PantallaLogIn.class.getResource("imgs/icono.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(icono1));
		setResizable(false);
		LaminaLogIn lamina=new LaminaLogIn();
		add(lamina);
		
	}


}


class LaminaLogIn extends JPanel  {
    // The Image to store the background image in.
	URL ruta_fondo=LaminaLogIn.class.getResource("imgs/Loginpic3.jpg");
	
    Image fondo;
    public boolean ingresoCorrecto;
    public LaminaLogIn() {

    	setLayout(new UbicaCampos());
    			
    		try {
    			
    			fondo=ImageIO.read(ruta_fondo);
    			}
    		catch(IOException e) {
    				
    				System.out.println("Archivo no encontrado");
    				
    			}
 
    			JLabel usuario= new JLabel("Usuario:");	
    			campo_usuario=new JTextField();
    			JLabel contraseña= new JLabel("Contraseña:");
    			campo_contraseña=new JPasswordField();
    			JButton ingresar=new JButton("Ingresar");
    			//ingresar.setForeground(Color.yellow);
    			
    			campo_usuario.addFocusListener(new VerificaMail());
    			campo_contraseña.getDocument().addDocumentListener(new VerificaPass());
    			ingresar.addActionListener(new IniciaSesion());
    			
    			
    			
    			add(usuario);
    			add(campo_usuario);
    			add(contraseña);
    			add(campo_contraseña);
    			add(ingresar);
    		}
    

    

    public void paintComponent(Graphics g)
    {
    	g.drawImage(fondo, 0, 0, null);
    }
    


    
    private class VerificaMail implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			int arroba=0;
    		boolean puntocom=false;
    		int cantidad_numeros=0;
    		String mail= campo_usuario.getText();
    		
    		for(int i=0;i<mail.length();i++) {
    			
    			
    			if(mail.charAt(i)=='@') {
    				
    				arroba++;
    			}
  
    			
    			if(mail.endsWith(".com") || mail.endsWith(".com.ar")) {
    				
    				puntocom=true;
    			}
    			
    		}
    		
    		if(arroba==1 && puntocom==true && !mail.startsWith("@")) {
    			
    			mailCorrecto=true;		
    			
    		}
    		
    		else {
    			
    			mailCorrecto=false;
    			
    		}
		}
    	
    	
    }
    
   private class VerificaPass implements DocumentListener{

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			char [] pass;
			
			pass= campo_contraseña.getPassword();
			contraseñaCorrecta=false;
			
			if(pass.length<8 || pass.length>12) {

				campo_contraseña.setBackground(Color.red);
				contraseñaCorrecta=false;
				
			}else {

				campo_contraseña.setBackground(Color.green);
				contraseñaCorrecta=true;
				
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			char [] pass;
			contraseñaCorrecta=false;
			
			pass= campo_contraseña.getPassword();
			
			if(pass.length<8 || pass.length>12) {
			
				campo_contraseña.setBackground(Color.red);
				contraseñaCorrecta=false;

				
			}else {
	
				campo_contraseña.setBackground(Color.green);
				contraseñaCorrecta=true;

			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
    
    private class IniciaSesion implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
    		if(mailCorrecto==true && contraseñaCorrecta==true) {
    			
    			JOptionPane.showMessageDialog(LaminaLogIn.this, "Datos correctos","Ingreso", 1);
    			System.exit(0);
    			
    			ingresoCorrecto=true;
    			cierraVentana();
    			//p.setVisible(true);
    			
    		}else {
    			JOptionPane.showMessageDialog(LaminaLogIn.this, "Datos incorrectos","Error al iniciar sesion", 0);

    		}
    		
		}
    	
    }
   // Programa p=new Programa();
    JTextField campo_usuario;
    JPasswordField campo_contraseña;
    boolean mailCorrecto;
    boolean contraseñaCorrecta;

    public void cierraVentana() {
    	
    	JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    	topFrame.setVisible(false);	
    	
    }
    
}
	
class UbicaCampos implements LayoutManager{

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container parent) {
		
		int contador=0;
		int d=parent.getWidth();
		x=d/2;
		y=100;
		int cantidad_componentes= parent.getComponentCount();
		
		for (int i=0;i<cantidad_componentes;i++) {
			
			contador++;
			
			Component c= parent.getComponent(i);
			
			c.setBounds(x-200,y,200,25);
			
			x+=200;
			
			if(contador%2==0) {
				
				x=d/2;
				y+=40;
				
			}
		}
		
	}
	
	private int x;
	private int y;
	
}
