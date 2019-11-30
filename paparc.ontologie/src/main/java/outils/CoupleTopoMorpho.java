package outils;

public class CoupleTopoMorpho implements Comparable<CoupleTopoMorpho> {
	//private int id;
	//private static int compteur;
	
	private int gTopo;
	private int gMorpho;
	
	private String topoCimO;
	private int morphoCimO;

	public CoupleTopoMorpho(String gt,String gm,String codet,String codem) {
		gTopo = Integer.parseInt(gt);
		gMorpho = Integer.parseInt(gm);
		
		topoCimO = codet;
		morphoCimO = Integer.parseInt(codem);
	}
	public CoupleTopoMorpho(String gt,String gm) {
		this(gt,gm,"","0");
	}
	

	//public static int getCompteur() {return compteur;}
	///public int getID() {return id;}
	public int getT() {return gTopo;}
	public int getM() {return gMorpho;}
	
	public boolean memeTopo(CoupleTopoMorpho c) {
		return c.getT()==gTopo;
	}
	public boolean memeMorpho(CoupleTopoMorpho c) {
		return c.getM()==gMorpho;
	}
	
	@Override
	public boolean equals(Object obj) {
		CoupleTopoMorpho c = (CoupleTopoMorpho)obj;
		return c.getT()==gTopo && c.getM()==gMorpho;
	}
	@Override
	public String toString() {
		return "grp_"+gTopo+"_"+gMorpho;
	}
	@Override
	public int compareTo(CoupleTopoMorpho ctm) {//compare desc
		return Integer.compare(ctm.morphoCimO,this.morphoCimO);
	}
	
}
