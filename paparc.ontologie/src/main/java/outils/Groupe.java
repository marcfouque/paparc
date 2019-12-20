package outils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.simple.JSONArray;

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
			listCimo3.get(1).add(arrMorpho.get(i)[0].substring(0, 4));
		}
		for(int j = 0;j<arrTopo.size();j++) {
			listCimo3.get(0).add(arrTopo.get(j)[0]);
		}

		listCodeTopo = getGroupeTopo();
		listCodeMorpho = getGroupeMorpho();

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
				//System.out.println(s);
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

	public void sqlTopo() {
		try {
			FileWriter fw = new FileWriter("./src/main/resources/sqlTopo.sql");
			
			//creation table
			fw.write("DROP TABLE IF EXISTS topoCimo3_groupeIACRTopo;\n");
			fw.write("CREATE TABLE topoCimo3_groupeIACRTopo( \n");
			fw.write("\ttopoCimo3 varchar(7) NOT NULL, \n");
			fw.write("\ttopoIACR int(2) DEFAULT NULL, \n");
			fw.write("\tPRIMARY KEY (topoCimo3) \n");
			fw.write(") ENGINE=InnoDB DEFAULT CHARSET=latin1; \n\n");
			
			//insertion valeurs
			fw.write("INSERT INTO topoCimo3_groupeIACRTopo (topoCimo3, topoIACR) VALUES \n");
			
			for(int i =0; i<arrTopo.size(); i++) {
				if(i==arrTopo.size()-1)fw.write("\t('"+arrTopo.get(i)[0]+"',"+arrTopo.get(i)[7]+"); \n");
				else fw.write("('"+arrTopo.get(i)[0]+"',"+arrTopo.get(i)[7]+"), \n");
			}
			
			fw.close();
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
			
	}
	
	public void sqlTopoNew() {
		try {
			FileWriter fw = new FileWriter("./src/main/resources/sqlTopoCimo3.sql");
			
			//creation table
			fw.write("DROP TABLE IF EXISTS topoCimo3;\n");
			fw.write("CREATE TABLE topoCimo3_groupeIACRTopo( \n");
			fw.write("\ttopoCimo3 varchar(7) NOT NULL, \n");
			fw.write("\tlibelleTopoCimo3 varchar(100) DEFAULT NULL, \n");
			fw.write("\tPRIMARY KEY (topoCimo3) \n");
			fw.write(") ENGINE=InnoDB DEFAULT CHARSET=latin1; \n\n");
			
			//insertion valeurs
			fw.write("INSERT INTO topoCimo3_groupeIACRTopo (topoCimo3, libelleTopoCimo3) VALUES \n");
			
			for(int i =0; i<arrTopo.size(); i++) {
				if(i==arrTopo.size()-1)fw.write("\t('"+arrTopo.get(i)[2]+"',"+arrTopo.get(i)[1]+"); \n");
				else fw.write("('"+arrTopo.get(i)[2]+"',"+arrTopo.get(i)[1]+"), \n");
			}
			
			fw.close();
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
			
	}
	public void sqlMorpho() {
		try {
			FileWriter fw = new FileWriter("./src/main/resources/sqlMorpho.sql");
			
			//creation table
			fw.write("DROP TABLE IF EXISTS morphoCimo3_groupeIACRMorpho;\n");
			fw.write("CREATE TABLE morphoCimo3( \n");
			fw.write("\tmorphoCimo3 varchar(7) NOT NULL, \n");
			fw.write("\tmorphoIACR int(2) DEFAULT NULL, \n");
			fw.write("\tPRIMARY KEY (morphoCimo3) \n");
			fw.write(") ENGINE=InnoDB DEFAULT CHARSET=latin1; \n\n");
			
			//insertion valeurs
			fw.write("INSERT INTO morphoCimo3 (morphoCimo3, morphoIACR) VALUES \n");
			
			for(int i =0; i<arrMorpho.size(); i++) {
				if(i==arrMorpho.size()-1)fw.write("\t('"+arrMorpho.get(i)[0]+"',"+arrMorpho.get(i)[3]+"); \n");
				else fw.write("('"+arrMorpho.get(i)[0]+"',"+arrMorpho.get(i)[3]+"), \n");
			}
			
			fw.close();
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void sqlMorphoNew() {
		try {
			FileWriter fw = new FileWriter("./src/main/resources/sqlMorphoCimo3.sql");
			
			//creation table
			fw.write("DROP TABLE IF EXISTS morphoCimo3;\n");
			fw.write("CREATE TABLE morphoCimo3_groupeIACRMorpho( \n");
			fw.write("\tmorphoCimo3 varchar(7) NOT NULL, \n");
			fw.write("\tlibelleMorphoCimo3 varchar(100) DEFAULT NULL, \n");
			fw.write("\tPRIMARY KEY (morphoCimo3) \n");
			fw.write(") ENGINE=InnoDB DEFAULT CHARSET=latin1; \n\n");
			
			//insertion valeurs
			fw.write("INSERT INTO morphoCimo3 (morphoCimo3, libelleMorphoCimo3) VALUES \n");
			
			for(int i =0; i<arrMorpho.size(); i++) {
				if(i==arrMorpho.size()-1)fw.write("\t('"+arrMorpho.get(i)[0]+"',"+arrMorpho.get(i)[1]+"); \n");
				else fw.write("('"+arrMorpho.get(i)[0]+"',"+arrMorpho.get(i)[1]+"), \n");
			}
			
			fw.close();
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void topoLibJSON() {
		//fait � l'ancienne avec des regex
		/*
		ArrayList<String> temp = new ArrayList<String>();
		JSONArray jsArray = new JSONArray();
		
		try {
		//FileWriter fw = new FileWriter("./src/main/resources/jsonTopo.json");
		
		jsArray.writeJSONString(temp, fw);
		fw.close();
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		*/
	}
}
