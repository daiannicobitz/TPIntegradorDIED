package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import imp.DTOs.InsumoDTO;
import imp.DTOs.InsumoDTOFiltro;
import imp.enumerators.Marca;
import imp.enumerators.UM;
import imp.gestores.GestorInsumo;

public class DarBajaInsumo extends JPanel {
	
	private ArrayList<InsumoDTO> listaInsumosBuscados = new ArrayList<InsumoDTO>(); //esta definido aca para poder mostrarlo en el Jtable

	public DarBajaInsumo() {
		setBackground(new Color(118, 203, 117));

		JLabel lbl_descripcion = new JLabel("DESCRIPCION");
		lbl_descripcion.setBounds(125, 57, 91, 14);
		
		JLabel lbl_unidadMedida = new JLabel("UNIDAD DE MEDIDA");
		lbl_unidadMedida.setBounds(125, 118, 111, 14);
		
		JComboBox combo_medidas = new JComboBox();
		combo_medidas.setBounds(265, 115, 160, 20);
		combo_medidas.setModel(new DefaultComboBoxModel(UM.values()));
		
		JFormattedTextField ftxt_descripcion = new JFormattedTextField();
		ftxt_descripcion.setBounds(265, 42, 560, 45);
		
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
		
		JLabel lbl_costoUnitario = new JLabel("COSTO UNITARIO");
		lbl_costoUnitario.setBounds(510, 118, 108, 14);
		
		JFormattedTextField ftxt_costoUnitario = new JFormattedTextField();
		ftxt_costoUnitario.setBounds(657, 115, 168, 20);
		
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
		
		
		setLayout(null);
		add(lbl_descripcion);
		add(lbl_unidadMedida);
		add(ftxt_descripcion);
		add(combo_medidas);
		add(lbl_costoUnitario);
		add(ftxt_costoUnitario);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 210, 702, 190);
		add(scrollPane);
		
		JTable tabla_insumo = new JTable();
		tabla_insumo.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_insumo = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
						"Descripcion", "Unidad Medida", "Costo Unitario", "Cantidad", "Peso", "Densidad"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_insumo.setModel(model_tabla_insumo);
		tabla_insumo.getTableHeader().setReorderingAllowed(false);
		tabla_insumo.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_insumo);
		
		JButton btn_eliminar = new JButton("ELIMINAR INSUMO");
		btn_eliminar.setBounds(636, 411, 189, 40);
		btn_eliminar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_eliminar.setBorderPainted(false);
		btn_eliminar.setFocusPainted(false);
		btn_eliminar.setContentAreaFilled(true);
		btn_eliminar.setForeground(new Color(0, 0, 0));
		btn_eliminar.setBackground(new Color(80, 165, 94));
		add(btn_eliminar);
		
		btn_eliminar.addActionListener(e -> {
			
			int posicionSeleccionadaTablaInsumo=tabla_insumo.getSelectedRow();
			GestorInsumo.eliminarInsumo(listaInsumosBuscados.get(posicionSeleccionadaTablaInsumo));
			JOptionPane.showMessageDialog(null, "El insumo se ha borrado correctamente.", "MENSAJE", JOptionPane.INFORMATION_MESSAGE );
		});
		
		JButton btn_buscar = new JButton("BUSCAR INSUMO");
		btn_buscar.setForeground(Color.BLACK);
		btn_buscar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscar.setFocusPainted(false);
		btn_buscar.setContentAreaFilled(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setBackground(new Color(80, 165, 94));
		btn_buscar.setBounds(657, 168, 168, 28);
		add(btn_buscar);
		
		btn_buscar.addActionListener(e -> {
			
			InsumoDTOFiltro insumoFiltro = new InsumoDTOFiltro(ftxt_descripcion.getText(), combo_medidas.getSelectedItem().toString(),ftxt_costoUnitario.getText());
			listaInsumosBuscados= GestorInsumo.buscarInsumosConFiltro(insumoFiltro);
			
			int cantInsumo=listaInsumosBuscados.size();
			int fila=0;
			
			Object[][] listaMuestra = new Object[cantInsumo][6];
			
			for(InsumoDTO c:listaInsumosBuscados) {

				listaMuestra[fila][0] = c.getDescripcion();
				listaMuestra[fila][1] = c.getUnidadMedida();
				listaMuestra[fila][2] = c.getCostoUnitario();
				listaMuestra[fila][3] = c.getCantidad();
				listaMuestra[fila][4] = c.getPeso();
				listaMuestra[fila][5] = c.getDensidad();
				fila++;
			}
			
			DefaultTableModel modelo = new DefaultTableModel(listaMuestra,new String[] {"Descripcion", "Unidad Medida", "Costo Unitario", "Cantidad", "Peso", "Densidad"}) {

				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int i, int i1) {
					return false;
				}
			};
			tabla_insumo.setModel(modelo);
			
		});
		
		
	}
}
