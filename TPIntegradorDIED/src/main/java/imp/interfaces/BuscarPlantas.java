package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.DTOs.InsumoDTO;
import imp.DTOs.OrdenPedidoDTO;
import imp.DTOs.PlantaDTO;
import imp.gestores.GestorInsumo;
import imp.gestores.GestorPlanta;
import imp.primaryClasses.Planta;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BuscarPlantas extends JPanel {
	
	private ArrayList<PlantaDTO> listaPlantasBuscadas = new ArrayList<PlantaDTO>(); //esta definido aca para poder mostrarlo en el Jtable
	
	public CardLayout c = new CardLayout();
	
	public BuscarPlantas () {
		setBackground(new Color(118, 203, 117));
		setLayout(new CardLayout(0, 0));
		
		JPanel contenedor_buscarPlanta = new JPanel();
		add(contenedor_buscarPlanta, "contenedor_buscarPlanta");
		contenedor_buscarPlanta.setLayout(null);
		contenedor_buscarPlanta.setBackground(new Color(118, 203, 117));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 93, 772, 168);
		contenedor_buscarPlanta.add(scrollPane);
		
		JTable tabla_Plantas = new JTable();
		tabla_Plantas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_Plantas = new DefaultTableModel(
				new Object[][] {
				},
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
		contenedor_buscarPlanta.add(btn_actualizarStock);
		
		JButton btn_verPlantasStock = new JButton("VER PLANTAS CON STOCK MENOR A PUNTO PEDIDO");
		btn_verPlantasStock.setForeground(Color.BLACK);
		btn_verPlantasStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPlantasStock.setFocusPainted(false);
		btn_verPlantasStock.setContentAreaFilled(true);
		btn_verPlantasStock.setBorderPainted(false);
		btn_verPlantasStock.setBackground(new Color(80, 165, 94));
		btn_verPlantasStock.setBounds(91, 339, 338, 41);
		contenedor_buscarPlanta.add(btn_verPlantasStock);
		
		JButton btn_verPlantasPageRank = new JButton("VER PLANTAS ORDENADAS POR PAGE RANK");
		btn_verPlantasPageRank.setForeground(Color.BLACK);
		btn_verPlantasPageRank.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPlantasPageRank.setFocusPainted(false);
		btn_verPlantasPageRank.setContentAreaFilled(true);
		btn_verPlantasPageRank.setBorderPainted(false);
		btn_verPlantasPageRank.setBackground(new Color(80, 165, 94));
		btn_verPlantasPageRank.setBounds(525, 287, 338, 41);
		contenedor_buscarPlanta.add(btn_verPlantasPageRank);
		
		JButton btn_buscarPlantas = new JButton("BUSCAR PLANTAS");
		btn_buscarPlantas.setForeground(Color.BLACK);
		btn_buscarPlantas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarPlantas.setFocusPainted(false);
		btn_buscarPlantas.setContentAreaFilled(true);
		btn_buscarPlantas.setBorderPainted(false);
		btn_buscarPlantas.setBackground(new Color(80, 165, 94));
		btn_buscarPlantas.setBounds(91, 31, 156, 41);
		contenedor_buscarPlanta.add(btn_buscarPlantas);
		
		btn_buscarPlantas.addActionListener(e -> {
			
			listaPlantasBuscadas=GestorPlanta.visualizarTodasLasPlantas();
			
			int cantPlantas=listaPlantasBuscadas.size();
			int fila=0;
			
			Object[][] listaMuestra = new Object[cantPlantas][2];
			
			for(PlantaDTO c: listaPlantasBuscadas) {

				listaMuestra[fila][0] = c.getNombre();
				listaMuestra[fila][1] = c.getTipo();
				
				fila++;
			}
			
			DefaultTableModel modelo = new DefaultTableModel(listaMuestra,new String[] {"Nombre Planta", "Tipo Planta"}) {

				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int i, int i1) {
					return false;
				}
			};
			
			tabla_Plantas.setModel(modelo);
			
			
		});
		
		JButton btn_agregarInsumo = new JButton("AGREGAR INSUMO Y STOCK ");
		btn_agregarInsumo.setForeground(Color.BLACK);
		btn_agregarInsumo.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_agregarInsumo.setFocusPainted(false);
		btn_agregarInsumo.setContentAreaFilled(true);
		btn_agregarInsumo.setBorderPainted(false);
		btn_agregarInsumo.setBackground(new Color(80, 165, 94));
		btn_agregarInsumo.setBounds(525, 339, 338, 41);
		contenedor_buscarPlanta.add(btn_agregarInsumo);

		AgregarInsumoYStock panel_agregarInsumoYStock = new AgregarInsumoYStock (); 
		add(panel_agregarInsumoYStock, "agregarInsumoYStock");
		
		PlantasStockMenorAPuntoPedido panel_plantasStockMenorPuntoPedido = new PlantasStockMenorAPuntoPedido();
		add(panel_plantasStockMenorPuntoPedido, "plantasStockMenorPuntoPedido");
		
		PlantasOrdenadasPageRank panel_plantasOrdenadasPageRank = new PlantasOrdenadasPageRank();
		add(panel_plantasOrdenadasPageRank, "plantasOrdenadasPageRank");
		
		ActualizarStockPlanta panel_actualizarStockPlanta = new ActualizarStockPlanta();
		add(panel_actualizarStockPlanta, "actualizarStockPlanta");
		
		btn_agregarInsumo.addActionListener(e -> {
			if(tabla_Plantas.getSelectedRow() >= 0) {
				PlantaDTO planta = listaPlantasBuscadas.get(tabla_Plantas.getSelectedRow()); 
				c = (CardLayout)(this.getLayout());
				c.show(this, "agregarInsumoYStock");
			}else {
				JOptionPane.showMessageDialog(null, "No se ha seleccionado una planta.", "Estado Detalle.", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		});
		btn_verPlantasStock.addActionListener(e -> {
			c = (CardLayout)(this.getLayout());
				c.show(this, "plantasStockMenorPuntoPedido");
		});
		
		btn_verPlantasPageRank.addActionListener(e -> {
				c = (CardLayout)(this.getLayout());
				c.show(this, "plantasOrdenadasPageRank");	
		});
		
		btn_actualizarStock.addActionListener(e -> {
			if(tabla_Plantas.getSelectedRow() >= 0) {
				PlantaDTO planta = listaPlantasBuscadas.get(tabla_Plantas.getSelectedRow()); 
				c = (CardLayout)(this.getLayout());
				c.show(this, "actualizarStockPlanta");
			}else {
				JOptionPane.showMessageDialog(null, "No se ha seleccionado una planta.", "Estado Detalle.", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});

	}
	
	
}
