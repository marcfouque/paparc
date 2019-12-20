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
		
		grou.sqlTopoNew();
		grou.sqlMorphoNew();
	
		
//		//set d'exemple de patient
//		HashMap<String,ArrayList<String>> patients = new HashMap<String,ArrayList<String>>();
//	    patients = exemplePatient();
//	    
//	    
//		ArrayList<Patient> listePatients = new ArrayList<Patient>();
//		
//		//passage liste cimo3 par patient � liste de patient chacun contenant leurs cancers primaires
//		for(String p : patients.keySet()){
//				ArrayList<CoupleTopoMorpho>temp = new ArrayList<CoupleTopoMorpho>();
//				for(String c : patients.get(p)) {
//					boolean b = true;
//					ArrayList<String> al = new ArrayList<String>(Arrays.asList(grou.getGrpTopoFromCimo3(c.split("M")[0]),grou.getGrpMorphoFromCimo3(c.split("M")[1].substring(0, 4)),c.split("M")[0],c.split("M")[1].substring(0, 4)));
//					
//					if(al.get(0)!="nope" && al.get(1)!="nope")temp.add(new CoupleTopoMorpho(al.get(0),al.get(1),al.get(2),al.get(3)));
//					else System.out.println(p+" : code cimo3 non reconnu, "+c+"\n\ttopo : "+grou.getGrpTopoFromCimo3(c.split("M")[0])+"\t"+c.split("M")[0]+"\n\tmorpho: "+grou.getGrpMorphoFromCimo3(c.split("M")[1].substring(0, 4))+"\t"+c.split("M")[1].substring(0, 4));
//				}
//			   listePatients.add(new Patient(p,temp));
//			}
//		
//		System.out.println(listePatients.toString());
//		//listePatients.forEach((x)->System.out.println(x));
//		
//		
//		enregistrementCP_sql(listePatients);
		
	}
	public static void enregistrementCP_sql(ArrayList<Patient> lp) {
		//commandes pour g�n�ration fichier sql de
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
		System.out.println("fichier enregistr�");

	}

	
	public static HashMap<String,ArrayList<String>> exemplePatient() {
		HashMap<String,ArrayList<String>> p = new HashMap<String,ArrayList<String>>();
		p.put("837404",new ArrayList<String>(Arrays.asList("C80.9M80100/3","C62.9M80106/3")));
		p.put("468647",new ArrayList<String>(Arrays.asList("C34.8M95903/3","C26.8M95913/3")));
		p.put("864787",new ArrayList<String>(Arrays.asList("C80.9M80000/3","C80.9M97503/3","C51.9M96503/3")));
		p.put("103823",new ArrayList<String>(Arrays.asList("C18.2M97273/3","C38.8M98403/3","C18.2M96503/3","C54.9M80100/3","C18.2M80000/3")));
		p.put("329048",new ArrayList<String>(Arrays.asList("C61.9M91403/3","C30.1M91403/3","C49.9M96703/3","C49.9M96733/3","C51.9M96733/3")));
		p.put("527647",new ArrayList<String>(Arrays.asList("C34.8M87200/3","C09.9M80102/3","C34.8M80000/3","C80.9M80100/3","C09.9M82600/3")));
		p.put("384382",new ArrayList<String>(Arrays.asList("C00.8M97401/3","C16.9M80011/3")));
		
		return p;
	}
}
