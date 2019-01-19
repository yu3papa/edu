package com.kosta.helloboot.board.service;

import java.util.List;

import com.kosta.helloboot.board.vo.Board;

public interface BoardService {
	public Board createNewBoard(Board board);

	public Board findOneBoard(long boardId);

	public List<Board> findAllBoards();

	public void deleteOneBoard(long boardId);

	public Board updateOneBoard(Board board);
}
