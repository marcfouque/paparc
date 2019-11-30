package paparc.ontologie.structureOntologie;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.model.*;

import algo.Patient;
import outils.CoupleTopoMorpho;
import outils.Groupe;

//import org.semanticweb.owlapi.model.OWLOntology;
//import org.semanticweb.owlapi.model.OWLOntologyManager;

public class CreerOnto {

	public static void main(String[] args) {
		Groupe grou = new Groupe();
		ArrayList<CoupleTopoMorpho> pcg = grou.getPCG();
		
        try {
        	//creation onto vide
        	OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        	//OWLOntology onto = manager.createOntology();	//onto sans IRI
        	//System.out.println(manager);
        	
        	//creation onto avec IRI
        	IRI iri = IRI.create("http://www.ime202.ISPED/paparc/primaryCancer");
            IRI viri = IRI.create("http://www.ime202.ISPED/paparc/primaryCancer/v1");
            OWLOntologyID ontoID = new OWLOntologyID(iri,viri);
            OWLOntology onto = manager.createOntology(ontoID);        	
        	
            //creation concept
            OWLDataFactory df = onto.getOWLOntologyManager().getOWLDataFactory();
            //creation patient
            OWLClass patient = df.getOWLClass(iri+"#Patient");
            OWLDeclarationAxiom daPat = df.getOWLDeclarationAxiom(patient);
          //creation groupe
            OWLClass groupe = df.getOWLClass(iri+"#Groupe");
            OWLDeclarationAxiom daGro = df.getOWLDeclarationAxiom(groupe);
          //creation cancerPrimaire
            OWLClass pc = df.getOWLClass(iri+"#PrimaryCancer");
            OWLDeclarationAxiom daPc = df.getOWLDeclarationAxiom(pc);
            
            
            //insertion Concept
            onto.add(daPat);
            onto.add(daGro);
            onto.add(daPc);
            
            //System.out.println(onto);
            System.out.println("insertion groupes");
            //ajout  de tous les groupes subclass de groupe | nom = Grp+id
            for(int i = 0;i<pcg.size();i++) {
                OWLClass grp = df.getOWLClass(iri+"#"+pcg.get(i));
                OWLDeclarationAxiom daGrp = df.getOWLDeclarationAxiom(grp);
                onto.add(daGrp);
            	OWLSubClassOfAxiom gsubG = df.getOWLSubClassOfAxiom(grp, groupe);
            	onto.add(gsubG);
            }
            
            //ajout axioms disjoint
            //entre patient et groupe
            OWLDisjointClassesAxiom disjointClassesAxiom = df.getOWLDisjointClassesAxiom(patient, groupe);
            manager.addAxiom(onto, disjointClassesAxiom);
            //entre patient et primaryCacner
            OWLDisjointClassesAxiom disjointPatPc = df.getOWLDisjointClassesAxiom(patient, pc);
            manager.addAxiom(onto, disjointPatPc);
            
            //entre tous les groupes
            System.out.println("axioms groupes");
            for(int i = 0;i<pcg.size();i++) {
            	for(int j = i+1;j<pcg.size();j++) {
	                OWLClass g1 = df.getOWLClass(iri+"#"+pcg.get(i));
	                OWLClass g2 = df.getOWLClass(iri+"#"+pcg.get(j));
	                OWLDisjointClassesAxiom disGr = df.getOWLDisjointClassesAxiom(g1, g2);
	                manager.addAxiom(onto, disGr);
            	}
            	//System.out.println(i);
            }
            
            //creation relation
           // OWLObjectProperty estAtteint = factory.getOWLObjectProperty(
            
            //System.out.println(onto);
        	//enregistrement ontologie
            System.out.println("Enregistrement du fichier");
        	File fileout = new File("./src/main/resources/primaryCancer.owl");
        	manager.saveOntology(onto, new FunctionalSyntaxDocumentFormat(),new FileOutputStream(fileout));
        	System.out.println("fichier enregistré");
        }catch(Exception e) {
        	 e.printStackTrace();
        }
		
	}

}
