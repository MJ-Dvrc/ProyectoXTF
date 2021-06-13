package interfacecompra;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class Pedidos extends JFrame {

	private JPanel contentPane;
	JList listq;
	ArrayList <String> nombres;
	DefaultListModel modelo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public Pedidos() throws SQLException{
		setTitle("Bienvenido al fantastico mundo de los x");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MarianoJ\\Downloads\\descarga (2).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione el producto");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 109, 225, 35);
		contentPane.add(lblNewLabel);
		
	
		//Combobox muestra los productos de la db
		JComboBox comboBox = new JComboBox();	
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 17));
		
		
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
				PreparedStatement ps= con.prepareStatement("select nombre from productos ");
				ResultSet resul = ps.executeQuery();
				while(resul.next()) {
					comboBox.addItem(resul.getString("nombre"));
				}
				con.close();					
			} catch (SQLException ex) {
				setTitle(ex.toString());
			}

		comboBox.setBounds(10, 156, 346, 35);
		contentPane.add(comboBox);
		////////////////////////////////////
		// seccion donde añado y se muestra el listado 
		
		nombres = new ArrayList<String>();
		modelo = new DefaultListModel();
		
		listq = new JList();
		listq.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		listq.setForeground(new Color(25, 25, 112));
		listq.setBackground(new Color(255, 245, 238));
		listq.setFont(new Font("Calibri", Font.PLAIN, 24));
		listq.setModel(modelo);
		listq.setBounds(366, 96, 320, 392);
		contentPane.add(listq);
		
		JButton btnañadir = new JButton("A\u00D1ADIR");
		btnañadir.setFont(new Font("Calibri", Font.BOLD, 21));
		btnañadir.setBackground(new Color(25, 25, 112));
		btnañadir.setForeground(new Color(255, 255, 255));
		btnañadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object valor=comboBox.getSelectedItem();
				nombres.add((String) valor);
			
				modelo.removeAllElements();
				for(int i=0;i<nombres.size();i++) {
					modelo.addElement(nombres.get(i));
				}
			}
		});
		
		
		btnañadir.setBounds(195, 202, 160, 35);
		contentPane.add(btnañadir);
		//////////////////////////////////////////
		JButton btnenviar = new JButton("ENVIAR");
		btnenviar.setBackground(new Color(25, 25, 112));
		btnenviar.setForeground(new Color(255, 255, 255));
		btnenviar.setFont(new Font("Calibri", Font.BOLD, 21));
		Enviarlista enviarlis=new Enviarlista();
		btnenviar.addActionListener(enviarlis);
		
		btnenviar.setBounds(708, 202, 132, 35);
		contentPane.add(btnenviar);
		
		JLabel lblNewLabel_1 = new JLabel("LISTA DE LA COMPRA DEL CLIENTE");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(211, 28, 470, 44);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("CANCELAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				modelo=(DefaultListModel)listq.getModel();
				int n=listq.getSelectedIndex();
				modelo.removeElementAt(n);
				
			}
		});
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 21));
		btnNewButton_1.setBounds(708, 333, 132, 35);
		contentPane.add(btnNewButton_1);
		
	}
	public class Enviarlista implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println(nombres);
			try {
				Socket socket=new Socket("192.168.1.123",5555);
				ObjectOutputStream mensaje = new ObjectOutputStream(socket.getOutputStream());
                mensaje.writeObject(nombres); 
                socket.close();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			modelo=(DefaultListModel)listq.getModel();
			int n=listq.getSelectedIndex();
			modelo.removeAllElements();
			
			
		}
		
	}
}

