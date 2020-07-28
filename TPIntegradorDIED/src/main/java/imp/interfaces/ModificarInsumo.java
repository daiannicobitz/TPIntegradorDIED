package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import imp.DTOs.InsumoDTO;
import imp.enumerators.Marca;
import imp.enumerators.UM;
import imp.gestores.GestorInsumo;

public class ModificarInsumo extends JPanel {
	
	private InsumoDTO insumoSeleccionado=null;

	public ModificarInsumo() {
		setBackground(new Color(118, 203, 117));
		
		JLabel lbl_descripcion = new JLabel("DESCRIPCION");
		lbl_descripcion.setBounds(112, 109, 91, 14);
		
		JLabel lbl_unidadMedida = new JLabel("UNIDAD DE MEDIDA");
		lbl_unidadMedida.setBounds(112, 186, 111, 14);
		
		JComboBox combo_medidas = new JComboBox();
		combo_medidas.setBounds(246, 183, 160, 20);
		combo_medidas.setModel(new DefaultComboBoxModel(UM.values()));
		
		
		JLabel lbl_peso = new JLabel("PESO");
		lbl_peso.setBounds(473, 246, 91, 14);
		
		JFormattedTextField ftxt_peso = new JFormattedTextField();
		ftxt_peso.setBounds(591, 243, 168, 20);
		ftxt_peso.setColumns(10);
		ftxt_peso.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != '.')) e.consume();
				else if(ftxt_peso.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_peso.getText().substring(0,max);
					ftxt_peso.setText(shortened);
				}else if(ftxt_peso.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		
		JFormattedTextField ftxt_descripcion = new JFormattedTextField();
		ftxt_descripcion.setBounds(245, 94, 514, 45);
		
		ftxt_descripcion.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') &&(c < 'a' || c > 'z') &&(c < 'A' || c > 'Z')) e.consume();
				else if(ftxt_descripcion.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_descripcion.getText().substring(0,max);
					ftxt_descripcion.setText(shortened);
				}else if(ftxt_descripcion.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		
		
		JSpinner spinner_cantidad = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 0.1));
		spinner_cantidad.setBounds(245, 243, 160, 20);
		
		
		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setBounds(112, 246, 135, 14);
		
		JLabel lbl_costoUnitario = new JLabel("COSTO UNITARIO");
		lbl_costoUnitario.setBounds(473, 183, 108, 14);
		
		JFormattedTextField ftxt_costoUnitario = new JFormattedTextField();
		ftxt_costoUnitario.setBounds(591, 180, 168, 20);
		
		ftxt_costoUnitario.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9')&& (c != '.')) e.consume();
				else if(ftxt_costoUnitario.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoUnitario.getText().substring(0,max);
					ftxt_costoUnitario.setText(shortened);
				}else if(ftxt_costoUnitario.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		JLabel lbl_densidad = new JLabel("DENSIDAD");
		lbl_densidad.setBounds(112, 302, 125, 14);
		
		JFormattedTextField ftxt_densidad = new JFormattedTextField();
		ftxt_densidad.setBounds(245, 299, 160, 20);
		ftxt_densidad.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != '.')) e.consume();
				else if(ftxt_densidad.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_densidad.getText().substring(0,max);
					ftxt_densidad.setText(shortened);
				}else if(ftxt_densidad.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		
		setLayout(null);
		add(lbl_descripcion);
		add(lbl_cantidad);
		add(lbl_unidadMedida);
		add(lbl_densidad);
		add(ftxt_densidad);
		add(ftxt_descripcion);
		add(combo_medidas);
		add(spinner_cantidad);
		add(lbl_peso);
		add(lbl_costoUnitario);
		add(ftxt_costoUnitario);
		add(ftxt_peso);
		
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(553, 372, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		add(btn_aceptar);
		
		btn_aceptar.addActionListener(e -> {
			
			InsumoDTO insumodtoUPDATE=null;
			
			if (ftxt_densidad.isEnabled()) {
				insumodtoUPDATE = new InsumoDTO(insumoSeleccionado.getId(), ftxt_descripcion.getText(), combo_medidas.getSelectedItem().toString(),
						ftxt_costoUnitario.getText(), spinner_cantidad.getValue().toString(), null,
						ftxt_densidad.getText());
				
			} else {
				insumodtoUPDATE = new InsumoDTO(insumoSeleccionado.getId(), ftxt_descripcion.getText(), combo_medidas.getSelectedItem().toString(),
						ftxt_costoUnitario.getText(), spinner_cantidad.getValue().toString(), ftxt_peso.getText(),
						"-");
			}

			if (insumodtoUPDATE.getDescripcion().isEmpty() || (combo_medidas.getSelectedIndex() == 0)
					|| insumodtoUPDATE.getCostoUnitario().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Todos los campos obligatorios (*) deben estan completos.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);

			} else {
				
				System.out.println(insumodtoUPDATE.getCantidad());
				GestorInsumo.editarInsumo(insumodtoUPDATE);
				JOptionPane.showMessageDialog(null, "El insumo se actualizo correctamente.", "MENSAJE",
						JOptionPane.INFORMATION_MESSAGE);

			}
			
			
			
		});
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(661, 372, 98, 40);
		btn_cancelar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setForeground(new Color(0, 0, 0));
		btn_cancelar.setBackground(new Color(80, 165, 94));
		add(btn_cancelar);
		
		btn_cancelar.addActionListener(e -> {
//			FALTA IMPLEMENTAR
		});
		
		JButton btn_buscarInsumo = new JButton("BUSCAR INSUMO A EDITAR");
		btn_buscarInsumo.setForeground(Color.BLACK);
		btn_buscarInsumo.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarInsumo.setFocusPainted(false);
		btn_buscarInsumo.setContentAreaFilled(true);
		btn_buscarInsumo.setBorderPainted(false);
		btn_buscarInsumo.setBackground(new Color(80, 165, 94));
		btn_buscarInsumo.setBounds(112, 25, 281, 40);
		
		btn_buscarInsumo.addActionListener(e -> {
			
			PopUpBuscarInsumo buscar_insumo = new PopUpBuscarInsumo(this);
			
		});
		
		add(btn_buscarInsumo);
		
	
	}

	public void setInsumoDTO(InsumoDTO insumoDTOSelect) {
		// TODO Auto-generated method stub
		insumoSeleccionado=insumoDTOSelect;
	}
}
