package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.gestores.GestorPlanta;

import javax.swing.JComboBox;

public class RutasPosiblesEntrePlantas extends JPanel {
	
	List<String> listaNombresPlantas = GestorPlanta.getPlantasNombres();


	public RutasPosiblesEntrePlantas() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 155, 772, 168);
		add(scrollPane);
		
		JTable tabla_rutas = new JTable();
		tabla_rutas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_rutas = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"id Ruta", "Planta inicio", "Planta fin", "Distancia (km)", "Duracion (hs)"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_rutas.setModel(model_tabla_rutas);
		tabla_rutas.getTableHeader().setReorderingAllowed(false);
		tabla_rutas.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_rutas);
		
		JLabel lbl_titulo = new JLabel("VER RUTAS ENTRE PLANTAS");
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_titulo.setBounds(37, 28, 302, 14);
		add(lbl_titulo);
		
		JLabel lbl_inicio = new JLabel("PLANTA INICIAL");
		lbl_inicio.setBounds(37, 86, 116, 14);
		add(lbl_inicio);
		
		JComboBox combo_inicio = new JComboBox();
		combo_inicio.setBounds(164, 82, 175, 22);
		add(combo_inicio);
		
		JComboBox combo_fin = new JComboBox();
		combo_fin.setBounds(529, 82, 175, 22);
		add(combo_fin);
		
		JLabel lbl_fin = new JLabel("PLANTA FINAL");
		lbl_fin.setBounds(374, 86, 116, 14);
		add(lbl_fin);
		
		for(String c : listaNombresPlantas) {
			combo_inicio.addItem(c.toString());
			combo_fin.addItem(c.toString());
		}
		
	}
}
