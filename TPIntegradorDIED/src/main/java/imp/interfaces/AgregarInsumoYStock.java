package imp.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.DTOs.InsumoDTO;
import imp.gestores.GestorInsumo;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarInsumoYStock extends JPanel {
	private ArrayList<InsumoDTO> listaInsumosBuscados = new ArrayList<InsumoDTO>(); //esta definido aca para poder mostrarlo en el Jtable
	

	public AgregarInsumoYStock() {

		setBackground(new Color(118, 203, 117));
		
		
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 66, 849, 233);
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
		btn_buscar.setBounds(57, 11, 227, 34);
		
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
		
		JLabel lbl_Planta = new JLabel("PLANTA");
		lbl_Planta.setBounds(606, 22, 46, 14);
		add(lbl_Planta);
		

		JTextField txt_planta = new JTextField();
		
		txt_planta.setEnabled(false);
		txt_planta.setBounds(662, 19, 244, 20);
		add(txt_planta);
		txt_planta.setColumns(10);
		
		JLabel lbl_insumoSeleccionado = new JLabel("INSUMO SELECCIONADO");
		lbl_insumoSeleccionado.setBounds(57, 321, 145, 14);
		add(lbl_insumoSeleccionado);
		
		JTextField txt_insumoSeleccionado = new JTextField();
		txt_insumoSeleccionado.setBounds(212, 318, 259, 20);
		add(txt_insumoSeleccionado);
		txt_insumoSeleccionado.setColumns(10);
		
		JLabel lbl_stockInsumo = new JLabel("STOCK DEL INSUMO PARA LA PLANTA ");
		lbl_stockInsumo.setBounds(57, 357, 201, 14);
		add(lbl_stockInsumo);
		
		JSpinner spinner_stockInsumo = new JSpinner();
		spinner_stockInsumo.setBounds(268, 354, 101, 20);
		add(spinner_stockInsumo);
		
		JLabel lblNewLabel = new JLabel("PUNTO PEDIDO");
		lblNewLabel.setBounds(435, 357, 101, 14);
		add(lblNewLabel);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(546, 354, 101, 20);
		add(spinner_1);
		
		JButton btn_agregarInsumo = new JButton("AGREGAR INSUMO");
		btn_agregarInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_agregarInsumo.setForeground(Color.BLACK);
		btn_agregarInsumo.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_agregarInsumo.setFocusPainted(false);
		btn_agregarInsumo.setContentAreaFilled(true);
		btn_agregarInsumo.setBorderPainted(false);
		btn_agregarInsumo.setBackground(new Color(80, 165, 94));
		btn_agregarInsumo.setBounds(603, 400, 162, 34);
		add(btn_agregarInsumo);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setForeground(Color.BLACK);
		btn_cancelar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setBackground(new Color(80, 165, 94));
		btn_cancelar.setBounds(775, 400, 131, 34);
		add(btn_cancelar);
	}
}
