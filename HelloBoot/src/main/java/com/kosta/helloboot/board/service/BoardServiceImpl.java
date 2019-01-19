package com.kosta.helloboot.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kosta.helloboot.board.dao.BoardDao;
import com.kosta.helloboot.board.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired // BoardDao를 구현한 클래스를 가져와서 주입해라!!!
	@Qualifier("boardDaoJdbc")
	private BoardDao boardDao;

	@Override
	public Board createNewBoard(Board board) {
		this.boardDao.insertNewBoard(board);
		return null;
	}

	@Override
	public Board findOneBoard(long boardId) {
		return this.boardDao.selectOneBoard(boardId);
//		
//		try {
//			return this.boardDao.selectOneBoard(boardId);
//		} catch (RuntimeException e) {
//			return null;
//		}
	}

	@Override
	public List<Board> findAllBoards() {
		return this.boardDao.selectAllBoards();
	}

	@Override
	public void deleteOneBoard(long boardId) {
		this.boardDao.deleteOneBoard(boardId);

	}

	@Override
	public Board updateOneBoard(Board board) {
		return this.boardDao.updateOneBoard(board);
	}

}
