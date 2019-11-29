package paparc.ontologie.structureOntologie;

public class CoupleTopoMorpho implements Comparable<CoupleTopoMorpho> {
	//private int id;
	//private static int compteur;
	
	private int topo;
	private int morpho;

	public CoupleTopoMorpho(String t,String m) {
		// TODO Auto-generated constructor stub
		//compteur++;
		
		topo = Integer.parseInt(t);
		morpho = Integer.parseInt(m);
		//id=compteur;
		//System.out.println("compteur "+compteur);
	}

	//public static int getCompteur() {return compteur;}
	///public int getID() {return id;}
	public int getT() {return topo;}
	public int getM() {return morpho;}
	
	public boolean memeTopo(CoupleTopoMorpho c) {
		return c.getT()==topo;
	}
	public boolean memeMorpho(CoupleTopoMorpho c) {
		return c.getM()==morpho;
	}
	
	@Override
	public boolean equals(Object obj) {
		CoupleTopoMorpho c = (CoupleTopoMorpho)obj;
		return c.getT()==topo && c.getM()==morpho;
	}
	@Override
	public String toString() {
		return "grp_"+topo+"_"+morpho;
	}
	@Override
	public int compareTo(CoupleTopoMorpho ctm) {
		return Integer.compare(this.morpho, ctm.morpho);
	}
	
}
