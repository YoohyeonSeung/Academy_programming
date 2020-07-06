package exam02;

import java.io.*;

public class Object_Inout_Output {

	public static void main(String[] args) {
		
		
		
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
		
			
			out.writeObject( new Circle(1, 1, 3.4) );
			out.writeObject( new Circle(2, 2, 6.5) );
		
			
			
			out.close();
			
			ObjectInputStream in = 
					new ObjectInputStream(new FileInputStream("Object.ser"));
		
			System.out.println(in.available());
			System.out.println(in.read());
			
			Circle cr1 = (Circle) in.readObject();
		
			Circle cr2 = (Circle) in.readObject();
		
				
			in.close();
			
			
			cr1.ShowInfo();
			cr2.ShowInfo();
		
		
		
		
		
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		

	}

}
