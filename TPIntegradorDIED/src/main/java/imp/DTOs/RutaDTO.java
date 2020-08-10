package imp.DTOs;


public class RutaDTO {
	
	private int id;
	private String nombrePlantaOrigen;
	private String nombrePlantaDestino;
	private String distancia;
	private String duracionRecorrido; //expresado en horas
	private String pesoMaximo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id =id;
	}
	
	public String getNombrePlantaOrigen() {
		return nombrePlantaOrigen;
	}
	
	public void setNombrePlantaOrigen(String nombrePlantaOrigen) {
		this.nombrePlantaOrigen = nombrePlantaOrigen;
	}
	
	public String getNombrePlantaDestino() {
		return nombrePlantaDestino;
	}
	
	public void setNombrePlantaDestino(String nombrePlantaDestino) {
		this.nombrePlantaDestino = nombrePlantaDestino;
	}
	
	public String getDistancia() {
		return distancia;
	}
	
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	
	public String getDuracionRecorrido() {
		return duracionRecorrido;
	}
	
	public void setDuracionRecorrido(String duracionRecorrido) {
		this.duracionRecorrido = duracionRecorrido;
	}
	
	public String getPesoMaximo() {
		return pesoMaximo;
	}
	
	public void setPesoMaximo(String pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public RutaDTO(int id, String nombrePlantaOrigen, String nombrePlantaDestino, String distancia,
			String duracionRecorrido, String pesoMaximo) {
		
		super();
		this.id = id;
		this.nombrePlantaOrigen = nombrePlantaOrigen;
		this.nombrePlantaDestino = nombrePlantaDestino;
		this.distancia = distancia;
		this.duracionRecorrido = duracionRecorrido;
		this.pesoMaximo = pesoMaximo;
		
	}
	

}
