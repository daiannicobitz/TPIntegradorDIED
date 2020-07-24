package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenuInsumo extends JPanel {
	public CardLayout c = new CardLayout();
	public MenuInsumo() {
	setBackground(new Color(187, 238, 110));


	JButton btn_altaInsumo = new JButton("DAR DE ALTA UN INSUMO");
	btn_altaInsumo.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_altaInsumo.setBorderPainted(false);
	btn_altaInsumo.setFocusPainted(false);
	btn_altaInsumo.setContentAreaFilled(true);
	btn_altaInsumo.setForeground(new Color(0, 0, 0));
	btn_altaInsumo.setBackground(new Color(80, 165, 94));
	
	JButton btn_bajaInsumo = new JButton("DAR DE BAJA UN INSUMO");
	btn_bajaInsumo.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_bajaInsumo.setBorderPainted(false);
	btn_bajaInsumo.setFocusPainted(false);
	btn_bajaInsumo.setContentAreaFilled(true);
	btn_bajaInsumo.setForeground(new Color(0, 0, 0));
	btn_bajaInsumo.setBackground(new Color(80, 165, 94));
	
	JButton btn_modificarInsumo = new JButton("EDITAR DATOS DE UN INSUMO ");
	btn_modificarInsumo.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_modificarInsumo.setBorderPainted(false);
	btn_modificarInsumo.setFocusPainted(false);
	btn_modificarInsumo.setContentAreaFilled(true);
	btn_modificarInsumo.setForeground(new Color(0, 0, 0));
	btn_modificarInsumo.setBackground(new Color(80, 165, 94));
	
	JButton btn_buscarInsumos = new JButton("BUSCAR TODOS LOS INSUMOS");
	btn_buscarInsumos.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_buscarInsumos.setBorderPainted(false);
	btn_buscarInsumos.setFocusPainted(false);
	btn_buscarInsumos.setContentAreaFilled(true);
	btn_buscarInsumos.setForeground(new Color(0, 0, 0));
	btn_buscarInsumos.setBackground(new Color(80, 165, 94));
	
	JPanel contenedor_insumo = new JPanel();
	GroupLayout gl_panel_insumo = new GroupLayout(this);
	
	gl_panel_insumo.setHorizontalGroup(
			gl_panel_insumo.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_insumo.createSequentialGroup()
				.addGroup(gl_panel_insumo.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_insumo.createSequentialGroup()
						.addGap(7)
						.addComponent(btn_altaInsumo, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btn_bajaInsumo, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addComponent(btn_modificarInsumo, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addComponent(btn_buscarInsumos, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_insumo.createSequentialGroup()
						.addContainerGap()
						.addComponent(contenedor_insumo, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)))
				.addContainerGap())
	);
	gl_panel_insumo.setVerticalGroup(
			gl_panel_insumo.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_insumo.createSequentialGroup()
				.addGap(7)
				.addGroup(gl_panel_insumo.createParallelGroup(Alignment.TRAILING, false)
					.addComponent(btn_buscarInsumos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btn_modificarInsumo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btn_bajaInsumo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btn_altaInsumo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(contenedor_insumo, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
				.addContainerGap())
	);
	contenedor_insumo.setLayout(new CardLayout(0, 0));
	
	JPanel inicio_camion = new JPanel();
	contenedor_insumo.add(inicio_camion);
	inicio_camion.setBackground(new Color(187, 238, 110));
	
	
	
	DarAltaInsumo panel_altaInsumo = new DarAltaInsumo();
	contenedor_insumo.add(panel_altaInsumo, "altaInsumo");
	
	DarBajaInsumo panel_bajaInsumo = new DarBajaInsumo();
	contenedor_insumo.add(panel_bajaInsumo, "bajaInsumo");
	
	ModificarInsumo panel_modificarInsumo = new ModificarInsumo();
	contenedor_insumo.add(panel_modificarInsumo, "modificarInsumo");
	
	BuscarInsumos panel_buscarInsumos = new BuscarInsumos();
	contenedor_insumo.add(panel_buscarInsumos, "buscarInsumos");
	
	setLayout(gl_panel_insumo);
	
	
	btn_altaInsumo.addActionListener(e -> {
		c = (CardLayout)(contenedor_insumo.getLayout());
		c.show(contenedor_insumo, "altaInsumo");
		
	});
	
	btn_bajaInsumo.addActionListener(e -> {
	 c = (CardLayout)(contenedor_insumo.getLayout());
		c.show(contenedor_insumo, "bajaInsumo");
		
	});
	
	btn_modificarInsumo.addActionListener(e -> {
		
		 c = (CardLayout)(contenedor_insumo.getLayout());
		c.show(contenedor_insumo, "modificarInsumo");
		
	});
	btn_buscarInsumos.addActionListener(e -> {
		 c = (CardLayout)(contenedor_insumo.getLayout());
		c.show(contenedor_insumo, "buscarInsumos");
		
	});
	
	}
	
}
