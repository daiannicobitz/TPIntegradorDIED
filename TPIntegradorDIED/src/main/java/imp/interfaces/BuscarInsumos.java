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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import imp.DTOs.InsumoDTO;
import imp.enumerators.UM;
import imp.gestores.GestorInsumo;

public class BuscarInsumos extends JPanel {
	
	private ArrayList<InsumoDTO> listaInsumosBuscados = new ArrayList<InsumoDTO>(); //esta definido aca para poder mostrarlo en el Jtable
	
	public BuscarInsumos() {	
		
		setBackground(new Color(118, 203, 117));
		
		
		setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 102, 849, 233);
		add(scrollPane);
		
		JTable tabla_insumo = new JTable();
		tabla_insumo.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_insumo = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
						"Descripcion", "Unidad Medida", "Costo Unitario", "Cantidad", "Peso", "Densidad", "Stock Total"
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
		
		
		
		JButton btn_buscar = new JButton("BUSCAR INSUMOS");
		btn_buscar.setForeground(Color.BLACK);
		btn_buscar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscar.setFocusPainted(false);
		btn_buscar.setContentAreaFilled(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setBackground(new Color(80, 165, 94));
		btn_buscar.setBounds(574, 29, 227, 34);
		
		btn_buscar.addActionListener(e -> {
			
			listaInsumosBuscados=GestorInsumo.visualizarTodosLosInsumos();
			
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
		
		add(btn_buscar);
		
		JLabel lbl_planta = new JLabel("PLANTA");
		lbl_planta.setBounds(66, 40, 46, 14);
		add(lbl_planta);
		
		JComboBox combo_plantas = new JComboBox();
		combo_plantas.setBounds(134, 36, 168, 22);
		add(combo_plantas);
	}
}
