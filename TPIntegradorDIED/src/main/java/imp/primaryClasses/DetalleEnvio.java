package imp.primaryClasses;

public class DetalleEnvio {
	
	private double costoEnvio;
	private Camion camion;
	private Ruta rutaEnvio;
	
	public double getCostoEnvio() {
		return costoEnvio;
	}
	
	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}
	
	public Camion getCamion() {
		return camion;
	}
	
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	
	public Ruta getRutaEnvio() {
		return rutaEnvio;
	}
	
	public void setRutaEnvio(Ruta rutaEnvio) {
		this.rutaEnvio = rutaEnvio;
	}

	public DetalleEnvio(double costoEnvio, Camion camion, Ruta rutaEnvio) {
		super();
		this.costoEnvio = costoEnvio;
		this.camion = camion;
		this.rutaEnvio = rutaEnvio;
	}
	
	
}
