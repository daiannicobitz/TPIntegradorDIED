package imp.interfaces;

import java.awt.BorderLayout;
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

public class PopUpBuscarCamion extends JFrame{
	ArrayList<Camion> Lista = null;
	
	public PopUpBuscarCamion (){
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(200, 200, 800, 540);
		setResizable(false);
		
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
		
		JSpinner spinner_kmR = new JSpinner();
		spinner_kmR.setBounds(186, 131, 160, 20);
		
		JLabel lbl_kmR = new JLabel("KM RECORRIDOS");
		lbl_kmR.setBounds(59, 134, 135, 14);
		
		JLabel lbl_costoKm = new JLabel("COSTO POR KM");
		lbl_costoKm.setBounds(429, 134, 108, 14);
		
		JFormattedTextField ftxt_costoKm = new JFormattedTextField();
		ftxt_costoKm.setBounds(584, 131, 168, 20);
		
		JLabel lbl_costoHora = new JLabel("COSTO POR HORA");
		lbl_costoHora.setBounds(51, 176, 125, 14);
		
		JFormattedTextField ftxt_costoHora = new JFormattedTextField();
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
			Lista = gc1.BuscarCamion(ftxt_patente.getText(), ftxt_costoHora.getText(), ftxt_costoKm.getText(), strDate, spinner_kmR.getValue().toString(), combo_marca.getSelectedItem().toString(), txt_modelo.getText());
			tabla_camion.setModel(ActualizarTabla(Lista));
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
		
		getContentPane().add(panel_buscarCamion);
		
		
		
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
