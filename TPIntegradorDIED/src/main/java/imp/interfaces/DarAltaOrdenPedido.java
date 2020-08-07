package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import imp.DAOs.DAOOrdenPedido;
import imp.enumerators.EstadoOrden;
import imp.enumerators.UM;
import imp.gestores.GestorPlanta;
import imp.primaryClasses.Item;
import imp.primaryClasses.OrdenPedido;
import imp.primaryClasses.Planta;

import javax.swing.JScrollPane;

public class DarAltaOrdenPedido extends JPanel {
	private JTextField txt_nroOrden;
	private ArrayList<Integer> idInsumos = new ArrayList<>();
	private ArrayList<Item> listaItems = new ArrayList<>();
	public CardLayout c = new CardLayout();
	
	
	public DarAltaOrdenPedido() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		JLabel lbl_nroOrden = new JLabel("NUMERO DE ORDEN");
		lbl_nroOrden.setBounds(63, 29, 128, 14);
		add(lbl_nroOrden);
		
		txt_nroOrden = new JTextField();
		txt_nroOrden.setEnabled(false);
		txt_nroOrden.setEditable(false);
		txt_nroOrden.setBounds(226, 26, 168, 20);
		add(txt_nroOrden);
		txt_nroOrden.setColumns(10);
		txt_nroOrden.setText(Long.toString(DAOOrdenPedido.recupearUltimoOP() + 1));
		
		JLabel lbl_plantaDestino = new JLabel("PLANTA DE DESTINO");
		lbl_plantaDestino.setBounds(63, 74, 128, 14);
		add(lbl_plantaDestino);
		
		JTextField plantaDestino = new JTextField();
		plantaDestino.setBounds(226, 70, 168, 22);
		add(plantaDestino);
		

		JLabel lbl_fechaSolicitud = new JLabel("FECHA SOLICITUD");
		lbl_fechaSolicitud.setBounds(491, 29, 111, 14);
		
		JDateChooser fecha_solicitud = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecha_solicitud.setDateFormatString("dd/MM/yyyy");
		
		LocalDateTime now = LocalDateTime.now();  
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date nowdate = Date.from(now.atZone(defaultZoneId).toInstant());
		fecha_solicitud.setDate(nowdate);
		Date inicio= null;
		try {
			inicio=new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1980");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		fecha_solicitud.setSelectableDateRange(inicio, nowdate);
		fecha_solicitud.setEnabled(false);
		fecha_solicitud.setBounds(648, 23, 168, 20);
		
		add(fecha_solicitud);
		add(lbl_fechaSolicitud);

		JLabel lbl_fechaEntrega = new JLabel("FECHA ENTREGA");
		lbl_fechaEntrega.setBounds(491, 74, 111, 14);
		
		JDateChooser fecha_entrega = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecha_entrega.setDateFormatString("dd/MM/yyyy");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowdate);
		calendar.add(Calendar.MONTH, 3);
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(nowdate);
		calendar1.add(Calendar.DAY_OF_YEAR, 1);
		
		fecha_entrega.setSelectableDateRange(calendar1.getTime(), calendar.getTime());
		fecha_entrega.setDate(calendar1.getTime());
		fecha_entrega.setBounds(648, 68, 168, 20);
		
		add(fecha_entrega);
		add(lbl_fechaEntrega);
		
		
		JLabel lbl_detalleItems = new JLabel("DETALLES DE LOS ITEMS");
		lbl_detalleItems.setBounds(62, 155, 186, 14);
		add(lbl_detalleItems);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 180, 753, 112);
		add(scrollPane);
		
		JTable tabla_detalleItems = new JTable();
		tabla_detalleItems.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_detalleItems = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						 "Descripcion insumo", "Costo unitario", "Cantidad solicitada", "Costo total"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_detalleItems.setModel(model_tabla_detalleItems);
		tabla_detalleItems.getTableHeader().setReorderingAllowed(false);
		tabla_detalleItems.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_detalleItems);
		
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(612, 370, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		btn_aceptar.addActionListener(e -> {
			
		    String validados = validarCampos(fecha_entrega.getDate(), plantaDestino.getText().toUpperCase(), model_tabla_detalleItems.getRowCount());
				
		    if(validados == "") {
		    
			int cantidad_insumos = idInsumos.size();
			
			for (int i =0; i< cantidad_insumos; i++) {
				
				Item item = new Item(idInsumos.get(i), Double.parseDouble(model_tabla_detalleItems.getValueAt(i, 2).toString()), Integer.parseInt(txt_nroOrden.getText()));
				
				listaItems.add(item);

			}
			
			
			OrdenPedido ordenPedido = new OrdenPedido();
			
			ordenPedido.setFechaSolicitud(fecha_solicitud.getDate());
			ordenPedido.setFechaEntrega(fecha_entrega.getDate());
			ordenPedido.setNumeroOrden(Integer.parseInt(txt_nroOrden.getText()));
			ordenPedido.setEstado(EstadoOrden.valueOf("CREADA"));
			ordenPedido.setItems(listaItems);
			ordenPedido.setPlantaDestino(plantaDestino.getText().toUpperCase());
			
			
			DAOOrdenPedido.guardarOrden(ordenPedido);
			
			
			
		    } else {
		    	
				JOptionPane.showMessageDialog(null, "Error en los siguientes campos: \n"+ validados, "Estado Orden.", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			}
		
			
		);
		add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(718, 370, 98, 40);
		btn_cancelar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setForeground(new Color(0, 0, 0));
		btn_cancelar.setBackground(new Color(80, 165, 94));
		add(btn_cancelar);
		btn_cancelar.addActionListener(e -> {
			JPanel padre = (JPanel) this.getParent();
			 c = (CardLayout)(padre.getLayout());
				c.show(padre, "inicio_ordenes");
		});
		
		JButton btn_agregarInsumo = new JButton("BUSCAR INSUMOS");
		btn_agregarInsumo.setForeground(Color.BLACK);
		btn_agregarInsumo.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_agregarInsumo.setFocusPainted(false);
		btn_agregarInsumo.setContentAreaFilled(true);
		btn_agregarInsumo.setBorderPainted(false);
		btn_agregarInsumo.setBackground(new Color(80, 165, 94));
		btn_agregarInsumo.setBounds(612, 310, 204, 35);
		btn_agregarInsumo.addActionListener(e -> {
			
			PopUpBuscarInsumoMasCantidad buscar_insumo = new PopUpBuscarInsumoMasCantidad(this, idInsumos);
			
		});
		add(btn_agregarInsumo);
		
	}


	private String validarCampos(Date date, String plantaDestino, int rowCount) {
		// TODO Auto-generated method stub
		String retorno = "";
		
		LocalDateTime now = LocalDateTime.now();  
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date nowdate = Date.from(now.atZone(defaultZoneId).toInstant());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowdate);
		calendar.add(Calendar.MONTH, 3);
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(nowdate);
		calendar1.add(Calendar.DAY_OF_YEAR, 1);
		
		if(date.after(calendar.getTime()) || date.before(calendar1.getTime())) {
			
			retorno = retorno + " Fecha de entrega \n";

	}
		if(!GestorPlanta.ExistePlanta(plantaDestino)) {
		
			retorno = retorno + " Planta destino \n";
			
		}
		
		if(rowCount ==0) {
			retorno = retorno + " Items \n";
		}
		return retorno;
	}
	
	
	
}
