package com.ivonunes.mf.model;

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

    /*
    In this function we receive a possible neighbour we verify if we can
    add it to the list of neighbours of the correspondent field object
    if YES we add it to the list otherwise we return false
     */

    boolean differentLine = this.line != neighbour.line;
    boolean differentColumn = this.column != neighbour.column;
    boolean diagonal = differentLine && differentColumn;
    int diffColumn = Math.abs(this.column - neighbour.column);
    int diffLine = Math.abs(this.line - neighbour.line);
    int diffTotal = diffColumn+diffLine;

    if (!diagonal && diffTotal == 1){
      neighbours.add(neighbour);
      return true;

    }else if (diagonal && diffTotal == 2){
      neighbours.add(neighbour);
      return true;
    }

    return false;
  }

  void changeMarked(){
    /*
    Function that will add the possibility to mark a field
    just like the mine swiper game when you think that is
    a mine you mark the field
     */
    if (!open){
      this.marked = !marked;
    }
  }




}
