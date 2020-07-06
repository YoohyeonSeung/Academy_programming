package exam04.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

//DAO : Data Access Object
class ConnectionPoolDAO { // DB -> CRUD기능

	BasicDataSource ds;
	ConnectionPoolDAO(){
		
		 ds = new BasicDataSource();  // Connection Pool 기능과 Thread-safe기능을 갖추고 있다.
		 											// commons-dbcp2-2.x.x.jar에 내장된 API.
		
		 ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		 ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		 ds.setUsername("scott");
		 ds.setPassword("tiger");
		 
		 ds.setInitialSize(5);     //5개의 Connection을 공유하면서 사용할 수 있음. 개인pc이므로 적게 해도됨 서버라면 더 크게 해야됨
		 
		 
	}

	public List<ConnectionPoolDTO> select() {
		//List<ConnectionPoolDTO>타입으로 리턴하기때문에 void 대신 해야된다.
		List<ConnectionPoolDTO> list = new ArrayList<ConnectionPoolDTO>();
				
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ds.getConnection();
			String sql =  "select * from customer order by no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();                  //여기서 읽어오기만 하고 출력하는건 메인클래스의 select에서...
					
			while(rs.next()) {
				ConnectionPoolDTO dto= new ConnectionPoolDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				list.add(dto);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null ) {rs.close();}
				if(pstmt!=null) { pstmt.close();}
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return list;
	}
	
	public void insert(ConnectionPoolDTO dto) {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		
		String sql = "insert into customer values(?,?,?,?)";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getTel());
			
			int result = pstmt.executeUpdate();
			
			if(result ==1) {
				System.out.println("데이터 저장 성공");
			}
			else {
				System.out.println("데이터 저장 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) { pstmt.close();}
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	public void update(ConnectionPoolDTO dto) {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		
		String sql = "update customer set name=?, email=?, tel=? where no = ?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTel());
			pstmt.setInt(4, dto.getNo());
			
			int result = pstmt.executeUpdate();
			
			if(result ==1) {
				System.out.println("데이터 수정 성공");
			}
			else {
				System.out.println("데이터 수정 실패");
			}			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) { pstmt.close();}
				if(con!=null) {	con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}

	public void delete(ConnectionPoolDTO dto) {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String sql="delete from customer where no=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNo());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("회원 삭제 성공");
			}
			else {
				System.out.println("회원 삭제 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { 
				if(pstmt != null) { pstmt.close();}
				if(con !=null) {con.close();}				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}
	
	
}
