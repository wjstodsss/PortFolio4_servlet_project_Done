package com.blacksmith.banchan.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.blacksmith.banchan.admin.dto.AdminVO;
import com.blacksmith.banchan.board.dto.NoticeBoardVO;
import com.blacksmith.banchan.util.DBManager;



public class AdminDAO {

	public AdminDAO() {
	}

	private static AdminDAO dao = new AdminDAO();

	public static AdminDAO getAdminDao() {
		return dao;
	}

	Connection conn = null;

	// 커넥션 풀
	public Connection getConnection() throws Exception {

		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/estoreDB");

		Connection conn = ds.getConnection();
		return conn;
	}
	
	//int result = mDao.adminCheck(adminId, adminPassword);

	public int adminCheck(String adminId, String adminPassword) {
		
		int result = -1;
		String sql = "select adminPassword from tbl_admin_member where adminId=?";
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("adminPassword") != null && rs.getString("adminPassword").equals(adminPassword)) {
					result = 1;
					
					
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 아이디로 회원 정보를 가져오는 메소드
	// admin 테이블에서 아이디로 해당 회원을 찾아 회원 정보를 가져온다.
	public AdminVO getAdmin(int adminId) {
		AdminVO pVO = null;
		String sql = "select * from tbl_admin_member where adminId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adminId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pVO = new AdminVO();
				pVO.setAdminName(rs.getString("adminName"));
				pVO.setAdminId(rs.getString("adminId"));
				pVO.setAdminPassword(rs.getString("adminPassword"));
				pVO.setAdminEmail(rs.getString("adminEmail"));
				pVO.setAdminPhone(rs.getString("adminPhone"));
				pVO.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pVO;
	}

	// 회원 가입 할때 아이디 중복 체크를 위한 메소드
	// 해당 아이디가 있으면 1, 없으면 -1
	public int confirmID(String adminId) {
		int result = -1;
		String sql = "select adminId from tbl_admin_member where adminId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}
	
	//회원 정보를 DB에 추가하기 위한 메소드 추가   C
    //매개변수로 받은 VO 객체를 admin 테이블에 삽입한다.
	//회원 가입 할때 아이디 중복 체크를 위한 메소드
    //해당 아이디가 있으면 1, 없으면 -1
    public int insertAdmin(AdminVO pVO) {
		int result = -1;
		String sql = "insert into tbl_admin_member (adminName, adminId, adminPassword, adminEmail, adminPhone, admin) values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVO.getAdminName());
			pstmt.setString(2, pVO.getAdminId());
			pstmt.setString(3, pVO.getAdminPassword());
			pstmt.setString(4, pVO.getAdminEmail());
			pstmt.setString(5, pVO.getAdminPhone());
			pstmt.setInt(6, pVO.getAdmin());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
  //회원 정보를 변경하기 위한 메소드 추가
    //매개변수로 받은 VO 객체 내의 아이디로 admin 테이블에서 검색해서 
    //VO객체에 저장된 정보로 회원 정보를 수정한다.
   public int updateAdmin(AdminVO pVO) {
		int result = -1;
		String sql = "update tbl_admin_member set adminPassword=?, adminEmail=?," + "adminPhone=?, admin=? where adminId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVO.getAdminPassword());
			pstmt.setString(2, pVO.getAdminEmail());
			pstmt.setString(3, pVO.getAdminPhone());
			pstmt.setInt(4, pVO.getAdmin());
			pstmt.setString(5, pVO.getAdminId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
   
   
   public List<AdminVO> getAllAdmin() {
		
		List<AdminVO> list = new ArrayList<AdminVO>();
		String sql = "select * from tbl_admin_member";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminVO pVO = new AdminVO();
				pVO.setCode(rs.getInt("code"));
				pVO.setAdminName(rs.getString("adminName"));
				pVO.setAdminId(rs.getString("adminId"));
				pVO.setAdminPassword(rs.getString("adminPassword"));
				pVO.setAdminEmail(rs.getString("adminEmail"));
				pVO.setAdminPhone(rs.getString("adminPhone"));
				pVO.setAdmin(rs.getInt("admin"));
				list.add(pVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
   
   public void deleteAdmin(int id) {
		String sql = "delete from tbl_admin_member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
