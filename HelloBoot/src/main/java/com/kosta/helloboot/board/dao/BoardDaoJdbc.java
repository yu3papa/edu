package com.kosta.helloboot.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kosta.helloboot.board.vo.Board;

@Repository
public class BoardDaoJdbc implements BoardDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Board insertNewBoard(Board board) {
		StringBuffer qeury = new StringBuffer();
		qeury.append(" INSERT INTO POST (SUBJECT, CONTENT )  ");
		qeury.append(" VALUES (?,?)                          ");
		
		int insertCount = jdbcTemplate.update(qeury.toString(), board.getSubject(), board.getContent());
		
		
		return board;
	}

	@Override
	public Board selectOneBoard(long boardId) {
		StringBuffer qeury = new StringBuffer();
		qeury.append(" SELECT * FROM POST WHERE POST_ID = ?  ");
		
		return jdbcTemplate.queryForObject(qeury.toString()
				                   , new RowMapper<Board>() {
									@Override
									public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
										Board board = new Board();
										board.setPostId(rs.getLong("POST_ID"));
										board.setSubject(rs.getString("SUBJECT"));
										board.setContent(rs.getString("CONTENT"));
										return board;
									}}
									, boardId);
	}

	@Override
	public List<Board> selectAllBoards() {
		StringBuffer qeury = new StringBuffer();
		qeury.append(" SELECT * FROM POST ORDER BY POST_ID DESC");
		
		return jdbcTemplate.query(qeury.toString()
				                   , new RowMapper<Board>() {
									@Override
									public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
										Board board = new Board();
										board.setPostId(rs.getLong("POST_ID"));
										board.setSubject(rs.getString("SUBJECT"));
										board.setContent(rs.getString("CONTENT"));
										return board;
									}});
	}

	@Override
	public void deleteOneBoard(long boardId) {
		StringBuffer qeury = new StringBuffer();
		qeury.append(" DELETE FROM POST WHERE POST_ID = ? ");
		
		int deleteCount = jdbcTemplate.update(qeury.toString(), boardId);
	}

	@Override
	public Board updateOneBoard(Board board) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE POST         ");
		query.append("SET SUBJECT = ?     ");
		query.append("		, CONTENT = ? ");
		query.append("WHERE POST_ID = ?   ");
		
		int updateCount = jdbcTemplate.update(query.toString(), board.getSubject(), board.getContent(), board.getPostId());
		return this.selectOneBoard(board.getPostId());
	}

}
