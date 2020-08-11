package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import imp.enumerators.Marca;
import imp.gestores.DBManager;
import imp.gestores.GestorCamion;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import imp.primaryClasses.*;

public class DarAltaCamion extends JPanel {
	public CardLayout c = new CardLayout();
	
	
	public DarAltaCamion() {
		
		setBackground(new Color(118, 203, 117));
		
		JLabel lbl_patente = new JLabel("PATENTE *");
		lbl_patente.setBounds(125, 45, 60, 14);
		
		JLabel lbl_marca = new JLabel("MARCA");
		lbl_marca.setBounds(125, 123, 60, 14);
		
		JComboBox combo_marca = new JComboBox();
		combo_marca.setBounds(246, 120, 160, 20);
		combo_marca.setModel(new DefaultComboBoxModel(Marca.values()));
		
		
		JLabel lbl_modelo = new JLabel("MODELO");
		lbl_modelo.setBounds(464, 123, 91, 14);
		
		JTextField txt_modelo = new JTextField();
		txt_modelo.setBounds(595, 120, 168, 20);
		txt_modelo.setColumns(10);
		
		JFormattedTextField ftxt_patente = new JFormattedTextField();
		ftxt_patente.setBounds(246, 42, 160, 20);
		
		ftxt_patente.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 8;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') &&(c < 'a' || c > 'z') &&(c < 'A' || c > 'Z')) e.consume();
				else if(ftxt_patente.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_patente.getText().substring(0,max);
					ftxt_patente.setText(shortened);
				}else if(ftxt_patente.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		
		
		JSpinner spinner_kmR = new JSpinner();
		spinner_kmR.setBounds(246, 205, 160, 20);
		
		JLabel lbl_kmR = new JLabel("KM RECORRIDOS");
		lbl_kmR.setBounds(125, 208, 135, 14);
		
		JLabel lbl_costoKm = new JLabel("COSTO POR KM **");
		lbl_costoKm.setBounds(464, 208, 108, 14);
		
		JFormattedTextField ftxt_costoKm = new JFormattedTextField();
		ftxt_costoKm.setBounds(595, 205, 168, 20);
		
		ftxt_costoKm.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9')&& (c != '.')) e.consume();
				else if(ftxt_costoKm.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoKm.getText().substring(0,max);
					ftxt_costoKm.setText(shortened);
				}else if(ftxt_costoKm.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		JLabel lbl_costoHora = new JLabel("COSTO POR HORA **");
		lbl_costoHora.setBounds(125, 289, 125, 14);
		
		JFormattedTextField ftxt_costoHora = new JFormattedTextField();
		ftxt_costoHora.setBounds(246, 286, 160, 20);
		ftxt_costoHora.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != '.')) e.consume();
				else if(ftxt_costoHora.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoHora.getText().substring(0,max);
					ftxt_costoHora.setText(shortened);
				}else if(ftxt_costoHora.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("FECHA COMPRA");
		lblNewLabel.setBounds(464, 45, 111, 14);
		
		JDateChooser fecha_compra = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecha_compra.setDateFormatString("dd/MM/yyyy");
		
		LocalDateTime now = LocalDateTime.now();  
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date nowdate = Date.from(now.atZone(defaultZoneId).toInstant());
		fecha_compra.setDate(nowdate);
		Date inicio= null;
		try {
			inicio=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1980");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		fecha_compra.setSelectableDateRange(inicio, nowdate);
		fecha_compra.setBounds(595, 42, 168, 20);
		
		JLabel lblinfoPatente = new JLabel("* Ingrese su patente en forma LLLNNN o LLNNNLL.");
		lblinfoPatente.setBounds(125, 397, 315, 14);
		
		JLabel lblinfoCosto = new JLabel("** Solo se permiten 2 decimales.");
		lblinfoCosto.setBounds(125, 415, 315, 14);
		
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
		add(fecha_compra);
		add(lblinfoPatente);
		add(lblinfoCosto);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(529, 397, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		btn_aceptar.addActionListener(e -> {
			

		GestorCamion gc1 = new GestorCamion();

		Date date = fecha_compra.getDate(); 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		String strDate = dateFormat.format(date);
		
		String validados = validarCampos(ftxt_patente.getText().toUpperCase(), spinner_kmR.getValue().toString(), combo_marca.getSelectedItem().toString(), txt_modelo.getText(), ftxt_costoKm.getText(), ftxt_costoHora.getText());
		
		if(validados == "") {
			
	
	    Camion retorno = gc1.AltaCamion(ftxt_patente.getText().toUpperCase(), Double.parseDouble(spinner_kmR.getValue().toString()), combo_marca.getSelectedItem().toString(), txt_modelo.getText().toUpperCase(), Double.parseDouble(ftxt_costoKm.getText()), Double.parseDouble(ftxt_costoHora.getText()), strDate);

	    
		} else {
			JOptionPane.showMessageDialog(null, "Error en los siguientes campos: \n"+ validados, "Estado camión.", JOptionPane.INFORMATION_MESSAGE);
			
		}
			
		});
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
		btn_cancelar.addActionListener(e -> { 
			JPanel padre = (JPanel) this.getParent();
			 c = (CardLayout)(padre.getLayout());
				c.show(padre, "inicioCamion");
		});
		
		
	}

	private String validarCampos(String patente, String kmr, String marca, String modelo, String costokm, String costohora) {
		
		String retorno = "";
		
		if(!patente.matches("[A-Z]{3}[0-9]{3}") && !patente.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
			retorno = retorno + " Patente \n";
		}	
		if(marca == "SELECCIONE_MARCA") {
				
				retorno = retorno + " Marca \n";
		}		
		if(modelo.isBlank()) {
				
			retorno = retorno + " Modelo \n";
		}		
		if (Double.parseDouble(kmr) < 0 ) {
				
			retorno = retorno + " Kilometros Recorridos \n";
		}		
		if(!costokm.matches("[0-9]*.[0-9]{2}")&& !costokm.matches("[0-9]*")){
			
			retorno = retorno + " Costo Kilometro \n";
		}	
		if(!costohora.matches("[0-9]*.[0-9]{2}") && !costohora.matches("[0-9]*")){
			
			retorno = retorno + " Costo Hora \n";
		}
		return retorno;
	}
}
