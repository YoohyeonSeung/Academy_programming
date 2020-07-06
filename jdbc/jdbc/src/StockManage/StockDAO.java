package StockManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

class StockDAO {
		
	BasicDataSource ds;
	
	StockDAO(){
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(5); 			
	}
	
	public StockDTO select(){
		StockDTO dto = new StockDTO();
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ds.getConnection();
			String sql =  "select * from customer order by no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();                  //여기서 읽어오기만 하고 출력하는건 메인클래스의 select에서...
			
			dto.setBeanQ(rs.getInt("Bean"));
			dto.setMilkQ(rs.getInt("Milk"));
			dto.setChocoQ(rs.getInt("Choco"));
			dto.setVanillaQ(rs.getInt("Vanila"));			
				
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
		return dto;
			
	}
	
	public  void update(StockDTO dto) {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		String sql = "update stock set Bean = ?, Milk=?, Choco=?, Vanilla=?";
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,  dto.getBeanQ());
			pstmt.setInt(2, dto.getMilkQ());
			pstmt.setInt(3,  dto.getChocoQ());
			pstmt.setInt(4,  dto.getVanillaQ());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("재고 수정 성공");
			}
			else {
				System.out.println("데이터 수정 실패");
			}		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {pstmt.close();}
				if(con!=null) {con.close();}			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
