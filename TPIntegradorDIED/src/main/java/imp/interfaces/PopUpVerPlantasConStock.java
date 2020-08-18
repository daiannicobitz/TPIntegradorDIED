package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class PopUpVerPlantasConStock extends JFrame {

	public PopUpVerPlantasConStock() {

	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setVisible(true);
	setBounds(200, 200, 800, 540);
	setResizable(false);
	
	JPanel panel_verPlantasConStock = new JPanel();
	panel_verPlantasConStock.setBackground(new Color(118, 203, 117));
	getContentPane().add(panel_verPlantasConStock);
	panel_verPlantasConStock.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(51, 94, 685, 230);
	panel_verPlantasConStock.add(scrollPane);
	
	JTable tabla_DetalleOrden = new JTable();
	tabla_DetalleOrden.setBounds(42, 313, 626, -132);
	
	DefaultTableModel model_tabla_VerPlantaConStock = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"Nombre planta", "Insumo", "Stock"
			}
			){

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int i, int i1) {
			return false;
		}
	};
	
	
	
	tabla_DetalleOrden.setModel(model_tabla_VerPlantaConStock);
	tabla_DetalleOrden.getTableHeader().setReorderingAllowed(false);
	tabla_DetalleOrden.getTableHeader().setResizingAllowed(false);
	scrollPane.setViewportView(tabla_DetalleOrden);
	

	JButton btn_aceptar = new JButton("ACEPTAR");
	btn_aceptar.setBounds(278, 409, 189, 40);
	btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
	btn_aceptar.setBorderPainted(false);
	btn_aceptar.setFocusPainted(false);
	btn_aceptar.setContentAreaFilled(true);
	btn_aceptar.setForeground(new Color(0, 0, 0));
	btn_aceptar.setBackground(new Color(80, 165, 94));
	panel_verPlantasConStock.add(btn_aceptar);
	
	JLabel lbl_PlantasConStock = new JLabel("PLANTAS CON STOCK");
	lbl_PlantasConStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lbl_PlantasConStock.setBounds(304, 26, 307, 29);
	panel_verPlantasConStock.add(lbl_PlantasConStock);
	}
}
