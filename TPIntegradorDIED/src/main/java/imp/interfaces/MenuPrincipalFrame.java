package imp.interfaces;

import java.awt.*;

import javax.swing.*;

public class MenuPrincipalFrame extends JFrame {

	public MenuPrincipalFrame() {
		
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	setBounds(100, 100, 600, 300);
	setResizable(false);
	
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenuItem menu_planta = new JMenuItem("PLANTA");
	menuBar.add(menu_planta);
	
	JMenuItem menu_camion = new JMenuItem("CAMION");
	menuBar.add(menu_camion);
	
	JPanel panel = new JPanel();
	getContentPane().add(panel, BorderLayout.CENTER);
	panel.setLayout(new CardLayout(0, 0));
	
	JPanel panel_planta = new JPanel();
	panel_planta.setBackground(Color.PINK);
	panel.add(panel_planta, "planta");
	
	JPanel panel_camion = new JPanel();
	panel_camion.setBackground(Color.ORANGE);
	panel.add(panel_camion, "camion");
	
	
	
	
	menu_planta.addActionListener(e -> {
		CardLayout c = (CardLayout)(panel.getLayout());
		c.show(panel, "planta");
		
	});
	
	menu_camion.addActionListener(e -> {
		CardLayout c = (CardLayout)(panel.getLayout());
		c.show(panel, "camion");
		
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

