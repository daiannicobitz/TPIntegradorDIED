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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import imp.DTOs.InsumoDTO;
import imp.DTOs.InsumoDTOFiltro;
import imp.enumerators.UM;
import imp.gestores.GestorInsumo;
import javax.swing.JTextField;
import javax.swing.JViewport;

public class PopUpBuscarInsumoMasCantidad extends JFrame {
	
	private ArrayList<InsumoDTO> listaInsumosBuscados = new ArrayList<InsumoDTO>(); //esta definido aca para poder mostrarlo en el Jtable
	private InsumoDTO insumoDTOSelect;
	private JTextField textFieldCantidadSolicitar;
	
	public PopUpBuscarInsumoMasCantidad (DarAltaOrdenPedido darAltaOrdenPedido, ArrayList<Integer> idInsumos){
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(200, 200, 800, 540);
		setResizable(false);
		
		JPanel panel_buscarInsumo = new JPanel();
		panel_buscarInsumo.setBackground(new Color(118, 203, 117));
		
		JLabel lbl_descripcion = new JLabel("DESCRIPCION");
		lbl_descripcion.setBounds(52, 61, 91, 14);
		
		JLabel lbl_unidadMedida = new JLabel("UNIDAD DE MEDIDA");
		lbl_unidadMedida.setBounds(52, 122, 111, 14);
		
		JComboBox combo_medidas = new JComboBox();
		combo_medidas.setBounds(164, 119, 160, 20);
		combo_medidas.setModel(new DefaultComboBoxModel(UM.values()));
		
		JFormattedTextField ftxt_descripcion = new JFormattedTextField();
		ftxt_descripcion.setBounds(164, 46, 560, 45);
		
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
		lbl_costoUnitario.setBounds(438, 122, 108, 14);
		
		JFormattedTextField ftxt_costoUnitario = new JFormattedTextField();
		ftxt_costoUnitario.setBounds(556, 119, 168, 20);
		
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
		
		
		panel_buscarInsumo.setLayout(null);
		panel_buscarInsumo.add(lbl_descripcion);
		panel_buscarInsumo.add(lbl_unidadMedida);
		panel_buscarInsumo.add(ftxt_descripcion);
		panel_buscarInsumo.add(combo_medidas);
		panel_buscarInsumo.add(lbl_costoUnitario);
		panel_buscarInsumo.add(ftxt_costoUnitario);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 210, 722, 108);
		panel_buscarInsumo.add(scrollPane);
		
