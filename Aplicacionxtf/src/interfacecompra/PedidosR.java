package interfacecompra;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PedidosR extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PedidosR frame = new PedidosR();
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
	public PedidosR() {
		setTitle("No olvides actualizar cuando acabes turno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setForeground(new Color(25, 25, 112));
		textArea.setFont(new Font("Calibri", Font.PLAIN, 16));
		textArea.setBackground(new Color(255, 245, 238));
		textArea.setBounds(22, 92, 541, 383);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Seccion de Productos para recoger del almacen");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel.setBounds(22, 33, 650, 61);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 21));
		btnNewButton.setBounds(606, 140, 168, 41);
		contentPane.add(btnNewButton);
		
		Thread hilo = new Thread(this);
		hilo.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			ServerSocket servidor=new ServerSocket(5555);
			while(true) {
				Socket socket = servidor.accept();
				ObjectInputStream mensaje = new ObjectInputStream(socket.getInputStream());
				Object mensaje2= mensaje.readObject();
				textArea.append("\n" + mensaje2);
				socket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
