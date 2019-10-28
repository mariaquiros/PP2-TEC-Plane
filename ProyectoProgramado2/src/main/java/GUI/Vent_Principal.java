package GUI;
/**
 * Ventana Principal
 */
import org.json.JSONArray;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Objetos.*;
import TDA.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class Vent_Principal {

	private JFrame frame;
	private JTextField txtnombre;
	private JTextField txtfechanacimiento;
	private JTextField txtPasaporte;
	private JTextField txtnacionalidad;
	private JTextField txtLorigen;
	private JTextField txtLdestino;
	private JTextPane txtInfoPersona;
	private JRadioButton rdbtnEspecial,rdbtnOro,rdbtnPlatino,rdbtnEconimico,
	rdbtnColaVIP,rdbtnHeapVIP,rdbtnheapEspeciales,rdbtnColaEspeciales;
	private Persona pActual;
	private JTextField txtNumero;
	private JTable tableNormales;
	private JTable tableVIP;
	private JTable tableEspeciales;
	private IPrioridad PuertaVIP=new ColaPrioridad(3);
	private Cola PuertaEspecial=new Cola();
	private IPrioridad ColaSalida;
	private JTextField txtPuertasVIP;
	private JTextField txtPuertasEspeciales;
	private JTextField txtCatidadSalidas;
	private JTextField txtrangotiempo1;
	private JTextField txtrangotiempo2;
	private JTable tableSalida;
	public DefaultTableModel FormatoPuertasVIP,FormatoPuertasEspecial,FormatoPuertasSalida;
	private int contVIP=1, contEspecial=1, contSalida=1;
	private double tiempoinicio, tiempofinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vent_Principal window = new Vent_Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vent_Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String[] ColumnasPuerta = {"# Puerta", "Estado"};
        Object[][] dataPuerta = {{}};
        FormatoPuertasVIP= new DefaultTableModel(dataPuerta, ColumnasPuerta);
        FormatoPuertasEspecial= new DefaultTableModel(dataPuerta, ColumnasPuerta);
        FormatoPuertasSalida= new DefaultTableModel(dataPuerta, ColumnasPuerta);
        
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.decode("#21ae94"));
		frame.getContentPane().setLayout(null);
		
		txtLdestino = new JTextField();
		txtLdestino.setBounds(159, 273, 148, 14);
		frame.getContentPane().add(txtLdestino);
		txtLdestino.setColumns(10);
		
		JLabel lblLugarDeDestino = new JLabel("Lugar de destino:");
		lblLugarDeDestino.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblLugarDeDestino.setForeground(Color.WHITE);
		lblLugarDeDestino.setBounds(21, 271, 140, 16);
		frame.getContentPane().add(lblLugarDeDestino);
		
		txtLorigen = new JTextField();
		txtLorigen.setBounds(159, 245, 148, 14);
		frame.getContentPane().add(txtLorigen);
		txtLorigen.setColumns(10);
		
		JLabel lblLugarDeOrigen = new JLabel("Lugar de origen:");
		lblLugarDeOrigen.setForeground(Color.WHITE);
		lblLugarDeOrigen.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblLugarDeOrigen.setBounds(21, 240, 128, 20);
		frame.getContentPane().add(lblLugarDeOrigen);
		
		txtnacionalidad = new JTextField();
		txtnacionalidad.setBounds(140, 215, 148, 14);
		frame.getContentPane().add(txtnacionalidad);
		txtnacionalidad.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setForeground(Color.WHITE);
		lblNacionalidad.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNacionalidad.setBounds(21, 213, 117, 14);
		frame.getContentPane().add(lblNacionalidad);
		
		txtPasaporte = new JTextField();
		txtPasaporte.setBounds(117, 185, 148, 14);
		frame.getContentPane().add(txtPasaporte);
		txtPasaporte.setColumns(10);
		
		JLabel lblPasaporte = new JLabel("Pasaporte:");
		lblPasaporte.setForeground(Color.WHITE);
		lblPasaporte.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPasaporte.setBounds(23, 177, 84, 26);
		frame.getContentPane().add(lblPasaporte);
		
		txtfechanacimiento = new JTextField();
		txtfechanacimiento.setBounds(183, 153, 148, 15);
		frame.getContentPane().add(txtfechanacimiento);
		txtfechanacimiento.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setBounds(21, 152, 182, 14);
		frame.getContentPane().add(lblFechaDeNacimiento);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(90, 124, 148, 14);
		frame.getContentPane().add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(21, 122, 77, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblRegistroDePersonas = new JLabel("Registro de Personas");
		lblRegistroDePersonas.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblRegistroDePersonas.setForeground(Color.WHITE);
		lblRegistroDePersonas.setBounds(281, 33, 271, 33);
		frame.getContentPane().add(lblRegistroDePersonas);
		
		// btn group Ventanilla
		rdbtnEconimico = new JRadioButton("Economico");
		rdbtnEconimico.setForeground(Color.WHITE);
		rdbtnEconimico.setFont(new Font("Century Gothic", Font.BOLD, 14));
		rdbtnEconimico.setBackground(Color.decode("#21ae94"));
		rdbtnEconimico.setBounds(400, 73, 109, 23);
		frame.getContentPane().add(rdbtnEconimico);
		
	
		rdbtnEspecial = new JRadioButton("Especial");
		rdbtnEspecial.setBackground(Color.decode("#21ae94"));
		rdbtnEspecial.setFont(new Font("Century Gothic", Font.BOLD, 14));
		rdbtnEspecial.setForeground(Color.WHITE);
		rdbtnEspecial.setBounds(511, 73, 92, 23);
		frame.getContentPane().add(rdbtnEspecial);
		
		rdbtnPlatino = new JRadioButton("Platino");
		rdbtnPlatino.setForeground(Color.WHITE);
		rdbtnPlatino.setFont(new Font("Century Gothic", Font.BOLD, 14));
		rdbtnPlatino.setBackground(Color.decode("#21ae94"));
		rdbtnPlatino.setBounds(304, 73, 84, 23);
		frame.getContentPane().add(rdbtnPlatino);
		
		rdbtnOro = new JRadioButton("Oro\r\n");
		rdbtnOro.setBackground(Color.decode("#21ae94"));
		rdbtnOro.setFont(new Font("Century Gothic", Font.BOLD, 14));
		rdbtnOro.setForeground(Color.WHITE);
		rdbtnOro.setBounds(224, 73, 58, 23);
		frame.getContentPane().add(rdbtnOro);
		
		ButtonGroup buttonGroupServicio=new ButtonGroup();    
		buttonGroupServicio.add(rdbtnEspecial);buttonGroupServicio.add(rdbtnPlatino);buttonGroupServicio.add(rdbtnOro);buttonGroupServicio.add(rdbtnEconimico);
		
		// fin btn ventanilla 1
		
		txtInfoPersona = new JTextPane();
		txtInfoPersona.setBackground(SystemColor.text);
		txtInfoPersona.setFont(new Font("Century Gothic", Font.BOLD, 14));
		txtInfoPersona.setBounds(388, 129, 212, 100);
		txtInfoPersona.setEditable(false); 

		frame.getContentPane().add(txtInfoPersona);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setForeground(Color.WHITE);
		btnGenerar.setBackground(SystemColor.decode("#00cb75"));
		btnGenerar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtnombre.getText().length()==0 || txtfechanacimiento.getText().length()==0 || txtPasaporte.getText().length()==0 
						|| txtnacionalidad.getText().length()==0 || txtLorigen.getText().length()==0 || txtLdestino.getText().length()==0) {
					System.out.println("Debe seleccionar el servicio");
					JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos");
					return;

				}
				
				else if ((rdbtnOro.isSelected()||
					rdbtnPlatino.isSelected()||
					rdbtnEspecial.isSelected()||
					rdbtnEconimico.isSelected())==false) {
					System.out.println("Debe seleccionar el servicio");
					JOptionPane.showMessageDialog(null, "Debe seleccionar el servicio");
					return;
				}
				
				String servicio="";
				
				if(rdbtnOro.isSelected()) {
					servicio="Oro";
				}else if(rdbtnPlatino.isSelected()) {
					servicio="Platino";
				}else if(rdbtnEspecial.isSelected()) {
					servicio="Especial";
				}
				else if(rdbtnEconimico.isSelected()) {
					servicio="Econimico";
				}
				
				pActual=new Persona(
				txtnombre.getText(),txtfechanacimiento.getText(),txtPasaporte.getText(),
				txtnacionalidad.getText(),txtLorigen.getText(),txtLdestino.getText(),servicio
				);
				
				txtInfoPersona.setText(pActual.toString()); 
				JOptionPane.showMessageDialog(null, "Usuario Registrado");
				
			}
		});
		btnGenerar.setBounds(388, 240, 89, 23);
		frame.getContentPane().add(btnGenerar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(SystemColor.decode("#00cb75"));
		btnEnviar.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pActual==null) {
					System.out.println("Debe generar el checkin");
					return;
				}
				
				if(pActual.getServicio().equals("Oro")) {
					PuertaVIP.enqueue(pActual, 2);
					
				}else if(pActual.getServicio().equals("Platino")) {
					PuertaVIP.enqueue(pActual, 1);
					
				}else if(pActual.getServicio().equals("Econimico")) {
					PuertaVIP.enqueue(pActual, 3);
					
				}else if(pActual.getServicio().equals("Especial")) {
					PuertaEspecial.enqueue(pActual);
					
				}
				JOptionPane.showMessageDialog(null, "Asiento:"+pActual.getCodigo() +" ha sido enviado a\nla puerta check in.");
				pActual=null;
				txtnombre.setText("");txtfechanacimiento.setText("");txtPasaporte.setText("");
				txtnacionalidad.setText("");txtLorigen.setText("");txtLdestino.setText("");
				txtInfoPersona.setText(""); 
				return;
				
			}
		});
		
		txtNumero = new JTextField();
		txtNumero.setBounds(435, 322, 117, 14);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		btnEnviar.setBounds(511, 240, 89, 23);
		frame.getContentPane().add(btnEnviar);
		
		JButton btnSMS = new JButton("");
		btnSMS.setBackground(Color.decode("#00cb75"));
		btnSMS.setIcon(new ImageIcon("C:\\Users\\jmjos\\Desktop\\pp2\\SMS1.png"));
		btnSMS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNumero.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe de ingresar el número de telefono");
					return;
					
				}else {
					SMS.EnviarSMS(pActual.toString(), txtNumero.getText());
					JOptionPane.showMessageDialog(null, "Mensaje Enviado");
					
				}
				
			}
		});
		btnSMS.setBounds(556, 303, 59, 39);
		frame.getContentPane().add(btnSMS);
		
		JLabel lblVentanillas = new JLabel("Puertas");
		lblVentanillas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentanillas.setForeground(Color.WHITE);
		lblVentanillas.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblVentanillas.setBounds(887, 0, 133, 33);
		frame.getContentPane().add(lblVentanillas);
		
		JButton btnCerrarespeciales = new JButton("Cerrar");
		btnCerrarespeciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarTabla(FormatoPuertasEspecial);
				contEspecial=1;
			}
		});
		btnCerrarespeciales.setForeground(Color.WHITE);
		btnCerrarespeciales.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnCerrarespeciales.setBackground(new Color(0, 203, 117));
		btnCerrarespeciales.setBounds(1165, 317, 89, 23);
		frame.getContentPane().add(btnCerrarespeciales);
		
		JButton btnAtenderEspeciales = new JButton("Atender");
		btnAtenderEspeciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableVIP.getSelectedRow()<1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar la ventanilla que desea atender.");
					return;
					}
				TableModel Ventanilla=tableEspeciales.getModel();
				int Fila=tableEspeciales.getSelectedRow();
				System.out.println(Fila);
	        	Persona sigPersona=(Persona) PuertaEspecial.dequeue();
	        	if (sigPersona==null) {
					JOptionPane.showMessageDialog(null, "No hay personas para ingresar\na la puerta.");
					return;
	        	}
				Ventanilla.setValueAt("Atendiendo a: "+sigPersona.getCodigo(), Fila, 1);
			}
		});
		btnAtenderEspeciales.setForeground(Color.WHITE);
		btnAtenderEspeciales.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnAtenderEspeciales.setBackground(new Color(0, 203, 117));
		btnAtenderEspeciales.setBounds(1006, 317, 89, 23);
		frame.getContentPane().add(btnAtenderEspeciales);
		
		tableEspeciales = new JTable(FormatoPuertasEspecial);
		tableEspeciales.setBounds(1072, 62, 182, 225);
		frame.getContentPane().add(tableEspeciales);
		
		JScrollPane scrollPaneEspeciales = new JScrollPane(tableEspeciales);
		scrollPaneEspeciales.setBounds(1006, 72, 248, 234);
		frame.getContentPane().add(scrollPaneEspeciales);
		
		JLabel lblEspeciales = new JLabel("Especiales");
		lblEspeciales.setForeground(Color.WHITE);
		lblEspeciales.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblEspeciales.setBounds(1088, 49, 84, 20);
		frame.getContentPane().add(lblEspeciales);
		
		JButton btnCerrarpuertaVIP = new JButton("Cerrar");
		btnCerrarpuertaVIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimpiarTabla(FormatoPuertasVIP);
				contVIP=1;
			}
		});
		
		btnCerrarpuertaVIP.setForeground(Color.WHITE);
		btnCerrarpuertaVIP.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnCerrarpuertaVIP.setBackground(new Color(0, 203, 117));
		btnCerrarpuertaVIP.setBounds(829, 317, 89, 23);
		frame.getContentPane().add(btnCerrarpuertaVIP);
		
		JButton btnAtenderVIP = new JButton("Atender");
		btnAtenderVIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableVIP.getSelectedRow()<1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar la ventanilla que desea atender.");
					return;
					}
				TableModel Ventanilla=tableVIP.getModel();
				int Fila=tableVIP.getSelectedRow();
				System.out.println(Fila);
	        	Persona sigPersona=(Persona) PuertaVIP.dequeue();
	        	if (sigPersona==null) {
					JOptionPane.showMessageDialog(null, "No hay personas para ingresar\na la puerta.");
					return;
	        	}
				Ventanilla.setValueAt("Atendiendo a: "+sigPersona.getCodigo(), Fila, 1);

			}
		});
		btnAtenderVIP.setForeground(Color.WHITE);
		btnAtenderVIP.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnAtenderVIP.setBackground(new Color(0, 203, 117));
		btnAtenderVIP.setBounds(670, 317, 89, 23);
		frame.getContentPane().add(btnAtenderVIP);
		
		tableVIP = new JTable(FormatoPuertasVIP);
		tableVIP.setBounds(860, 62, 182, 225);
		frame.getContentPane().add(tableVIP);
		
		JScrollPane scrollPaneVIp = new JScrollPane(tableVIP);
		scrollPaneVIp.setBounds(670, 72, 248, 234);
		frame.getContentPane().add(scrollPaneVIp);
		
		JLabel lblVip = new JLabel("VIP");
		lblVip.setHorizontalAlignment(SwingConstants.CENTER);
		lblVip.setForeground(Color.WHITE);
		lblVip.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblVip.setBounds(759, 52, 77, 14);
		frame.getContentPane().add(lblVip);
		
		JLabel lblAdministraccin = new JLabel("Administracción");
		lblAdministraccin.setForeground(Color.WHITE);
		lblAdministraccin.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblAdministraccin.setBounds(225, 373, 199, 26);
		frame.getContentPane().add(lblAdministraccin);
		
		JButton btnConfigurarTiempo = new JButton("Configurar");
		btnConfigurarTiempo.setForeground(Color.WHITE);
		btnConfigurarTiempo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnConfigurarTiempo.setBackground(Color.decode("#00cb75"));
		btnConfigurarTiempo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCatidadSalidas.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe de ingresar el número de puertas");
					return;
				}
				if (txtrangotiempo1.getText().length()==0||txtrangotiempo2.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe de ingresar el rango de tiempo");
					return;
				}
				
				int Cantidad=Integer.parseInt(txtCatidadSalidas.getText());
				tiempoinicio= Double.parseDouble(txtrangotiempo1.getText());
				tiempofinal= Double.parseDouble(txtrangotiempo2.getText());
				
				for (int i = 0;i<Cantidad;i++) {
					String Ventanilla="V #"+contVIP;
					String[] newRow= {Ventanilla,"Ventanilla Libre"};			
					FormatoPuertasSalida.addRow(newRow);
					contVIP++;
				}
				
				JOptionPane.showMessageDialog(null, "Tiempo Configurado");

				
				
			}
		});
		btnConfigurarTiempo.setBounds(450, 572, 102, 23);
		frame.getContentPane().add(btnConfigurarTiempo);
		
		txtrangotiempo2 = new JTextField();
		txtrangotiempo2.setColumns(10);
		txtrangotiempo2.setBounds(534, 523, 46, 20);
		frame.getContentPane().add(txtrangotiempo2);
		
		txtrangotiempo1 = new JTextField();
		txtrangotiempo1.setBounds(478, 523, 46, 20);
		frame.getContentPane().add(txtrangotiempo1);
		txtrangotiempo1.setColumns(10);
		
		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblTiempo.setBounds(411, 521, 63, 18);
		frame.getContentPane().add(lblTiempo);
		
		txtCatidadSalidas = new JTextField();
		txtCatidadSalidas.setColumns(10);
		txtCatidadSalidas.setBounds(478, 480, 54, 21);
		frame.getContentPane().add(txtCatidadSalidas);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setForeground(Color.WHITE);
		lblSalida.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblSalida.setBounds(411, 480, 49, 14);
		frame.getContentPane().add(lblSalida);
		
		JButton btncrearEspeciales = new JButton("Crear");
		btncrearEspeciales.setBackground(Color.decode("#00cb75"));
		btncrearEspeciales.setForeground(Color.WHITE);
		btncrearEspeciales.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btncrearEspeciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPuertasEspeciales.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe de ingresar el número de puertas");
					return;
				}
				else if ((rdbtnColaEspeciales.isSelected()||
						rdbtnheapEspeciales.isSelected())==false) {
						System.out.println("Debe seleccionar la estructura de prioridad");
						JOptionPane.showMessageDialog(null, "Debe seleccionar la estructura de prioridad");
						return;
				}
				int Cantidad=Integer.parseInt(txtPuertasEspeciales.getText());
				
				for (int i = 0;i<Cantidad;i++) {
					String Ventanilla="V #"+contEspecial;
					String[] newRow= {Ventanilla,"Ventanilla Libre"};			
					FormatoPuertasEspecial.addRow(newRow);
					contEspecial++;
				}
				if(rdbtnColaEspeciales.isSelected()) {
					PuertaEspecial=new Cola();
				}else if (rdbtnheapEspeciales.isSelected()) {
					PuertaEspecial=new Cola();//CUANDO ESTE HABILITADO CAMBIAR POR CONSTRUCTOR DE HEAD
				}
				JOptionPane.showMessageDialog(null, "Puertas agregadas");
			}
		});
		
		JLabel lblTiempoDeAtencin = new JLabel("Tiempo de Atención");
		lblTiempoDeAtencin.setForeground(Color.WHITE);
		lblTiempoDeAtencin.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTiempoDeAtencin.setBounds(398, 441, 182, 25);
		frame.getContentPane().add(lblTiempoDeAtencin);
		btncrearEspeciales.setBounds(21, 633, 79, 23);
		frame.getContentPane().add(btncrearEspeciales);
		
		rdbtnColaEspeciales = new JRadioButton("Cola");
		rdbtnColaEspeciales.setBackground(Color.decode("#21ae94"));
		rdbtnColaEspeciales.setForeground(Color.WHITE);
		rdbtnColaEspeciales.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnColaEspeciales.setBounds(159, 598, 63, 23);
		frame.getContentPane().add(rdbtnColaEspeciales);
		
		rdbtnheapEspeciales = new JRadioButton("Heap");
		rdbtnheapEspeciales.setBackground(Color.decode("#21ae94"));
		rdbtnheapEspeciales.setForeground(Color.WHITE);
		rdbtnheapEspeciales.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnheapEspeciales.setBounds(86, 598, 63, 23);
		frame.getContentPane().add(rdbtnheapEspeciales);
		
		txtPuertasEspeciales = new JTextField();
		txtPuertasEspeciales.setColumns(10);
		txtPuertasEspeciales.setBounds(21, 599, 54, 23);
		frame.getContentPane().add(txtPuertasEspeciales);
		
		JLabel lblEspeciales_1 = new JLabel("Especiales");
		lblEspeciales_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEspeciales_1.setForeground(Color.WHITE);
		lblEspeciales_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblEspeciales_1.setBounds(74, 571, 87, 20);
		frame.getContentPane().add(lblEspeciales_1);
		
		JButton btnCrearVIP = new JButton("Crear");
		btnCrearVIP.setBackground(Color.decode("#00cb75"));
		btnCrearVIP.setForeground(Color.WHITE);
		btnCrearVIP.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnCrearVIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPuertasVIP.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Debe de ingresar el número de puertas");
					return;
				}
				else if ((rdbtnColaVIP.isSelected()||
						rdbtnHeapVIP.isSelected())==false) {
						System.out.println("Debe seleccionar la estructura de prioridad");
						JOptionPane.showMessageDialog(null, "Debe seleccionar la estructura de prioridad");
						return;
				}
				int Cantidad=Integer.parseInt(txtPuertasVIP.getText());

				for (int i = 0;i<Cantidad;i++) {
					String Ventanilla="V #"+contVIP;
					String[] newRow= {Ventanilla,"Ventanilla Libre"};			
					FormatoPuertasVIP.addRow(newRow);
					contVIP++;
				}
				if(rdbtnColaVIP.isSelected()) {
					PuertaVIP=new ColaPrioridad(3);
				}else if (rdbtnHeapVIP.isSelected()) {
					PuertaVIP=new ColaPrioridad(3);//CUANDO ESTE HABILITADO CAMBIAR POR CONSTRUCTOR DE HEAD
					
				}
				JOptionPane.showMessageDialog(null, "Puertas agregadas");

			}
		});
		btnCrearVIP.setBounds(21, 537, 78, 23);
		frame.getContentPane().add(btnCrearVIP);
		
		rdbtnColaVIP = new JRadioButton("Cola");
		rdbtnColaVIP.setBackground(Color.decode("#21ae94"));
		rdbtnColaVIP.setForeground(Color.WHITE);
		rdbtnColaVIP.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnColaVIP.setBounds(159, 503, 63, 23);
		frame.getContentPane().add(rdbtnColaVIP);
		
		rdbtnHeapVIP = new JRadioButton("Heap");
		rdbtnHeapVIP.setBackground(Color.decode("#21ae94"));
		rdbtnHeapVIP.setForeground(Color.WHITE);
		rdbtnHeapVIP.setFont(new Font("Century Gothic", Font.BOLD, 12));
		rdbtnHeapVIP.setBounds(90, 503, 63, 23);
		frame.getContentPane().add(rdbtnHeapVIP);
		
		txtPuertasVIP = new JTextField();
		txtPuertasVIP.setBounds(21, 504, 54, 23);
		frame.getContentPane().add(txtPuertasVIP);
		txtPuertasVIP.setColumns(10);
		
		ButtonGroup buttonGroupCrearVIP=new ButtonGroup();    
		buttonGroupCrearVIP.add(rdbtnColaVIP);buttonGroupCrearVIP.add(rdbtnHeapVIP);
		
		ButtonGroup buttonGroupCrearEspecial=new ButtonGroup();    
		buttonGroupCrearEspecial.add(rdbtnColaEspeciales);buttonGroupCrearEspecial.add(rdbtnheapEspeciales);
		
		JLabel lblVip_1 = new JLabel("VIP");
		lblVip_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblVip_1.setForeground(Color.WHITE);
		lblVip_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblVip_1.setBounds(101, 480, 37, 14);
		frame.getContentPane().add(lblVip_1);
		
		JLabel lblPuertas = new JLabel("Puertas");
		lblPuertas.setForeground(Color.WHITE);
		lblPuertas.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPuertas.setBounds(84, 444, 77, 18);
		frame.getContentPane().add(lblPuertas);
		
		JLabel lblSalida_1 = new JLabel("Salida");
		lblSalida_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalida_1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblSalida_1.setForeground(Color.WHITE);
		lblSalida_1.setBounds(903, 386, 128, 34);
		frame.getContentPane().add(lblSalida_1);
		
		JButton btnComentarios = new JButton("");
		btnComentarios.setBackground(Color.WHITE);
		btnComentarios.setIcon(new ImageIcon("C:\\Users\\jmjos\\Desktop\\pp2\\Comentarios.png"));
		btnComentarios.setBounds(1152, 644, 54, 50);
		frame.getContentPane().add(btnComentarios);
		
		JButton btnInciarCola = new JButton("Iniciar Desabordo");
		btnInciarCola.setBackground(Color.decode("#00cb75"));
		btnInciarCola.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnInciarCola.setForeground(Color.WHITE);
		btnInciarCola.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			}
		});
		btnInciarCola.setBounds(670, 674, 128, 20);
		frame.getContentPane().add(btnInciarCola);
		
		tableSalida = new JTable(FormatoPuertasSalida);
		tableSalida.setBounds(670, 441, 317, 253);
		frame.getContentPane().add(tableSalida);
		
		JScrollPane scrollPaneTabladeSalida = new JScrollPane(tableSalida);
		scrollPaneTabladeSalida.setBounds(808, 441, 317, 253);
		frame.getContentPane().add(scrollPaneTabladeSalida);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\jmjos\\Desktop\\pp2\\Fondo.png"));
		label.setBounds(0, -51, 1264, 820);
		frame.getContentPane().add(label);
		frame.setBounds(0, 0, 1280, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void LimpiarTabla(DefaultTableModel Modelo) {
		while(Modelo.getRowCount() > 1){
		    Modelo.removeRow(1);
		}
	}
}
