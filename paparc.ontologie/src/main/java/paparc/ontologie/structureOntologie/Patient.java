package paparc.ontologie.structureOntologie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Patient {
	private String id;
	private ArrayList<CoupleTopoMorpho> listeCancer;
	private ArrayList<CoupleTopoMorpho> listeCancerNonCat;
	private ArrayList<CoupleTopoMorpho> listeCancerPrimaire;
	private ArrayList<Boolean> listBool815;
	
	public Patient(String id, ArrayList<CoupleTopoMorpho>cancers) {
	    //Consumer<String> afficher = (String param) -> System.out.println(param);
	    System.out.println(cancers);
	    //cancers.forEach(cimo3Couple);
	    listeCancer = cancers;
	    listeCancerNonCat = listeCancer;
	    Collections.sort(listeCancerNonCat);
	    listeCancerPrimaire = new ArrayList<CoupleTopoMorpho>();
		listBool815 = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false,false,false));

	    for(CoupleTopoMorpho ctm  : listeCancerNonCat) {
	    	//if(ctm.getM())
	    }
		//listeCancer = new ArrayList<CoupleTopoMorpho>(cancers.forEach(cimo3Couple));
		
	}
	

}
