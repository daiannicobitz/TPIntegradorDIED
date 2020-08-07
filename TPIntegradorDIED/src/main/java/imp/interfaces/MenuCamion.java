package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class MenuCamion extends JPanel {
	public CardLayout c = new CardLayout();
	
	public MenuCamion() {
	setBackground(new Color(187, 238, 110));

	JButton btn_altaCamion = new JButton("DAR DE ALTA UN CAMION");
	btn_altaCamion.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_altaCamion.setBorderPainted(false);
	btn_altaCamion.setFocusPainted(false);
	btn_altaCamion.setContentAreaFilled(true);
	btn_altaCamion.setForeground(new Color(0, 0, 0));
	btn_altaCamion.setBackground(new Color(80, 165, 94));
	
	JButton btn_bajaCamion = new JButton("DAR DE BAJA UN CAMION");
	btn_bajaCamion.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_bajaCamion.setBorderPainted(false);
	btn_bajaCamion.setFocusPainted(false);
	btn_bajaCamion.setContentAreaFilled(true);
	btn_bajaCamion.setForeground(new Color(0, 0, 0));
	btn_bajaCamion.setBackground(new Color(80, 165, 94));
	
	JButton btn_modificarCamion = new JButton("EDITAR DATOS DE UN CAMION ");
	btn_modificarCamion.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_modificarCamion.setBorderPainted(false);
	btn_modificarCamion.setFocusPainted(false);
	btn_modificarCamion.setContentAreaFilled(true);
	btn_modificarCamion.setForeground(new Color(0, 0, 0));
	btn_modificarCamion.setBackground(new Color(80, 165, 94));

	
	JPanel contenedor_camion = new JPanel();
	GroupLayout gl_panel_camion = new GroupLayout(this);
	gl_panel_camion.setHorizontalGroup(
		gl_panel_camion.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_camion.createSequentialGroup()
				.addGroup(gl_panel_camion.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_camion.createSequentialGroup()
						.addGap(75)
						.addComponent(btn_altaCamion, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addGap(64)
						.addComponent(btn_bajaCamion, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addGap(59)
						.addComponent(btn_modificarCamion, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addGap(4))
					.addGroup(gl_panel_camion.createSequentialGroup()
						.addContainerGap()
						.addComponent(contenedor_camion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addContainerGap())
	);
	gl_panel_camion.setVerticalGroup(
		gl_panel_camion.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_camion.createSequentialGroup()
				.addGap(7)
				.addGroup(gl_panel_camion.createParallelGroup(Alignment.LEADING, false)
					.addComponent(btn_modificarCamion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_camion.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_altaCamion, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(btn_bajaCamion, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(contenedor_camion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap())
	);
	
	contenedor_camion.setLayout(new CardLayout(0, 0));
	
	JPanel inicio_camion = new JPanel();
	contenedor_camion.add(inicio_camion, "inicioCamion");
	inicio_camion.setBackground(new Color(187, 238, 110));
	
	DarAltaCamion panel_altaCamion = new DarAltaCamion();
	contenedor_camion.add(panel_altaCamion, "altaCamion");
	
	DarBajaCamion panel_bajaCamion = new DarBajaCamion();
	contenedor_camion.add(panel_bajaCamion, "bajaCamion");
	
	ModificarCamion panel_modificarCamion = new ModificarCamion();
	contenedor_camion.add(panel_modificarCamion, "modificarCamion");
	
	//BuscarCamion panel_buscarCamion = new BuscarCamion();
	//contenedor_camion.add(panel_buscarCamion, "buscarCamion");
	
	setLayout(gl_panel_camion);
	
	
	btn_altaCamion.addActionListener(e -> {
		c = (CardLayout)(contenedor_camion.getLayout());
		c.show(contenedor_camion, "altaCamion");
		
	});
	
	btn_bajaCamion.addActionListener(e -> {
	 c = (CardLayout)(contenedor_camion.getLayout());
		c.show(contenedor_camion, "bajaCamion");
		
	});
	
	btn_modificarCamion.addActionListener(e -> {
		 c = (CardLayout)(contenedor_camion.getLayout());
		c.show(contenedor_camion, "modificarCamion");
		
	});
	/* --- MOVER DONDE SEA NECESARIO 
	btn_buscarCamion.addActionListener(e -> {
		
		PopUpBuscarCamion buscar_camion = new PopUpBuscarCamion();
	});
	*/
	}
	
	
	
	

}
