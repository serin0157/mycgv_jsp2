package com.mycgv_jsp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycgv_jsp.dao.BoardDao;
import com.mycgv_jsp.vo.BoardVo;

public class BoardServiceImpl implements BoardService{
	//private BoardDao boardDao = new BoardDao();
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int getTotalRowCount() {
		return boardDao.totalRowCount();
	}
	
	@Override
	public ArrayList<BoardVo> getSelet(int startCount, int endCount){
		return boardDao.select(startCount, endCount);
	}
	
	@Override
	public void getUpdateHits(String bid) {
		boardDao.updateHits(bid);
	}
	
	@Override
	public int getBoardDelete(String bid) {
		return boardDao.delete(bid);
	}
	
	@Override
	public int getBoardUpdate(BoardVo boardVo) {
		return boardDao.update(boardVo);
	}
	
	@Override
	public int getBoardWrite(BoardVo boardVo) {
		return boardDao.insert(boardVo);
	}
	
	@Override
	public BoardVo getBoardContent(String bid) {
		return boardDao.select(bid);
		
	}
}
