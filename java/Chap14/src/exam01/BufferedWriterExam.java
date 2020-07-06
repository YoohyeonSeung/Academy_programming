package exam01;

import java.io.*;

public class BufferedWriterExam {

	public static void main(String[] args) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"));
			BufferedReader in = new BufferedReader(new FileReader("String.txt"));
			
			
			
			out.write("하 쉬고싶다.");
			
			out.close();
			
			System.out.println(in.readLine());
			
			
			in.close();
			
			
			
		} catch (Exception e) {


			e.printStackTrace();
		}

	}

}
