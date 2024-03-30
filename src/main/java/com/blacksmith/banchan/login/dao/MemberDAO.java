package com.blacksmith.banchan.login.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.blacksmith.banchan.login.dto.MemberVO;



public class MemberDAO {

	public MemberDAO() {
	}

	private static MemberDAO dao = new MemberDAO();

	public static MemberDAO getMemberDao() {
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
	
	//int result = mDao.memberCheck(userId, userPassword);

	public int memberCheck(String userId, String userPassword) {
		
		int result = -1;
		String sql = "select userPassword from tbl_member where userId=?";
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("userPassword") != null && rs.getString("userPassword").equals(userPassword)) {
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
	// member 테이블에서 아이디로 해당 회원을 찾아 회원 정보를 가져온다.
	public MemberVO getMember(String userId) {
		MemberVO mVo = null;
		String sql = "select * from tbl_member where userId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new MemberVO();
				mVo.setUserName(rs.getString("username"));
				mVo.setUserId(rs.getString("userId"));
				mVo.setUserPassword(rs.getString("userPassword"));
				mVo.setUserEmail(rs.getString("userEmail"));
				mVo.setUserPhone(rs.getString("userPhone"));
				mVo.setAdmin(rs.getInt("admin"));
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
		return mVo;
	}

	// 회원 가입 할때 아이디 중복 체크를 위한 메소드
	// 해당 아이디가 있으면 1, 없으면 -1
	public int confirmID(String userId) {
		int result = -1;
		String sql = "select userId from tbl_member where userId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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
    //매개변수로 받은 VO 객체를 member 테이블에 삽입한다.
	//회원 가입 할때 아이디 중복 체크를 위한 메소드
    //해당 아이디가 있으면 1, 없으면 -1
    public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into tbl_member values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserName());
			pstmt.setString(2, mVo.getUserId());
			pstmt.setString(3, mVo.getUserPassword());
			pstmt.setString(4, mVo.getUserEmail());
			pstmt.setString(5, mVo.getUserPhone());
			pstmt.setInt(6, mVo.getAdmin());
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
    //매개변수로 받은 VO 객체 내의 아이디로 member 테이블에서 검색해서 
    //VO객체에 저장된 정보로 회원 정보를 수정한다.
   public int updateMember(MemberVO mVo) {
		int result = -1;
		String sql = "update tbl_member set userPassword=?, userEmail=?," + "userPhone=?, admin=? where userId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserPassword());
			pstmt.setString(2, mVo.getUserEmail());
			pstmt.setString(3, mVo.getUserPhone());
			pstmt.setInt(4, mVo.getAdmin());
			pstmt.setString(5, mVo.getUserId());
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


}
