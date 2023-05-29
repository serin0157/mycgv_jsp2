package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.dao.NoticeDao;
import com.mycgv_jsp.vo.NoticeVo;

public class NoticeServiceImpl implements NoticeService{
	private NoticeDao noticeDao = new NoticeDao();
	
	
	public int getInsert(NoticeVo noticeVo) {
		return noticeDao.insert(noticeVo);
	}
	
	public ArrayList<NoticeVo> getSelect(int startCount, int endCount){
		return noticeDao.select(startCount, endCount);
	}
	
	public NoticeVo getSelect(String nid) {
		return noticeDao.select(nid);
	}
	
	public int getUpdate(NoticeVo noticeVo) {
		return noticeDao.update(noticeVo);
	}
	
	public int getDelete(String nid) {
		return noticeDao.delete(nid);
	}
	
	public int getTotalRowCount() {
		return noticeDao.totalRowCount();
	}
	
	public void getUpdateHits(String nid) {
		noticeDao.updateHits(nid);
	}
}
