package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import imp.enumerators.UM;
import javax.swing.JScrollPane;

public class DarAltaOrdenPedido extends JPanel {
	private JTextField txt_nroOrden;
	
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
		
		JLabel lbl_plantaDestino = new JLabel("PLANTA DE DESTINO");
		lbl_plantaDestino.setBounds(63, 74, 128, 14);
		add(lbl_plantaDestino);
		
		JComboBox combo_plantaDestino = new JComboBox();
		combo_plantaDestino.setBounds(226, 70, 168, 22);
		add(combo_plantaDestino);
		

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
			
			//en caso de que la cantidad a solicitar sea mayor a la disponible en ese momento, mostrar una advertencia diciendo que 
			//es posible que el envio no se realize
			//crear los items necesarios
			//mostrar el numero de orden que se generará y validad que todos los campos estén completos
			//crear una instancia de orden de pedido y guardarla en la base de datos junto a sus items
			//asignarle el estado CREADA
			
		});
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
		
		JButton btn_agregarInsumo = new JButton("BUSCAR INSUMOS");
		btn_agregarInsumo.setForeground(Color.BLACK);
		btn_agregarInsumo.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_agregarInsumo.setFocusPainted(false);
		btn_agregarInsumo.setContentAreaFilled(true);
		btn_agregarInsumo.setBorderPainted(false);
		btn_agregarInsumo.setBackground(new Color(80, 165, 94));
		btn_agregarInsumo.setBounds(612, 310, 204, 35);
		btn_agregarInsumo.addActionListener(e -> {
			
			PopUpBuscarInsumoMasCantidad buscar_insumo = new PopUpBuscarInsumoMasCantidad(this);
			
		});
		add(btn_agregarInsumo);
		
	}
	
	
	
	
	
}
