package imp.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.util.SupplierUtil;

import imp.primaryClasses.Planta;



public class Grafo<Planta> {
	
	private List<Ruta<Planta>> rutas;
	private List<Vertice<Planta>> vertices;


	
//	public void prueba(Planta p) {
//
//		DefaultDirectedWeightedGraph<Vertice<Planta>, Ruta<Planta>> grafo= new DefaultDirectedWeightedGraph<Vertice<Planta>, Ruta<Planta>>(SupplierUtil.createSupplier());
//		
//		this.grafo.addVertex(new Vertice<Planta>(p));
//		System.out.println(((imp.primaryClasses.Planta) this.grafo.getVertexSupplier().get().getValor()).getNombre(DefaultEdge.class));
//	}
	
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
	

	protected List<Vertice<Planta>> getAdyacentes(Vertice<Planta> unNodo){ 
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
}