package com.ivonunes.mf.view;

import com.ivonunes.mf.exception.ExplosionException;
import com.ivonunes.mf.exception.LeaveException;
import com.ivonunes.mf.model.Board;

import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class BoardConsole {

    private Board board;
    private Scanner sc = new Scanner(System.in);

    public BoardConsole(Board board){
        this.board = board;
        executeGame();
    }

    private void executeGame() {
        try {
            boolean continueGame = true;
            while(continueGame){
                gameLoop();
                System.out.println("Another Game? (y/n)");
                String answer = sc.nextLine();
                if ("n".equalsIgnoreCase(answer.trim())){
                    continueGame = false;
                }else{
                    board.reset();
                }
            }
        }catch (LeaveException e){
            System.out.println(e);
            System.out.println("GoodBye...");
        }finally {
            sc.close();
        }
    }

    private void gameLoop() {
        try{

            while(!board.objectiveDone()){
                System.out.println(board);
                String enter = captureEnterDigit("Enter (x,y): ");

                Iterator<Integer> xy = Arrays.stream(enter.split(","))
                        .map(e -> Integer.parseInt(e.trim())).iterator();

                enter = captureEnterDigit("1 - to Open 2 - Mark or UnMark: ");
                if ("1".equals(enter)){
                    board.openField(xy.next(),xy.next());
                }else if ("2".equals(enter)) {
                    board.markField(xy.next(),xy.next());
                }
            }
            System.out.println(board);
            System.out.println("You Win!");
        }catch(ExplosionException e){
            System.out.println(board);
            System.out.println("You Lost!");
        }
    }

    private String captureEnterDigit(String text){
        System.out.print(text);
        String enter = sc.nextLine();

        if("leave".equalsIgnoreCase(enter)){
            throw new LeaveException();
        }
        return enter;
    }
}
