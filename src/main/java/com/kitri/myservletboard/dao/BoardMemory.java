package com.kitri.myservletboard.dao;

import com.kitri.myservletboard.data.Board;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BoardMemory{
    private static final BoardMemory instance = new BoardMemory();
    private ArrayList<Board> memoryBoardDB = new ArrayList<>();
    private Long sequnece;
    private BoardMemory() {
        memoryBoardDB.add(new Board(1L,"첫 글","안녕","누1구", LocalDateTime.now(),10,1));
        memoryBoardDB.add(new Board(2L,"두 글","안녕","누2구", LocalDateTime.now(),9,3));
        memoryBoardDB.add(new Board(3L,"세 글","안녕","누3구", LocalDateTime.now(),8,5));
        memoryBoardDB.add(new Board(4L,"네 글","안녕","누4구", LocalDateTime.now(),7,7));
        memoryBoardDB.add(new Board(5L,"다섯 글","안녕","누5구", LocalDateTime.now(),6,9));
        memoryBoardDB.add(new Board(6L,"여섯 글","안녕","누6구", LocalDateTime.now(),5,11));
        memoryBoardDB.add(new Board(7L,"일곱 글","안녕","누7구", LocalDateTime.now(),4,13));
        memoryBoardDB.add(new Board(8L,"여덟 글","안녕","누8구", LocalDateTime.now(),3,15));
        memoryBoardDB.add(new Board(9L,"아홉 글","안녕","누9구", LocalDateTime.now(),2,17));
        memoryBoardDB.add(new Board(10L,"열 글","안녕","누0구", LocalDateTime.now(),1,19));
        sequnece = memoryBoardDB.stream().mapToLong(board -> board.getId()).max().getAsLong();
    }
    public static BoardMemory getInstance(){
        return instance;
    }

    //@Override
    public ArrayList<Board> getAll(int page, int rows) {
        return memoryBoardDB;
    }

    //@Override
    public Board getById(Long id) {
        return memoryBoardDB.stream().filter(board -> board.getId() == id).findFirst().get();
    }

    //@Override
    public void save(Board board) {
        board.setId(++sequnece);
        memoryBoardDB.add(board);

    }

    //@Override
    public void update(Board board) {
        Board board_ = getById(board.getId());
        board_.setTitle(board.getTitle());
        board_.setContent(board.getContent());
    }

    //@Override
    public void delete(Board board) {
        memoryBoardDB.remove(board);
    }
}
