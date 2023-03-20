package com.ivonunes.mf.model;

import com.ivonunes.mf.model.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

  private Field field;
  @BeforeEach
  public void beginField(){
    field = new Field(3,3);
  }

  @Test
  void TestAddNeighbourDiff1Up(){
    Field neighbour = new Field(2,3);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }
  @Test
  void TestAddNeighbourDiff1Down(){
      Field neighbour = new Field(4,3);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }
  @Test
  void TestAddNeighbourDiff1Left(){
    Field neighbour = new Field(3,2);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }
  @Test
  void TestAddNeighbourDiff1Right(){
    Field neighbour = new Field(3,4);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }

// DIAGONAL CHECK
  @Test
  void TestAddNeighbourDiff2rightTop(){
    Field neighbour = new Field(2,4);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }

  @Test
  void TestAddNeighbourDiff2leftTop(){
    Field neighbour = new Field(2,2);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }

  @Test
  void TestAddNeighbourDiff2rightBottom(){
    Field neighbour = new Field(4,4);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }

  @Test
  void TestAddNeighbourDiff2leftBottom(){
    Field neighbour = new Field(4,2);
    boolean result = field.addNeighbour(neighbour);
    assertTrue(result);
  }

  // NOT NEIGHBOUR
  @Test
  void TestAddNeighbourNotBeighbour(){
    Field neighbour = new Field(1,2);
    boolean result = field.addNeighbour(neighbour);
    assertFalse(result);
  }

  // Verify the transition between MARKED and not MARKED Field
  @Test
  void changeMarkedTest(){
    assertFalse(field.isMarked());
    }

  @Test
  void changeMarkedTestTrue(){
    field.changeMarked();
    assertTrue(field.isMarked());
  }

}
