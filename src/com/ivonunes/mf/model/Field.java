package com.ivonunes.mf.model;

import com.ivonunes.mf.exception.ExplosionException;

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

  boolean open(){
    /*
    Verify if the field is marked because you can only open a field
    if the field is not marked, if user tried to open a mined field
    it throws a new ExplosionException and if all neighbours are safe
    he opens all the fields
     */
    if (!marked && !open ){
      this.open = true;
      if ( mine ){
        throw new ExplosionException();
      }
      if (safeNeighbour()){
        neighbours.forEach(n -> n.open());
      }
      return true;
    }
    return false;
  }

  boolean safeNeighbour(){
    /*
    Verify if the neighbours don't have mines and
    returns true if they are clean
     */
    return neighbours.stream().noneMatch(n -> n.mine);
  }

  public boolean isMarked(){
    return marked;
  }

}
