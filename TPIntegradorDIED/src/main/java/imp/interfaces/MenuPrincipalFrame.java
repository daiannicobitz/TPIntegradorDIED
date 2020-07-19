package imp.interfaces;

import java.awt.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MenuPrincipalFrame extends JFrame {

	
	public CardLayout c = new CardLayout();
	
	public MenuPrincipalFrame() {
		
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setBounds(200, 200, 1000, 600);
	setResizable(false);
	
	
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBackground(UIManager.getColor("CheckBox.focus"));
	setJMenuBar(menuBar);
	
	JMenuItem menu_planta = new JMenuItem("PLANTA");
	menu_planta.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menu_planta.setBackground(SystemColor.info);
	menuBar.add(menu_planta);
	
	JMenuItem menu_camion = new JMenuItem("CAMION");
	menu_camion.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menu_camion.setForeground(Color.BLACK);
	menu_camion.setBackground(SystemColor.info);
	menuBar.add(menu_camion);
	
	JMenuItem menu_insumos = new JMenuItem("INSUMOS");
	menu_insumos.setBackground(SystemColor.info);
	menu_insumos.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menuBar.add(menu_insumos);
	
	JMenuItem menu_ordenP = new JMenuItem("ORDEN PEDIDO ");
	menu_ordenP.setBackground(SystemColor.info);
	menu_ordenP.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menuBar.add(menu_ordenP);
	
	JPanel panelPrincipal = new JPanel();
	getContentPane().add(panelPrincipal, BorderLayout.CENTER);
	panelPrincipal.setLayout(new CardLayout(0, 0));
	
	JPanel panel_planta = new JPanel();
	panel_planta.setBackground(new Color(255, 204, 153));
	panelPrincipal.add(panel_planta, "planta");
	
	JPanel panel_camion = new JPanel();
	panel_camion.setBackground(new Color(255, 204, 153));
	panelPrincipal.add(panel_camion, "camion");
	
	JButton btn_altaCamion = new JButton("DAR DE ALTA UN CAMION");
	
	JButton btn_bajaCamion = new JButton("DAR DE BAJA UN CAMION");
	
	JButton btn_modificarCamion = new JButton("EDITAR INFOMRACION DE UN CAMION ");
	
	JButton btn_buscarCamion = new JButton("BUSCAR UN CAMION");
	
	JPanel contenedor_camion = new JPanel();
	GroupLayout gl_panel_camion = new GroupLayout(panel_camion);
	gl_panel_camion.setHorizontalGroup(
		gl_panel_camion.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_camion.createSequentialGroup()
				.addGroup(gl_panel_camion.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_camion.createSequentialGroup()
						.addGap(7)
						.addComponent(btn_altaCamion, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btn_bajaCamion, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addComponent(btn_modificarCamion, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addGap(4)
						.addComponent(btn_buscarCamion, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_camion.createSequentialGroup()
						.addContainerGap()
						.addComponent(contenedor_camion, GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)))
				.addContainerGap())
	);
	gl_panel_camion.setVerticalGroup(
		gl_panel_camion.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_panel_camion.createSequentialGroup()
				.addGap(7)
				.addGroup(gl_panel_camion.createParallelGroup(Alignment.TRAILING, false)
					.addComponent(btn_buscarCamion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btn_modificarCamion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btn_bajaCamion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btn_altaCamion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(contenedor_camion, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
				.addContainerGap())
	);
	contenedor_camion.setLayout(new CardLayout(0, 0));
	
	JPanel inicio_camion = new JPanel();
	contenedor_camion.add(inicio_camion);
	inicio_camion.setBackground(new Color(255, 204, 153));
	
	
	
	DarAltaCamion panel_altaCamion = new DarAltaCamion();
	contenedor_camion.add(panel_altaCamion, "altaCamion");
	
	DarBajaCamion panel_bajaCamion = new DarBajaCamion();
	contenedor_camion.add(panel_bajaCamion, "bajaCamion");
	
	ModificarCamion panel_modificarCamion = new ModificarCamion();
	contenedor_camion.add(panel_modificarCamion, "modificarCamion");
	
	JPanel panel_buscarCamion = new JPanel();
	contenedor_camion.add(panel_buscarCamion, "buscarCamion");
	panel_camion.setLayout(gl_panel_camion);
	
	JPanel panel_insumos = new JPanel();
	panel_insumos.setBackground(new Color(255, 204, 153));
	panelPrincipal.add(panel_insumos, "insumos");
	
	JPanel panel_ordenP = new JPanel();
	panel_ordenP.setBackground(new Color(255, 204, 153));
	panelPrincipal.add(panel_ordenP, "ordenP");
	
	//---------- ACCIONES
	menu_planta.addActionListener(e -> {
		c = (CardLayout)(panelPrincipal.getLayout());
		c.show(panelPrincipal, "planta");
		
	});
	
	menu_camion.addActionListener(e -> {
		c = (CardLayout)(panelPrincipal.getLayout());
		c.show(panelPrincipal, "camion");
		
	});
	
	menu_insumos.addActionListener(e -> {
		c = (CardLayout)(panelPrincipal.getLayout());
		c.show(panelPrincipal, "insumos");
		
	});
	menu_ordenP.addActionListener(e -> {
		c = (CardLayout)(panelPrincipal.getLayout());
		c.show(panelPrincipal, "ordenP");
		
	});
	
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
	
	
	
	
	addWindowListener(new java.awt.event.WindowAdapter() {
		@Override
		public void windowClosing(java.awt.event.WindowEvent evt) {
			close();
		}
	});
	
	}
	
	protected static void close() {
		// TODO Auto-generated method stub
		if (JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?", "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			
		System.exit(0);
		}
	}
}

