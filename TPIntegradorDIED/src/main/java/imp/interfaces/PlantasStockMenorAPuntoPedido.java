package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.DTOs.PlantaDTO;
import imp.DTOs.StockDTO;
import imp.gestores.GestorStock;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PlantasStockMenorAPuntoPedido extends JPanel {
	
	ArrayList<StockDTO> listaStockBajoPuntoPedido;
	
	public PlantasStockMenorAPuntoPedido() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 146, 772, 168);
		add(scrollPane);
		
		JTable tabla_Plantas = new JTable();
		tabla_Plantas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_Plantas = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
				},
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
		
		JButton btn_buscarPlantas = new JButton("BUSCAR");
		btn_buscarPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listaStockBajoPuntoPedido = GestorStock.buscarStockBajoPuntoPedido();
				
				int cantPlantas=listaStockBajoPuntoPedido.size();
				int fila=0;
				
				Object[][] listaMuestra = new Object[cantPlantas][2];
				
				for(StockDTO c: listaStockBajoPuntoPedido) {

					listaMuestra[fila][0] = c.getNombrePlanta();
					listaMuestra[fila][1] = c.getNombreInsumo();
					listaMuestra[fila][2] = c.getStockEnPlanta();
					listaMuestra[fila][3] = c.getPuntoPedido();
					listaMuestra[fila][4] = c.getStockTotal();
					
					fila++;
				}
				
				DefaultTableModel modelo = new DefaultTableModel(listaMuestra,new String[] {"Nombre Planta", "Nombre Insumo", "Stock en planta", "Punto pedido en planta", "Stock total"}) {

					private static final long serialVersionUID = 1L;

					@Override
					public boolean isCellEditable(int i, int i1) {
						return false;
					}
				};
				
				tabla_Plantas.setModel(modelo);
				
			}
		});
		btn_buscarPlantas.setForeground(Color.BLACK);
		btn_buscarPlantas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarPlantas.setFocusPainted(false);
		btn_buscarPlantas.setContentAreaFilled(true);
		btn_buscarPlantas.setBorderPainted(false);
		btn_buscarPlantas.setBackground(new Color(80, 165, 94));
		btn_buscarPlantas.setBounds(307, 72, 156, 41);
		add(btn_buscarPlantas);
		
		
		JLabel lbl_planta = new JLabel("Presione buscar:");
		lbl_planta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_planta.setBounds(91, 78, 106, 27);
		add(lbl_planta);
		
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
