package imp.DTOs;

public class InsumoDTOFiltro {
	
//	Esta clase fue creada para buscar insumos con los siguientes atributos
	
	private String descripcion;
	private String unidadMedida;
	private String costoUnitario;
	
	public InsumoDTOFiltro(String descripcion, String unidadMedida, String costoUnitario) {
		super();
		this.descripcion = descripcion;
		this.unidadMedida = unidadMedida;
		this.costoUnitario = costoUnitario;
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
	
	

}
