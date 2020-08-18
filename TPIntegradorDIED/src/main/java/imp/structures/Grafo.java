package imp.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import java.util.stream.Collectors;


import imp.gestores.GestorPlanta;
import imp.gestores.GestorRuta;
import imp.primaryClasses.Planta;



public class Grafo<Planta> {
	
	private static Grafo GRAFO;
	
	private List<Ruta<Planta>> rutas;
	private List<Vertice<Planta>> vertices;

	
	 public Grafo(List<Ruta<Planta>> rutas, List<Vertice<Planta>> vertices) {
		// TODO Auto-generated constructor stub
		 this.rutas=rutas;
		 this.vertices=vertices;
	}
	
	public  static Grafo getInstance() {
		 
		 if (GRAFO==null) {
			 
			 ArrayList<Vertice<imp.primaryClasses.Planta>> listaVertices = new ArrayList<Vertice<imp.primaryClasses.Planta>>();
			 ArrayList<imp.primaryClasses.Planta> plantas = GestorPlanta.BuscarTodasLasPlantas();
			 
			 for(imp.primaryClasses.Planta p : plantas) 
				 
				 listaVertices.add(new Vertice<imp.primaryClasses.Planta>(p));
			 
			 GRAFO = new Grafo(GestorRuta.BuscarTodasLasRutas(), listaVertices);
		 }
		 return GRAFO;
	}
	
	
	public Grafo(){
		this.rutas = new ArrayList<Ruta<Planta>>();
		this.vertices = new ArrayList<Vertice<Planta>>();
	}
	
	public List<Vertice<Planta>> vertices() {
		return this.vertices;
	}
	
	public void addNodo(Planta nodo){
		this.addNodo(new Vertice<Planta>(nodo));
	}

	private void addNodo(Vertice<Planta> nodo){
		this.vertices.add(nodo);
	}
	
	public void conectar(Planta n1,Planta n2){
		this.conectar(getNodo(n1), getNodo(n2), 1.0, 1.0, 1.0);
	}

	public void conectar(Planta n1,Planta n2,double distancia, double duracionRecorrido, double pesoMaximo){
		this.conectar(getNodo(n1), getNodo(n2), distancia, duracionRecorrido, pesoMaximo);
	}

	private void conectar(Vertice<Planta> nodo1,Vertice<Planta> nodo2, double distancia, double duracionRecorrido, double pesoMaximo){
		this.rutas.add(new Ruta<Planta>(nodo1,nodo2, distancia, duracionRecorrido, pesoMaximo));
	}
	
	public Vertice<Planta> getNodo(Planta valor){
		return this.vertices.get(this.vertices.indexOf(new Vertice<Planta>(valor)));
	}
	
	public Vertice<Planta> getNodo(int idPlanta){
		Vertice<Planta> vert = new Vertice<Planta>();
		for(Vertice<Planta> v : vertices) {
			if(idPlanta == ((imp.primaryClasses.Planta) v.getValor()).getId())
				return v;
		}
		return null;
	}

