package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.DAOs.DAOOrdenPedido;
import imp.DTOs.OrdenPedidoDTO;
import imp.primaryClasses.OrdenPedido;

public class BuscarOrdenesProcesadas extends JPanel {
	
	ArrayList<OrdenPedidoDTO> listaOrdenesProcesadasDTO = new ArrayList<OrdenPedidoDTO>();;
	
	public BuscarOrdenesProcesadas() {
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
		
		JButton btn_buscarOProcesadas = new JButton("BUSCAR ORDENES ");
		btn_buscarOProcesadas.setForeground(Color.BLACK);
		btn_buscarOProcesadas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarOProcesadas.setFocusPainted(false);
		btn_buscarOProcesadas.setContentAreaFilled(true);
		btn_buscarOProcesadas.setBorderPainted(false);
		btn_buscarOProcesadas.setBackground(new Color(80, 165, 94));
		btn_buscarOProcesadas.setBounds(91, 31, 156, 41);
		add(btn_buscarOProcesadas);
		btn_buscarOProcesadas.addActionListener(e -> {
			
			
			ArrayList<OrdenPedido> listaOrdenesProcesadas = DAOOrdenPedido.buscarOrdenesProcesadas();
			
			for (OrdenPedido o : listaOrdenesProcesadas) {
				OrdenPedidoDTO dto = new OrdenPedidoDTO(o);
				listaOrdenesProcesadasDTO.add(dto);
			}
			
			for(OrdenPedidoDTO orden : listaOrdenesProcesadasDTO) {
				
				model_tabla_ordenesCreadas.addRow(new Object[]{orden.getNroOrden(), orden.getPlantaDestino(), orden.getFechaSolicitud(), orden.getFechaEntrega(), orden.getEstado()});
				
			}
			
		});
		
		JButton btn_marcarEntregadas = new JButton("MARCAR COMO ENTREGADAS");
		btn_marcarEntregadas.setForeground(Color.BLACK);
		btn_marcarEntregadas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_marcarEntregadas.setFocusPainted(false);
		btn_marcarEntregadas.setContentAreaFilled(true);
		btn_marcarEntregadas.setBorderPainted(false);
		btn_marcarEntregadas.setBackground(new Color(80, 165, 94));
		btn_marcarEntregadas.setBounds(660, 318, 203, 41);
		add(btn_marcarEntregadas);
	
		btn_marcarEntregadas.addActionListener(e -> {
			
			
			if(tabla_ordenesCreadas.getSelectedRow() > 0) {
				DAOOrdenPedido.actualizarOrdenAEntregada(listaOrdenesProcesadasDTO.get(tabla_ordenesCreadas.getSelectedRow())); 
		
			}else {
				JOptionPane.showMessageDialog(null, "No se ha seleccionado una orden.", "Estado Detalle.", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}

}
