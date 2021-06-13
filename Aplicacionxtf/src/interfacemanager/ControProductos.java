package interfacemanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.awt.Toolkit;

public class ControProductos extends JFrame {
	
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControProductos frame = new ControProductos();
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
	public ControProductos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MarianoJ\\Downloads\\descarga (2).jpg"));
		setTitle("Ventana de creacion, modificacion, eliminacion y busqueda de empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf1.setBounds(254, 351, 235, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf2.setBounds(254, 385, 57, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf3.setBounds(254, 413, 235, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf4.setBounds(254, 444, 161, 36);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Calibri", Font.PLAIN, 19));
		tf5.setBounds(254, 140, 227, 49);
		contentPane.add(tf5);
		tf5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre  del Producto");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(63, 351, 175, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio  a la venta");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(63, 385, 175, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Referencia del producto");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(61, 413, 160, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion del producto");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(61, 444, 175, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Aqui podras buscar a los Productos y podras eliminarlos o modificarlo.");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel_5.setBounds(32, 93, 656, 36);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("(Busqueda por referencia)");
		lblNewLabel_6.setBounds(63, 191, 143, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Creador de nuevos productos  ya ademas poder modificarlos y eliminarlo.");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel_7.setBounds(32, 255, 676, 36);
		contentPane.add(lblNewLabel_7);
		
		
		
		
		//registrar empleado
		JButton btnalta = new JButton("REGISTRAR");
		btnalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					comando.executeUpdate("insert into productos(nombre,precio,referencia,descripcion) values('" + tf1.getText()+"',"+tf2.getText()+",'"+ tf3.getText()+"','"+ tf4.getText() +"')");
					conexion.close();
					JOptionPane.showMessageDialog(null, "Se registro correctamente el producto.");
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
										
				} catch (SQLException ex) {
					setTitle(ex.toString());
				}	
			}
		});
		btnalta.setFont(new Font("Calibri", Font.BOLD, 21));
		btnalta.setBounds(532, 494, 165, 54);
		contentPane.add(btnalta);
		
		//buscar empleado
		JButton btnbuscar = new JButton("BUSCAR");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					ResultSet registro = comando.executeQuery("select nombre,precio,referencia,descripcion from productos where referencia='"+ tf5.getText()+"'");
					
					if(registro.next()==true) {
						tf1.setText(registro.getString("nombre"));
						tf2.setText(registro.getString("precio"));
						tf3.setText(registro.getString("referencia"));
						tf4.setText(registro.getString("descripcion"));
						
					}else {
						JOptionPane.showMessageDialog(null, "No existe la referencia del producto.");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
			}
		});
		btnbuscar.setFont(new Font("Calibri", Font.BOLD, 21));
		btnbuscar.setBounds(71, 135, 135, 54);
		contentPane.add(btnbuscar);
		
		
		//borrar empleado
		JButton btnborrar = new JButton("ELIMINAR");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int referencia = comando.executeUpdate("delete from productos where referencia="+tf5.getText());
					
					if(referencia==1) {
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						JOptionPane.showMessageDialog(null, "Se elimino el producto correctamete.");
					}else {
						JOptionPane.showMessageDialog(null, "No existe y si te acuerdas de haberlo creado, consultar con el tecnico.e");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
		});
		btnborrar.setFont(new Font("Calibri", Font.BOLD, 21));
		btnborrar.setBounds(577, 403, 143, 36);
		contentPane.add(btnborrar);
		
		//modificar empleado
		JButton btnmodificar = new JButton("MODIFICAR");
		btnmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int referencia = comando.executeUpdate("update productos set nombre='"+tf1.getText()+"',"+"precio="+tf2.getText()+", descripcion='"+tf4.getText()+"' where referencia='"+tf5.getText()+"'");
					
					if(referencia==1) {
						JOptionPane.showMessageDialog(null, "Se modifico correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "No existe y si te acuerdas de haberlo creado, consultar con el tecnico.m");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
		});
		btnmodificar.setFont(new Font("Calibri", Font.BOLD, 21));
		btnmodificar.setBounds(577, 349, 149, 36);
		contentPane.add(btnmodificar);
		
		JLabel lblNewLabel_4 = new JLabel("Controlador Productos");
		lblNewLabel_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 42));
		lblNewLabel_4.setBounds(129, 11, 506, 71);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("(Euros)");
		lblNewLabel_8.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblNewLabel_8.setBounds(321, 386, 57, 20);
		contentPane.add(lblNewLabel_8);
		
		cargarDriver();
	}
	private void cargarDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			setTitle(e.toString());
		}
	}
}
