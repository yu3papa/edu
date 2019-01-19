package com.kosta.helloboot.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.kosta.helloboot.board.vo.Board;

@Repository
public class BoardDaoInMemory implements BoardDao {
	private Map<Long, Board> boardMap;
	private long boardId;

	public BoardDaoInMemory() {
		this.boardMap = new HashMap<>();
		this.boardId = 0;
	}

	@Override
	public Board insertNewBoard(Board board) {
		board.setPostId(++boardId);
		this.boardMap.put(boardId, board);

		return null;
	}

	@Override
	public Board selectOneBoard(long boardId) {
		return this.boardMap.get(boardId);
	}

	@Override
	public List<Board> selectAllBoards() {
		return this.boardMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}

	@Override
	public void deleteOneBoard(long boardId) {
		this.boardMap.remove(boardId);

	}

	@Override
	public Board updateOneBoard(Board board) {
		Board originalBoard = this.selectOneBoard(board.getPostId());

		board.setPostId(originalBoard.getPostId());

		this.boardMap.put(originalBoard.getPostId(), board);
		return board;

	}
}
