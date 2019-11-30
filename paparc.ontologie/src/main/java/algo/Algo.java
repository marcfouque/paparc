package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import outils.CoupleTopoMorpho;
import outils.Groupe;

public class Algo {

	public static void main(String[] args) {
		Groupe grou = new Groupe();
		ArrayList<CoupleTopoMorpho> pcg = grou.getPCG();
		
		//set d'exemple
		HashMap<String,ArrayList<String>> patients = new HashMap<String,ArrayList<String>>();
		patients.put("patient1",new ArrayList<String>(Arrays.asList("C40.1M9870/3","C39.1M9040/3","C42.1M8840/3")));
		patients.put("patient2",new ArrayList<String>(Arrays.asList("C42.1M9870/3","C42.1M9040/3","C42.1M8840/3")));
		patients.put("patient3",new ArrayList<String>(Arrays.asList("C40.1M9570/3","C12.1M9840/3","C12.1M8840/3")));
		patients.put("patient4",new ArrayList<String>(Arrays.asList("C40.1M9040/3","C30.1M9040/3","C37.1M9040/3")));
		
		ArrayList<Patient> listePatients = new ArrayList<Patient>();
	    
		//passage liste cimo3 par patient à liste de patient chacun contenant leurs cancers primaires
		for(String p : patients.keySet()){
				ArrayList<CoupleTopoMorpho>temp = new ArrayList<CoupleTopoMorpho>();
				for(String c : patients.get(p)) {
					boolean b = true;
					ArrayList<String> al = new ArrayList<String>(Arrays.asList(grou.getGrpTopoFromCimo3(c.split("M")[0]),grou.getGrpMorphoFromCimo3(c.split("M")[1].substring(0, 4)),c.split("M")[0],c.split("M")[1].substring(0, 4)));
					
					if(al.get(0)!="nope" && al.get(1)!="nope")temp.add(new CoupleTopoMorpho(al.get(0),al.get(1),al.get(2),al.get(3)));
					else System.out.println(p+" : code cimo3 non reconnu, "+c+"\n\ttopo : "+grou.getGrpTopoFromCimo3(c.split("M")[0])+"\t"+c.split("M")[0]+"\n\tmorpho: "+grou.getGrpMorphoFromCimo3(c.split("M")[1].substring(0, 4))+"\t"+c.split("M")[1].substring(0, 4));
				}
			   listePatients.add(new Patient(p,temp));
			}
		
		System.out.println(listePatients.toString());
	}

}
