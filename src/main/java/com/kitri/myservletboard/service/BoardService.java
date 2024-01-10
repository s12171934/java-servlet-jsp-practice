package com.kitri.myservletboard.service;

import com.kitri.myservletboard.dao.BoardDao;
import com.kitri.myservletboard.dao.BoardJdbc;
import com.kitri.myservletboard.data.Board;
import com.kitri.myservletboard.data.Pagination;

import java.util.ArrayList;

public class BoardService {
    private BoardDao boardDao = BoardJdbc.getInstance();
    private static final BoardService instance = new BoardService();
    private BoardService(){}
    public static BoardService getInstance(){
        return instance;
    }
    public ArrayList<Board> getBoards(Pagination pagination){
        return boardDao.getAll(pagination);
    }
    public Board getBoard(Long id){
        return boardDao.getById(id);
    }
    public void addBoard(Board board){boardDao.save(board);}
    public void updateBoard(Board board){
        boardDao.update(board);
    }
    public void deleteBoard(Board board){
        boardDao.delete(board);
    }
    public int getTotalRow(){return boardDao.getTotal();}
}
