package interfacemanager;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class ControladorEmpleados extends JFrame implements ActionListener  {
	JPanel contentPanel;
	JLabel lblresultado , lblconsultar; 
	JButton btnbuscar,btnalta,btnborrar,btnmodificar; 
	JTextField tf1,tf2,tf3,tf4,tf5;
	
	//launcher
	
	public static void main(String[]args) {
		
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				try {
					ControladorEmpleados produ=  new ControladorEmpleados();
					produ.setVisible(true);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

//Creacion del frame

	public ControladorEmpleados() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,800,800);
		
		contentPanel=new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre del empleado");
		lblNombre.setBounds(23,44,193,14);
		contentPanel.add(lblNombre);
		
		tf1=new JTextField();
		tf1.setBounds(247,45,193,20);
		contentPanel.add(tf1);
		tf1.setColumns(10);
		
		//dni1
		JLabel lbldni= new JLabel("DNI");
		lbldni.setBounds(23,74,95,14);
		contentPanel.add(lbldni);
		
		tf2=new JTextField();
		tf2.setBounds(247,71,107,20);
		contentPanel.add(tf2);
		tf2.setColumns(10);
		
		
		//Usuario
		JLabel lblUsuario= new JLabel("Usuario");
		lblUsuario.setBounds(23,94,95,14);
		contentPanel.add(lblUsuario);
		
		tf3=new JTextField();
		tf3.setBounds(247,91,107,20);
		contentPanel.add(tf3);
		tf3.setColumns(10);
		
		//contraseña
		JLabel lblContraseña= new JLabel("Contraseña");
		lblContraseña.setBounds(23,114,95,14);
		contentPanel.add(lblContraseña);
		
		tf4=new JTextField();
		tf4.setBounds(247,111,107,20);
		contentPanel.add(tf4);
		tf4.setColumns(10);
		
		
		
		
		
		//donde se imprime el mensaje dependiendo del error o si esta bien
		
		lblresultado = new JLabel("Resultado");
		lblresultado.setBounds(361,122,229,14);
		contentPanel.add(lblresultado);
		
		
		
		//boton para agregar a los empleados a la base de datos
		
		btnalta = new JButton("Registrar Empleado");
		btnalta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					comando.executeUpdate("insert into empleados(nombre,dni,usuario,contrasena) values('" + tf1.getText()+"','"+tf2.getText()+
							"','"+ tf3.getText()+ "','"+tf4.getText()+"')");
					conexion.close();
					lblresultado.setText("Se registro al empleado correctamente");
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
										
				} catch (SQLException ex) {
					setTitle(ex.toString());
				}	
			}	
		});
		
		btnalta.setBounds(247,140,89,23);
		contentPanel.add(btnalta);
		
		
	
		
		//consultar producto
		btnbuscar =new JButton("Consultar el producto");
		btnbuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblresultado.setText("");
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
						lblresultado.setText("No existe el empleado");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
			
		});
		
		btnbuscar.setBounds(25,182,177,23);
		contentPanel.add(btnbuscar);
		
		tf5 = new JTextField();
		tf5.setBounds(247,183,86,20);
		contentPanel.add(tf5);
		
		//Borrar Empleado
		btnborrar =new JButton("Borrar");
		btnborrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblresultado.setText("");
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int referencia = comando.executeUpdate("delete from empleados where id="+tf5.getText());
					
					if(referencia==1) {
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						lblresultado.setText("Se elimino al empleado correctamente.");
					}else {
						lblresultado.setText("No existe el tipo ese mmh.");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
			
		});
		
		btnborrar.setBounds(24,356,277,23);
		contentPanel.add(btnborrar);
		
		//Modificar Empleado
		
		btnmodificar =new JButton("Modificar");
		btnmodificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblresultado.setText("");;
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int id = comando.executeUpdate("update empleados set nombre='"+tf1.getText()+"'," + " dni= " + tf2.getText() + "," + " usuario= '" + tf3.getText()+"',"+" contrasena= '" + tf4.getText() + "'"+" where id= " + tf5.getText());
					 
					if(id==1) {
						lblresultado.setText("Se modifico correctamente.");
					}else {
						lblresultado.setText("No existe el empleado.");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
			
		});
		
		btnmodificar.setBounds(24,456,277,23);
		contentPanel.add(btnmodificar);
		cargarDriver();
		
	}
	
	
	private void cargarDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			setTitle(e.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
