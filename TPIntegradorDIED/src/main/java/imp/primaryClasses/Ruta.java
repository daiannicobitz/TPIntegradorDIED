package imp.primaryClasses;

public class Ruta {
	
	private Planta plantaOrigen;
	private Planta plantaDestino;
	private double distancia;
	private double duracionRecorrido; //expresado en horas
	private double pesoMaximo;
	
	
	public Planta getPlantaOrigen() {
		return plantaOrigen;
	}
	
	public void setPlantaOrigen(Planta plantaOrigen) {
		this.plantaOrigen = plantaOrigen;
	}
	
	public Planta getPlantaDestino() {
		return plantaDestino;
	}
	
	public void setPlantaDestino(Planta plantaDestino) {
		this.plantaDestino = plantaDestino;
	}
	
	public double getDistancia() {
		return distancia;
	}
	
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public double getDuracionRecorrido() {
		return duracionRecorrido;
	}
	
	public void setDuracionRecorrido(double duracionRecorrido) {
		this.duracionRecorrido = duracionRecorrido;
	}
	
	public double getPesoMaximo() {
		return pesoMaximo;
	}
	
	public void setPesoMaximo(double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}
	
	public Ruta(Planta plantaOrigen, Planta plantaDestino, double distancia, double duracionRecorrido,
			double pesoMaximo) {
		super();
		this.plantaOrigen = plantaOrigen;
		this.plantaDestino = plantaDestino;
		this.distancia = distancia;
		this.duracionRecorrido = duracionRecorrido;
		this.pesoMaximo = pesoMaximo;
	}

}


