package imp.interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import imp.enumerators.Marca;

public class PopUpBuscarCamion extends JFrame{
	
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(584, 42, 168, 20);
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
			//TO-DO  implementar  la busqueda 
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
		panel_buscarCamion.add(formattedTextField);
		
		getContentPane().add(panel_buscarCamion);
		
		
		
	}
	
	

}
