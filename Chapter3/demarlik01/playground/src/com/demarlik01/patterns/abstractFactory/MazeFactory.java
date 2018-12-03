package com.demarlik01.patterns.abstractFactory;

import com.demarlik01.materials.Door;
import com.demarlik01.materials.Maze;
import com.demarlik01.materials.Room;
import com.demarlik01.materials.Wall;

public class MazeFactory {

  public Maze makeMaze() {
    return new Maze();
  }

  public Wall makeWall() {
    return new Wall();
  }

  public Room makeRoom(Integer no) {
    return new Room(no);
  }

  public Door makeDoor(Room r1, Room r2) {
    return new Door(r1, r2);
  }

}
