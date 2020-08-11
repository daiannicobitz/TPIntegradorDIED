package imp.interfaces;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import imp.enumerators.Marca;
import imp.gestores.GestorCamion;
import imp.primaryClasses.Camion;

public class ModificarCamion extends JPanel {
	ArrayList<Camion> Lista = null;
	Camion c1 = null;
	
	
	

	public CardLayout c = new CardLayout();
	JComboBox combo_marca1;
	JTextField txt_modelo1;
	JTextField ftxt_patente1;
	JSpinner spinner_kmR1;
	JTextField ftxt_costoKm1;
	JTextField ftxt_costoHora1;
	JDateChooser fecha_compra1;
	private boolean camionSeleccionado=false;
	
	public ModificarCamion () {
		
		
		setBackground(new Color(118, 203, 117));
		
		JLabel lbl_patente = new JLabel("PATENTE");
		lbl_patente.setBounds(125, 106, 60, 14);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setBounds(125, 173, 60, 14);
		
		combo_marca1 = new JComboBox();
		combo_marca1.setBounds(246, 170, 160, 20);
		combo_marca1.setModel(new DefaultComboBoxModel(Marca.values()));
		
		
		JLabel lbl_modelo = new JLabel("MODELO");
		lbl_modelo.setBounds(464, 173, 91, 14);
		
		txt_modelo1 = new JTextField();
		txt_modelo1.setBounds(595, 167, 168, 20);
		txt_modelo1.setColumns(10);
		
		ftxt_patente1 = new JFormattedTextField();
		ftxt_patente1.setBounds(246, 103, 160, 20);
		
		ftxt_patente1.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 8;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') &&(c < 'a' || c > 'z') &&(c < 'A' || c > 'Z')) e.consume();
				else if(ftxt_patente1.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_patente1.getText().substring(0,max);
					ftxt_patente1.setText(shortened);
				}else if(ftxt_patente1.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		spinner_kmR1 = new JSpinner();
		spinner_kmR1.setBounds(246, 231, 160, 20);
		
		JLabel lbl_kmR = new JLabel("KM RECORRIDOS");
		lbl_kmR.setBounds(125, 234, 135, 14);
		
		JLabel lbl_costoKm = new JLabel("COSTO POR KM");
		lbl_costoKm.setBounds(464, 234, 108, 14);
		
		ftxt_costoKm1 = new JFormattedTextField();
		ftxt_costoKm1.setBounds(595, 231, 168, 20);
		ftxt_costoKm1.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9')&& (c != '.')) e.consume();
				else if(ftxt_costoKm1.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoKm1.getText().substring(0,max);
					ftxt_costoKm1.setText(shortened);
				}else if(ftxt_costoKm1.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		JLabel lbl_costoHora = new JLabel("COSTO POR HORA");
		lbl_costoHora.setBounds(125, 300, 125, 14);
		
		ftxt_costoHora1 = new JFormattedTextField();
		ftxt_costoHora1.setBounds(246, 297, 160, 20);
		ftxt_costoHora1.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != '.')) e.consume();
				else if(ftxt_costoHora1.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoHora1.getText().substring(0,max);
					ftxt_costoHora1.setText(shortened);
				}else if(ftxt_costoHora1.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("FECHA COMPRA");
		lblNewLabel.setBounds(461, 106, 111, 14);
		
		fecha_compra1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecha_compra1.setDateFormatString("dd/MM/yyyy");
		
		LocalDateTime now = LocalDateTime.now();  
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date nowdate = Date.from(now.atZone(defaultZoneId).toInstant());
		Date inicio= null;
		try {
			inicio=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1980");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		fecha_compra1.setSelectableDateRange(inicio, nowdate);
		fecha_compra1.setBounds(595, 103, 168, 20);
		
		setLayout(null);
		add(lbl_patente);
		add(lbl_kmR);
		add(lbl_marca);
		add(lbl_costoHora);
		add(ftxt_costoHora1);
		add(ftxt_patente1);
		add(combo_marca1);
		add(spinner_kmR1);
		add(lblNewLabel);
		add(lbl_modelo);
		add(lbl_costoKm);
		add(ftxt_costoKm1);
		add(txt_modelo1);
		add(fecha_compra1);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(529, 397, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		btn_aceptar.addActionListener(e -> {

		GestorCamion gc1 = new GestorCamion();

		Date date = fecha_compra1.getDate(); 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = dateFormat.format(date);
		
		String validados = validarCampos(ftxt_patente1.getText().toUpperCase(), spinner_kmR1.getValue().toString(), combo_marca1.getSelectedItem().toString(), txt_modelo1.getText(), ftxt_costoKm1.getText(), ftxt_costoHora1.getText());
		
		if(validados == "" && camionSeleccionado == true) {
			
			c1.EditarCamion(ftxt_patente1.getText().toUpperCase(), ftxt_costoHora1.getText(), ftxt_costoKm1.getText(), strDate, spinner_kmR1.getValue().toString(), combo_marca1.getSelectedItem().toString(), txt_modelo1.getText());
			camionSeleccionado = false;
			
		} else {
			JOptionPane.showMessageDialog(null, "Error en los siguientes campos: \n"+ validados, "Estado camión.", JOptionPane.INFORMATION_MESSAGE);
			
		}
			
		});
		add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(637, 397, 98, 40);
		btn_cancelar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setForeground(new Color(0, 0, 0));
		btn_cancelar.setBackground(new Color(80, 165, 94));
		add(btn_cancelar);
		btn_cancelar.addActionListener(e -> { 
			JPanel padre = (JPanel) this.getParent();
			 c = (CardLayout)(padre.getLayout());
				c.show(padre, "inicioCamion");
		});
		
		JButton btn_buscarCamion = new JButton("BUSCAR CAMION A EDITAR");
		btn_buscarCamion.setForeground(Color.BLACK);
		btn_buscarCamion.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarCamion.setFocusPainted(false);
		btn_buscarCamion.setContentAreaFilled(true);
		btn_buscarCamion.setBorderPainted(false);
		btn_buscarCamion.setBackground(new Color(80, 165, 94));
		btn_buscarCamion.setBounds(125, 19, 281, 40);
		
		btn_buscarCamion.addActionListener(e -> {
			
			PopUpBuscarCamion();
		});
		
		add(btn_buscarCamion);
	}
	
	private String validarCampos(String patente, String kmr, String marca, String modelo, String costokm, String costohora) {
		
		String retorno = "";
		
		if(!patente.matches("[A-Z]{3}[0-9]{3}") && !patente.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
			retorno = retorno + " Patente \n";
		}	
		if(marca == "SELECCIONE_MARCA") {
				
				retorno = retorno + " Marca \n";
		}		
		if(modelo.isBlank()) {
				
			retorno = retorno + " Modelo \n";
		}		
		if (Double.parseDouble(kmr) < 0 ) {
				
			retorno = retorno + " Kilometros Recorridos \n";
		}		
		if(!costokm.matches("[0-9]*.[0-9]{2}")&& !costokm.matches("[0-9]*")){
			
			retorno = retorno + " Costo Kilometro \n";
		}	
		if(!costohora.matches("[0-9]*.[0-9]{2}") && !costohora.matches("[0-9]*")){
			
			retorno = retorno + " Costo Hora \n";
		}
		return retorno;
	}

	private void PopUpBuscarCamion(){
		JFrame frame = new JFrame();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(200, 200, 800, 540);
		frame.setResizable(false);
		
		JPanel panel_buscarCamion = new JPanel();
		panel_buscarCamion.setBackground(new Color(118, 203, 117));
		
		JLabel lbl_patente = new JLabel("PATENTE");
		lbl_patente.setBounds(61, 45, 60, 14);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setBounds(61, 88, 60, 14);
		
		JComboBox combo_marca = new JComboBox();
		combo_marca.setBounds(186, 85, 160, 20);
		combo_marca.setModel(new DefaultComboBoxModel(Marca.values()));
		
		
		JLabel lbl_modelo = new JLabel("MODELO");
		lbl_modelo.setBounds(426, 88, 91, 14);
		
		JTextField txt_modelo = new JTextField();
		txt_modelo.setBounds(584, 85, 168, 20);
		txt_modelo.setColumns(10);
		
		JFormattedTextField ftxt_patente = new JFormattedTextField();
		ftxt_patente.setBounds(186, 42, 160, 20);
		ftxt_patente.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 8;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') &&(c < 'a' || c > 'z') &&(c < 'A' || c > 'Z')) e.consume();
				else if(ftxt_patente.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_patente.getText().substring(0,max);
					ftxt_patente.setText(shortened);
				}else if(ftxt_patente.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		JSpinner spinner_kmR = new JSpinner();
		spinner_kmR.setBounds(186, 131, 160, 20);
		
		JLabel lbl_kmR = new JLabel("KM RECORRIDOS");
		lbl_kmR.setBounds(59, 134, 135, 14);
		
		JLabel lbl_costoKm = new JLabel("COSTO POR KM");
		lbl_costoKm.setBounds(429, 134, 108, 14);
		
		JFormattedTextField ftxt_costoKm = new JFormattedTextField();
		ftxt_costoKm.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9')&& (c != '.')) e.consume();
				else if(ftxt_costoKm.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoKm.getText().substring(0,max);
					ftxt_costoKm.setText(shortened);
				}else if(ftxt_costoKm.getText().length() >max) {
					e.consume();
				}
			}
		});
		ftxt_costoKm.setBounds(584, 131, 168, 20);
		
		JLabel lbl_costoHora = new JLabel("COSTO POR HORA");
		lbl_costoHora.setBounds(51, 176, 125, 14);
		
		JFormattedTextField ftxt_costoHora = new JFormattedTextField();
		ftxt_costoHora.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != '.')) e.consume();
				else if(ftxt_costoHora.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoHora.getText().substring(0,max);
					ftxt_costoHora.setText(shortened);
				}else if(ftxt_costoHora.getText().length() >max) {
					e.consume();
				}
			}
		});
		ftxt_costoHora.setBounds(186, 173, 160, 20);
		
		JLabel lblNewLabel = new JLabel("FECHA COMPRA");
		lblNewLabel.setBounds(426, 45, 111, 14);
		
		JDateChooser fecha_compra = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecha_compra.setDateFormatString("dd/MM/yyyy");
		
		LocalDateTime now = LocalDateTime.now();  
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date nowdate = Date.from(now.atZone(defaultZoneId).toInstant());
		Date inicio= null;
		try {
			inicio=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1980");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		fecha_compra.setSelectableDateRange(inicio, nowdate);
		fecha_compra.setBounds(584, 42, 168, 20);
		panel_buscarCamion.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 215, 719, 190);
		panel_buscarCamion.add(scrollPane);
		
		JTable tabla_camion = new JTable();
		tabla_camion.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_camion = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Patente", "Fecha compra", "Marca", "Modelo", "Km Recorridos", "Costo por Km", "Costo por hora"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_camion.setModel(model_tabla_camion);
		tabla_camion.getTableHeader().setReorderingAllowed(false);
		tabla_camion.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_camion);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(334, 432, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		btn_aceptar.addActionListener(e -> {
			
			if(tabla_camion.getSelectedRow() >=0) {
		    	c1 = Lista.get(tabla_camion.getSelectedRow());
		    	actualizarCamposCamion(c1);
		    	camionSeleccionado =true;
		    	frame.dispose();
			}  else {
		    	
		    	JOptionPane.showMessageDialog(null, "No se seleccionó un camión de la lista" , "Estado camión.", JOptionPane.INFORMATION_MESSAGE);
				
		    }
			});
		panel_buscarCamion.add(btn_aceptar);
		
		JButton btn_buscar = new JButton("BUSCAR CAMION");
		btn_buscar.setForeground(Color.BLACK);
		btn_buscar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscar.setFocusPainted(false);
		btn_buscar.setContentAreaFilled(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setBackground(new Color(80, 165, 94));
		btn_buscar.setBounds(584, 168, 168, 28);
		
		btn_buscar.addActionListener(e -> {
			GestorCamion gc1 = new GestorCamion();
			String strDate = "";
			try {
			Date date = fecha_compra.getDate(); 
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
			strDate = dateFormat.format(date);
			} catch (NullPointerException e1) {
				
			}finally {
				String validados = validarCampos(ftxt_patente.getText().toUpperCase(), spinner_kmR.getValue().toString(), combo_marca.getSelectedItem().toString(), txt_modelo.getText(), ftxt_costoKm.getText(), ftxt_costoHora.getText());
				
				if(validados == "") {
					
					Lista = gc1.BuscarCamion(ftxt_patente.getText(), ftxt_costoHora.getText(), ftxt_costoKm.getText(), strDate, spinner_kmR.getValue().toString(), combo_marca.getSelectedItem().toString(), txt_modelo.getText());
					tabla_camion.setModel(ActualizarTabla(Lista));
					
				} else {
					JOptionPane.showMessageDialog(null, "Error en los siguientes campos: \n"+ validados, "Estado camión.", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			});
		
		panel_buscarCamion.add(btn_buscar);
		
		
		panel_buscarCamion.add(lbl_patente);
		panel_buscarCamion.add(lbl_kmR);
		panel_buscarCamion.add(lbl_marca);
		panel_buscarCamion.add(lbl_costoHora);
		panel_buscarCamion.add(ftxt_costoHora);
		panel_buscarCamion.add(ftxt_patente);
		panel_buscarCamion.add(combo_marca);
		panel_buscarCamion.add(spinner_kmR);
		panel_buscarCamion.add(lblNewLabel);
		panel_buscarCamion.add(lbl_modelo);
		panel_buscarCamion.add(lbl_costoKm);
		panel_buscarCamion.add(ftxt_costoKm);
		panel_buscarCamion.add(txt_modelo);
		panel_buscarCamion.add(fecha_compra);
		
		frame.getContentPane().add(panel_buscarCamion);
		
	}
	
	
	private void actualizarCamposCamion(Camion c12) {
		
		 combo_marca1.setSelectedItem(Marca.valueOf(c12.getMarca()));
		 txt_modelo1.setText(c12.getModelo());
		 ftxt_patente1.setText(c12.getPatente());
		 spinner_kmR1.setValue(c12.getKmRecorridos());
		 ftxt_costoKm1.setText(Double.toString(c12.getCostoKm()));
		 ftxt_costoHora1.setText(Double.toString(c12.getCostoHora()));
		 Date date= null;
			try {
				date=new SimpleDateFormat("dd/MM/yyyy").parse(c12.getFechacompra());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 fecha_compra1.setDate(date);
	}

	private TableModel ActualizarTabla(ArrayList<Camion> lista) {

		System.out.println(lista.size());
		int cantCamiones = lista.size(); 
		int fila =0;
		Object[][] listaMuestra = new Object[cantCamiones][7];
		
		for(Camion c: lista) {
			
			listaMuestra[fila][0] = c.getPatente();
			listaMuestra[fila][1] = c.getFechacompra();
			listaMuestra[fila][2] = c.getMarca();
			listaMuestra[fila][3] = c.getModelo();
			listaMuestra[fila][4] = c.getKmRecorridos();
			listaMuestra[fila][5] = c.getCostoKm();
			listaMuestra[fila][6] = c.getCostoHora();
			fila++;

		}
		
		DefaultTableModel modelo = new DefaultTableModel(listaMuestra,new String[] {"Patente", "Fecha compra", "Marca", "Modelo", "Km Recorridos", "Costo por Km", "Costo por hora"}) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
		
		return modelo;
	}

}
