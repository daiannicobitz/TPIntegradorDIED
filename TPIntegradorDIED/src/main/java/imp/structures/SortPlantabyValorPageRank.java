package imp.structures;

import java.util.Comparator;

import imp.DTOs.PlantaDTO;

public class SortPlantabyValorPageRank implements  Comparator<imp.DTOs.PlantaDTO>{
	
    public int compare(PlantaDTO a, PlantaDTO b) 
    { 
        return a.getValorPagerank() - b.getValorPagerank(); 
    } 

}
