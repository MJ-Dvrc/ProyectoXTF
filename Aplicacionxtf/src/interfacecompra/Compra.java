package interfacecompra;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JList;

public class Compra extends JFrame implements Runnable {

	private JPanel contentPane;
	JTextArea textArea ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compra frame = new Compra();
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
	public Compra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textArea = new JTextArea();
		textArea.setBounds(28, 28, 192, 118);
		contentPane.add(textArea);
		
			
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		  try{
	          ServerSocket servidor = new ServerSocket(5555);
	              while(true){
	                  Socket misocket = servidor.accept();
	                  ObjectInputStream entrada=new ObjectInputStream(misocket.getInputStream());
	                  String mensaje = (String) entrada.readUTF();
	                  textArea.append(mensaje);
	                  misocket.close();
	                  System.out.println("errrr");

	              }
	             
	      }catch(IOException e){
	          System.out.println("Error");
	      }
	    }
}


