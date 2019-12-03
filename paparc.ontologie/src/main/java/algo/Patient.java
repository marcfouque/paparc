package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import outils.CoupleTopoMorpho;

public class Patient {
	private String id;
	//private ArrayList<CoupleTopoMorpho> listeCancer;
	private ArrayList<CoupleTopoMorpho> listeCancerNonCat;
	private ArrayList<CoupleTopoMorpho> listeCancerPrimaire;
	//private ArrayList<Boolean> listBool815;
	
	public Patient(String id, ArrayList<CoupleTopoMorpho>cancers) {
	    //Consumer<String> afficher = (String param) -> System.out.println(param);
		this.id=id;
	    //System.out.println(cancers);
	    //cancers.forEach(cimo3Couple);
	    //listeCancer = cancers;
	    //listeCancerNonCat = listeCancer;
		listeCancerNonCat = cancers;
	    Collections.sort(listeCancerNonCat);
	    listeCancerPrimaire = new ArrayList<CoupleTopoMorpho>();
	    
	    //System.out.println(listeCancer);
	    //System.out.println(listeCancerNonCat);
	    
	    
	    ArrayList<Boolean> listBool815 = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false,false,false));
		/*HashMap<Integer,ArrayList<Integer>> derniereRegle = new HashMap<Integer,ArrayList<Integer>>();
		derniereRegle.put(5,new ArrayList<Integer>());
		derniereRegle.put(14,new ArrayList<Integer>());
		derniereRegle.put(17,new ArrayList<Integer>());
		*/
		
	    for(CoupleTopoMorpho ctm  : listeCancerNonCat) {
	    	boolean ajouter = true;
	    	
	    	//pas de doublon
	    	if(listeCancerPrimaire.contains(ctm))ajouter=false;
	    	
	    	//derniere regle dernier § 
	    	
	    	//si morpho non specifique et qu'une morpho plus spécifique est présente dans la liste de cancers primaires, on n'ajoute pas la morpho non-spécifique
	    	if(ctm.getM()==5) {
	    		for(CoupleTopoMorpho cp  : listeCancerPrimaire) {	//recherche de topo identiques parmi les cancers primaires, 
	    			if(cp.getT()==ctm.getT() && cp.morphoRetrieve(1,2,3,4))ajouter=false;			//si un existe alors pas d'ajout du cancer non specifique
	    		}
	    	}
	    	else if(ctm.getM()==14) {
	    		for(CoupleTopoMorpho cp  : listeCancerPrimaire) {	//recherche de topo identiques parmi les cancers primaires, 
	    			if(cp.getT()==ctm.getT() && cp.morphoRetrieve(8,9,10,11,12,13))ajouter=false;			//si un existe alors pas d'ajout du cancer non specifique
	    		}
	    	}
	    	else if(ctm.getM()==17) {	//si ctm est de morpho 17
	    		for(CoupleTopoMorpho cp  : listeCancerPrimaire) {	//recherche de topo identiques parmi les cancers primaires, 
	    			if(cp.getT()==ctm.getT())ajouter=false;			//si un existe alors pas d'ajout du cancer non specifique
	    		}
	    	}
	    	
	    	//si est ajoutable et morpho plus specifique et qu'un cancer non specifique de la meme topo existe alors suppression du non specifique
	    	if(ajouter && ctm.morphoRetrieve(1,2,3,4) && listeCancerPrimaire.contains(new CoupleTopoMorpho(Integer.toString(ctm.getT()), "5")))listeCancerPrimaire.remove(new CoupleTopoMorpho(Integer.toString(ctm.getT()), "5"));
	    	else if(ajouter && ctm.morphoRetrieve(8,9,10,11,12,13) && listeCancerPrimaire.contains(new CoupleTopoMorpho(Integer.toString(ctm.getT()), "14")))listeCancerPrimaire.remove(new CoupleTopoMorpho(Integer.toString(ctm.getT()), "14"));
	    	else if(ajouter && listeCancerPrimaire.contains(new CoupleTopoMorpho(Integer.toString(ctm.getT()), "17")))listeCancerPrimaire.remove(new CoupleTopoMorpho(Integer.toString(ctm.getT()), "17"));
	    	
	    	//si topo non specifique et qu'une topo plus spécifique est présente dans la liste de cancers primaires, on n'ajoute pas la topo non-spécifique
	    	if(ctm.getT()==54) {	//si ctm est de topo 54 (non spécifique)
	    		for(CoupleTopoMorpho cp  : listeCancerPrimaire) {	//recherche de morpho identiques parmi les cancers primaires, 
	    			if(cp.getM()==ctm.getM())ajouter=false;			//si un existe alors pas d'ajout du cancer non specifique
	    		}
	    	}
	    	//si est ajoutable et topo plus specifique et qu'un cancer non specifique de la meme morpho existe alors suppression du non specifique
	    	if(ajouter && listeCancerPrimaire.contains(new CoupleTopoMorpho("54", Integer.toString(ctm.getT())))) {
	    		listeCancerPrimaire.remove(new CoupleTopoMorpho("54", Integer.toString(ctm.getT())));
	    		listBool815.set( ctm.getM()-8, false );
	    		}
	    	
	    	//regle 4.1
	    	if(ctm.getM()>7 && ctm.getM()<16) {//si morpho entre 8 et 15
	    		if(listBool815.get(ctm.getM()-8)) {ajouter = false;}//si deja ajouté alors on ajoute pas
	    		else {listBool815.set( ctm.getM()-8, true );}//si pas encore ajouter, on ajoute et on passe le bool a true
	    	}
	    	
	    	if(ajouter)listeCancerPrimaire.add(ctm);
	    }
		//listeCancer = new ArrayList<CoupleTopoMorpho>(cancers.forEach(cimo3Couple));
		//System.out.println(listeCancerPrimaire);
	}
	
	public ArrayList<CoupleTopoMorpho> applicationRegle2(ArrayList<CoupleTopoMorpho> cancers) {
		//retour de la liste sans les extensions les recurrences et les metstases
		ArrayList<CoupleTopoMorpho> listeCancersSansExtRecOuMeta = cancers;
		
		return cancers;
	}
	
	@Override
	public String toString() {
		return "\nPatient : "+this.id+"\n\tliste cancers :\t\t"+listeCancerNonCat.toString()+"\n\tListe cancers Primaire :\t"+listeCancerPrimaire.toString();
	}

}
