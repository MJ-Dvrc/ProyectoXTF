package interfacemanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class ControEmpleados extends JFrame {

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
					ControEmpleados frame = new ControEmpleados();
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
	public ControEmpleados() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\MarianoJ\\Downloads\\descarga (2).jpg"));
		setTitle("Bienvenido querido Manager espero que seas el, si no lo eres, preparate que te encontrare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 640);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(25, 25, 112));
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setFont(new Font("Calibri", Font.PLAIN, 13));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Manager Empleados");
		lblNewLabel_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 42));
		lblNewLabel_4.setBounds(166, 11, 392, 71);
		contentPane.add(lblNewLabel_4);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf1.setBounds(254, 140, 235, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf2.setBounds(254, 171, 235, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf3.setBounds(254, 202, 135, 20);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Calibri", Font.PLAIN, 16));
		tf4.setBounds(254, 233, 135, 20);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Calibri", Font.PLAIN, 19));
		tf5.setBounds(55, 409, 240, 42);
		contentPane.add(tf5);
		tf5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre  del empleado");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel.setBounds(46, 139, 175, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Documento del empleado");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Calibri Light", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(46, 170, 175, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(46, 201, 135, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a");
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(46, 232, 135, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Aqui podras buscar a los empleados y poder eliminarlos o modificarlo");
		lblNewLabel_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel_5.setBounds(24, 303, 685, 42);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Al buscarlo, te "
				+ "n/ aparecera en la parte superior.");
		lblNewLabel_6.setBackground(new Color(25, 25, 112));
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(26, 335, 330, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Creador de nuevos empleados y modificarlos");
		lblNewLabel_7.setForeground(new Color(25, 25, 112));
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel_7.setBounds(32, 93, 489, 36);
		contentPane.add(lblNewLabel_7);
		
		
		
		
		//registrar empleado
		JButton btnalta = new JButton("REGISTRAR");
		btnalta.setBackground(new Color(25, 25, 112));
		btnalta.setForeground(new Color(25, 25, 112));
		btnalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					comando.executeUpdate("insert into empleados(nombre,dni,usuario,contrasena) values('" + tf1.getText()+"','"+tf2.getText()+
							"','"+ tf3.getText()+ "','"+tf4.getText()+"')");
					conexion.close();
					JOptionPane.showMessageDialog(null, "El nuevo empleado a sido registrado.");
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
		btnalta.setBounds(588, 140, 149, 57);
		contentPane.add(btnalta);
		
		//buscar empleado
		JButton btnbuscar = new JButton("BUSCAR");
		btnbuscar.setBackground(new Color(25, 25, 112));
		btnbuscar.setForeground(new Color(25, 25, 112));
		btnbuscar.setFont(new Font("Calibri", Font.BOLD, 21));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					ResultSet registro = comando.executeQuery("select nombre,dni,usuario,contrasena from empleados where id="+ tf5.getText());
					
					if(registro.next()==true) {
						tf1.setText(registro.getString("nombre"));
						tf2.setText(registro.getString("dni"));
						tf3.setText(registro.getString("usuario"));
						tf4.setText(registro.getString("contrasena"));
						
					}else {
						JOptionPane.showMessageDialog(null, "No existe el empleado");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
			}
		});
		btnbuscar.setBounds(305, 402, 135, 54);
		contentPane.add(btnbuscar);
		
		
		//borrar empleado
		JButton btnborrar = new JButton("ELIMINAR");
		btnborrar.setBackground(new Color(25, 25, 112));
		btnborrar.setForeground(new Color(25, 25, 112));
		btnborrar.setFont(new Font("Calibri", Font.BOLD, 21));
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int referencia = comando.executeUpdate("delete from empleados where id="+tf5.getText());
					
					if(referencia==1) {
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						JOptionPane.showMessageDialog(null, "Se elimno al empleado correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "No existe y si te acuerdas de haberlo creado, consultar con el tecnico.e");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
		});
		btnborrar.setBounds(588, 364, 149, 42);
		contentPane.add(btnborrar);
		
		//modificar empleado
		JButton btnmodificar = new JButton("MODIFICAR");
		btnmodificar.setBackground(new Color(25, 25, 112));
		btnmodificar.setForeground(new Color(25, 25, 112));
		btnmodificar.setFont(new Font("Calibri", Font.BOLD, 21));
		btnmodificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int id = comando.executeUpdate("update empleados set nombre='"+tf1.getText()+"'," + " dni= " + tf2.getText() + "," + " usuario= '" + tf3.getText()+"',"+" contrasena= '" + tf4.getText() + "'"+" where id= " + tf5.getText());
					 
					if(id==1) {
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
		btnmodificar.setBounds(588, 437, 149, 42);
		contentPane.add(btnmodificar);
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
