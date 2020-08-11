package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.*;

import imp.DTOs.PlantaDTO;
import imp.DTOs.RutaDTO;
import imp.gestores.GestorPlanta;
import imp.gestores.GestorRuta;
import imp.structures.Ruta;

public class PopUpAgregarRuta extends JFrame {
	
	List<String> listaNombresPlantas = GestorPlanta.getPlantasNombres();
	
	public PopUpAgregarRuta (PlantaDTO plantaDestino) {
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(200, 200, 800, 540);
		setResizable(false);
		
		JPanel contenedor_agregarRuta = new JPanel();
		contenedor_agregarRuta.setBackground(new Color(118, 203, 117));
		contenedor_agregarRuta.setLayout(null);
		
		
		JLabel lbl_plantaDestino = new JLabel("PLANTA ORIGEN");
		lbl_plantaDestino.setBounds(69, 94, 110, 14);
		contenedor_agregarRuta.add(lbl_plantaDestino);
		
		JLabel lbl_plantaFinal = new JLabel("PLANTA FINAL");
		lbl_plantaFinal.setBounds(420, 94, 116, 14);
		contenedor_agregarRuta.add(lbl_plantaFinal);
		
		JComboBox combo_plantaOrigen = new JComboBox();
		combo_plantaOrigen.setBounds(210, 90, 173, 22);
		contenedor_agregarRuta.add(combo_plantaOrigen);
		
		for(String c : listaNombresPlantas) {
			combo_plantaOrigen.addItem(c.toString());
		}
		
		JComboBox combo_plantaFinal = new JComboBox();
		combo_plantaFinal.setBounds(546, 90, 181, 22);
		contenedor_agregarRuta.add(combo_plantaFinal);
		
		if(plantaDestino != null) {
			combo_plantaFinal.addItem(plantaDestino.getNombre().toString());
			combo_plantaFinal.setEditable(false);
			combo_plantaFinal.setEnabled(false);
		}else {
			JOptionPane.showMessageDialog(null, "Hubo un error al crear la planta.",
					"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		JLabel lbl_distancia = new JLabel("DISTANCIA (Kms)");
		lbl_distancia.setBounds(69, 150, 85, 14);
		contenedor_agregarRuta.add(lbl_distancia);
		
		JLabel lbl_duracion = new JLabel("DURACION (Hs)");
		lbl_duracion.setBounds(420, 150, 110, 14);
		contenedor_agregarRuta.add(lbl_duracion);
		
		JSpinner spinner_duracion = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 0.1));
		spinner_duracion.setBounds(554, 147, 173, 20);
		contenedor_agregarRuta.add(spinner_duracion);
		
		JSpinner spinner_distancia = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 0.1));
		spinner_distancia.setBounds(210, 147, 173, 20);
		contenedor_agregarRuta.add(spinner_distancia);
		
		JLabel lbl_pesoMax = new JLabel("PESO MÁXIMO (Kgs)");
		lbl_pesoMax.setBounds(69, 199, 98, 14);
		contenedor_agregarRuta.add(lbl_pesoMax);
		
		JTextField  txt_PesoMax = new JTextField();
		txt_PesoMax.setBounds(210, 196, 173, 20);
		txt_PesoMax.setColumns(10);
		contenedor_agregarRuta.add(txt_PesoMax);
		txt_PesoMax.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && (c != '.'))
					e.consume();
				else if (txt_PesoMax.getText().length() > max + 1) {
					e.consume();
					String shortened = txt_PesoMax.getText().substring(0, max);
					txt_PesoMax.setText(shortened);
				} else if (txt_PesoMax.getText().length() > max) {
					e.consume();
				}
			}
		});

		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(404, 319, 110, 34);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		contenedor_agregarRuta.add(btn_aceptar);
		btn_aceptar.addActionListener(e -> {
			
			RutaDTO rutaDto = new RutaDTO(0,combo_plantaOrigen.getSelectedItem().toString(),plantaDestino.getNombre(),
					spinner_distancia.getValue().toString(),spinner_duracion.getValue().toString(),txt_PesoMax.getText());
			
			if(rutaDto.getPesoMaximo().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos obligatorios (*) deben estan completos.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else {
				GestorPlanta.darAltaPlanta(plantaDestino);
				int idPlantaDestino = GestorPlanta.getIDPlanta(rutaDto.getNombrePlantaDestino());
				int idPlantaOrigen = GestorPlanta.getIDPlanta(rutaDto.getNombrePlantaOrigen());
				GestorRuta.darAltaRuta(rutaDto,idPlantaOrigen,idPlantaDestino);
				this.dispose();
				JOptionPane.showMessageDialog(null, "La planta y la ruta se han creado correctamente.", "MENSAJE",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		
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
