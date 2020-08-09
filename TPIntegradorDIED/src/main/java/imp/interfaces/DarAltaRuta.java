package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class DarAltaRuta extends JPanel {
	
	public CardLayout c = new CardLayout();
	
	public DarAltaRuta() {
		
		
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		JLabel lbl_plantaDestino = new JLabel("PLANTA DESTINO");
		lbl_plantaDestino.setBounds(99, 95, 130, 14);
		add(lbl_plantaDestino);
		
		JLabel lbl_plantaFinal = new JLabel("PLANTA FINAL");
		lbl_plantaFinal.setBounds(529, 95, 130, 14);
		add(lbl_plantaFinal);
		
		JComboBox combo_plantaDestino = new JComboBox();
		combo_plantaDestino.setBounds(279, 91, 187, 22);
		add(combo_plantaDestino);
		
		JComboBox combo_plantaFinal = new JComboBox();
		combo_plantaFinal.setBounds(693, 91, 187, 22);
		add(combo_plantaFinal);
		
		JLabel lbl_distancia = new JLabel("DISTNACIA (Kms)");
		lbl_distancia.setBounds(99, 146, 130, 14);
		add(lbl_distancia);
		
		JLabel lbl_duracion = new JLabel("DURACION (Hs)");
		lbl_duracion.setBounds(529, 146, 130, 14);
		add(lbl_duracion);
		
		JSpinner spinner_duracion = new JSpinner();
		spinner_duracion.setBounds(693, 143, 187, 20);
		add(spinner_duracion);
		
		JSpinner spinner_duracion_1 = new JSpinner();
		spinner_duracion_1.setBounds(279, 143, 187, 20);
		add(spinner_duracion_1);
		
		JLabel lbl_pesoMax = new JLabel("PESO MÁXIMO (Kgs)");
		lbl_pesoMax.setBounds(99, 199, 130, 14);
		add(lbl_pesoMax);
		
		JTextField  txt_PesoMax = new JTextField();
		txt_PesoMax.setBounds(279, 196, 187, 20);
		txt_PesoMax.setColumns(10);
		add(txt_PesoMax);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(504, 319, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		add(btn_aceptar);
		
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
