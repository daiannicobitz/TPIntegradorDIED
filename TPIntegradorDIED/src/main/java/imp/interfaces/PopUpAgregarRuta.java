package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import imp.DTOs.PlantaDTO;

public class PopUpAgregarRuta extends JFrame {
	
	public PopUpAgregarRuta (PlantaDTO plantaDestino) {
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(200, 200, 800, 540);
		setResizable(false);
		
		JPanel contenedor_agregarRuta = new JPanel();
		contenedor_agregarRuta.setBackground(new Color(118, 203, 117));
		contenedor_agregarRuta.setLayout(null);
		
		
		JLabel lbl_plantaDestino = new JLabel("PLANTA DESTINO");
		lbl_plantaDestino.setBounds(69, 94, 110, 14);
		contenedor_agregarRuta.add(lbl_plantaDestino);
		
		JLabel lbl_plantaFinal = new JLabel("PLANTA FINAL");
		lbl_plantaFinal.setBounds(420, 94, 116, 14);
		contenedor_agregarRuta.add(lbl_plantaFinal);
		
		JComboBox combo_plantaDestino = new JComboBox();
		combo_plantaDestino.setBounds(210, 90, 173, 22);
		contenedor_agregarRuta.add(combo_plantaDestino);
		
		JComboBox combo_plantaFinal = new JComboBox();
		combo_plantaFinal.setBounds(546, 90, 181, 22);
		contenedor_agregarRuta.add(combo_plantaFinal);
		
		JLabel lbl_distancia = new JLabel("DISTNACIA (Kms)");
		lbl_distancia.setBounds(69, 150, 85, 14);
		contenedor_agregarRuta.add(lbl_distancia);
		
		JLabel lbl_duracion = new JLabel("DURACION (Hs)");
		lbl_duracion.setBounds(420, 150, 110, 14);
		contenedor_agregarRuta.add(lbl_duracion);
		
		JSpinner spinner_duracion = new JSpinner();
		spinner_duracion.setBounds(554, 147, 173, 20);
		contenedor_agregarRuta.add(spinner_duracion);
		
		JSpinner spinner_distancia = new JSpinner();
		spinner_distancia.setBounds(210, 147, 173, 20);
		contenedor_agregarRuta.add(spinner_distancia);
		
		JLabel lbl_pesoMax = new JLabel("PESO MÁXIMO (Kgs)");
		lbl_pesoMax.setBounds(69, 199, 98, 14);
		contenedor_agregarRuta.add(lbl_pesoMax);
		
		JTextField  txt_PesoMax = new JTextField();
		txt_PesoMax.setBounds(210, 196, 173, 20);
		txt_PesoMax.setColumns(10);
		contenedor_agregarRuta.add(txt_PesoMax);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(404, 319, 110, 34);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		contenedor_agregarRuta.add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(524, 319, 98, 34);
		btn_cancelar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setForeground(new Color(0, 0, 0));
		btn_cancelar.setBackground(new Color(80, 165, 94));
		contenedor_agregarRuta.add(btn_cancelar);
		
		btn_cancelar.addActionListener(e -> {
			this.dispose();
		});
		
		getContentPane().add(contenedor_agregarRuta);
		
		JLabel lbl_agregarRuta = new JLabel("AGREGAR RUTA");
		lbl_agregarRuta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_agregarRuta.setBounds(321, 30, 143, 34);
		contenedor_agregarRuta.add(lbl_agregarRuta);
		
	}

}
