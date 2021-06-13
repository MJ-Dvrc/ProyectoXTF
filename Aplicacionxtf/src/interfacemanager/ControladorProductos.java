package interfacemanager;

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class ControladorProductos extends JFrame {

	JPanel contentPanel;
	JLabel lblresultado , lblconsultar; 
	JButton btnbuscar,btnalta,btnborrar,btnmodificar; 
	JTextField tf1,tf2,tf3,tf4;
	
	//launcher
	
	public static void main(String[]args) {
		
		
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				try {
					ControladorProductos produ=  new ControladorProductos();
					produ.setVisible(true);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

//Creacion del frame

	public ControladorProductos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,800,800);
		
		contentPanel=new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//Nombre
		JLabel lblNombre = new JLabel("Nombre del producto");
		lblNombre.setBounds(23,44,193,14);
		contentPanel.add(lblNombre);
		
		tf1=new JTextField();
		tf1.setBounds(247,45,193,20);
		contentPanel.add(tf1);
		tf1.setColumns(10);
		
		//Precio
		JLabel lblPrecio= new JLabel("Precio");
		lblPrecio.setBounds(23,74,95,14);
		contentPanel.add(lblPrecio);
		
		tf2=new JTextField();
		tf2.setBounds(247,71,107,20);
		contentPanel.add(tf2);
		tf2.setColumns(10);
		
		
		//Referencia
		JLabel lblReferencia= new JLabel("Referencia");
		lblReferencia.setBounds(23,94,95,14);
		contentPanel.add(lblReferencia);
		
		tf3=new JTextField();
		tf3.setBounds(247,91,107,20);
		contentPanel.add(tf3);
		tf3.setColumns(10);
		
		
	

		
		//boton para agregar los produtos a la base de datos
		
		btnalta = new JButton("Alta");
		btnalta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					comando.executeUpdate("insert into productos(nombre,precio,referencia) values('" + tf1.getText()+"',"+tf2.getText()+",'"+ tf3.getText()+"')");
					conexion.close();
					lblresultado.setText("Se registro el producto correctamente");
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
										
				} catch (SQLException ex) {
					setTitle(ex.toString());
				}	
			}	
		});
		
		btnalta.setBounds(247,140,89,23);
		contentPanel.add(btnalta);
		
		//donde se imprime el mensaje dependiendo del error o si esta bien
		
		lblresultado = new JLabel("Resultado");
		lblresultado.setBounds(361,122,229,14);
		contentPanel.add(lblresultado);
		
		//consultar producto
		btnbuscar =new JButton("Consultar el producto");
		btnbuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblresultado.setText("");
				tf1.setText("");
				tf2.setText("");
				tf3.setText("");
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					ResultSet registro = comando.executeQuery("select nombre,precio,referencia from productos where referencia="+ tf4.getText());
					
					if(registro.next()==true) {
						tf1.setText(registro.getString("nombre"));
						tf2.setText(registro.getString("precio"));
						tf3.setText(registro.getString("referencia"));
						
					}else {
						lblresultado.setText("No existe el producto");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
			
		});
		
		btnbuscar.setBounds(25,182,177,23);
		contentPanel.add(btnbuscar);
		
		tf4 = new JTextField();
		tf4.setBounds(247,183,86,20);
		contentPanel.add(tf4);
		
		//Borrar producto
		btnborrar =new JButton("Borrar");
		btnborrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblresultado.setText("");
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int referencia = comando.executeUpdate("delete from productos where referencia="+tf4.getText());
					
					if(referencia==1) {
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						lblresultado.setText("Se elimino el producto correctamente.");
					}else {
						lblresultado.setText("No existe el producto dentro de la base de datos.");
					}
					
					conexion.close();
				
				}catch(SQLException ex) {
					 setTitle(ex.toString());
				}
				
			}
			
		});
		
		btnborrar.setBounds(24,356,277,23);
		contentPanel.add(btnborrar);
		
		//Modificar Producto
		
		btnmodificar =new JButton("Modificar");
		btnmodificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				lblresultado.setText("");;
				try {
					Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/aplicacionx","root","j4tr3Y53");
					Statement comando= conexion.createStatement();
					int referencia = comando.executeUpdate("update productos set nombre='"+tf1.getText()+"',"+"precio="+tf2.getText()+" where referencia= "+tf4.getText());
					
					if(referencia==1) {
						lblresultado.setText("Se modifico correctamente.");
					}else {
						lblresultado.setText("No existe el producto dentro de la base de datos.");
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
}