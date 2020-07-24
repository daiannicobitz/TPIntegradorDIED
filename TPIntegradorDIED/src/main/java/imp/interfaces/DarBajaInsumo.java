package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import imp.enumerators.Marca;
import imp.enumerators.UM;

public class DarBajaInsumo extends JPanel {

	public DarBajaInsumo() {
		setBackground(new Color(118, 203, 117));

		JLabel lbl_descripcion = new JLabel("DESCRIPCION");
		lbl_descripcion.setBounds(125, 45, 91, 14);
		
		JLabel lbl_unidadMedida = new JLabel("UNIDAD DE MEDIDA");
		lbl_unidadMedida.setBounds(125, 94, 111, 14);
		
		JComboBox combo_medidas = new JComboBox();
		combo_medidas.setBounds(265, 91, 160, 20);
		combo_medidas.setModel(new DefaultComboBoxModel(UM.values()));
		
		
		JLabel lbl_peso = new JLabel("PESO");
		lbl_peso.setBounds(520, 134, 91, 14);
		
		JTextField txt_peso = new JTextField();
		txt_peso.setBounds(657, 131, 168, 20);
		txt_peso.setColumns(10);
		
		JFormattedTextField ftxt_descripcion = new JFormattedTextField();
		ftxt_descripcion.setBounds(265, 30, 560, 45);
		
		ftxt_descripcion.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') &&(c < 'a' || c > 'z') &&(c < 'A' || c > 'Z')) e.consume();
				else if(ftxt_descripcion.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_descripcion.getText().substring(0,max);
					ftxt_descripcion.setText(shortened);
				}else if(ftxt_descripcion.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		
		
		JSpinner spinner_cantidad = new JSpinner();
		spinner_cantidad.setBounds(265, 131, 160, 20);
		
		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setBounds(125, 134, 135, 14);
		
		JLabel lbl_costoUnitario = new JLabel("COSTO UNITARIO");
		lbl_costoUnitario.setBounds(520, 94, 108, 14);
		
		JFormattedTextField ftxt_costoUnitario = new JFormattedTextField();
		ftxt_costoUnitario.setBounds(657, 91, 168, 20);
		
		ftxt_costoUnitario.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9')&& (c != '.')) e.consume();
				else if(ftxt_costoUnitario.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_costoUnitario.getText().substring(0,max);
					ftxt_costoUnitario.setText(shortened);
				}else if(ftxt_costoUnitario.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		JLabel lbl_densidad = new JLabel("DENSIDAD");
		lbl_densidad.setBounds(125, 176, 125, 14);
		
		JFormattedTextField ftxt_densidad = new JFormattedTextField();
		ftxt_densidad.setBounds(265, 173, 160, 20);
		ftxt_densidad.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9') && (c != '.')) e.consume();
				else if(ftxt_densidad.getText().length() > max+1) {
					e.consume();
					String shortened = ftxt_densidad.getText().substring(0,max);
					ftxt_densidad.setText(shortened);
				}else if(ftxt_densidad.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		
		setLayout(null);
		add(lbl_descripcion);
		add(lbl_cantidad);
		add(lbl_unidadMedida);
		add(lbl_densidad);
		add(ftxt_densidad);
		add(ftxt_descripcion);
		add(combo_medidas);
		add(spinner_cantidad);
		add(lbl_peso);
		add(lbl_costoUnitario);
		add(ftxt_costoUnitario);
		add(txt_peso);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 210, 702, 190);
		add(scrollPane);
		
		JTable tabla_camion = new JTable();
		tabla_camion.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_camion = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Id", "Descripcion", "Unidad Medida", "Costo Unitario", "Cantidad", "Peso", "Densidad"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_camion.setModel(model_tabla_camion);
		tabla_camion.getTableHeader().setReorderingAllowed(false);
		tabla_camion.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_camion);
		
		JButton btn_eliminar = new JButton("ELIMINAR INSUMO");
		btn_eliminar.setBounds(636, 411, 189, 40);
		btn_eliminar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_eliminar.setBorderPainted(false);
		btn_eliminar.setFocusPainted(false);
		btn_eliminar.setContentAreaFilled(true);
		btn_eliminar.setForeground(new Color(0, 0, 0));
		btn_eliminar.setBackground(new Color(80, 165, 94));
		add(btn_eliminar);
		
		
		
		JButton btn_buscar = new JButton("BUSCAR INSUMO");
		btn_buscar.setForeground(Color.BLACK);
		btn_buscar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscar.setFocusPainted(false);
		btn_buscar.setContentAreaFilled(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setBackground(new Color(80, 165, 94));
		btn_buscar.setBounds(657, 168, 168, 28);
		
		btn_buscar.addActionListener(e -> {
			//TO-DO  implementar  la busqueda 
		});
		
		add(btn_buscar);
	}
}