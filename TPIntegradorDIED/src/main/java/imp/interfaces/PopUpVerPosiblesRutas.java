package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PopUpVerPosiblesRutas extends JFrame {
	private JTextField txt_camionAsignado;

	public PopUpVerPosiblesRutas () {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(200, 200, 942, 540);
		setResizable(false);
		
		JPanel panel_verPosiblesRutas = new JPanel();
		panel_verPosiblesRutas.setBackground(new Color(118, 203, 117));
		getContentPane().add(panel_verPosiblesRutas);
		panel_verPosiblesRutas.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 132, 429, 230);
		panel_verPosiblesRutas.add(scrollPane);
		
		JTable tabla_recorridoKm = new JTable();
		tabla_recorridoKm.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_recorridoKm = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Producto", "Recorrido", "Km"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};

		tabla_recorridoKm.setModel(model_tabla_recorridoKm);
		tabla_recorridoKm.getTableHeader().setReorderingAllowed(false);
		tabla_recorridoKm.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_recorridoKm);
		

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(487, 132, 429, 230);
		panel_verPosiblesRutas.add(scrollPane2);
		
		JTable tabla_recorridoTiempo = new JTable();
		tabla_recorridoTiempo.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_recorridoTiempo = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Producto", "Recorrido", "Horas"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};

		tabla_recorridoTiempo.setModel(model_tabla_recorridoTiempo);
		tabla_recorridoTiempo.getTableHeader().setReorderingAllowed(false);
		tabla_recorridoTiempo.getTableHeader().setResizingAllowed(false);
		scrollPane2.setViewportView(tabla_recorridoTiempo);
		
		JLabel lbl_recorridoKm = new JLabel("RECORRIDO MAS CORTO EN KM");
		lbl_recorridoKm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_recorridoKm.setBounds(26, 71, 429, 14);
		panel_verPosiblesRutas.add(lbl_recorridoKm);
		
		JLabel lbl_recorridoTiempo = new JLabel("RECORRIDO MAS CORTO EN TIEMPO");
		lbl_recorridoTiempo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_recorridoTiempo.setBounds(487, 71, 361, 14);
		panel_verPosiblesRutas.add(lbl_recorridoTiempo);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(533, 450, 189, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		panel_verPosiblesRutas.add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setForeground(Color.BLACK);
		btn_cancelar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setBackground(new Color(80, 165, 94));
		btn_cancelar.setBounds(727, 450, 189, 40);
		panel_verPosiblesRutas.add(btn_cancelar);
		
		JLabel lbl_camion = new JLabel("CAMION ASIGNADO");
		lbl_camion.setBounds(26, 386, 130, 14);
		panel_verPosiblesRutas.add(lbl_camion);
		
		txt_camionAsignado = new JTextField();
		txt_camionAsignado.setBounds(166, 383, 258, 20);
		panel_verPosiblesRutas.add(txt_camionAsignado);
		txt_camionAsignado.setColumns(10);
		
	}
}
