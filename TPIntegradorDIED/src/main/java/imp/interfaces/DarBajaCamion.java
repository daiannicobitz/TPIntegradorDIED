package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
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
import imp.primaryClasses.ListaGlobalCamiones;

public class DarBajaCamion extends JPanel {
	
	ArrayList<Camion> Lista = null;
	
	public DarBajaCamion () {
		setBackground(new Color(118, 203, 117));
		
		JLabel lbl_patente = new JLabel("PATENTE");
		lbl_patente.setBounds(110, 45, 60, 14);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setBounds(110, 88, 60, 14);
		
		JComboBox combo_marca = new JComboBox();
		combo_marca.setBounds(291, 85, 160, 20);
		combo_marca.setModel(new DefaultComboBoxModel(Marca.values()));
		
		
		JLabel lbl_modelo = new JLabel("MODELO");
		lbl_modelo.setBounds(503, 88, 91, 14);
		
		JTextField txt_modelo = new JTextField();
		txt_modelo.setBounds(661, 85, 168, 20);
		txt_modelo.setColumns(10);
		
		JFormattedTextField ftxt_patente = new JFormattedTextField();
		ftxt_patente.setBounds(291, 42, 160, 20);
		
		JSpinner spinner_kmR = new JSpinner();
		spinner_kmR.setBounds(291, 131, 160, 20);
		
		JLabel lbl_kmR = new JLabel("KM RECORRIDOS");
		lbl_kmR.setBounds(110, 134, 135, 14);
		
		JLabel lbl_costoKm = new JLabel("COSTO POR KM");
		lbl_costoKm.setBounds(503, 134, 108, 14);
		
		JFormattedTextField ftxt_costoKm = new JFormattedTextField();
		ftxt_costoKm.setBounds(661, 131, 168, 20);
		
		JLabel lbl_costoHora = new JLabel("COSTO POR HORA");
		lbl_costoHora.setBounds(110, 176, 125, 14);
		
		JFormattedTextField ftxt_costoHora = new JFormattedTextField();
		ftxt_costoHora.setBounds(291, 173, 160, 20);
		
		JLabel lblNewLabel = new JLabel("FECHA COMPRA");
		lblNewLabel.setBounds(503, 45, 111, 14);
		
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
		//fecha_compra.setBounds(595, 42, 168, 20);
		fecha_compra.setBounds(661, 42, 168, 20);
		setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 220, 719, 190);
		add(scrollPane);
		
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
		
		
		add(lbl_patente);
		add(lbl_kmR);
		add(lbl_marca);
		add(lbl_costoHora);
		add(ftxt_costoHora);
		add(ftxt_patente);
		add(combo_marca);
		add(spinner_kmR);
		add(lblNewLabel);
		add(lbl_modelo);
		add(lbl_costoKm);
		add(ftxt_costoKm);
		add(txt_modelo);
		add(fecha_compra);
				
		JButton btn_buscar = new JButton("BUSCAR CAMION");
		btn_buscar.setForeground(Color.BLACK);
		btn_buscar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscar.setFocusPainted(false);
		btn_buscar.setContentAreaFilled(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setBackground(new Color(80, 165, 94));
		btn_buscar.setBounds(661, 168, 168, 28);
		
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
		
		add(btn_buscar);
		
		JButton btn_eliminar = new JButton("ELIMINAR CAMION");
		btn_eliminar.setBounds(623, 423, 189, 40);
		btn_eliminar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_eliminar.setBorderPainted(false);
		btn_eliminar.setFocusPainted(false);
		btn_eliminar.setContentAreaFilled(true);
		btn_eliminar.setForeground(new Color(0, 0, 0));
		btn_eliminar.setBackground(new Color(80, 165, 94));
		btn_eliminar.addActionListener(e -> {
		    Camion retorno = new Camion();
			
		    if(tabla_camion.getSelectedRow() >=0) {
		    	
		    	retorno = Lista.get(tabla_camion.getSelectedRow());
		    	retorno.BajaCamion();
		    	tabla_camion.setModel(model_tabla_camion);
		    	JOptionPane.showMessageDialog(null, "El Camión se eliminó correctamente" , "Estado camión.", JOptionPane.INFORMATION_MESSAGE);
				
		    } else {
		    	
		    	JOptionPane.showMessageDialog(null, "No se seleccionó un camión de la lista" , "Estado camión.", JOptionPane.INFORMATION_MESSAGE);
				
		    }
		    
		});
		add(btn_eliminar);
		
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
