package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import imp.DTOs.InsumoDTO;
import imp.DTOs.InsumoDTOFiltro;
import imp.DTOs.PlantaDTO;
import imp.gestores.GestorInsumo;
import imp.gestores.GestorPlanta;

public class DarAltaPlanta extends JPanel {
	private JFormattedTextField txt_nombrePlanta;
	private JTextField txt_TipoPlanta;
	
	public DarAltaPlanta () {
		
		setBackground(new Color(118, 203, 117));
		setLayout(null); 
		
		JLabel lbl_nombrePlanta = new JLabel("NOMBRE DE LA PLANTA");
		lbl_nombrePlanta.setBounds(192, 137, 163, 14);
		add(lbl_nombrePlanta);
		
		JLabel lblNewLabel = new JLabel("TIPO DE PLANTA");
		lblNewLabel.setBounds(192, 193, 120, 14);
		add(lblNewLabel);
		
		JLabel lbl_agregarPlanta = new JLabel("AGREGAR PLANTA");
		lbl_agregarPlanta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_agregarPlanta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_agregarPlanta.setBounds(365, 39, 163, 20);
		add(lbl_agregarPlanta);
		
		txt_nombrePlanta = new JFormattedTextField();
		txt_nombrePlanta.setBounds(365, 134, 204, 20);
		add(txt_nombrePlanta);
		txt_nombrePlanta.setColumns(10);
		
		txt_nombrePlanta.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
					e.consume();
				else if (txt_nombrePlanta.getText().length() > max + 1) {
					e.consume();
					String shortened = txt_nombrePlanta.getText().substring(0, max);
					txt_nombrePlanta.setText(shortened);
				} else if (txt_nombrePlanta.getText().length() > max) {
					e.consume();
				}
			}
		});
		
		txt_TipoPlanta = new JTextField();
		txt_TipoPlanta.setText("PRODUCCION");
		txt_TipoPlanta.setEnabled(false);
		txt_TipoPlanta.setEditable(false);
		txt_TipoPlanta.setColumns(10);
		txt_TipoPlanta.setBounds(365, 190, 204, 20);
		add(txt_TipoPlanta);
		
		JButton btn_crear = new JButton("CREAR");
		btn_crear.setBounds(471, 265, 98, 40);
		btn_crear.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_crear.setBorderPainted(false);
		btn_crear.setFocusPainted(false);
		btn_crear.setContentAreaFilled(true);
		btn_crear.setForeground(new Color(0, 0, 0));
		btn_crear.setBackground(new Color(80, 165, 94));
		add(btn_crear);
		btn_crear.addActionListener(e -> { 
			
			PlantaDTO plantaDTO=new PlantaDTO(0, txt_nombrePlanta.getText().toUpperCase(), txt_TipoPlanta.getText());
			
			if(plantaDTO.getNombre().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Todos los campos obligatorios (*) deben estan completos.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else {
				GestorPlanta.darAltaPlanta(plantaDTO);
			}
			
			plantaDTO.setId(GestorPlanta.getIDPlanta(plantaDTO.getNombre()));
			PopUpAgregarRuta agregar_ruta = new PopUpAgregarRuta(plantaDTO);
			
		});
		
		
		
	}
}
