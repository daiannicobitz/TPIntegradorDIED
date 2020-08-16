package imp.interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class CaminoMinimoEntrePlantas extends JPanel {
	
	List<String> listaNombresPlantas = GestorPlanta.getPlantasNombres();
	private JTextField txt_duracion;
	private JTextField txt_distancia;
	
	public CaminoMinimoEntrePlantas() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		JLabel lbl_duracion = new JLabel("Duracion:");
		JLabel lbl_distancia_KM = new JLabel("Distancia en KM:");
		
		JLabel lbl_plantaorigen = new JLabel("Seleccione la planta de origen:");
		lbl_plantaorigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_plantaorigen.setBounds(46, 43, 228, 26);
		add(lbl_plantaorigen);
		
		JComboBox comboBox_plantaOrigen = new JComboBox();
		comboBox_plantaOrigen.setBounds(266, 47, 137, 22);
		add(comboBox_plantaOrigen);
		
		JLabel lbl_plantadestino = new JLabel("Seleccione la planta de destino:");
		lbl_plantadestino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_plantadestino.setBounds(436, 43, 228, 26);
		add(lbl_plantadestino);
		
		JComboBox comboBox_plantaDestino = new JComboBox();
		comboBox_plantaDestino.setBounds(653, 47, 128, 22);
		add(comboBox_plantaDestino);
		
		for(String c : listaNombresPlantas) {
			comboBox_plantaOrigen.addItem(c.toString());
			comboBox_plantaDestino.addItem(c.toString());
		}		
		
		
		JLabel lbl_tipoBusqueda = new JLabel("Realizar la busqueda de caminos minimos por:");
		lbl_tipoBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tipoBusqueda.setBounds(46, 95, 318, 22);
		add(lbl_tipoBusqueda);
		
		JComboBox comboBox_tipoBusqueda = new JComboBox();
		comboBox_tipoBusqueda.setBounds(374, 97, 128, 22);
		add(comboBox_tipoBusqueda);
		comboBox_tipoBusqueda.addItem("DISTANCIA EN KM");
		comboBox_tipoBusqueda.addItem("DURACION");
		
		JLabel lbl_recorrido = new JLabel("Recorrido:");
		lbl_recorrido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_recorrido.setBounds(46, 203, 116, 26);
		add(lbl_recorrido);
		
		JTextField txt_camino = new JTextField();
		txt_camino.setBounds(146, 208, 518, 20);
		txt_camino.setColumns(10);
		add(txt_camino);
		
		JButton btn_actualizarStock = new JButton("Buscar recorridos");
		btn_actualizarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_plantaDestino.getSelectedItem().toString().equals(comboBox_plantaOrigen.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(null, "Los nombres de las Plantas Origen y Final no pueden ser iguales.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
				}else {
			    	Vertice<Planta> v1 = new Vertice<Planta>(GestorPlanta.getPlantaById(
			    							GestorPlanta.getIDPlanta(comboBox_plantaOrigen.getSelectedItem().toString())));
			    								
			    	Vertice<Planta> v2 = new Vertice<Planta>(GestorPlanta.getPlantaById(
			    								GestorPlanta.getIDPlanta(comboBox_plantaDestino.getSelectedItem().toString())));
				
			    	List<String> listaCamino = null;
			    	
			    	if(comboBox_tipoBusqueda.getSelectedItem().toString().equals("DURACION")) {
			    		listaCamino = Grafo.getInstance().caminoMinimoDuracion(v1,v2);
			    		lbl_distancia_KM.setVisible(false);
			    		txt_distancia.setVisible(false);
			    		lbl_duracion.setVisible(true);
			    		txt_duracion.setEditable(true);
			    		txt_duracion.setVisible(true);
			    		txt_camino.setText(listaCamino.subList(0, listaCamino.size()-1).toString());
			    		txt_duracion.setText(listaCamino.subList(listaCamino.size()-1, listaCamino.size()).get(0));
			    		txt_duracion.setEditable(false);
			    		
			    	}else {
			    		
			    		listaCamino = Grafo.getInstance().caminoMinimoDistancia(v1,v2);
			    		if(!listaCamino.isEmpty()) {
			    		lbl_duracion.setVisible(false);
			    		txt_duracion.setVisible(false);
			    		lbl_distancia_KM.setVisible(true);
			    		txt_distancia.setEditable(true);
			    		txt_distancia.setVisible(true);
			    		txt_camino.setText(listaCamino.subList(0, listaCamino.size()-1).toString());
			    		txt_distancia.setText(listaCamino.subList(listaCamino.size()-1, listaCamino.size()).get(0));
			    		txt_distancia.setEditable(false);
			    		}else {
							JOptionPane.showMessageDialog(null, "No existe un camino desde "+comboBox_plantaOrigen.getSelectedItem().toString()+""
									+ " hasta "+comboBox_plantaDestino.getSelectedItem().toString()+".",
									"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			    		}
			    	}
				}				
			}
		});
		
		btn_actualizarStock.setForeground(Color.BLACK);
		btn_actualizarStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_actualizarStock.setFocusPainted(false);
		btn_actualizarStock.setContentAreaFilled(true);
		btn_actualizarStock.setBorderPainted(false);
		btn_actualizarStock.setBackground(new Color(80, 165, 94));
		btn_actualizarStock.setBounds(294, 145, 149, 41);
		add(btn_actualizarStock);
		
		
		lbl_duracion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_duracion.setBounds(46, 250, 103, 26);
		add(lbl_duracion);
		lbl_duracion.setVisible(false);
		
		txt_duracion = new JTextField();
		txt_duracion.setColumns(10);
		txt_duracion.setBounds(194, 255, 138, 20);
		add(txt_duracion);
		txt_duracion.setEditable(false);
		txt_duracion.setVisible(false);
		
		
		lbl_distancia_KM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_distancia_KM.setBounds(46, 250, 138, 26);
		add(lbl_distancia_KM);
		lbl_distancia_KM.setVisible(false);
		
		txt_distancia = new JTextField();
		txt_distancia.setColumns(10);
		txt_distancia.setBounds(193, 255, 138, 20);
		add(txt_distancia);
		txt_distancia.setEditable(false);
		txt_distancia.setVisible(false);
	}
}
