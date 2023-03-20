package com.ivonunes.mf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Board {

  private int lines;
  private int columns;

  private int mines;

  private final List<Field> fields = new ArrayList<>();

  public Board(int lines, int columns, int mines) {
    this.lines = lines;
    this.columns = columns;
    this.mines = mines;

    generateFields();
    joinNeighbours();
    generateMines();
  }

  private void generateFields() {
    for (int i = 0; i < lines ; i++) {
      for (int j = 0; j < columns; j++) {
        fields.add( new Field(i,j));
      }
    }
  }

  private void joinNeighbours() {
    for (Field f: fields){
      for (Field f2: fields){
          f.addNeighbour(f2);
      }
    }
  }
  private void generateMines() {
    long activatedMines = 0;
    Predicate<Field> mined = f -> f.isMined();
    do {
      activatedMines = fields.stream().filter(mined).count();
      int randomNumber = 1;
      fields.get(randomNumber).setMine();
    }while(activatedMines<mines);
  }
}
