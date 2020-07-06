package practice;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class practice {
	
	
	public static void main(String[] args) {
		List<String> Coffee = new ArrayList();
		
		
		StringBuffer stb = new StringBuffer();
		
		Coffee.add("AH");
		Coffee.add("LH");
		Coffee.add("VH");
		Coffee.add("AH");
		Coffee.add("AI");
		Coffee.add("LH");
		Coffee.add("AH");
		int AHcnt=0, LHcnt=0, MHcnt=0, VHcnt=0, AIcnt=0, LIcnt=0, MIcnt=0, VIcnt=0;
		List<String> fl = new ArrayList();
		for(String coffee : Coffee ) {
			if( coffee.equals("AH")) {
				++AHcnt; 
				if(fl.contains("AH")) {
					continue;
				}
				else {
					fl.add("AH");
				}
			}
			else if(coffee.equals("AH")){
				++LHcnt;
				if(fl.contains("AH")) {
					continue;
				}
				else {
					fl.add("AH");
				}
			}
			else if(coffee.equals("LH")){
				++LHcnt;
				if(fl.contains("LH")) {
					continue;
				}
				else {
					fl.add("LH");
				}
			}else if(coffee.equals("MH")){
				++MHcnt;
				if(fl.contains("MH")) {
					continue;
				}
				else {
					fl.add("MH");
				}
			}else if(coffee.equals("VH")){
				++VHcnt;
				if(fl.contains("VH")) {
					continue;
				}
				else {
					fl.add("VH");
				}
			}else if(coffee.equals("AI")){
				++AIcnt;
				if(fl.contains("AI")) {
					continue;
				}
				else {
					fl.add("AI");
				}
			}else if(coffee.equals("LI")){
				++LIcnt;
				if(fl.contains("LI")) {
					continue;
				}
				else {
					fl.add("LI");
				}
			}else if(coffee.equals("MI")){
				++MIcnt;
				if(fl.contains("MI")) {
					continue;
				}
				else {
					fl.add("MI");
				}
			}else if(coffee.equals("VI")){
				++VIcnt;
				if(fl.contains("VI")) {
					continue;
				}
				else {
					fl.add("VI");
				}
			}
			
		}for(String coffee : fl ) {
			if( coffee.equals("AH")) {
				stb.append("Americano Hot \t "+Integer.toString(AHcnt)+"\n");
				
			}else if(coffee.equals("LH")){
				stb.append("Latte Hot \t\t "+Integer.toString(LHcnt)+"\n");	
			}else if(coffee.equals("MH")){
				stb.append("Mocha latte Hot \t "+Integer.toString(MHcnt)+"\n");
			}else if(coffee.equals("VH")){
				stb.append("Vanilla latte Hot \t "+Integer.toString(VHcnt)+"\n");
			}else if(coffee.equals("AI")){
				stb.append("Americano Ice \t "+Integer.toString(AIcnt)+"\n");
			}else if(coffee.equals("LI")){
				stb.append("Latte Ice \t "+Integer.toString(LIcnt)+"\n");
			}else if(coffee.equals("MI")){
				stb.append("Mocha latte Ice \t "+Integer.toString(MIcnt)+"\n");
			}else if(coffee.equals("VI")){
				stb.append("Vanilla latte Ice \t "+Integer.toString(VIcnt)+"\n");
			}
		}
		String orderedCoffee = stb.toString();
		System.out.println(orderedCoffee);	
	}	
				
		
}
