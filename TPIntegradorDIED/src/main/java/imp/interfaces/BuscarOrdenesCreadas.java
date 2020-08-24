package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.DAOs.DAOItem;
import imp.DAOs.DAOOrdenPedido;
import imp.DTOs.OrdenPedidoDTO;
import imp.DTOs.PlantaDTO;
import imp.primaryClasses.OrdenPedido;
import imp.primaryClasses.*;

public class BuscarOrdenesCreadas extends JPanel {

	ArrayList<OrdenPedidoDTO> listaOrdenesCreadasDTO;
	
	
	public  BuscarOrdenesCreadas() {
		listaOrdenesCreadasDTO = new ArrayList<OrdenPedidoDTO>();
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 108, 772, 168);
		add(scrollPane);
		
		JTable tabla_ordenesCreadas = new JTable();
		tabla_ordenesCreadas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_ordenesCreadas = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Nro. Orden", "Planta Destino", "Fecha Solicitud", "Fecha Entrega", "Estado"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_ordenesCreadas.setModel(model_tabla_ordenesCreadas);
		tabla_ordenesCreadas.getTableHeader().setReorderingAllowed(false);
		tabla_ordenesCreadas.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_ordenesCreadas);
		
		JButton btn_verDetalle = new JButton("VER DETALLE DE ORDEN ");
		btn_verDetalle.setForeground(Color.BLACK);
		btn_verDetalle.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verDetalle.setFocusPainted(false);
		btn_verDetalle.setContentAreaFilled(true);
		btn_verDetalle.setBorderPainted(false);
		btn_verDetalle.setBackground(new Color(80, 165, 94));
		btn_verDetalle.setBounds(91, 338, 203, 41);
		add(btn_verDetalle);
		
		JButton btn_verPlantasStock = new JButton("VER PLANTAS CON STOCK");
		btn_verPlantasStock.setForeground(Color.BLACK);
		btn_verPlantasStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPlantasStock.setFocusPainted(false);
		btn_verPlantasStock.setContentAreaFilled(true);
		btn_verPlantasStock.setBorderPainted(false);
		btn_verPlantasStock.setBackground(new Color(80, 165, 94));
		btn_verPlantasStock.setBounds(380, 338, 203, 41);
		add(btn_verPlantasStock);
		
		JButton btn_verPosiblesRutas = new JButton("VER POSIBLES RUTAS");
		btn_verPosiblesRutas.setForeground(Color.BLACK);
		btn_verPosiblesRutas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPosiblesRutas.setFocusPainted(false);
		btn_verPosiblesRutas.setContentAreaFilled(true);
		btn_verPosiblesRutas.setBorderPainted(false);
		btn_verPosiblesRutas.setBackground(new Color(80, 165, 94));
		btn_verPosiblesRutas.setBounds(660, 338, 203, 41);
		add(btn_verPosiblesRutas);
		
		JButton btn_buscarOCreadas = new JButton("BUSCAR ORDENES ");		
		btn_buscarOCreadas.setForeground(Color.BLACK);
		btn_buscarOCreadas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarOCreadas.setFocusPainted(false);
		btn_buscarOCreadas.setContentAreaFilled(true);
		btn_buscarOCreadas.setBorderPainted(false);
		btn_buscarOCreadas.setBackground(new Color(80, 165, 94));
		btn_buscarOCreadas.setBounds(91, 31, 156, 41);
		add(btn_buscarOCreadas);
		btn_buscarOCreadas.addActionListener(e -> {
			
			
			ArrayList<OrdenPedido> listaOrdenesCreadas = DAOOrdenPedido.buscarOrdenesCreadas();
			
			for (OrdenPedido o : listaOrdenesCreadas) {
				OrdenPedidoDTO dto = new OrdenPedidoDTO(o);
				listaOrdenesCreadasDTO.add(dto);
			}
			
			for(OrdenPedidoDTO orden : listaOrdenesCreadasDTO) {
				
				model_tabla_ordenesCreadas.addRow(new Object[]{orden.getNroOrden(), orden.getPlantaDestino(), orden.getFechaSolicitud(), orden.getFechaEntrega(), orden.getEstado()});
				
			}
			
		});
		
		
		btn_verDetalle.addActionListener(e -> {
			
			
			if(tabla_ordenesCreadas.getSelectedRow() >= 0) {
				OrdenPedidoDTO op = listaOrdenesCreadasDTO.get(tabla_ordenesCreadas.getSelectedRow()); 
				PopUpDetalleOrden detalle_orden = new PopUpDetalleOrden(op);	
			}else {
				JOptionPane.showMessageDialog(null, "No se ha seleccionado una orden.", "Estado Detalle.", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		btn_verPlantasStock.addActionListener(e -> {
			OrdenPedidoDTO op = listaOrdenesCreadasDTO.get(tabla_ordenesCreadas.getSelectedRow());
			
			PopUpVerPlantasConStock plantas_con_Stock = new PopUpVerPlantasConStock(DAOItem.recuperarItemsPorIdOrden(Long.parseLong(op.getNroOrden())));
			
			//obtener todos los items
		});
		
		btn_verPosiblesRutas.addActionListener(e -> {
			
//			inicializar las siguientes variables con la funcion creada en GestorStock.buscarPlantaConStock y 
//			con el nombre de la planta destino del renglon de la tabla seleccionado

			PopUpVerPosiblesRutas posiblesRutas = new PopUpVerPosiblesRutas(this.listaOrdenesCreadasDTO.get(tabla_ordenesCreadas.getSelectedRow()));
			
		});
	}
}