	public List<Planta> getAdyacentes(Planta valor){ 
		Vertice<Planta> unNodo = this.getNodo(valor);
		List<Planta> salida = new ArrayList<Planta>();
		for(Ruta<Planta> enlace : this.rutas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	public List<Vertice<Planta>> getAdyacentes(Vertice<Planta> unNodo){  //funciona
		List<Vertice<Planta>> salida = new ArrayList<Vertice<Planta>>();
		for(Ruta<Planta> enlace : this.rutas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida; 
	}
	
	
	public void imprimirRutas(){
		System.out.println(this.rutas.toString());
	}

	public Integer gradoEntrada(Vertice<Planta> vertice){
		Integer res =0;
		for(Ruta<Planta> arista : this.rutas){
			if(arista.getFin().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<Planta> vertice){
		Integer res =0;
		for(Ruta<Planta> arista : this.rutas){
			if(arista.getInicio().equals(vertice)) ++res;
		}
		return res;
	}
	public List<Planta> recorridoAnchura(Vertice<Planta> inicio){
		List<Planta> resultado = new ArrayList<Planta>();
		
		//estructuras auxiliares
		Queue<Vertice<Planta>> pendientes = new LinkedList<Vertice<Planta>>();
		HashSet<Vertice<Planta>> marcados = new HashSet<Vertice<Planta>>();
		marcados.add(inicio);
		pendientes.add(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<Planta> actual = pendientes.poll();
			List<Vertice<Planta>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<Planta> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
	
	public List<Planta> recorridoProfundidad(Vertice<Planta> inicio){
		List<Planta> resultado = new ArrayList<Planta>();
		Stack<Vertice<Planta>> pendientes = new Stack<Vertice<Planta>>();
		HashSet<Vertice<Planta>> marcados = new HashSet<Vertice<Planta>>();
		marcados.add(inicio);
		pendientes.push(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<Planta> actual = pendientes.pop();
			List<Vertice<Planta>> adyacentes = this.getAdyacentes(actual);
			resultado.add(actual.getValor());
			for(Vertice<Planta> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
 	
	public List<Planta> recorridoTopologico(){
		List<Planta> resultado = new ArrayList<Planta>();
		Map<Vertice<Planta>,Integer> gradosVertice = new HashMap<Vertice<Planta>,Integer>();
		for(Vertice<Planta> vert : this.vertices){
			gradosVertice.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertice.isEmpty()){
		
			List<Vertice<Planta>> nodosSinEntradas = gradosVertice.entrySet()
							.stream()
							.filter( x -> x.getValue()==0)
							.map( p -> p.getKey())
							.collect( Collectors.toList());
			
            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");
            
			for(Vertice<Planta> v : nodosSinEntradas){
            	resultado.add(v.getValor());
            	gradosVertice.remove(v);
            	for(Vertice<Planta> ady: this.getAdyacentes(v)){
            		gradosVertice.put(ady,gradosVertice.get(ady)-1);
            	}
            }
		}
		
		System.out.println(resultado);
		return resultado;
 	}
        
    private boolean esAdyacente(Vertice<Planta> v1,Vertice<Planta> v2){
    	List<Vertice<Planta>> ady = this.getAdyacentes(v1);
        for(Vertice<Planta> unAdy : ady){
        	if(unAdy.equals(v2)) return true;
        }
        return false;
    }
    
    
    public void actualizarGrafo() {
    	
    	 ArrayList<Vertice<imp.primaryClasses.Planta>> listaVertices = new ArrayList<Vertice<imp.primaryClasses.Planta>>();
		 ArrayList<imp.primaryClasses.Planta> plantas = GestorPlanta.BuscarTodasLasPlantas();
		 
		 for(imp.primaryClasses.Planta p : plantas) 
			 
			 listaVertices.add(new Vertice<imp.primaryClasses.Planta>(p));
		 
		 GRAFO = new Grafo(GestorRuta.BuscarTodasLasRutas(), listaVertices);
    }
    
    public List<List<String>> flujoMaximo (Vertice<Planta> inicio, Vertice<Planta> fin){
    	//va a devolver los nombres de la ruta y el último elemento va a ser el flujo máximo 
    	
    	List<List<String>> retorno = new ArrayList<List<String>>();
    	
    	List<Vertice<Planta>> listaAdyInicio =  this.getAdyacentes(inicio); 
    	
    	
    	List<List<Vertice<Planta>>> recorridos = getRecorridos(listaAdyInicio,inicio, fin); 

    		
    		for(int i = 0; i<recorridos.size();i++) {
    				
    				List<String> recorridoString = new ArrayList<String>();
    				List<Vertice<Planta>> recorrido = recorridos.get(i);
    				
    				for(int j = 0; j<recorrido.size();j++){
    					
    					if(j!= 0) {
    						Ruta ruta= rutaEntreDosPlantas(recorrido.get(j-1), recorrido.get(j));
    					
    						if(recorridoString.size() == 1) {
    							recorridoString.add(((imp.primaryClasses.Planta) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(Double.toString(ruta.getPesoMaximo()));
    						}else if(Double.parseDouble(recorridoString.get(recorridoString.size()-1)) > ruta.getPesoMaximo()) {
    							recorridoString.remove(recorridoString.size()-1);
    							recorridoString.add(((imp.primaryClasses.Planta) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(Double.toString(ruta.getPesoMaximo()));
    						}else {
    							String pesoMax = recorridoString.get(recorridoString.size()-1);
    							recorridoString.remove(recorridoString.size()-1);
    							recorridoString.add(((imp.primaryClasses.Planta) recorrido.get(j).getValor()).getNombre());
    							recorridoString.add(pesoMax);
    						}
    					}else {
    						recorridoString.add(((imp.primaryClasses.Planta) recorrido.get(j).getValor()).getNombre());
    					}
    				}
    				retorno.add(recorridoString);
    			}    	
    	
    	for(List<String> ls : retorno)
    		System.out.println(ls.toString());
    	return retorno;
    	
    }
    
    private List<List<Vertice<Planta>>> getRecorridos(List<Vertice<Planta>> listaAdy, Vertice<Planta> inicio, Vertice<Planta> fin) {
    	List<List<Vertice<Planta>>> retorno = new ArrayList<List<Vertice<Planta>>>();
    	
    	if(!listaAdy.isEmpty()) {
    		
    		for (Vertice<Planta> v : listaAdy) {
    		
    			if(v.equals(fin)) {
    				
    				List<Vertice<Planta>> recorrido = new ArrayList<Vertice<Planta>>();
    				recorrido.add(inicio);
    				recorrido.add(v);
    				retorno.add(recorrido);
    				
    			}else {
    				List<List<Vertice<Planta>>> listaSub = getRecorridos(this.getAdyacentes(v), v, fin);
    				if(!listaAdy.isEmpty()) {
    					for(List<Vertice<Planta>> ls : listaSub) {
    						
    						List<Vertice<Planta>> recorrido = new ArrayList<Vertice<Planta>>();
    						
    						recorrido.add(inicio);
    						recorrido.addAll(ls);
    						System.out.println(recorrido.toString());
    						retorno.add(recorrido);
    						
    						
    					}
    				}
    			}
    		}
    	}
		return retorno;
	}

	public Ruta rutaEntreDosPlantas(Vertice<Planta> inicio, Vertice<Planta> fin) {
    	for (Ruta r : this.rutas) {
    		if (r.getInicio().equals(inicio) && r.getFin().equals(fin)) return r;
    	}
		return null;
    }
	
	public double getDistanciaEntrePlantas(Vertice<Planta> inicio,Vertice<Planta> fin) {
		return rutaEntreDosPlantas(inicio, fin).getDistancia();
	}
	
	public double getDuracionEntrePlantas(Vertice<Planta> inicio,Vertice<Planta> fin) {
		return rutaEntreDosPlantas(inicio, fin).getDuracionRecorrido();
	}
	
	public List<String> caminoMinimoDistancia(Vertice<Planta> inicio,Vertice<Planta> fin) {
		List<String> retorno = new ArrayList<String>();
		
    	List<Vertice<Planta>> listaAdyInicio =  this.getAdyacentes(inicio); 
    	
    	List<List<Vertice<Planta>>> caminos = getRecorridos(listaAdyInicio,inicio, fin);
    	
    	Double distanciaMinima=null;
    	
    	for(int j=0;j<caminos.size();j++) {
    		
    		List<Vertice<Planta>> c = caminos.get(j);
    		Double distanciaMinimaAux = distanciaCamino(caminos.get(j));
    		
    		if(distanciaMinima==null) {
    			distanciaMinima = distanciaMinimaAux;
    			retorno = listaNombresPlantas(c);
    			retorno.add(distanciaMinima.toString());
    			
    		}else if(distanciaMinima > distanciaMinimaAux){
    			distanciaMinima = distanciaMinimaAux;
    			retorno = listaNombresPlantas(c);
    			retorno.add(distanciaMinima.toString());
    		}
    		
    	}
    	
		return retorno;
	}

	public List<String> caminoMinimoDuracion(Vertice<Planta> inicio, Vertice<Planta> fin) {
		
		List<String> retorno = new ArrayList<String>();
		
    	List<Vertice<Planta>> listaAdyInicio =  this.getAdyacentes(inicio); 
    	
    	List<List<Vertice<Planta>>> caminos = getRecorridos(listaAdyInicio,inicio, fin);
    	
    	Double duracionMinima=null;
    	for(int j=0;j<caminos.size();j++) {
    		
    		List<Vertice<Planta>> c = caminos.get(j);
    		Double duracionMinimaAux = duracionCamino(caminos.get(j));
    		
    		if(duracionMinima==null) {
    			duracionMinima = duracionMinimaAux;
    			retorno = listaNombresPlantas(c);
    			retorno.add(duracionMinima.toString());
    			
    		}else if(duracionMinima > duracionMinimaAux){
    			duracionMinima = duracionMinimaAux;
    			retorno = listaNombresPlantas(c);
    			retorno.add(duracionMinima.toString());
    		}
    		
    	}
		
		return retorno;
	}

	private List<String> listaNombresPlantas(List<Vertice<Planta>> listVertices) {
		List<String> ret = new ArrayList<String>();
		for(Vertice<Planta> v : listVertices)
			ret.add(((imp.primaryClasses.Planta) v.getValor()).getNombre());
		return ret;
	}

	private Double distanciaCamino(List<Vertice<Planta>> list) {
		Double distanciaMinima=null;
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosPlantas(list.get(i-1), list.get(i));
				if(distanciaMinima==null) {
					distanciaMinima=ruta.getDistancia();
				}else {
					distanciaMinima=distanciaMinima + ruta.getDistancia();
				}
			}
		}
		
		return distanciaMinima;
	}
	
	private Double duracionCamino(List<Vertice<Planta>> list) {
		
		Double duracionMinima=null;
		
		for(int i = 0; i<list.size(); i++) {
			if(i != 0) {
				Ruta ruta= rutaEntreDosPlantas(list.get(i-1), list.get(i));
				if(duracionMinima==null) {
					duracionMinima=ruta.getDuracionRecorrido();
				}else {
					duracionMinima=duracionMinima + ruta.getDuracionRecorrido();
				}
			}
		}
		
		return duracionMinima;
	}
	
	public int getPageRank(Vertice<Planta> v) {
		int pageRank = 0;

		for (Ruta r : rutas) {
			if (r.getFin().equals(v) ) {
				pageRank++;
			}
		}

		return pageRank;
	}

	public ArrayList<imp.DTOs.PlantaDTO> getPlantaPagerank() {
		ArrayList<imp.DTOs.PlantaDTO> listaRetorno = new ArrayList<imp.DTOs.PlantaDTO>();
		
		for(Vertice<Planta> v : vertices) {
			
			imp.DTOs.PlantaDTO planta = new imp.DTOs.PlantaDTO(0, ((imp.primaryClasses.Planta) v.getValor()).getNombre(),
					((imp.primaryClasses.Planta) v.getValor()).getTipo().toString());
			
			planta.setValorPagerank(getPageRank(v));
			
			listaRetorno.add(planta);
			
		}
		
		return listaRetorno;
	}
	
	public ArrayList<Planta> getPlantas(){
		
		ArrayList<Planta> plantas = new ArrayList<>();
		
		for(Vertice<Planta> v : this.vertices) {
			
			plantas.add(v.getValor());
			
		}
		
		return plantas;
		
	}
    
}