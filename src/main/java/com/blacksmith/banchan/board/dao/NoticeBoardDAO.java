package com.blacksmith.banchan.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blacksmith.banchan.board.dto.NoticeBoardVO;
<<<<<<< HEAD
import com.blacksmith.banchan.board.dto.NoticeBoardVO;
=======
>>>>>>> develop
import com.blacksmith.banchan.util.DBManager;





public class NoticeBoardDAO {
	private NoticeBoardDAO() {
	}

	private static NoticeBoardDAO instance = new NoticeBoardDAO();

	public static NoticeBoardDAO getInstance() {
		return instance;
	}

	public List<NoticeBoardVO> selectAllBoards() {
<<<<<<< HEAD
		String sql = "select * from tbl_notice order by id desc";
=======
		String sql = "select * from tbl_notice_board order by num desc";
>>>>>>> develop
		List<NoticeBoardVO> list = new ArrayList<NoticeBoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				NoticeBoardVO bVo = new NoticeBoardVO();
<<<<<<< HEAD
				bVo.setId(rs.getInt("id"));
				bVo.setTitle(rs.getString("title"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPassword(rs.getString("password"));
				bVo.setContent(rs.getString("content"));
				bVo.setImageUrl(rs.getString("imageurl"));
				bVo.setReadCount(rs.getInt("readCount"));
				bVo.setDatePosted(rs.getTimestamp("datePosted"));
=======
				bVo.setNum(rs.getInt("num"));
				bVo.setUsername(rs.getString("username"));
				bVo.setEmail(rs.getString("email"));
				bVo.setPass(rs.getString("pass"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
>>>>>>> develop
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

<<<<<<< HEAD
	
	
	
	
	
	public void insertBoard(NoticeBoardVO bVo) {
		String sql = "insert into tbl_notice(title, author, password, content, imageurl) values(?, ?, ?, ?, ?)";
=======
	public void insertBoard(NoticeBoardVO bVo) {
		String sql = "insert into tbl_notice_board(username, email, pass, title, content) values(?, ?, ?, ?, ?)";
>>>>>>> develop
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
<<<<<<< HEAD
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getAuthor());
			pstmt.setString(3, bVo.getPassword());
			pstmt.setString(4, bVo.getContent());
			pstmt.setString(5, bVo.getImageUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그에 기록
			throw new RuntimeException("!! 글 작성 중에 오류가 발생했습니다.", e);
=======
			pstmt.setString(1, bVo.getUsername());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그에 기록
			throw new RuntimeException("글 작성 중에 오류가 발생했습니다.", e);
>>>>>>> develop
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

<<<<<<< HEAD
	public void updateReadCount(int id) {
		String sql = "update tbl_notice set readcount=readcount+1 where id=?";
=======
	public void updateReadCount(String num) {
		String sql = "update tbl_notice_board set readcount=readcount+1 where num=?";
>>>>>>> develop
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
<<<<<<< HEAD
			pstmt.setInt(1, id);
=======
			pstmt.setString(1, num);
>>>>>>> develop
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
<<<<<<< HEAD
	public NoticeBoardVO selectOneBoardById(int id) {
		String sql = "select * from tbl_notice where id = ?";
=======
	public NoticeBoardVO selectOneBoardByNum(String num) {
		String sql = "select * from tbl_notice_board where num = ?";
>>>>>>> develop
		NoticeBoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
<<<<<<< HEAD
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new NoticeBoardVO();
				bVo.setId(rs.getInt("id"));
				bVo.setTitle(rs.getString("title"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPassword(rs.getString("password"));
				bVo.setContent(rs.getString("content"));
				bVo.setImageUrl(rs.getString("imageurl"));
				bVo.setReadCount(rs.getInt("readCount"));
				bVo.setDatePosted(rs.getTimestamp("datePosted"));
=======
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new NoticeBoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setUsername(rs.getString("username"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
>>>>>>> develop
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBoard(NoticeBoardVO bVo) {
<<<<<<< HEAD
		String sql = "update tbl_notice set title=?, author=?, password=?, content=?, imageUrl=? where id=?";
=======
		String sql = "update tbl_notice_board set username=?, email=?, pass=?, " + "title=?, content=? where num=?";
>>>>>>> develop
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
<<<<<<< HEAD
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getAuthor());
			pstmt.setString(3, bVo.getPassword());
			pstmt.setString(4, bVo.getContent());
			pstmt.setString(5, bVo.getImageUrl());
			pstmt.setInt(6, bVo.getId());
=======
			pstmt.setString(1, bVo.getUsername());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());
>>>>>>> develop
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

<<<<<<< HEAD
	public void deleteBoard(int id) {
		String sql = "delete from tbl_notice where id=?";
=======
	public void deleteBoard(String num) {
		String sql = "delete from tbl_notice_board where num=?";
>>>>>>> develop
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
<<<<<<< HEAD
			pstmt.setInt(1, id);
=======
			pstmt.setString(1, num);
>>>>>>> develop
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}