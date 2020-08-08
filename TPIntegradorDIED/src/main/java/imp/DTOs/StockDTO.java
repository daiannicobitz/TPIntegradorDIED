package imp.DTOs;

import com.mysql.cj.util.DnsSrv.SrvRecord;

import imp.primaryClasses.Insumo;

public class StockDTO {
	
	private int id;
	private String stockEnPlanta;
	private String puntoPedido;
	private String nombreInsumo;
	private String nombrePlanta;
	private String stockTotal;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStockEnPlanta() {
		return stockEnPlanta;
	}
	
	public void setStockEnPlanta(String stockEnPlanta) {
		this.stockEnPlanta = stockEnPlanta;
	}
	
	public String getPuntoPedido() {
		return puntoPedido;
	}
	
	public void setPuntoPedido(String puntoPedido) {
		this.puntoPedido = puntoPedido;
	}
	
	public String getNombreInsumo() {
		return nombreInsumo;
	}
	
	public void setNombreInsumo(String nombreInsumo) {
		this.nombreInsumo = nombreInsumo;
	}
	
	public String getNombrePlanta() {
		return nombrePlanta;
	}
	
	public void setNombrePlanta(String nombrePlanta) {
		this.nombrePlanta = nombrePlanta;
	}
	
	public String getStockTotal() {
		return stockTotal;
	}
	
	public void setStockTotal(String stockTotal) {
		this.stockTotal = stockTotal;
	}
	
	public StockDTO(int id, String stockEnPlanta, String puntoPedido, String nombreInsumo, String nombrePlanta,
			String stockTotal) {
		super();
		this.id = id;
		this.stockEnPlanta = stockEnPlanta;
		this.puntoPedido = puntoPedido;
		this.nombreInsumo = nombreInsumo;
		this.nombrePlanta = nombrePlanta;
		this.stockTotal = stockTotal;
	}
	
	

}
