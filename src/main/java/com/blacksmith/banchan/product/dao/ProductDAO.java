package com.blacksmith.banchan.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.DBManager;

public class ProductDAO {
	public ProductDAO() {
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	// Read
	public List<ProductVO> selectAllProducts() {
		// 최근 등록한 상품 먼저 출력하기
		String sql = "select * from tbl_product order by code desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) { // 이동은 행(로우) 단위로
				ProductVO pVo = new ProductVO();
				pVo.setCode(rs.getInt("code"));
				pVo.setProductName(rs.getString("productName"));
				pVo.setPrice(rs.getInt("price"));
				pVo.setCategory(rs.getInt("category"));
				pVo.setPictureUrl(rs.getString("pictureUrl"));
				pVo.setDescription(rs.getString("description"));
				list.add(pVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 상품등록
	//Create

		public void insertProduct(ProductVO pVo) {
			
			System.out.println("ll");
			String sql = "insert into tbl_product (productname, price, category, pictureurl, description) values(?,?,?,?,?)";
			
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				System.out.println("ll");
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pVo.getProductName());
				pstmt.setInt(2, pVo.getPrice());
				pstmt.setInt(3, pVo.getCategory());
				pstmt.setString(4, pVo.getPictureUrl());
				pstmt.setString(5, pVo.getDescription());
				pstmt.executeUpdate(); // 실행
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		
		//Read
		public ProductVO selectProductByCode(String code) {
			String sql = "select * from tbl_product where code=?";
			ProductVO pVo = null;

			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, code);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						pVo = new ProductVO();
						pVo.setCode(rs.getInt("code"));
						pVo.setProductName(rs.getString("productname"));
						pVo.setPrice(rs.getInt("price"));
						pVo.setCategory(rs.getInt("category"));
						pVo.setPictureUrl(rs.getString("pictureUrl"));
						pVo.setDescription(rs.getString("description"));

					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(conn, pstmt, rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return pVo;
		}
		
		//update 
		public void updateProduct(ProductVO pVo) {
			String sql = "UPDATE tbl_product SET productname=?, price=?, category=?,pictureurl=?, description=? WHERE code=?";
			
			System.out.println("dddjjjfffjjjfjjsjfj");
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pVo.getProductName());
				pstmt.setInt(2, pVo.getPrice());
				pstmt.setInt(3, pVo.getCategory());
				pstmt.setString(4, pVo.getPictureUrl());
				pstmt.setString(5, pVo.getDescription());
				pstmt.setInt(6, pVo.getCode());
				pstmt.executeUpdate(); // 쿼리문 실행

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		//delete
		public void deleteProduct(String code) {
			String sql = "DELETE FROM tbl_product WHERE code=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				pstmt.executeUpdate();// 쿼리문 실행
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public List<ProductVO> selectProductsByCategory(int category) {
			String sql = "select * from tbl_product WHERE category=?";
			List<ProductVO> list = new ArrayList<ProductVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				System.out.println("ddddddddddddddddll");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, category);
				System.out.println("ddddddddddddddddll");
				rs = pstmt.executeQuery();
				while (rs.next()) { // 이동은 행(로우) 단위로
					ProductVO pVo = new ProductVO();
					pVo.setCode(rs.getInt("code"));
					pVo.setProductName(rs.getString("productName"));
					pVo.setPrice(rs.getInt("price"));
					pVo.setCategory(rs.getInt("category"));
					pVo.setPictureUrl(rs.getString("pictureUrl"));
					pVo.setDescription(rs.getString("description"));
					list.add(pVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}
		
		public List<ProductVO> selectProductsBySearchWord(String searchWord) {
			String sql = "select * from tbl_product WHERE productName LIKE ?";
			List<ProductVO> list = new ArrayList<ProductVO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + searchWord + "%");
				rs = pstmt.executeQuery();
				while (rs.next()) { // 이동은 행(로우) 단위로
					ProductVO pVo = new ProductVO();
					pVo.setCode(rs.getInt("code"));
					pVo.setProductName(rs.getString("productName"));
					pVo.setPrice(rs.getInt("price"));
					pVo.setCategory(rs.getInt("category"));
					pVo.setPictureUrl(rs.getString("pictureUrl"));
					pVo.setDescription(rs.getString("description"));
					list.add(pVo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}

		public List<ProductVO> selectProductsByCategoryCountNineLess(int category) {
			String sql = "select * from tbl_product WHERE category=? order by code limit 8";
			

		    List<ProductVO> list = new ArrayList<ProductVO>();
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1, category);
		        rs = pstmt.executeQuery();
		        while (rs.next()) {
		            ProductVO pVo = new ProductVO();
		            pVo.setCode(rs.getInt("code"));
		            pVo.setProductName(rs.getString("productName"));
		            pVo.setPrice(rs.getInt("price"));
		            pVo.setCategory(rs.getInt("category"));
		            pVo.setPictureUrl(rs.getString("pictureUrl"));
		            pVo.setDescription(rs.getString("description"));
		            list.add(pVo);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt, rs);
		    }
		    return list;
		}




}