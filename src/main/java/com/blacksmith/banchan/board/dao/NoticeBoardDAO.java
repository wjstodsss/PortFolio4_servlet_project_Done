package com.blacksmith.banchan.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blacksmith.banchan.board.dto.NoticeBoardVO;
import com.blacksmith.banchan.util.DBManager;





public class NoticeBoardDAO {
	private NoticeBoardDAO() {
	}

	private static NoticeBoardDAO instance = new NoticeBoardDAO();

	public static NoticeBoardDAO getInstance() {
		return instance;
	}

	public List<NoticeBoardVO> selectAllBoards() {


		String sql = "select * from tbl_notice order by id desc";


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

				bVo.setId(rs.getInt("id"));
				bVo.setTitle(rs.getString("title"));
				bVo.setAuthor(rs.getString("author"));
				bVo.setPassword(rs.getString("password"));
				bVo.setContent(rs.getString("content"));
				bVo.setImageUrl(rs.getString("imageurl"));
				bVo.setReadCount(rs.getInt("readCount"));
				bVo.setDatePosted(rs.getTimestamp("datePosted"));

				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}


	
	
	
	
	
	public void insertBoard(NoticeBoardVO bVo) {
		String sql = "insert into tbl_notice(title, author, password, content, imageurl) values(?, ?, ?, ?, ?)";


		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getAuthor());
			pstmt.setString(3, bVo.getPassword());
			pstmt.setString(4, bVo.getContent());
			pstmt.setString(5, bVo.getImageUrl());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그에 기록
			throw new RuntimeException("!! 글 작성 중에 오류가 발생했습니다.", e);

		} finally {
			DBManager.close(conn, pstmt);
		}
	}


	public void updateReadCount(int id) {
		String sql = "update tbl_notice set readcount=readcount+1 where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,

	public NoticeBoardVO selectOneBoardById(int id) {
		String sql = "select * from tbl_notice where id = ?";


		NoticeBoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

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

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBoard(NoticeBoardVO bVo) {


		String sql = "update tbl_notice set title=?, author=?, password=?, content=?, imageUrl=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getAuthor());
			pstmt.setString(3, bVo.getPassword());
			pstmt.setString(4, bVo.getContent());
			pstmt.setString(5, bVo.getImageUrl());
			pstmt.setInt(6, bVo.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}


	public void deleteBoard(int id) {
		String sql = "delete from tbl_notice where id=?";

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