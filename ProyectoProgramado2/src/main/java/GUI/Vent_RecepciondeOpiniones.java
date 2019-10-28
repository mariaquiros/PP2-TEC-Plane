package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Objetos.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vent_RecepciondeOpiniones extends JFrame {

	private JPanel contentPane;
	private JTextField txtopinion;
	private JTextField txtUsuario;

	/**
	 * Create the frame.
	 */
	public Vent_RecepciondeOpiniones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 240);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#21ae94"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOpinion = new JLabel("Recepcion de Opiniónes");
		lblOpinion.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpinion.setBounds(35, 11, 287, 31);
		lblOpinion.setForeground(Color.WHITE);
		lblOpinion.setFont(new Font("Century Gothic", Font.BOLD, 24));
		contentPane.add(lblOpinion);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(10, 66, 111, 23);
		contentPane.add(txtUsuario);
		
		txtopinion = new JTextField();
		txtopinion.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtopinion.setBounds(10, 125, 343, 23);
		contentPane.add(txtopinion);
		txtopinion.setColumns(10);
		
		JLabel lblicono = new JLabel("");
		lblicono.setIcon(new ImageIcon("C:\\Users\\jmjos\\Desktop\\pp2\\logopequeño.png"));
		lblicono.setBounds(363, 11, 111, 50);
		contentPane.add(lblicono);
		
		JButton btnEnviarComentarios = new JButton("Enviar");
		btnEnviarComentarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comentario newComentario =null;
				if (txtopinion.getText().length()==0||txtUsuario.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");	
					return;
				}else {
					String mjs="";
					mjs=txtopinion.getText();
					ToneAnalizer newToneAnalizer= new ToneAnalizer();
					newComentario= new Comentario(txtUsuario.getText(),mjs,newToneAnalizer.getFeelings(mjs));
					Vent_Principal.Comentarios.add(newComentario);
					JOptionPane.showMessageDialog(null, "Comentario Enviado");		
			}
			}
		});
		btnEnviarComentarios.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnEnviarComentarios.setForeground(Color.WHITE);
		btnEnviarComentarios.setBackground(Color.decode("#00cb75"));
		btnEnviarComentarios.setBounds(10, 159, 111, 31);
		contentPane.add(btnEnviarComentarios);
		
		JButton btnCerrarVentana = new JButton("X");
		btnCerrarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrarVentana.setForeground(Color.WHITE);
		btnCerrarVentana.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnCerrarVentana.setBackground(Color.decode("#00cb75"));
		btnCerrarVentana.setBounds(428, 164, 46, 23);
		contentPane.add(btnCerrarVentana);
		
		JLabel lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setForeground(Color.WHITE);
		lblComentarios.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblComentarios.setBounds(10, 100, 132, 14);
		contentPane.add(lblComentarios);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsuario.setBounds(10, 47, 132, 14);
		contentPane.add(lblUsuario);
	}
}
