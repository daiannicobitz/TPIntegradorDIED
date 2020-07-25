package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import imp.enumerators.UM;

public class BuscarInsumos extends JPanel {

	public BuscarInsumos() {
		setBackground(new Color(118, 203, 117));
		
		
		setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 102, 849, 233);
		add(scrollPane);
		
		JTable tabla_camion = new JTable();
		tabla_camion.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_camion = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Id", "Descripcion", "Unidad Medida", "Costo Unitario", "Cantidad", "Peso", "Densidad", "Stock Total"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_camion.setModel(model_tabla_camion);
		tabla_camion.getTableHeader().setReorderingAllowed(false);
		tabla_camion.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_camion);
		
		
		
		JButton btn_buscar = new JButton("BUSCAR INSUMOS");
		btn_buscar.setForeground(Color.BLACK);
		btn_buscar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscar.setFocusPainted(false);
		btn_buscar.setContentAreaFilled(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setBackground(new Color(80, 165, 94));
		btn_buscar.setBounds(574, 29, 227, 34);
		
		btn_buscar.addActionListener(e -> {
			//TO-DO  implementar  la busqueda 
		});
		
		add(btn_buscar);
		
		JLabel lbl_planta = new JLabel("PLANTA");
		lbl_planta.setBounds(66, 40, 46, 14);
		add(lbl_planta);
		
		JComboBox combo_plantas = new JComboBox();
		combo_plantas.setBounds(134, 36, 168, 22);
		add(combo_plantas);
	}
}