		JTable tabla_insumo = new JTable();
		tabla_insumo.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_insumo = new DefaultTableModel(
				new Object[][] {},
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
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(278, 409, 189, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		panel_buscarInsumo.add(btn_aceptar);
		
		btn_aceptar.addActionListener(e -> {
			try {
			insumoDTOSelect=listaInsumosBuscados.get(tabla_insumo.getSelectedRow());
			
			if(Integer.parseInt(textFieldCantidadSolicitar.getText()) <= Double.parseDouble(insumoDTOSelect.getCantidad())) {
				
				
			 JViewport viewport = ((JScrollPane) darAltaOrdenPedido.getComponent(9)).getViewport();
				
			 JTable mytable = (JTable)viewport.getView();
				
			 DefaultTableModel model = (DefaultTableModel) mytable.getModel();
			 
			 int cantfilas = model.getRowCount();
			 Double costo_total;
			 Boolean encontrado = false;
			 if(cantfilas > 0) {
			 for(int i=0; i<cantfilas; i++) {
				 if(model.getValueAt(i, 0).equals(insumoDTOSelect.getDescripcion())) {
					 Double cantidadtotal = Double.parseDouble(textFieldCantidadSolicitar.getText()) + Double.parseDouble( (String) model.getValueAt(i, 2));
					 costo_total = Double.parseDouble( (String) model.getValueAt(i, 3)) + (Double.parseDouble(insumoDTOSelect.getCostoUnitario()) * Integer.parseInt(textFieldCantidadSolicitar.getText()));
					 //model.addRow(new Object[] {insumoDTOSelect.getDescripcion() ,insumoDTOSelect.getCostoUnitario(), Double.toString(cantidadtotal), Double.toString(costo_total) });
					 model.setValueAt(insumoDTOSelect.getDescripcion(), i, 0);
					 model.setValueAt(insumoDTOSelect.getCostoUnitario(), i, 1);
					 model.setValueAt( Double.toString(cantidadtotal), i, 2);
					 model.setValueAt(Double.toString(costo_total), i, 3);
					 i = cantfilas;
					 encontrado = true;
				 }
			 }
			 if(encontrado ==false) {
				 costo_total = Double.parseDouble(insumoDTOSelect.getCostoUnitario()) * Integer.parseInt(textFieldCantidadSolicitar.getText());
				 
					model.addRow(new Object[] {insumoDTOSelect.getDescripcion() ,insumoDTOSelect.getCostoUnitario(), textFieldCantidadSolicitar.getText(), Double.toString(costo_total) });
					idInsumos.add(insumoDTOSelect.getId());
			 }
			 } else { 
			 
			 //"Id insumo", "Descripcion insumo", "Costo unitario", "Cantidad solicitada", "Costo total"
			 costo_total = Double.parseDouble(insumoDTOSelect.getCostoUnitario()) * Integer.parseInt(textFieldCantidadSolicitar.getText());
			 
			model.addRow(new Object[] {insumoDTOSelect.getDescripcion() ,insumoDTOSelect.getCostoUnitario(), textFieldCantidadSolicitar.getText(), Double.toString(costo_total) });
			idInsumos.add(insumoDTOSelect.getId());
			 }
			this.setVisible(false);
			
			} else {
				
				JOptionPane.showMessageDialog(null, "La cantidad a solicitar es mayor a la que hay disponible.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}
			}catch (IndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(null, "Usted todavia no ha seleccionado un insumo de la tabla.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}catch (NumberFormatException e1) {
				
				JOptionPane.showMessageDialog(null, "La cantidad a solicitar es mayor a la que hay disponible.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JButton btn_buscar = new JButton("BUSCAR INSUMO");
		btn_buscar.setForeground(Color.BLACK);
		btn_buscar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscar.setFocusPainted(false);
		btn_buscar.setContentAreaFilled(true);
		btn_buscar.setBorderPainted(false);
		btn_buscar.setBackground(new Color(80, 165, 94));
		btn_buscar.setBounds(556, 168, 168, 28);
		
		btn_buscar.addActionListener(e -> {
//			String medida = combo_medidas.getSelectedItem().toString();
//			if(medida.equals("SELECCIONE_UNIDAD")) {
//				medida = "";
//			}
//			String costoUnitario = ftxt_costoUnitario.getText();
//			if(!costoUnitario.matches("[0-9]*.[0-9]{2}") && !costoUnitario.matches("[0-9]*")){
//				
//				costoUnitario = "";
//			}
			
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
		
		panel_buscarInsumo.add(btn_buscar);
		
		getContentPane().add(panel_buscarInsumo);
		
		JLabel lblCantidadSolicitar = new JLabel("Cantidad a solicitar:");
		lblCantidadSolicitar.setBounds(501, 341, 120, 20);
		panel_buscarInsumo.add(lblCantidadSolicitar);
		
		textFieldCantidadSolicitar = new JTextField();
		textFieldCantidadSolicitar.setBounds(617, 341, 137, 20);
		panel_buscarInsumo.add(textFieldCantidadSolicitar);
		textFieldCantidadSolicitar.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if((c < '0' || c > '9')) e.consume();
				else if(textFieldCantidadSolicitar.getText().length() > max+1) {
					e.consume();
					String shortened = textFieldCantidadSolicitar.getText().substring(0,max);
					textFieldCantidadSolicitar.setText(shortened);
				}else if(textFieldCantidadSolicitar.getText().length() >max) {
					e.consume();
				}
			}
		});
		
		
	}

	public InsumoDTO getInsumoSeleccionado() {
		return this.insumoDTOSelect;
		
	}
}