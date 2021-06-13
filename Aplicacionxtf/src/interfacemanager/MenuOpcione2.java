package interfacemanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfacecompra.LoginM;
import interfacecompra.Pedidos;
import interfacecompra.PedidosR;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;

public class MenuOpcione2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOpcione2 frame = new MenuOpcione2();
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
	public MenuOpcione2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MarianoJ\\Downloads\\descarga (2).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ventanas");
		mnNewMenu.setForeground(new Color(25, 25, 112));
		mnNewMenu.setFont(new Font("Calibri", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Empleados");
		mntmNewMenuItem.setForeground(new Color(25, 25, 112));
		mntmNewMenuItem.setFont(new Font("Calibri", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Productos");
		mntmNewMenuItem_1.setForeground(new Color(25, 25, 112));
		mntmNewMenuItem_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Salir");
		mnNewMenu_1.setForeground(new Color(25, 25, 112));
		mnNewMenu_1.setFont(new Font("Calibri", Font.BOLD, 18));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mntmNewMenuItem_2.setForeground(new Color(25, 25, 112));
		mntmNewMenuItem_2.setFont(new Font("Calibri", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_2);
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
