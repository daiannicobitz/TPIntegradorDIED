package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import imp.DAOs.DAOInsumo;
import imp.DAOs.DAOItem;
import imp.DAOs.DAOOrdenPedido;
import imp.enumerators.EstadoOrden;
import imp.primaryClasses.Item;
import imp.primaryClasses.OrdenPedido;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PopUpDetalleOrden extends JFrame {
	private JTextField txt_IdOrden;
	private JTextField txt_FechaPedido;
	private JTextField txt_PlantaDestino;
	private JTextField txt_FechaEntrega;
	private JTable table;
	
	public PopUpDetalleOrden(OrdenPedido op){
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(200, 200, 800, 540);
		setResizable(false);
		
		JPanel panel_detalleOrden = new JPanel();
		panel_detalleOrden.setBackground(new Color(118, 203, 117));
		getContentPane().add(panel_detalleOrden);
		panel_detalleOrden.setLayout(null);
		
		JLabel lbl_idOrden = new JLabel("ID ORDEN ");
		lbl_idOrden.setBounds(52, 56, 85, 14);
		panel_detalleOrden.add(lbl_idOrden);
		
		JLabel lbl_plantaDestino = new JLabel("PLANTA DESTINO ");
		lbl_plantaDestino.setBounds(453, 56, 112, 14);
		panel_detalleOrden.add(lbl_plantaDestino);
		
		JLabel lbl_fechaPedido = new JLabel("FECHA PEDIDO");
		lbl_fechaPedido.setBounds(52, 118, 85, 14);
		panel_detalleOrden.add(lbl_fechaPedido);
		
		JLabel lbl_fechaEntrega = new JLabel("FECHA ENTREGA");
		lbl_fechaEntrega.setBounds(453, 118, 96, 14);
		panel_detalleOrden.add(lbl_fechaEntrega);
		
		txt_IdOrden = new JTextField();
		txt_IdOrden.setBounds(160, 53, 162, 20);
		panel_detalleOrden.add(txt_IdOrden);
		txt_IdOrden.setColumns(10);
		txt_IdOrden.setText(Long.toString(op.getNumeroOrden()));
		
		txt_FechaPedido = new JTextField();
		txt_FechaPedido.setColumns(10);
		txt_FechaPedido.setBounds(160, 115, 162, 20);
		panel_detalleOrden.add(txt_FechaPedido);

		String strDateFechaSolicitud = dateFormat.format(op.getFechaSolicitud()); 
		
		txt_FechaPedido.setText(strDateFechaSolicitud);
		
		txt_PlantaDestino = new JTextField();
		txt_PlantaDestino.setColumns(10);
		txt_PlantaDestino.setBounds(575, 53, 162, 20);
		panel_detalleOrden.add(txt_PlantaDestino);
		
		txt_PlantaDestino.setText(op.getPlantaDestino());
		
		txt_FechaEntrega = new JTextField();
		txt_FechaEntrega.setColumns(10);
		txt_FechaEntrega.setBounds(575, 115, 162, 20);
		panel_detalleOrden.add(txt_FechaEntrega);
		
		String strDateFechaEntrega = dateFormat.format(op.getFechaEntrega()); 
		
		txt_FechaEntrega.setText(strDateFechaEntrega);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 202, 685, 174);
		panel_detalleOrden.add(scrollPane);
		
		JTable tabla_DetalleOrden = new JTable();
		tabla_DetalleOrden.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_DetalleOrden = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Nombre", "Cantidad", "Precio", "Total"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		ArrayList<Item> listaItems = DAOItem.recuperarItemsPorIdOrden(op);
		
		for(Item item : listaItems) {
			
			model_tabla_DetalleOrden.addRow(new Object[]{DAOInsumo.buscarNombreInsumoPorId(item.getIdInsumo()), item.getCantidadSolicitada(), DAOInsumo.getPrecioPorId(item.getIdInsumo()), DAOInsumo.CalcularPrecioTotal(item.getIdInsumo(),item.getCantidadSolicitada())});
			
		}
		
		tabla_DetalleOrden.setModel(model_tabla_DetalleOrden);
		tabla_DetalleOrden.getTableHeader().setReorderingAllowed(false);
		tabla_DetalleOrden.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_DetalleOrden);
		
		JLabel lbl_Items = new JLabel("ITEMS");
		lbl_Items.setBounds(52, 170, 72, 14);
		panel_detalleOrden.add(lbl_Items);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(278, 409, 189, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		btn_aceptar.addActionListener(e->{
			dispose();
		});
		panel_detalleOrden.add(btn_aceptar);
		
		
		
		
	}
}
