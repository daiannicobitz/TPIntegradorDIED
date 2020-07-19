package imp.interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import imp.enumerators.Marca;

import java.awt.*;

public class BuscarCamion extends JPanel {
	
	

	public BuscarCamion() {
		setBackground(new Color(255,255, 204));
		
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(661, 42, 168, 20);
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
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(623, 434, 98, 23);
		add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(731, 434, 98, 23);
		add(btn_cancelar);
		
		
		
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
		add(formattedTextField);
	}
}
