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

import imp.primaryClasses.Planta;
import imp.primaryClasses.Ruta;

public class Grafo {
		private List<Ruta> rutas;
		private List<Planta> plantas;

		public Grafo(){
			this.rutas = new ArrayList<Ruta>();
			this.plantas = new ArrayList<Planta>();
		}
		
		public List<Planta> vertices() {
			return this.plantas;
		}

		private void addNodo(Planta nodo){
			this.plantas.add(nodo);
		}
		
//		public void conectar(Planta n1,Planta n2){
//			this.conectar(getNodo(n1), getNodo(n2), 1.0);
//		}

//		public void conectar(Planta n1,Planta n2,Number valor){
//			this.conectar(getNodo(n1), getNodo(n2), valor);
//		}

		private void conectar(Planta nodo1,Planta nodo2,double distancia, double duracionRecorrido, double pesoMaximo){
			this.rutas.add(new Ruta(nodo1,nodo2, distancia, duracionRecorrido, pesoMaximo));
		}
		
		public Planta getNodo(Planta valor){
			return this.plantas.get(this.plantas.indexOf(valor));
		}

//		public List<Planta> getAdyacentes(Planta valor){ 
//			Planta unNodo = this.getNodo(valor);
//			List<Planta> salida = new ArrayList<Planta>();
//			for(Ruta enlace : this.rutas){
//				if( enlace.getPlantaOrigen().equals(unNodo)){
//					salida.add(enlace.getPlantaDestino());
//				}
//			}
//			return salida;
//		}
		
//	ESTE METODO ME DEVUELVE UNA LISTA DE PLANTAS A LAS CUALES PUEDO LLEGAR POR MEDIO DE PLANTA
		protected List<Planta> getAdyacentes(Planta planta){ 
			List<Planta> salida = new ArrayList<Planta>();
			for(Ruta enlace : this.rutas){
				if( enlace.getPlantaOrigen().equals(planta)){
					salida.add(enlace.getPlantaDestino());
				}
			}
			return salida;
		}
		
		public void imprimirAristas(){
			System.out.println(this.rutas.toString());
		}

		public Integer gradoEntrada(Planta vertice){
			Integer res =0;
			for(Ruta arista : this.rutas){
				if(arista.getPlantaDestino().equals(vertice)) ++res;
			}
			return res;
		}

		public Integer gradoSalida(Planta vertice){
			Integer res =0;
			for(Ruta arista : this.rutas){
				if(arista.getPlantaOrigen().equals(vertice)) ++res;
			}
			return res;
		}
		
		public List<Planta> recorridoAnchura(Planta inicio){
			List<Planta> resultado = new ArrayList<Planta>();
			
			//estructuras auxiliares
			Queue<Planta> pendientes = new LinkedList<Planta>();
			HashSet<Planta> marcados = new HashSet<Planta>();
			marcados.add(inicio);
			pendientes.add(inicio);
			
			while(!pendientes.isEmpty()){
				Planta actual = pendientes.poll();
				List<Planta> adyacentes = this.getAdyacentes(actual);
				resultado.add(actual);
				for(Planta v : adyacentes){
					if(!marcados.contains(v)){ 
						pendientes.add(v);
						marcados.add(v);
					}
				}
			}		
			//System.out.println(resultado);
			return resultado;
	 	}
		
		public List<Planta> recorridoProfundidad(Planta inicio){
			List<Planta> resultado = new ArrayList<Planta>();
			Stack<Planta> pendientes = new Stack<Planta>();
			HashSet<Planta> marcados = new HashSet<Planta>();
			marcados.add(inicio);
			pendientes.push(inicio);
			
			while(!pendientes.isEmpty()){
				Planta actual = pendientes.pop();
				List<Planta> adyacentes = this.getAdyacentes(actual);
				resultado.add(actual);
				for(Planta v : adyacentes){
					if(!marcados.contains(v)){ 
						pendientes.push(v);
						marcados.add(v);
					}
				}
			}		
			//System.out.println(resultado);
			return resultado;
	 	}
	 	
//		public List<Planta> recorridoTopologico(){
//			List<Planta> resultado = new ArrayList<Planta>();
//			Map<Planta,Integer> gradosVertice = new HashMap<Planta,Integer>();
//			for(Planta vert : this.plantas){
//				gradosVertice.put(vert, this.gradoEntrada(vert));
//			}
//			while(!gradosVertice.isEmpty()){
//			
//				List<Planta<Planta>> nodosSinEntradas = gradosVertice.entrySet()
//								.stream()
//								.filter( x -> x.getValue()==0)
//								.map( p -> p.getKey())
//								.collect( Collectors.toList());
//				
//	            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");
//	            
//				for(Planta<Planta> v : nodosSinEntradas){
//	            	resultado.add(v.getValor());
//	            	gradosVertice.remove(v);
//	            	for(Planta<Planta> ady: this.getAdyacentes(v)){
//	            		gradosVertice.put(ady,gradosVertice.get(ady)-1);
//	            	}
//	            }
//			}
//			
//			System.out.println(resultado);
//			return resultado;
//	 	}
	        
	    private boolean esAdyacente(Planta v1,Planta v2){
	    	List<Planta> ady = this.getAdyacentes(v1);
	        for(Planta unAdy : ady){
	        	if(unAdy.equals(v2)) return true;
	        }
	        return false;
	    }
	}