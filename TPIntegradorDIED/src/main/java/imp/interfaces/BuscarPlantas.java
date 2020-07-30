package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BuscarPlantas extends JPanel {
	
	public BuscarPlantas () {
		setBackground(new Color(118, 203, 117));
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 93, 772, 168);
		add(scrollPane);
		
		JTable tabla_Plantas = new JTable();
		tabla_Plantas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_Plantas = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Nombre Planta", "Tipo Planta"
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
		
		JButton btn_actualizarStock = new JButton("ACTUALIZAR STOCK DE PRODUCTOS EN LA PLANTA");
		btn_actualizarStock.setForeground(Color.BLACK);
		btn_actualizarStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_actualizarStock.setFocusPainted(false);
		btn_actualizarStock.setContentAreaFilled(true);
		btn_actualizarStock.setBorderPainted(false);
		btn_actualizarStock.setBackground(new Color(80, 165, 94));
		btn_actualizarStock.setBounds(91, 287, 338, 41);
		add(btn_actualizarStock);
		
		JButton btn_verPlantasStock = new JButton("VER PLANTAS CON STOCK MENOR A PUNTO PEDIDO");
		btn_verPlantasStock.setForeground(Color.BLACK);
		btn_verPlantasStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPlantasStock.setFocusPainted(false);
		btn_verPlantasStock.setContentAreaFilled(true);
		btn_verPlantasStock.setBorderPainted(false);
		btn_verPlantasStock.setBackground(new Color(80, 165, 94));
		btn_verPlantasStock.setBounds(91, 339, 338, 41);
		add(btn_verPlantasStock);
		
		JButton btn_verPlantasPageRank = new JButton("VER PLANTAS ORDENADAS POR PAGE RANK");
		btn_verPlantasPageRank.setForeground(Color.BLACK);
		btn_verPlantasPageRank.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPlantasPageRank.setFocusPainted(false);
		btn_verPlantasPageRank.setContentAreaFilled(true);
		btn_verPlantasPageRank.setBorderPainted(false);
		btn_verPlantasPageRank.setBackground(new Color(80, 165, 94));
		btn_verPlantasPageRank.setBounds(525, 287, 338, 41);
		add(btn_verPlantasPageRank);
		
		JButton btn_buscarPlantas = new JButton("BUSCAR PLANTAS");
		btn_buscarPlantas.setForeground(Color.BLACK);
		btn_buscarPlantas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarPlantas.setFocusPainted(false);
		btn_buscarPlantas.setContentAreaFilled(true);
		btn_buscarPlantas.setBorderPainted(false);
		btn_buscarPlantas.setBackground(new Color(80, 165, 94));
		btn_buscarPlantas.setBounds(91, 31, 156, 41);
		add(btn_buscarPlantas);
		
		JButton btn_agregarInsumo = new JButton("AGREGAR INSUMO Y STOCK ");
		btn_agregarInsumo.setForeground(Color.BLACK);
		btn_agregarInsumo.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_agregarInsumo.setFocusPainted(false);
		btn_agregarInsumo.setContentAreaFilled(true);
		btn_agregarInsumo.setBorderPainted(false);
		btn_agregarInsumo.setBackground(new Color(80, 165, 94));
		btn_agregarInsumo.setBounds(525, 339, 338, 41);
		add(btn_agregarInsumo);


	}

}
