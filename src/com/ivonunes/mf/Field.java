package com.ivonunes.mf;

import java.util.ArrayList;
import java.util.List;

public class Field {

  private boolean mine = false;
  private boolean open = false;
  private boolean marked = false;
  private List<Field> neighbours = new ArrayList<>();
  private int line;
  private int column;


  public Field( int line, int column) {
    this.line = line;
    this.column = column;
  }

  // neighbour LOGIC
  boolean addNeighbour(Field neighbour){

    if ( Math.abs(this.line - neighbour.line) +
         Math.abs(this.column - neighbour.column) == 1 ){
      System.out.println("Is neighbour !!!!");
    }

  }


}
