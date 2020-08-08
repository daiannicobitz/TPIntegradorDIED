package imp.interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

import imp.DAOs.DAOStock;
import imp.DTOs.InsumoDTO;
import imp.enumerators.Marca;
import imp.enumerators.TipoInsumo;
import imp.enumerators.TipoPlanta;
import imp.enumerators.UM;
import imp.gestores.GestorInsumo;
import imp.primaryClasses.Planta;
import imp.primaryClasses.Stock;
import imp.structures.Grafo;

public class DarAltaInsumo extends JPanel {
	
	public CardLayout c = new CardLayout();

	public DarAltaInsumo() {
		setBackground(new Color(118, 203, 117));

		JLabel lbl_descripcion = new JLabel("DESCRIPCION (*)");
		lbl_descripcion.setBounds(109, 76, 98, 14);

		JLabel lbl_unidadMedida = new JLabel("UNIDAD DE MEDIDA (*)");
		lbl_unidadMedida.setBounds(109, 141, 135, 14);

		JComboBox combo_medidas = new JComboBox();
		combo_medidas.setBounds(237, 138, 160, 20);
		combo_medidas.setModel(new DefaultComboBoxModel(UM.values()));

		JLabel lbl_densidad = new JLabel("DENSIDAD");
		lbl_densidad.setBounds(109, 287, 125, 14);

		JFormattedTextField ftxt_densidad = new JFormattedTextField();
		ftxt_densidad.setBounds(237, 284, 160, 20);
		ftxt_densidad.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && (c != '.'))
					e.consume();
				else if (ftxt_densidad.getText().length() > max + 1) {
					e.consume();
					String shortened = ftxt_densidad.getText().substring(0, max);
					ftxt_densidad.setText(shortened);
				} else if (ftxt_densidad.getText().length() > max) {
					e.consume();
				}
			}
		});

		JLabel lbl_peso = new JLabel("PESO");
		lbl_peso.setBounds(478, 206, 91, 14);

		JFormattedTextField ftxt_peso = new JFormattedTextField();
		ftxt_peso.setBounds(616, 203, 168, 20);
		ftxt_peso.setColumns(10);
		ftxt_peso.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && (c != '.'))
					e.consume();
				else if (ftxt_peso.getText().length() > max + 1) {
					e.consume();
					String shortened = ftxt_peso.getText().substring(0, max);
					ftxt_peso.setText(shortened);
				} else if (ftxt_peso.getText().length() > max) {
					e.consume();
				}
			}
		});

		JFormattedTextField ftxt_descripcion = new JFormattedTextField();
		ftxt_descripcion.setBounds(237, 61, 560, 45);

		ftxt_descripcion.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z'))
					e.consume();
				else if (ftxt_descripcion.getText().length() > max + 1) {
					e.consume();
					String shortened = ftxt_descripcion.getText().substring(0, max);
					ftxt_descripcion.setText(shortened);
				} else if (ftxt_descripcion.getText().length() > max) {
					e.consume();
				}
			}
		});

		JSpinner spinner_cantidad = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 1000000.0, 0.1));
		spinner_cantidad.setBounds(237, 203, 160, 20);

		JLabel lbl_cantidad = new JLabel("CANTIDAD");
		lbl_cantidad.setBounds(109, 206, 135, 14);

		JLabel lbl_costoUnitario = new JLabel("COSTO UNITARIO (*)");
		lbl_costoUnitario.setBounds(478, 144, 128, 14);

		JFormattedTextField ftxt_costoUnitario = new JFormattedTextField();
		ftxt_costoUnitario.setBounds(616, 141, 168, 20);

		ftxt_costoUnitario.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				int max = 10;
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && (c != '.'))
					e.consume();
				else if (ftxt_costoUnitario.getText().length() > max + 1) {
					e.consume();
					String shortened = ftxt_costoUnitario.getText().substring(0, max);
					ftxt_costoUnitario.setText(shortened);
				} else if (ftxt_costoUnitario.getText().length() > max) {
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
		add(ftxt_peso);

		ftxt_densidad.setEnabled(false);
		ftxt_descripcion.setEnabled(false);
		combo_medidas.setEnabled(false);
		spinner_cantidad.setEnabled(false);
		ftxt_costoUnitario.setEnabled(false);
		ftxt_peso.setEnabled(false);

		JButton btn_tipo_insumo_liquido = new JButton("LIQUIDO");
		
		btn_tipo_insumo_liquido.setBounds(407, 11, 98, 40);
		btn_tipo_insumo_liquido.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_tipo_insumo_liquido.setBorderPainted(false);
		btn_tipo_insumo_liquido.setFocusPainted(false);
		btn_tipo_insumo_liquido.setContentAreaFilled(true);
		btn_tipo_insumo_liquido.setForeground(new Color(0, 0, 0));
		btn_tipo_insumo_liquido.setBackground(new Color(80, 165, 94));


		JButton btn_tipo_insumo_general = new JButton("GENERAL");
		btn_tipo_insumo_general.setBounds(557, 11, 98, 40);
		btn_tipo_insumo_general.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_tipo_insumo_general.setBorderPainted(false);
		btn_tipo_insumo_general.setForeground(new Color(0, 0, 0));
		btn_tipo_insumo_general.setBackground(new Color(80, 165, 94));
		
		btn_tipo_insumo_liquido.setBounds(434, 11, 87, 29);
		btn_tipo_insumo_liquido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_tipo_insumo_liquido.setEnabled(false);
				btn_tipo_insumo_general.setEnabled(true);
				ftxt_densidad.setEnabled(true);
				ftxt_descripcion.setEnabled(true);
				combo_medidas.setEnabled(true);
				spinner_cantidad.setEnabled(true);
				ftxt_costoUnitario.setEnabled(true);
				ftxt_peso.setEnabled(false);

			}
		});
		add(btn_tipo_insumo_liquido);

		btn_tipo_insumo_general.setBounds(521, 11, 87, 29);
		btn_tipo_insumo_general.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btn_tipo_insumo_general.setEnabled(false);
				btn_tipo_insumo_liquido.setEnabled(true);
				ftxt_densidad.setEnabled(false);
				ftxt_descripcion.setEnabled(true);
				combo_medidas.setEnabled(true);
				spinner_cantidad.setEnabled(true);
				ftxt_costoUnitario.setEnabled(true);
				ftxt_peso.setEnabled(true);

			}
		});
		add(btn_tipo_insumo_general);

		JButton btn_aceptar = new JButton("ACEPTAR");
		btn_aceptar.setBounds(616, 342, 98, 40);
		btn_aceptar.setFont(new Font("Montserrat", Font.ITALIC, 11));
		btn_aceptar.setBorderPainted(false);
		btn_aceptar.setFocusPainted(false);
		btn_aceptar.setContentAreaFilled(true);
		btn_aceptar.setForeground(new Color(0, 0, 0));
		btn_aceptar.setBackground(new Color(80, 165, 94));
		add(btn_aceptar);

		btn_aceptar.addActionListener(e -> {
			InsumoDTO insumodto = null;
			if (ftxt_densidad.isEnabled()) { 
				insumodto = new InsumoDTO(0, ftxt_descripcion.getText(), combo_medidas.getSelectedItem().toString(),
						ftxt_costoUnitario.getText(), spinner_cantidad.getValue().toString(), null,
						ftxt_densidad.getText());
			} else {
				
				insumodto = new InsumoDTO(0, ftxt_descripcion.getText(), combo_medidas.getSelectedItem().toString(),
						ftxt_costoUnitario.getText(), spinner_cantidad.getValue().toString(), ftxt_peso.getText(),
						"-");
				
			}

			if (insumodto.getDescripcion().isEmpty() || (combo_medidas.getSelectedIndex() == 0)
					|| insumodto.getCostoUnitario().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Todos los campos obligatorios (*) deben estan completos.",
						"ADVERTENCIA", JOptionPane.ERROR_MESSAGE);

			} else {

				GestorInsumo.darAltaInsumo(insumodto);
				int idInsumo = GestorInsumo.obtenerIdInsumo(insumodto);
				Stock stock = new Stock();
				
				stock.setCantidad(Integer.parseInt(insumodto.getCantidad()));
				stock.setInsumo(idInsumo);
				stock.setPuntoPedido(0);
				stock.setidPlanta(1);
				DAOStock.guardarStock(stock);
				
				Grafo plantas = Grafo.getInstance();
				Planta planta = new Planta(1, "Puerto", TipoPlanta.valueOf("AcopioInicial"));
				((Planta)plantas.getNodo(planta).getValor()).addStock(stock);
				
				
				JOptionPane.showMessageDialog(null, "El insumo se ha guardado correctamente.", "MENSAJE",
						JOptionPane.INFORMATION_MESSAGE);

			}

		});

		JButton btn_cancelar = new JButton("CANCELAR");
		btn_cancelar.setBounds(724, 342, 98, 40);
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
				c.show(padre, "inicioInsumo");
		});
		
		JLabel lbl_tipo_insumo = new JLabel("SELECCIONE EL TIPO DE INSUMO QUE DESEA GUARDAR:");
		lbl_tipo_insumo.setBounds(109, 18, 427, 14);
		add(lbl_tipo_insumo);

	}
}
