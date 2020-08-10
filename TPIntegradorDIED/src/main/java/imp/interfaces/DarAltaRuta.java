package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;

import imp.DTOs.RutaDTO;
import imp.gestores.GestorPlanta;
import imp.gestores.GestorRuta;

import javax.swing.JTextField;

public class DarAltaRuta extends JPanel {
	
	public CardLayout c = new CardLayout();
	
	List<String> listaNombresPlantas = GestorPlanta.getPlantasNombres();
	
	public DarAltaRuta() {
		
		
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		JLabel lbl_plantaDestino = new JLabel("PLANTA DESTINO");
		lbl_plantaDestino.setBounds(99, 95, 130, 14);
		add(lbl_plantaDestino);
		
		JLabel lbl_plantaFinal = new JLabel("PLANTA FINAL");
		lbl_plantaFinal.setBounds(529, 95, 130, 14);
		add(lbl_plantaFinal);
		
		JComboBox combo_plantaOrigen = new JComboBox();
		combo_plantaOrigen.setBounds(279, 91, 187, 22);
		add(combo_plantaOrigen);
		
		JComboBox combo_plantaFinal = new JComboBox();
		combo_plantaFinal.setBounds(693, 91, 187, 22);
		add(combo_plantaFinal);
		
		for(String c : listaNombresPlantas) {
			combo_plantaOrigen.addItem(c.toString());
			combo_plantaFinal.addItem(c.toString());
		}
		
		JLabel lbl_distancia = new JLabel("DISTNACIA (Kms)");
		lbl_distancia.setBounds(99, 146, 130, 14);
		add(lbl_distancia);
		
		JLabel lbl_duracion = new JLabel("DURACION (Hs)");
		lbl_duracion.setBounds(529, 146, 130, 14);
		add(lbl_duracion);
		
		JSpinner spinner_duracion = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 0.1));
		spinner_duracion.setBounds(693, 143, 187, 20);
		add(spinner_duracion);
		
		JSpinner spinner_distancia = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 0.1));
		spinner_distancia.setBounds(279, 143, 187, 20);
		add(spinner_distancia);
		
		JLabel lbl_pesoMax = new JLabel("PESO MÁXIMO (Kgs)");
		lbl_pesoMax.setBounds(99, 199, 130, 14);
		add(lbl_pesoMax);
		
		JTextField  txt_PesoMax = new JTextField();
		txt_PesoMax.setBounds(279, 196, 187, 20);
		txt_PesoMax.setColumns(10);
		add(txt_PesoMax);
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
		btn_aceptar.setBounds(504, 319, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		add(btn_aceptar);
		
		btn_aceptar.addActionListener(e -> {
			
			RutaDTO rutaDto = new RutaDTO(0,combo_plantaOrigen.getSelectedItem().toString(),combo_plantaFinal.getSelectedItem().toString(),
					spinner_distancia.getValue().toString(),spinner_duracion.getValue().toString(),txt_PesoMax.getText());
			
			if(rutaDto.getPesoMaximo().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos obligatorios (*) deben estan completos.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else if(rutaDto.getNombrePlantaDestino().equals((rutaDto.getNombrePlantaOrigen()))){
				JOptionPane.showMessageDialog(null, "Los nombres de las Plantas Origen y Final no deben ser iguales.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else{
				int idPlantaDestino = GestorPlanta.getIDPlanta(rutaDto.getNombrePlantaDestino());
				int idPlantaOrigen = GestorPlanta.getIDPlanta(rutaDto.getNombrePlantaOrigen());
				GestorRuta.darAltaRuta(rutaDto,idPlantaOrigen,idPlantaDestino);
				
				JOptionPane.showMessageDialog(null, "La ruta se ha creado correctamente.", "MENSAJE",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(612, 319, 98, 40);
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
				c.show(padre, "inicio_ruta");
		});
	}
}
