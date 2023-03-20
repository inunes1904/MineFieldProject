package com.ivonunes.mf;

import com.ivonunes.mf.model.Board;
import com.ivonunes.mf.view.BoardConsole;

public class Aplication {
    public static void main(String[] args) {

        Board board = new Board(6,6,3);

        new BoardConsole(board);

        System.out.println(board);
    }
}
