package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import imp.enumerators.Marca;

import java.awt.Component;

public class DarAltaCamion extends JPanel {
	private JTextField txt_modelo;
	
	public DarAltaCamion() {
		setBackground(new Color(255, 255, 204));
		
		JLabel lbl_patente = new JLabel("PATENTE");
		lbl_patente.setBounds(125, 45, 60, 14);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setBounds(125, 123, 60, 14);
		
		JComboBox combo_marca = new JComboBox();
		combo_marca.setBounds(246, 120, 160, 20);
		combo_marca.setModel(new DefaultComboBoxModel(Marca.values()));
		
		
		JLabel lbl_modelo = new JLabel("MODELO");
		lbl_modelo.setBounds(464, 123, 91, 14);
		
		txt_modelo = new JTextField();
		txt_modelo.setBounds(595, 120, 168, 20);
		txt_modelo.setColumns(10);
		
		JFormattedTextField ftxt_patente = new JFormattedTextField();
		ftxt_patente.setBounds(246, 42, 160, 20);
		
		JSpinner spinner_kmR = new JSpinner();
		spinner_kmR.setBounds(246, 205, 160, 20);
		
		JLabel lbl_kmR = new JLabel("KM RECORRIDOS");
		lbl_kmR.setBounds(125, 208, 135, 14);
		
		JLabel lbl_costoKm = new JLabel("COSTO POR KM");
		lbl_costoKm.setBounds(464, 208, 108, 14);
		
		JFormattedTextField ftxt_costoKm = new JFormattedTextField();
		ftxt_costoKm.setBounds(595, 205, 168, 20);
		
		JLabel lbl_costoHora = new JLabel("COSTO POR HORA");
		lbl_costoHora.setBounds(125, 289, 125, 14);
		
		JFormattedTextField ftxt_costoHora = new JFormattedTextField();
		ftxt_costoHora.setBounds(246, 286, 160, 20);
		
		JLabel lblNewLabel = new JLabel("FECHA COMPRA");
		lblNewLabel.setBounds(464, 45, 111, 14);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(595, 42, 168, 20);
		setLayout(null);
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