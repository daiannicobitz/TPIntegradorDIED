package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
		setBackground(new Color(187, 238, 110));
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
		fecha_solicitud.setBounds(648, 23, 168, 20);
		
		add(fecha_solicitud);
		add(lbl_fechaSolicitud);

		JLabel lbl_fechaEntrega = new JLabel("FECHA ENTREGA");
		lbl_fechaEntrega.setBounds(491, 74, 111, 14);
		
		JDateChooser fecha_entrega = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecha_entrega.setDateFormatString("dd/MM/yyyy");
		fecha_entrega.setSelectableDateRange(inicio, nowdate);
		fecha_entrega.setBounds(648, 68, 168, 20);
		
		add(fecha_entrega);
		add(lbl_fechaEntrega);
		
		JLabel lbl_EstadoOrden = new JLabel("ESTADO DE LA ORDEN");
		lbl_EstadoOrden.setBounds(63, 119, 128, 14);
		add(lbl_EstadoOrden);
		
		JComboBox combo_estadoOrden = new JComboBox();
		combo_estadoOrden.setBounds(226, 115, 168, 22);
		add(combo_estadoOrden);
		
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
						"Id insumo", "Descripcion insumo", "Costo unitario", "Cantidad solicitada"
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
		
		JLabel lbl_detalleEnvio = new JLabel("DETALLES DEL ENVIO");
		lbl_detalleEnvio.setBounds(63, 300, 139, 14);
		add(lbl_detalleEnvio);
		

		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(63, 320, 539, 58);
		add(scrollPane2);
		
		JTable tabla_detalleEnvio = new JTable();
		tabla_detalleEnvio.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_detalleEnvio = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Camion asignado", "Ruta asignada", "Costo envio"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_detalleEnvio.setModel(model_tabla_detalleEnvio);
		tabla_detalleEnvio.getTableHeader().setReorderingAllowed(false);
		tabla_detalleEnvio.getTableHeader().setResizingAllowed(false);
		scrollPane2.setViewportView(tabla_detalleEnvio);
		
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(612, 395, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(718, 395, 98, 40);
		btn_cancelar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setForeground(new Color(0, 0, 0));
		btn_cancelar.setBackground(new Color(80, 165, 94));
		add(btn_cancelar);
		
		JButton btn_verRuta = new JButton("VER RUTA ASIGNADA");
		btn_verRuta.setForeground(Color.BLACK);
		btn_verRuta.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verRuta.setFocusPainted(false);
		btn_verRuta.setContentAreaFilled(true);
		btn_verRuta.setBorderPainted(false);
		btn_verRuta.setBackground(new Color(80, 165, 94));
		btn_verRuta.setBounds(648, 331, 168, 28);
		add(btn_verRuta);
		
	}
}
