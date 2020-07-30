package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class PlantasStockMenorAPuntoPedido extends JPanel {

	public PlantasStockMenorAPuntoPedido() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		JButton btn_buscarPlantas = new JButton("BUSCAR PLANTAS");
		btn_buscarPlantas.setForeground(Color.BLACK);
		btn_buscarPlantas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarPlantas.setFocusPainted(false);
		btn_buscarPlantas.setContentAreaFilled(true);
		btn_buscarPlantas.setBorderPainted(false);
		btn_buscarPlantas.setBackground(new Color(80, 165, 94));
		btn_buscarPlantas.setBounds(707, 64, 156, 41);
		add(btn_buscarPlantas);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 146, 772, 168);
		add(scrollPane);
		
		JTable tabla_Plantas = new JTable();
		tabla_Plantas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_Plantas = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Nombre Planta", "Nombre Insumo", "Stock en planta", "Punto pedido en planta", "Stock total"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_Plantas.setModel(model_tabla_Plantas);
		tabla_Plantas.getTableHeader().setReorderingAllowed(false);
		tabla_Plantas.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_Plantas);
		
		JLabel lbl_planta = new JLabel("PLANTA");
		lbl_planta.setBounds(91, 78, 46, 14);
		add(lbl_planta);
		
		JComboBox combo_planta = new JComboBox();
		combo_planta.setBounds(157, 74, 147, 22);
		add(combo_planta);
		
		JLabel lbl_insumo = new JLabel("INSUMO");
		lbl_insumo.setBounds(412, 78, 46, 14);
		add(lbl_insumo);
		
		JComboBox combo_insumo = new JComboBox();
		combo_insumo.setBounds(496, 74, 147, 22);
		add(combo_insumo);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setForeground(Color.BLACK);
		btn_aceptar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setBackground(new Color(80, 165, 94));
		btn_aceptar.setBounds(536, 376, 156, 41);
		add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setForeground(Color.BLACK);
		btn_cancelar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setBackground(new Color(80, 165, 94));
		btn_cancelar.setBounds(707, 376, 156, 41);
		add(btn_cancelar);
		
		
		
		
	}
}
