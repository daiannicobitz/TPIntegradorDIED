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
	menuBar.setBackground(new Color(255, 204, 153));
	setJMenuBar(menuBar);
	JMenuItem menu_planta = new JMenuItem("PLANTA");
	//JMenuItem menu_planta = new JMenuItem("PLANTA");
	menu_planta.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menu_planta.setForeground(Color.BLACK);
	menu_planta.setBackground(new Color(90, 158, 101));
	menuBar.add(menu_planta);
	
	JMenuItem menu_camion = new JMenuItem("CAMION");
	menu_camion.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menu_camion.setForeground(Color.BLACK);
	menu_camion.setBackground(new Color(90, 158, 101));
	menuBar.add(menu_camion);
	
	JMenuItem menu_insumos = new JMenuItem("INSUMOS");
	menu_insumos.setBackground(new Color(90, 158, 101));
	menu_insumos.setForeground(Color.BLACK);
	menu_insumos.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menuBar.add(menu_insumos);
	
	JMenuItem menu_ordenP = new JMenuItem("ORDEN PEDIDO");
	menu_ordenP.setBackground(new Color(90, 158, 101));
	menu_ordenP.setForeground(Color.BLACK);
	menu_ordenP.setFont(new Font("Segoe UI", Font.BOLD, 12));
	menuBar.add(menu_ordenP);
	
	JPanel panelPrincipal = new JPanel();
	getContentPane().add(panelPrincipal, BorderLayout.CENTER);
	panelPrincipal.setLayout(new CardLayout(0, 0));
	
	JPanel panel_planta = new JPanel();
	panel_planta.setBackground(new Color(187, 238, 110));
	panelPrincipal.add(panel_planta, "planta");
	
	MenuCamion panel_camion = new MenuCamion();
	panelPrincipal.add(panel_camion, "camion");
		
	MenuInsumo panel_insumos = new MenuInsumo();
	panelPrincipal.add(panel_insumos, "insumos");
	
	MenuOrdenPedido panel_ordenP = new MenuOrdenPedido();
	panel_ordenP.setBackground(new Color(187, 238, 110));
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

