package exam03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc_Insert {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String pw = "tiger";
		
		Connection con = null;
		
		PreparedStatement pstmt =null;
		//Statement stmt = null;
		
		Scanner input =  new Scanner(System.in);
		String no=null, name=null, email=null, tel=null;
		String sql=null;
				
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pw);
			
			//stmt = con.createStatement();
			
			 
			//System.out.println("연결 성공");
			
			System.out.println("테이블에 입력할 값 입력 받기");
			System.out.print("번호 입력 : ");
			no = input.nextLine();
			int changeNo = Integer.parseInt(no);
			System.out.print("이름 입력 : ");
			name = input.nextLine();
			System.out.print("이메일 입력 : ");
			email = input.nextLine();
			System.out.print("전화번호 입력 : ");
			tel = input.nextLine();
			
			//sql = "insert into customer values("+no+",' "+ name+" ',' "+ email+" ',' " +tel+" ')";
			
			sql = "insert into customer values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);  //위의 stmt = con.createStatement(); 대신이용! 보안상의 이유!
			
			pstmt.setInt(1, changeNo );   //첫번째?에 입력
			pstmt.setString(2, name);      //두번째?에 입력
			pstmt.setString(3, email);      //세번째?에 입력
			pstmt.setString(4, tel);          //네번째?에 입력
			
			
			
			//int result = stmt.executeUpdate(sql);
			int result = pstmt.executeUpdate();
			
			if(result==1) {
				System.out.println("데이터 저장 성공");
			}
			else {
				System.out.println("데이터 저장 실패");
			}
						
		} catch (Exception e) {
			//System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) { pstmt.close();}
				if(con!=null) { con.close();  }
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
