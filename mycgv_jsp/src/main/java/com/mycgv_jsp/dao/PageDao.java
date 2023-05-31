package com.mycgv_jsp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PageDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * totalRowCount - 전체 로우 카운트(페이징 처리)
	 * */
	public int totalRowCount(String sname) {
		return sqlSession.selectOne("mapper.page.count", sname);
		
//		int count = 0;
//		String sql = "select count(*) from mycgv_notice";
//		getPreparedStatement(sql);
//		
//		try {
//			rs = pstmt.executeQuery();
//			while(rs.next()) {				
//				count = rs.getInt(1);
//			}			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return count;		
		}
	
}
