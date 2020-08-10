package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuRuta extends JPanel {
	
	public CardLayout c = new CardLayout();
	public MenuRuta() {
		
		setBackground(new Color(187, 238, 110));
		setLayout(null);

		JButton btn_altaRuta = new JButton("DAR DE ALTA UNA RUTA");
		btn_altaRuta.setBounds(10, 11, 226, 40);
		btn_altaRuta.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_altaRuta.setBorderPainted(false);
		btn_altaRuta.setFocusPainted(false);
		btn_altaRuta.setContentAreaFilled(true);
		btn_altaRuta.setForeground(new Color(0, 0, 0));
		btn_altaRuta.setBackground(new Color(80, 165, 94));
		add(btn_altaRuta);
		
		JButton btn_bajaRuta = new JButton("DAR DE BAJA UNA RUTA");
		btn_bajaRuta.setForeground(Color.BLACK);
		btn_bajaRuta.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_bajaRuta.setFocusPainted(false);
		btn_bajaRuta.setContentAreaFilled(true);
		btn_bajaRuta.setBorderPainted(false);
		btn_bajaRuta.setBackground(new Color(80, 165, 94));
		btn_bajaRuta.setBounds(250, 11, 226, 40);
		add(btn_bajaRuta);
		
		JButton btn_editarRuta = new JButton("MODIFICAR RUTA");
		btn_editarRuta.setForeground(Color.BLACK);
		btn_editarRuta.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_editarRuta.setFocusPainted(false);
		btn_editarRuta.setContentAreaFilled(true);
		btn_editarRuta.setBorderPainted(false);
		btn_editarRuta.setBackground(new Color(80, 165, 94));
		btn_editarRuta.setBounds(486, 11, 225, 40);
		add(btn_editarRuta);
		
		JButton btn_buscarRuta = new JButton("BUSCAR RUTA");
		btn_buscarRuta.setForeground(Color.BLACK);
		btn_buscarRuta.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarRuta.setFocusPainted(false);
		btn_buscarRuta.setContentAreaFilled(true);
		btn_buscarRuta.setBorderPainted(false);
		btn_buscarRuta.setBackground(new Color(80, 165, 94));
		btn_buscarRuta.setBounds(721, 11, 228, 40);
		add(btn_buscarRuta);
		
		JPanel contenedor_ruta = new JPanel();
		contenedor_ruta.setBounds(10, 61, 960, 434);
		
		add(contenedor_ruta);
		contenedor_ruta.setLayout(new CardLayout(0, 0));
		contenedor_ruta.setBackground(new Color(187, 238, 110));
		
		JPanel inicio_ruta = new JPanel();
		contenedor_ruta.add(inicio_ruta, "inicio_ruta");
		inicio_ruta.setBackground(new Color(187, 238, 110));
		inicio_ruta.setLayout(null);
		
		DarAltaRuta panel_altaRuta = new DarAltaRuta();
		contenedor_ruta.add(panel_altaRuta, "altaRuta");
		
		//faltan de los otros botones-  B- M y buscar
		
		btn_altaRuta.addActionListener(e -> {
			c = (CardLayout)(contenedor_ruta.getLayout());
			c.show(contenedor_ruta, "altaRuta");
			
		});
		
		btn_bajaRuta.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "EN MANTENIMIENTO", "DAR DE BAJA UNA RUTA", JOptionPane.INFORMATION_MESSAGE);		
		});
		
		btn_editarRuta.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "EN MANTENIMIENTO", "EDITAR UNA RUTA", JOptionPane.INFORMATION_MESSAGE);	
		});
		
		btn_buscarRuta.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "EN MANTENIMIENTO", "BUSCAR UNA RUTA", JOptionPane.INFORMATION_MESSAGE);	
		});
		
		
		
	}

}
