package interfacecompra;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfacemanager.ControladorEmpleados;
import interfacemanager.ControladorProductos;

public class Ventanamenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	JMenuBar mb;
	JMenu mu;
	JMenuItem mi1,mi2,mi3,mi4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanamenu frame = new Ventanamenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventanamenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		mb=new JMenuBar();
		setJMenuBar(mb);
		
		mu=new JMenu("Opciones");
		mb.add(mu);
		
		mi1= new JMenuItem("Compra");
		mi1.addActionListener(this);
		mu.add(mi1);
		
		mi2= new JMenuItem("Pedidos");
		mi2.addActionListener(this);
		mu.add(mi2);
		
		mi3= new JMenuItem("Salir");
		mi3.addActionListener(this);
		mu.add(mi3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mi1) {
			Compra comp = new Compra();
			comp.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==mi2){
			Pedidos pedi = null;
			try {
				pedi = new Pedidos();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			pedi.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==mi3){
			System.exit(0);
		}
		
	}

}
