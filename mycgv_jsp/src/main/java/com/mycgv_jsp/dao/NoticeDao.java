package com.mycgv_jsp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.NoticeVo;

@Repository
public class NoticeDao extends DBConn{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * startCount, endCount - ����¡ ó��
	 * */
	public ArrayList<NoticeVo> select(int startCount , int endCount){
		Map<String, Integer> param = new HashMap<String, Integer >();
		param.put("start", startCount);
		param.put("end", endCount);
		
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list", param);
		
		return (ArrayList<NoticeVo>)list;
		
//		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
//		String sql = "SELECT RNO, NID, NTITLE, NCONTENT, NHITS, ID, NDATE" +
//					 "	FROM(SELECT ROWNUM RNO, NID, NTITLE, NCONTENT, NHITS, ID, to_char(NDATE, 'yyyy-mm-dd') NDATE" + 
//				     "  	 FROM(SELECT NID, NTITLE, NCONTENT,NHITS, ID, NDATE FROM MYCGV_NOTICE" + 
//					 "  	 	  ORDER BY NDATE DESC))"+
//					 "	WHERE RNO BETWEEN ? AND ?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setInt(1, startCount);
//			pstmt.setInt(2, endCount);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				NoticeVo noticeVo = new NoticeVo();
//				noticeVo.setRno(rs.getInt(1));
//				noticeVo.setNid(rs.getString(2));
//				noticeVo.setNtitle(rs.getString(3));
//				noticeVo.setNcontent(rs.getString(4));
//				noticeVo.setNhits(rs.getInt(5));
//				noticeVo.setNdate(rs.getString(6));
//				
//				list.add(noticeVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
	}
	
	
	/**
	 * totalRowCount - ��ü �ο� ī��Ʈ(����¡ ó��)
	 * */
	public int totalRowCount() {
			int count = 0;
			String sql = "select count(*) from mycgv_notice";
			getPreparedStatement(sql);
			
			try {
				rs = pstmt.executeQuery();
				while(rs.next()) {				
					count = rs.getInt(1);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return count;		
		}
	/**
	 * updateHits - �Խñ� ��ȸ�� ����
	 * */
	public void updateHits(String nid){
		sqlSession.update("mapper.notice.updateHits",nid);
//		String sql = "update mycgv_notice set nhits = nhits+1 where nid=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, nid);
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}	
	/**
	 * delete - �Խñ� ����
	 * */
	public int delete(String nid) {
		return sqlSession.delete("mapper.notice.delete", nid);
//		int result = 0;
//		String sql = "delete from mycgv_notice where nid=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, nid);
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
	}
	/**
	 * update - �Խñ� ����
	 * */
	public int update(NoticeVo noticeVo) {
		return sqlSession.update("mapper.notice.update", noticeVo);
//		int result = 0;
//		String sql = "update mycgv_notice set ntitle=?, ncontent=? where nid=?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, noticeVo.getNtitle());
//			pstmt.setString(2, noticeVo.getNcontent());
//			pstmt.setString(3, noticeVo.getNid());
//			
//			result = pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
	}
		
	/**
	 * select - �Խñ� �󼼺���
	 * */
	public NoticeVo select(String nid){
		return sqlSession.selectOne("mapper.notice.content", nid);
//		NoticeVo noticeVo = new NoticeVo();
//		String sql = " SELECT NID, NTITLE, NCONTENT, NHITS, NDATE FROM MYCGV_NOTICE WHERE NID = ?";
//		getPreparedStatement(sql);
//		
//		try {
//			pstmt.setString(1, nid);
//			rs = pstmt.executeQuery();
//
//			while(rs.next()) {
//				noticeVo.setNid(rs.getString(1));
//				noticeVo.setNtitle(rs.getString(2));
//				noticeVo.setNcontent(rs.getString(3));
//				noticeVo.setNhits(rs.getInt(4));
//				noticeVo.setNdate(rs.getString(5));
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return noticeVo;
	}
	/**
	 * select - �Խñ� ��ü ����Ʈ
	 * */
	public ArrayList<NoticeVo> select(){
		List<NoticeVo> list = sqlSession.selectList("mapper.notice.list2");
		return (ArrayList<NoticeVo>) list;
//		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
//		String sql = "SELECT ROWNUM RNO, NID, NTITLE, NHITS,TO_CHAR(NDATE,'YYYY-MM-DD') NDATE FROM"
//				+ " (SELECT NID, NTITLE, NHITS, NDATE FROM MYCGV_NOTICE ORDER BY NID DESC)";
//		getPreparedStatement(sql);
//		
//		try {
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				NoticeVo noticeVo = new NoticeVo(); 
//				noticeVo.setRno(rs.getInt(1));
//				noticeVo.setNid(rs.getString(2));
//				noticeVo.setNtitle(rs.getString(3));
//				noticeVo.setNhits(rs.getInt(4));
//				noticeVo.setNdate(rs.getString(5));
//				
//				list.add(noticeVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
	}
	
	/**
	 * insert - �Խñ� ���
	 * */
	public int insert(NoticeVo noticeVo) {
		return sqlSession.insert("mapper.notice.insert", noticeVo);
	}
//		int result = 0;
//		
//		String sql = "INSERT INTO MYCGV_NOTICE(NID, NTITLE, NCONTENT, NHITS, NDATE) VALUES(" + 
//					 "  ('n_'||LTRIM(SEQU_MYCGV_NOTICE.NEXTVAL,'0000')), ?, ?,0,SYSDATE)";
//		getPreparedStatement(sql);
//		try {
//			pstmt.setString(1, noticeVo.getNtitle());
//			pstmt.setString(2, noticeVo.getNcontent());
//			
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return result;
//	} 
	
}
