package interfacecompra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import interfacemanager.MenuOpcione;
import interfacemanager.MenuOpcione2;

public class LoginM extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txfusuario;
	private JTextField txfcontrasena;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginM frame = new LoginM();
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
	public LoginM() {
		setTitle("Version/\u00BA 6 - DA");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MarianoJ\\Downloads\\descarga (2).jpg"));
		setForeground(SystemColor.textHighlight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 255);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manager Corporation");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setBounds(135, 32, 237, 42);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario: ");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setBounds(60, 86, 77, 20);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña: ");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setBounds(60, 119, 118, 20);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2);
		
		
		
		txfusuario = new JTextField();
		txfusuario.setBounds(171, 85, 141, 26);
		txfusuario.setFont(new Font("Calibri", Font.PLAIN, 18));
		contentPane.add(txfusuario);
		txfusuario.setColumns(10);
		
		txfcontrasena = new JTextField();
		txfcontrasena.setFont(new Font("Calibri", Font.PLAIN, 18));
		txfcontrasena.setBounds(172, 120, 141, 26);
		contentPane.add(txfcontrasena);
		txfcontrasena.setColumns(10);
		
		//boton de ingresar
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBackground(new Color(25, 25, 112));
		btnIngresar.setBounds(375, 113, 118, 32);
		btnIngresar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario=txfusuario.getText();
				String paswd=txfcontrasena.getText();
				if(usuario.isEmpty()||paswd.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Algun campo esta vacio");
				}else {
					if(usuario.equals("admin") && paswd.equals("admin")) {
						
						MenuOpcione2 mo= new MenuOpcione2();
						mo.setVisible(true);
						
					}else{
						JOptionPane.showMessageDialog(null,"Usted no es el manager, largo basura.");
					}
					
				}
			}
			
		});
		contentPane.add(btnIngresar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
