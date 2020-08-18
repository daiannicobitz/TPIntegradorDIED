package imp.interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import imp.gestores.GestorPlanta;
import imp.primaryClasses.Planta;
import imp.structures.Grafo;
import imp.structures.Vertice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class CaminoMinimoEntrePlantas extends JPanel {
	
	List<String> listaNombresPlantas = GestorPlanta.getPlantasNombres();
	List<String> listaColumnas = new ArrayList<String>();
	public CaminoMinimoEntrePlantas() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		listaColumnas.add("Plantas");
		listaColumnas.addAll(listaNombresPlantas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 194, 676, 168);
		add(scrollPane);
		
		JTable tabla_Plantas = new JTable();
		tabla_Plantas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_Plantas = new DefaultTableModel(
				new Object[][] {
					
				},
					listaColumnas.toArray()
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
		
		JLabel lbl_duracion = new JLabel("Duracion:");
		JLabel lbl_distancia_KM = new JLabel("Distancia en KM:");
		
		
		
		JLabel lbl_tipoBusqueda = new JLabel("Realizar la busqueda de caminos minimos por:");
		lbl_tipoBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tipoBusqueda.setBounds(46, 45, 318, 22);
		add(lbl_tipoBusqueda);
		
		JComboBox comboBox_tipoBusqueda = new JComboBox();
		comboBox_tipoBusqueda.setBounds(386, 47, 128, 22);
		add(comboBox_tipoBusqueda);
		comboBox_tipoBusqueda.addItem("DISTANCIA EN KM");
		comboBox_tipoBusqueda.addItem("DURACION");
		
		JButton btn_actualizarStock = new JButton("Buscar recorridos");
		btn_actualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    	List<Double> listaValores = null;
			    	
			    	if(comboBox_tipoBusqueda.getSelectedItem().toString().equals("DURACION")) {
			    		
			    		List<Vertice<Planta>> vertices=Grafo.getInstance().vertices();
			    		
			    		int cantfilas=listaColumnas.size()-1;
			    		int cantColumnas = listaColumnas.size();
			    		Object[][] listaMuestra = new Object[cantfilas][cantColumnas];
			    		int fila = 0;

			    		for(Vertice<Planta> v : vertices) {
			    			
			    			listaValores = Grafo.getInstance().getValoresDuracionConDemasVertices(v);
			    			listaMuestra[fila][0] = listaColumnas.get(fila+1);
			    			for(int j = 1 ; j<cantColumnas;j++) {
								
			    				listaMuestra[fila][j] = listaValores.get(j-1);
			    				
							}
							fila++;
			    		}
							DefaultTableModel modelo = new DefaultTableModel(listaMuestra,listaColumnas.toArray()) {

								private static final long serialVersionUID = 1L;

								@Override
								public boolean isCellEditable(int i, int i1) {
									return false;
								}
							};
							
							tabla_Plantas.setModel(modelo);
			    		
			    		
			    		lbl_distancia_KM.setVisible(false);
			    		lbl_duracion.setVisible(true);
			    	
			    		
			    	}else {
			    		
			    		List<Vertice<Planta>> vertices=Grafo.getInstance().vertices();
			    		
			    		int cantfilas=listaColumnas.size()-1;
			    		int cantColumnas = listaColumnas.size();
			    		Object[][] listaMuestra = new Object[cantfilas][cantColumnas];
			    		int fila = 0;

			    		for(Vertice<Planta> v : vertices) {
			    			
			    			listaValores = Grafo.getInstance().getValoresDistanciaConDemasVertices(v);
			    			listaMuestra[fila][0] = listaColumnas.get(fila+1);
			    			for(int j = 1 ; j<cantColumnas;j++) {
								
			    				listaMuestra[fila][j] = listaValores.get(j-1);
			    				
							}
							fila++;
			    		}
							DefaultTableModel modelo = new DefaultTableModel(listaMuestra,listaColumnas.toArray()) {

								private static final long serialVersionUID = 1L;

								@Override
								public boolean isCellEditable(int i, int i1) {
									return false;
								}
							};
							
							tabla_Plantas.setModel(modelo);
			    			
			    		lbl_duracion.setVisible(false);
			    		lbl_distancia_KM.setVisible(true);	
			    		
			    	}				
			}
		});
		
		btn_actualizarStock.setForeground(Color.BLACK);
		btn_actualizarStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_actualizarStock.setFocusPainted(false);
		btn_actualizarStock.setContentAreaFilled(true);
		btn_actualizarStock.setBorderPainted(false);
		btn_actualizarStock.setBackground(new Color(80, 165, 94));
		btn_actualizarStock.setBounds(523, 110, 149, 41);
		add(btn_actualizarStock);
		
		
		lbl_duracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_duracion.setBounds(46, 157, 103, 26);
		add(lbl_duracion);
		lbl_duracion.setVisible(false);
		
		
		lbl_distancia_KM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_distancia_KM.setBounds(46, 157, 138, 26);
		add(lbl_distancia_KM);
		lbl_distancia_KM.setVisible(false);
	}
}
