package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import outils.CoupleTopoMorpho;
import outils.Groupe;

public class Algo {

	public static void main(String[] args) {
		Groupe grou = new Groupe();
		ArrayList<CoupleTopoMorpho> pcg = grou.getPCG();
		
		//set d'exemple de patient
		HashMap<String,ArrayList<String>> patients = new HashMap<String,ArrayList<String>>();
	    patients = exemplePatient();
	    
	    
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
		//listePatients.forEach((x)->System.out.println(x));
		
		
		enregistrementCP_sql(listePatients);
		
	}
	public static void enregistrementCP_sql(ArrayList<Patient> lp) {
		//commandes pour génération fichier sql de
		String stringPrint = "Drop table if exists CancerPrimaire;\n\nCreate table CancerPrimaire (\npatient int(6),\ntopo_IACR varchar(7),\nmorpho_IACR varchar(7)\n);\n\n";
		stringPrint +="Insert Into CancerPrimaire VALUES\n";
		for(Patient x : lp){stringPrint += x.printCPP();}
		stringPrint =stringPrint.substring(0,stringPrint.length()-2)+";";
		//listePatients.forEach((x)->);
		System.out.println("###############");
		System.out.println("###############");
		System.out.println(stringPrint);
		System.out.println("creation fichier");
		try {
			BufferedWriter f = new BufferedWriter(new FileWriter("./src/main/resources/cancerPrimaire.sql"));
		    f.write(stringPrint);
		    f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("fichier enregistré");

	}

	
	public static HashMap<String,ArrayList<String>> exemplePatient() {
		HashMap<String,ArrayList<String>> p = new HashMap<String,ArrayList<String>>();
		p.put("patient1",new ArrayList<String>(Arrays.asList("C00.6M9870/3","C02.1M9040/3","C05.8M8840/3","C06.9M8840/3")));
		p.put("patient2",new ArrayList<String>(Arrays.asList("C42.1M9870/3","C42.1M9040/3","C42.1M8840/3")));
		p.put("patient3",new ArrayList<String>(Arrays.asList("C40.1M9570/3","C12.1M9840/3","C12.1M8840/3")));
		p.put("patient4",new ArrayList<String>(Arrays.asList("C40.1M9040/3","C30.1M9040/3","C37.1M9040/3")));
		
		return p;
	}
}
