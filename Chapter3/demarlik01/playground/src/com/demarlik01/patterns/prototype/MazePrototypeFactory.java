package com.demarlik01.patterns.prototype;

import com.demarlik01.materials.Door;
import com.demarlik01.materials.Maze;
import com.demarlik01.materials.Room;
import com.demarlik01.materials.Wall;
import com.demarlik01.patterns.abstractFactory.MazeFactory;

public class MazePrototypeFactory extends MazeFactory {

  private Maze mazePrototype;
  private Wall wallPrototype;
  private Room roomPrototype;
  private Door doorPrototype;

  public MazePrototypeFactory(Maze maze, Wall wall, Room room, Door door){
    this.mazePrototype = maze;
    this.wallPrototype = wall;
    this.roomPrototype = room;
    this.doorPrototype = door;
  }

  @Override
  public Door makeDoor(Room r1, Room r2) {
    Door door = doorPrototype.clone();
    door.initialize(r1, r2);
    return door;
  }
}
