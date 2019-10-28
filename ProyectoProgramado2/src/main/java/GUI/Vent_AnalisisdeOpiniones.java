package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Objetos.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vent_AnalisisdeOpiniones extends JFrame {

	private JPanel contentPane;
	private JTable tabledeSentimientos;
	private DefaultTableModel FormatoTableSentimientos;


	/**
	 * Create the frame.
	 */
	public Vent_AnalisisdeOpiniones() {
		String[] ColumnasSentimientos = {"Usuario", "Opinión" ,"Estados"};
        Object[][] dataPuerta = {{}};
        FormatoTableSentimientos= new DefaultTableModel(dataPuerta, ColumnasSentimientos);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 510);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#21ae94"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnalissDeSentimientos = new JLabel("Analisís de Sentimientos");
		lblAnalissDeSentimientos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalissDeSentimientos.setForeground(Color.WHITE);
		lblAnalissDeSentimientos.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblAnalissDeSentimientos.setBounds(22, 22, 292, 31);
		contentPane.add(lblAnalissDeSentimientos);
		
		tabledeSentimientos = new JTable(FormatoTableSentimientos);
		tabledeSentimientos.setBounds(22, 64, 355, 362);
		contentPane.add(tabledeSentimientos);
		
		JScrollPane scrollPanedeSentimientos = new JScrollPane(tabledeSentimientos);
		scrollPanedeSentimientos.setBounds(22, 64, 303, 362);
		contentPane.add(scrollPanedeSentimientos);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarTabla(FormatoTableSentimientos);
				for(int i=0; i<Vent_Principal.Comentarios.size(); i++) {
					Comentario newComentario = Vent_Principal.Comentarios.get(i);
					String[] newRow= {newComentario.getUsuario(),newComentario.getComentario(),newComentario.getSentimientos()};			
					FormatoTableSentimientos.addRow(newRow);
					
				}
			}
		});
		btnActualizar.setBackground(Color.decode("#00cb75"));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnActualizar.setBounds(348, 403, 119, 23);
		contentPane.add(btnActualizar);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon("C:\\Users\\jmjos\\Desktop\\pp2\\logopequeño.png"));
		lblIcono.setBounds(348, 0, 112, 67);
		contentPane.add(lblIcono);
		
		JButton btnCerrarVentana = new JButton("X");
		btnCerrarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrarVentana.setForeground(Color.WHITE);
		btnCerrarVentana.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnCerrarVentana.setBackground(new Color(0, 203, 117));
		btnCerrarVentana.setBounds(22, 437, 46, 23);
		contentPane.add(btnCerrarVentana);
	}
	public void LimpiarTabla(DefaultTableModel Modelo) {
		while(Modelo.getRowCount() > 1){
		    Modelo.removeRow(1);
		}
	}
	
	
}
