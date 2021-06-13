package interfacemanager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuDesplegable extends JFrame implements ActionListener  {

	JMenuBar mb;
	JMenu mu;
	JMenuItem mi1,mi2,mi3,mi4;
	
	public static void main(String[]args) {
		
		MenuDesplegable desple=new MenuDesplegable();
		desple.setBounds(100,100,500,500);
		desple.setVisible(true);
		desple.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public MenuDesplegable() {
		setLayout(null);
		mb=new JMenuBar();
		setJMenuBar(mb);
		
		mu=new JMenu("Ventanas");
		mb.add(mu);
		
		mi1= new JMenuItem("Productos");
		mi1.addActionListener(this);
		mu.add(mi1);
		
		mi2= new JMenuItem("Empleados");
		mi2.addActionListener(this);
		mu.add(mi2);
		
		mi3= new JMenuItem("Salir");
		mi3.addActionListener(this);
		mu.add(mi3);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mi1) {
			ControProductos conp = new ControProductos();
			conp.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==mi2){
			ControEmpleados cone = new ControEmpleados();
			cone.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==mi3){
			System.exit(0);
		}
	}
	
	
}
