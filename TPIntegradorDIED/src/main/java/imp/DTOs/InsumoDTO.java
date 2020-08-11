package imp.DTOs;


public class InsumoDTO {
	
	private int id; // este atributo no se mostrará en pantalla, lo guardamos solamente para que en caso de editar o eliminar un insumo, se pueda buscar mas facil
	private String descripcion;
	private String unidadMedida;
	private String costoUnitario;
	private String cantidad;
	private String peso;
	private String densidad;
	
	
	
	public InsumoDTO(int id,String descripcion, String unidadMedida, String costoUnitario, String cantidad, String peso,
			String densidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.unidadMedida = unidadMedida;
		this.costoUnitario = costoUnitario;
		this.cantidad = cantidad;
		this.peso = peso;
		this.densidad = densidad;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getUnidadMedida() {
		return unidadMedida;
	}
	
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	public String getCostoUnitario() {
		return costoUnitario;
	}
	
	public void setCostoUnitario(String costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	public String getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	public String getDensidad() {
		return densidad;
	}
	
	public void setDensidad(String densidad) {
		this.densidad = densidad;
	}
	
	
}
