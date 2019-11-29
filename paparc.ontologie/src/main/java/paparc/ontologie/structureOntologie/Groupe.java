package paparc.ontologie.structureOntologie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Groupe {
	private ArrayList <String[]> arrTopo;
	private ArrayList <String[]> arrMorpho;
	private ArrayList <String> listCodeTopo;
	private ArrayList <String> listCodeMorpho; 
	private ArrayList <ArrayList> listCimo3;
	
	public Groupe() {
		
		
		this.arrTopo = new ArrayList<String[]>();
		this.arrMorpho = new ArrayList<String[]>();

		//File directory = new File("./");
		//System.out.println(directory.getAbsolutePath());
		   
		BufferedReader reader = null;
		try {
		    File fichier = new File("./src/main/resources/CIMO3_TOPO.txt");
		    reader = new BufferedReader(new FileReader(fichier));

		    String line;
		    line = reader.readLine(); //premiere ligne out
		    while ((line = reader.readLine()) != null) {
		    	this.arrTopo.add(line.split("[|]"));
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		reader = null;
		try {
		    File fichier = new File("./src/main/resources/CIMO3_MORPHO.txt");
		    reader = new BufferedReader(new FileReader(fichier));

		    String line;
		    line = reader.readLine(); //premiere ligne out
		    while ((line = reader.readLine()) != null) {
		    	this.arrMorpho.add(line.split("[|]"));
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		listCimo3 = new ArrayList();
		listCimo3.add(new ArrayList<String>());
		listCimo3.add(new ArrayList<String>());
		for(int i = 0;i<arrMorpho.size();i++) {
            listCimo3.get(1).add(arrMorpho.get(i)[0]);
    	}
		for(int j = 0;j<arrTopo.size();j++) {
            listCimo3.get(0).add(arrTopo.get(j)[0]);
    	}
		
		listCodeTopo = getGroupeTopo();
		listCodeMorpho = getGroupeMorpho();
		System.out.println(listCimo3.get(0).size());
		System.out.println(listCimo3.get(1).size());
	}
	
	private ArrayList getGroupeTopo(){
		HashMap htopo = new HashMap();
		for (int i = 0; i < arrTopo.size(); i++) {
			//htopo[arrTopo[7]]=
			htopo.put(arrTopo.get(i)[7], true);
		}
		return new ArrayList(htopo.keySet());
	}
	private ArrayList getGroupeMorpho(){
		HashMap hmorpho = new HashMap();
		for (int i = 0; i < arrMorpho.size(); i++) {
			hmorpho.put(arrMorpho.get(i)[3], true);
		}
		return new ArrayList(hmorpho.keySet());
	}
	
	public ArrayList<String> getGT(){return listCodeTopo;}
	public ArrayList<String> getGM(){return listCodeMorpho;}
	public ArrayList<CoupleTopoMorpho> getPCG(){
		ArrayList<CoupleTopoMorpho> res = new ArrayList<CoupleTopoMorpho>();
		for (int i = 0; i < listCodeTopo.size(); i++) {
			for (int j = 0; j < listCodeMorpho.size(); j++) {
				CoupleTopoMorpho s = new CoupleTopoMorpho(listCodeTopo.get(i), listCodeMorpho.get(j));
				res.add(s);
				System.out.println(s);
				s=null;
			}
		}
		return res;
	}
	public String getGrpTopoFromCimo3(String cimo3Topo){
		int ind = this.listCimo3.get(0).indexOf(cimo3Topo);
		if(ind!=-1)return arrTopo.get(ind)[7];
		else return "nope";
	}
	public String getGrpMorphoFromCimo3(String cimo3Morpho){
		int ind = this.listCimo3.get(1).indexOf(cimo3Morpho);
		if(ind!=-1)return arrMorpho.get(ind)[3];
		else return "nope";
	}
	
}
