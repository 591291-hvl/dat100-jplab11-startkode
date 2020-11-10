package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable
	protected Innlegg[] innleggTabell;
	private int nesteLedig;

	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedig = 0;
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}

	public Innlegg[] getSamling() {
		return innleggTabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		
		for(int i = 0; i < nesteLedig; i++) {
			if(innlegg.erLik(innleggTabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return(finnInnlegg(innlegg) != -1);
		
	}

	public boolean ledigPlass() {
		return(nesteLedig < innleggTabell.length);

	}

	public boolean leggTil(Innlegg innlegg) {

		if(!finnes(innlegg) && ledigPlass()){
			innleggTabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;
		}
		return false;
		
	}

	public String toString() {
		String uttekst = nesteLedig + "\n";
		for(int i = 0; i < nesteLedig; i++) {
			uttekst += innleggTabell[i].toString();
		}
		
		return uttekst;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] utvidTabell;
		
		utvidTabell = new Innlegg[innleggTabell.length*2];
		for(int i = 0; i < nesteLedig; i++) {
			utvidTabell[i] = innleggTabell[i];
		}
		
		innleggTabell = utvidTabell;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		return leggTil(innlegg);
		

	}

	public boolean slett(Innlegg innlegg) {
		
		if(finnes(innlegg)) {
			innleggTabell[finnInnlegg(innlegg)] = null;
			nesteLedig--;
			return true;
		}
		return false;
	}
	

	public int[] search(String keyword) {
		String ids = "";
		for(int i = 0; i < nesteLedig; i++) {
			if(innleggTabell[i].toString().contains(keyword)) {
				ids += i + ",";
			}
		}
		
		String[] stringTabell = ids.split(",");
		int[] idTabell = new int[stringTabell.length];
		for(int i = 0; i < idTabell.length; i++) {
			idTabell[i] = Integer.parseInt(stringTabell[i]);
		}
		return idTabell;
		
	}
}