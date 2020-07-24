package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import imp.enumerators.Marca;
import imp.enumerators.UM;

public class DarAltaInsumo extends JPanel {
	
	public DarAltaInsumo() {
		setBackground(new Color(118, 203, 117));
		
		JLabel lbl_descripcion = new JLabel("DESCRIPCION");
		lbl_descripcion.setBounds(125, 60, 91, 14);
		
		JLabel lbl_unidadMedida = new JLabel("UNIDAD DE MEDIDA");
		lbl_unidadMedida.setBounds(125, 123, 111, 14);
		
		JComboBox combo_medidas = new JComboBox();
		combo_medidas.setBounds(265, 120, 160, 20);
		combo_medidas.setModel(new DefaultComboBoxModel(UM.values()));
		
		
		JLabel lbl_peso = new JLabel("PESO");
		lbl_peso.setBounds(519, 208, 91, 14);
		
		JTextField txt_peso = new JTextField();
		txt_peso.setBounds(657, 205, 168, 20);
		txt_peso.setColumns(10);
		
		JFormattedTextField ftxt_descripcion = new JFormattedTextField();
		ftxt_descripcion.setBounds(265, 45, 560, 45);
		
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
		
		
		
		JSpinner spinner_cantidad = new JSpinner();
		spinner_cantidad.setBounds(265, 205, 160, 20);
		
		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setBounds(125, 208, 135, 14);
		
		JLabel lbl_costoUnitario = new JLabel("COSTO UNITARIO");
		lbl_costoUnitario.setBounds(519, 123, 108, 14);
		
		JFormattedTextField ftxt_costoUnitario = new JFormattedTextField();
		ftxt_costoUnitario.setBounds(657, 120, 168, 20);
		
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
		lbl_densidad.setBounds(125, 289, 125, 14);
		
		JFormattedTextField ftxt_densidad = new JFormattedTextField();
		ftxt_densidad.setBounds(265, 286, 160, 20);
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
		add(txt_peso);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(529, 397, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(637, 397, 98, 40);
		btn_cancelar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setForeground(new Color(0, 0, 0));
		btn_cancelar.setBackground(new Color(80, 165, 94));
		add(btn_cancelar);
	}

}
