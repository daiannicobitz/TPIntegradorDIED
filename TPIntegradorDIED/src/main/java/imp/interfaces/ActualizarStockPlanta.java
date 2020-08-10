package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class ActualizarStockPlanta extends JPanel {
	private JTextField textField;

	public CardLayout c = new CardLayout();

	public ActualizarStockPlanta() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 74, 772, 168);
		add(scrollPane);
		
		JTable tabla_insumos = new JTable();
		tabla_insumos.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_insumos = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"Nombre Planta", "Tipo Planta", "Insumo", "Stock en planta"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_insumos.setModel(model_tabla_insumos);
		tabla_insumos.getTableHeader().setReorderingAllowed(false);
		tabla_insumos.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_insumos);
		
		JLabel lbl_titulo = new JLabel("ACTUALIZAR STOCK EN LA PLANTA ");
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_titulo.setBounds(37, 28, 302, 14);
		add(lbl_titulo);
		
		JLabel lbl_insumo = new JLabel("INSUMO");
		lbl_insumo.setBounds(37, 265, 46, 14);
		add(lbl_insumo);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(108, 262, 170, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setBounds(319, 265, 79, 14);
		add(lbl_cantidad);
		
		JSpinner spinner_cantidad = new JSpinner();
		spinner_cantidad.setBounds(408, 262, 133, 20);
		add(spinner_cantidad);
		
		JSpinner spinner_puntoPedido = new JSpinner();
		spinner_puntoPedido.setBounds(676, 262, 133, 20);
		add(spinner_puntoPedido);
		
		JLabel lbl_puntoPedido = new JLabel("PUNTO PEDIDO");
		lbl_puntoPedido.setBounds(565, 265, 101, 14);
		add(lbl_puntoPedido);
		
		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setForeground(Color.BLACK);
		btn_aceptar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setBackground(new Color(80, 165, 94));
		btn_aceptar.setBounds(487, 328, 156, 41);
		add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setForeground(Color.BLACK);
		btn_cancelar.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_cancelar.setFocusPainted(false);
		btn_cancelar.setContentAreaFilled(true);
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.setBackground(new Color(80, 165, 94));
		btn_cancelar.setBounds(653, 328, 156, 41);
		add(btn_cancelar);

		btn_cancelar.addActionListener(e -> { 
			JPanel padre = (JPanel) this.getParent();
			 c = (CardLayout)(padre.getLayout());
				c.show(padre, "contenedor_buscarPlanta");
		});
	}
}
