package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.gestores.GestorPlanta;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlujoMaximoEntreDosPlantas extends JPanel {
	
	List<String> listaNombresPlantas = GestorPlanta.getPlantasNombres();

	public FlujoMaximoEntreDosPlantas() {
		
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 149, 489, 168);
		add(scrollPane);
		
		JTable tabla_recorrido = new JTable();
		tabla_recorrido.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_recorrido = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Recorrido", "Flujo maximo"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_recorrido.setModel(model_recorrido);
		tabla_recorrido.getTableHeader().setReorderingAllowed(false);
		tabla_recorrido.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_recorrido);
		
		JLabel lbl_plantaorigen = new JLabel("Seleccione la planta de origen:");
		lbl_plantaorigen.setBounds(36, 43, 206, 26);
		add(lbl_plantaorigen);
		
		JComboBox comboBox_plantaOrigen = new JComboBox();
		comboBox_plantaOrigen.setBounds(239, 45, 137, 22);
		add(comboBox_plantaOrigen);
		
		JLabel lbl_plantadestino = new JLabel("Seleccione la planta de destino:");
		lbl_plantadestino.setBounds(425, 43, 207, 26);
		add(lbl_plantadestino);
		
		JComboBox comboBox_plantaDestino = new JComboBox();
		comboBox_plantaDestino.setBounds(642, 45, 128, 22);
		add(comboBox_plantaDestino);
		
		for(String c : listaNombresPlantas) {
			comboBox_plantaOrigen.addItem(c.toString());
			comboBox_plantaDestino.addItem(c.toString());
		}
		
		JButton btn_actualizarStock = new JButton("Buscar recorridos.");
		btn_actualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_actualizarStock.setForeground(Color.BLACK);
		btn_actualizarStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_actualizarStock.setFocusPainted(false);
		btn_actualizarStock.setContentAreaFilled(true);
		btn_actualizarStock.setBorderPainted(false);
		btn_actualizarStock.setBackground(new Color(80, 165, 94));
		btn_actualizarStock.setBounds(376, 97, 149, 41);
		add(btn_actualizarStock);
	}
}
