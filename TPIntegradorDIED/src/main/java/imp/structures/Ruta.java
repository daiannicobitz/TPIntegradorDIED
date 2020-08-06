package imp.structures;

import imp.primaryClasses.*;

public class Ruta<Planta> {
	
	private int id;
	protected Vertice<Planta> inicio;
	protected Vertice<Planta> fin;
	private double distancia;
	public double duracionRecorrido; //expresado en horas
	public double pesoMaximo;
	

	public Ruta(){
		distancia=1.0;
		duracionRecorrido=1.0;
		pesoMaximo=1.0;
	} 
	
	public Ruta(Vertice<Planta> ini,Vertice<Planta> fin){
		this();
		this.inicio = ini;
		this.fin = fin;
	}

	public Ruta(Vertice<Planta> ini,Vertice<Planta> fin,double distancia, double duracionRecorrido, double pesoMaximo){
		this(ini,fin);
		this.distancia=  distancia;
		this.duracionRecorrido=  duracionRecorrido;
		this.pesoMaximo= pesoMaximo;
	}
	
	public Vertice<Planta> getInicio() {
		return inicio;
	}
	
	public void setInicio(Vertice<Planta> inicio) {
		this.inicio = inicio;
	}
	
	public Vertice<Planta> getFin() {
		return fin;
	}
	
	public void setFin(Vertice<Planta> fin) {
		this.fin = fin;
	}

	public Number getValor() {
		return distancia;
	}

	public void setValor(Number distancia) {
		this.distancia = (double) distancia;
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

	@Override
	public String toString() {
		return "( "+this.inicio.getValor().toString()+" --> "+this.fin.getValor().toString()+" )";
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Ruta<?>) && ((Ruta<?>)obj).getValor().equals(this.distancia); 
	}
}
