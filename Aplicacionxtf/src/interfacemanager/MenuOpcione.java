package interfacemanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfacecompra.LoginM;
import interfacecompra.Pedidos;
import interfacecompra.PedidosR;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class MenuOpcione extends JFrame implements ActionListener{

	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu menu,manager;
	JMenuItem mi1,mi2,mi3,mi4,mi5;
	JMenu mnNewMenu;
	JMenu mnNewMenu_1;
	JMenuItem salir;
	JMenuItem contacto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOpcione frame = new MenuOpcione();
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
	public MenuOpcione() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MarianoJ\\Downloads\\descarga (2).jpg"));
		setTitle("Bienvenido manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 469);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Calibri", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		menu = new JMenu("Opciones");
		menu.setForeground(new Color(25, 25, 112));
		menu.setBackground(new Color(240, 255, 255));
		menu.setFont(new Font("Calibri", Font.BOLD, 18));
		
		menuBar.add(menu);
		//menu ventanads
		
		mi1 = new JMenuItem("PedidosCaja");
		mi1.setForeground(new Color(25, 25, 112));
		mi1.setBackground(new Color(240, 255, 255));
		mi1.setFont(new Font("Calibri", Font.PLAIN, 16));
		mi1.addActionListener(this);
		menu.add(mi1);
		
		mi2 = new JMenuItem("PedidosAlmacen");
		mi2.setForeground(new Color(25, 25, 112));
		mi2.setBackground(new Color(240, 255, 255));
		mi2.setFont(new Font("Calibri", Font.PLAIN, 16));
		mi2.addActionListener(this);
		menu.add(mi2);
		
		
		//menu ayuda
		
		mnNewMenu = new JMenu("Ayuda");
		mnNewMenu.setBackground(new Color(240, 255, 255));
		mnNewMenu.setForeground(new Color(25, 25, 112));
		mnNewMenu.setFont(new Font("Calibri", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		contacto = new JMenuItem("Contacto ");
		contacto.setBackground(new Color(240, 255, 255));
		contacto.setForeground(new Color(25, 25, 112));
		contacto.setFont(new Font("Calibri", Font.PLAIN, 16));
		contacto.addActionListener(this);
		mnNewMenu.add(contacto);
		
		manager = new JMenu("Manager");
		manager.setBackground(new Color(240, 255, 255));
		manager.setFont(new Font("Calibri", Font.BOLD, 18));
		manager.setForeground(new Color(25, 25, 112));
		menuBar.add(manager);
		
		mi5 = new JMenuItem("Login");
		mi5.setBackground(new Color(240, 255, 255));
		mi5.setFont(new Font("Calibri", Font.PLAIN, 16));
		mi5.setForeground(new Color(25, 25, 112));
		mi5.addActionListener(this);
		manager.add(mi5);
		//menu salir
		
		mnNewMenu_1 = new JMenu("Salir");
		mnNewMenu_1.setBackground(new Color(240, 255, 255));
		mnNewMenu_1.setForeground(new Color(25, 25, 112));
		mnNewMenu_1.setFont(new Font("Calibri", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		salir = new JMenuItem("Salir");
		salir.setForeground(new Color(25, 25, 112));
		salir.setBackground(new Color(240, 255, 255));
		salir.setFont(new Font("Calibri", Font.PLAIN, 16));
		salir.addActionListener(this);
		mnNewMenu_1.add(salir);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mi1) {
			Pedidos pedi;
			try {
				pedi = new Pedidos();
				pedi.setVisible(true);
			this.setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==mi2){
			PedidosR pedir;
			pedir = new PedidosR();
			pedir.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource()==salir){
			System.exit(0);
		}
		if(e.getSource()==contacto){
			JOptionPane.showMessageDialog(null, "Contacte con suppor al 123456789");
		}
		if(e.getSource()==mi5){
			LoginM loginm = new LoginM();
			loginm.setVisible(true);
			this.setVisible(false);
		}
}
}
