package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuPlanta extends JPanel {
	
	public CardLayout c = new CardLayout();
	public MenuPlanta() {
		
		setBackground(new Color(187, 238, 110));
		setLayout(null);
		
		JButton btn_buscarPlanta = new JButton("BUSCAR PLANTAS");
		btn_buscarPlanta.setBounds(215, 11, 152, 37);
		btn_buscarPlanta.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_buscarPlanta.setBorderPainted(false);
		btn_buscarPlanta.setFocusPainted(false);
		btn_buscarPlanta.setContentAreaFilled(true);
		btn_buscarPlanta.setForeground(new Color(0, 0, 0));
		btn_buscarPlanta.setBackground(new Color(80, 165, 94));

		JButton btn_flujoMaxEntrePlantas = new JButton("FLUJO MAXIMO ");
		btn_flujoMaxEntrePlantas.setBounds(377, 11, 167, 37);
		btn_flujoMaxEntrePlantas.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_flujoMaxEntrePlantas.setBorderPainted(false);
		btn_flujoMaxEntrePlantas.setFocusPainted(false);
		btn_flujoMaxEntrePlantas.setContentAreaFilled(true);
		btn_flujoMaxEntrePlantas.setForeground(new Color(0, 0, 0));
		btn_flujoMaxEntrePlantas.setBackground(new Color(80, 165, 94));

		
		add (btn_buscarPlanta);
		add (btn_flujoMaxEntrePlantas);
		
		JButton btn_verCaminoEntrePlantas = new JButton("CAMINO MINIMO");
		btn_verCaminoEntrePlantas.setForeground(Color.BLACK);
		btn_verCaminoEntrePlantas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verCaminoEntrePlantas.setFocusPainted(false);
		btn_verCaminoEntrePlantas.setContentAreaFilled(true);
		btn_verCaminoEntrePlantas.setBorderPainted(false);
		btn_verCaminoEntrePlantas.setBackground(new Color(80, 165, 94));
		btn_verCaminoEntrePlantas.setBounds(554, 11, 210, 37);
		add(btn_verCaminoEntrePlantas);
		
		JButton btn_verRutasPosibles = new JButton("VER RUTAS POSIBLES");
		btn_verRutasPosibles.setForeground(Color.BLACK);
		btn_verRutasPosibles.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verRutasPosibles.setFocusPainted(false);
		btn_verRutasPosibles.setContentAreaFilled(true);
		btn_verRutasPosibles.setBorderPainted(false);
		btn_verRutasPosibles.setBackground(new Color(80, 165, 94));
		btn_verRutasPosibles.setBounds(774, 11, 197, 37);
		add(btn_verRutasPosibles);
		
		JPanel contenedor_planta = new JPanel();
		contenedor_planta.setBounds(10, 59, 968, 438);
		add(contenedor_planta);
		contenedor_planta.setLayout(new CardLayout(0, 0));
		
		
		JPanel inicio_planta = new JPanel();
		contenedor_planta.add(inicio_planta,"inicioPlanta");
		inicio_planta.setBackground(new Color(187, 238, 110));
		
		BuscarPlantas panel_buscarPlantas = new BuscarPlantas();
		contenedor_planta.add(panel_buscarPlantas, "buscarPlantas");
		
		FlujoMaximoEntreDosPlantas panel_flujoMaxEntrePlantas = new FlujoMaximoEntreDosPlantas();
		contenedor_planta.add(panel_flujoMaxEntrePlantas, "flujoMaxEntrePlantas");
		
		RutasPosiblesEntrePlantas panel_verRutasPosibles = new RutasPosiblesEntrePlantas();
		contenedor_planta.add(panel_verRutasPosibles, "verRutasPosibles");
		
		CaminoMinimoEntrePlantas panel_verCaminoEntrePlantas = new CaminoMinimoEntrePlantas();
		contenedor_planta.add(panel_verCaminoEntrePlantas, "verCaminoEntrePlantas");
		
		DarAltaPlanta panel_agregarPlanta = new DarAltaPlanta();
		contenedor_planta.add(panel_agregarPlanta, "agregarPlanta");
		
		JButton btn_agragarPlanta = new JButton("DAR DE ALTA UNA PLANTA");
		btn_agragarPlanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_agragarPlanta.setForeground(Color.BLACK);
		btn_agragarPlanta.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_agragarPlanta.setFocusPainted(false);
		btn_agragarPlanta.setContentAreaFilled(true);
		btn_agragarPlanta.setBorderPainted(false);
		btn_agragarPlanta.setBackground(new Color(80, 165, 94));
		btn_agragarPlanta.setBounds(10, 11, 195, 37);
		add(btn_agragarPlanta);
		
		btn_buscarPlanta.addActionListener(e -> {
			c = (CardLayout)(contenedor_planta.getLayout());
			c.show(contenedor_planta, "buscarPlantas");
			
		});
		
		btn_verRutasPosibles.addActionListener(e -> {
		 c = (CardLayout)(contenedor_planta.getLayout());
			c.show(contenedor_planta, "verRutasPosibles");
			
		});
		
		btn_verCaminoEntrePlantas.addActionListener(e -> {
			
			 c = (CardLayout)(contenedor_planta.getLayout());
			 c.show(contenedor_planta, "verCaminoEntrePlantas");
			
		});
		btn_flujoMaxEntrePlantas.addActionListener(e -> {
			 c = (CardLayout)(contenedor_planta.getLayout());
			 c.show(contenedor_planta, "flujoMaxEntrePlantas");
			
		});
		
		
		btn_agragarPlanta.addActionListener(e -> {
		 c = (CardLayout)(contenedor_planta.getLayout());
		 c.show(contenedor_planta, "agregarPlanta");
		
		});
	
		
		
	}
}
