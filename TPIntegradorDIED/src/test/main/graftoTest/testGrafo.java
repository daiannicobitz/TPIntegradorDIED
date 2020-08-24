package graftoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import imp.enumerators.TipoPlanta;
import imp.primaryClasses.Planta;
import imp.primaryClasses.Stock;
import imp.structures.Grafo;

public class testGrafo {

	Grafo grafo;
	Planta planta1;
	Planta planta2;
	Planta planta3;
	Planta planta4;
	Planta planta5;
	Planta planta6;
	Planta planta7;
	Planta planta8;
	
	@Before
	public void setup() {
		
		grafo = new Grafo();
		
		 planta1 = new Planta(1, "inicio", TipoPlanta.ACOPIOINICIAL);
		ArrayList<Stock> listaStock1 = new ArrayList<>();
		Stock stock1 = new Stock(1, 1, 15, 0, 1);
		Stock stock2 = new Stock(2, 1, 25, 0, 2);
		listaStock1.add(stock1);
		listaStock1.add(stock2);
		planta1.setListaStock(listaStock1);
		
		 planta2 = new Planta(2, "salta", TipoPlanta.PRODUCCION);
		 planta3 = new Planta(3, "cordoba", TipoPlanta.PRODUCCION);
		 planta4 = new Planta(4, "mendoza", TipoPlanta.PRODUCCION);
		 planta5 = new Planta(5, "chaco", TipoPlanta.PRODUCCION);
		 planta6 = new Planta(6, "santa fe", TipoPlanta.PRODUCCION);
		ArrayList<Stock> listaStock6 = new ArrayList<>();
		Stock stock3 = new Stock(3, 6, 10, 0, 4);
		Stock stock4 = new Stock(4, 6, 20, 0, 5);
		listaStock1.add(stock3);
		listaStock1.add(stock4);
		planta6.setListaStock(listaStock6);
		
		 planta7 = new Planta(7, "misiones", TipoPlanta.PRODUCCION);
		 planta8 = new Planta(8, "formosa", TipoPlanta.ACOPIOFINAL);

		grafo.addNodo(planta1);
		grafo.addNodo(planta2);
		grafo.addNodo(planta3);
		grafo.addNodo(planta4);
		grafo.addNodo(planta5);
		grafo.addNodo(planta6);
		grafo.addNodo(planta7);
		grafo.addNodo(planta8);

		grafo.conectar(planta1, planta2, 12, 1.5, 12);
		grafo.conectar(planta1, planta3, 15, 2, 8);
		grafo.conectar(planta2, planta5, 40, 3, 10);
		grafo.conectar(planta5, planta7, 5, 1, 5);
		grafo.conectar(planta7, planta8, 43, 3, 3);
		grafo.conectar(planta3, planta4, 10, 1, 14);
		grafo.conectar(planta3, planta6, 35, 3, 9);
		grafo.conectar(planta6, planta7, 50, 5, 7);
		grafo.conectar(planta4, planta7, 15, 1.5, 4);
		grafo.conectar(planta4, planta2, 30, 2.5, 6);
	
	}
	

	@Test
	public void testgetPlantaPageRank() {
		
		assertEquals(1, grafo.getPageRank(planta8));
		assertEquals(3, grafo.getPageRank(planta7));
		assertEquals(2, grafo.getPageRank(planta2));

	}
	@Test
	public void testFlujoMaximo() {
		
		assertEquals(14.0, (Double) grafo.flujoMaximoValor(planta3, planta4).get(0), 0);
		assertEquals(4.0, (Double)grafo.flujoMaximoValor(planta3, planta7).get(0), 0);
		assertEquals(5.0, (Double)grafo.flujoMaximoValor(planta3, planta7).get(1), 0);
		assertEquals(7.0, (Double)grafo.flujoMaximoValor(planta3, planta7).get(2), 0);
	}
	
	@Test
	public void testcaminoMinimoDistacia() {
		List<String> ls = (List<String>) grafo.caminoMinimoDistancia(planta1, planta7).get(0);
		assertEquals(40.0, Double.parseDouble(ls.subList(ls.size()-1, ls.size()).get(0)), 0);
		
		
	}
	
	@Test
	public void testcaminoMinimoDuracion() {
		List<String> ls = (List<String>) grafo.caminoMinimoDuracion(planta1, planta7).get(0);
		assertEquals(4.5, Double.parseDouble(ls.subList(ls.size()-1, ls.size()).get(0)), 0);
		
		
	}
	
}
