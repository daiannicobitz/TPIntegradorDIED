package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuOrdenPedido extends JPanel {
	public CardLayout c = new CardLayout();
	
	public MenuOrdenPedido(){
		
		setBackground(new Color(187, 238, 110));
		setLayout(null);

		JButton btn_altaOrden = new JButton("DAR DE ALTA UNA ORDEN");
		btn_altaOrden.setBounds(85, 11, 226, 40);
		btn_altaOrden.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_altaOrden.setBorderPainted(false);
		btn_altaOrden.setFocusPainted(false);
		btn_altaOrden.setContentAreaFilled(true);
		btn_altaOrden.setForeground(new Color(0, 0, 0));
		btn_altaOrden.setBackground(new Color(80, 165, 94));
		add(btn_altaOrden);
		
		JButton btn_buscarOCreadas = new JButton("BUSCAR ORDENES CREADAS");
		btn_buscarOCreadas.setBounds(651, 11, 226, 40);
		btn_buscarOCreadas.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_buscarOCreadas.setBorderPainted(false);
		btn_buscarOCreadas.setFocusPainted(false);
		btn_buscarOCreadas.setContentAreaFilled(true);
		btn_buscarOCreadas.setForeground(new Color(0, 0, 0));
		btn_buscarOCreadas.setBackground(new Color(80, 165, 94));
		add(btn_buscarOCreadas);
		
		JButton btn_buscarOProcesadas = new JButton("BUSCAR ORDENES PROCESADAS");
		btn_buscarOProcesadas.setBounds(369, 11, 226, 40);
		btn_buscarOProcesadas.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_buscarOProcesadas.setBorderPainted(false);
		btn_buscarOProcesadas.setFocusPainted(false);
		btn_buscarOProcesadas.setContentAreaFilled(true);
		btn_buscarOProcesadas.setForeground(new Color(0, 0, 0));
		btn_buscarOProcesadas.setBackground(new Color(80, 165, 94));
		add(btn_buscarOProcesadas);
		
		JPanel contenedor_ordenes = new JPanel();
		contenedor_ordenes.setBounds(10, 61, 960, 434);
		
		add(contenedor_ordenes);
		contenedor_ordenes.setLayout(new CardLayout(0, 0));
		contenedor_ordenes.setBackground(new Color(187, 238, 110));
		
		JPanel inicio_ordenes = new JPanel();
		contenedor_ordenes.add(inicio_ordenes, "inicio_ordenes");
		inicio_ordenes.setBackground(new Color(187, 238, 110));
		inicio_ordenes.setLayout(null);
		
		DarAltaOrdenPedido panel_altaOrden = new DarAltaOrdenPedido();
		contenedor_ordenes.add(panel_altaOrden, "altaOrden");
		
		BuscarOrdenesCreadas panel_buscarOrdenesCreadas = new BuscarOrdenesCreadas();
		contenedor_ordenes.add(panel_buscarOrdenesCreadas, "buscarOrdenesCreadas");
		
		BuscarOrdenesProcesadas panel_buscarOrdenesProcesadas = new BuscarOrdenesProcesadas();
		contenedor_ordenes.add(panel_buscarOrdenesProcesadas, "buscarOrdenesProcesadas");
		
		
		btn_altaOrden.addActionListener(e -> {
			c = (CardLayout)(contenedor_ordenes.getLayout());
			c.show(contenedor_ordenes, "altaOrden");
			
		});
		
		btn_buscarOCreadas.addActionListener(e -> {
		 c = (CardLayout)(contenedor_ordenes.getLayout());
			c.show(contenedor_ordenes, "buscarOrdenesCreadas");
			
		});
		
		btn_buscarOProcesadas.addActionListener(e -> {
			
			 c = (CardLayout)(contenedor_ordenes.getLayout());
			c.show(contenedor_ordenes, "buscarOrdenesProcesadas");
			
		});
		
		
		
		
	}
}
