package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/tests/";

	private static String FILNAVN = "bloggkorrect.dat";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	public static Blogg les(String mappe, String filnavn){

		Blogg samling = new Blogg();
		String file = MAPPE + FILNAVN;
		
		//reader
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String firstLine = reader.readLine();
			
			
			if(isNumber(firstLine)) {
				samling = new Blogg(Integer.parseInt(firstLine));
			}
			String[] linje = new String[7];
			Tekst innlegg1;
			Bilde innlegg2;
			
			for(int j = 0; j < Integer.parseInt(firstLine); j++) {
				if(reader.readLine().equals(TEKST)){
					for(int i = 0; i < 4; i++) {
						linje[i] = reader.readLine();
						
					}
					innlegg1 = new Tekst(Integer.parseInt(linje[0]),linje[1],linje[2],Integer.parseInt(linje[3]),linje[4]);
					samling.leggTil(innlegg1);
				}else if(reader.readLine().equals(BILDE)){
					for(int i = 0; i < 5; i++) {
						linje[i] = reader.readLine();
						
					}
					innlegg2 = new Bilde(Integer.parseInt(linje[0]),linje[1],linje[2],Integer.parseInt(linje[3]),linje[4],linje[5]);
					samling.leggTil(innlegg2);
				}else {
					System.out.print("Mangler blogg type");
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}catch (IOException e) {
			System.out.println("error!");
		}
		
		
		
		return samling;
		
	}
}