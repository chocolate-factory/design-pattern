package com.demarlik01.patterns.builder;

import com.demarlik01.materials.Direction;
import com.demarlik01.materials.Door;
import com.demarlik01.materials.Maze;
import com.demarlik01.materials.Room;
import com.demarlik01.materials.Wall;

public class StandardMazeBuilder extends MazeBuilder {

  private Maze currentMaze;

  public StandardMazeBuilder(){
    currentMaze = new Maze();
  }

  @Override
  public Maze getMaze(){
    return currentMaze;
  }

  private Direction commonwall(Room room1, Room room2){
    return Direction.EAST;
  }

  @Override
  public void buildRoom(Integer roomNumber){
    if(currentMaze.getRoom(roomNumber) == null){
      Room room = new Room(roomNumber);
      currentMaze.addRoom(room);

      room.setSide(Direction.NORTH, new Wall());
      room.setSide(Direction.SOUTH, new Wall());
      room.setSide(Direction.EAST, new Wall());
      room.setSide(Direction.WEST, new Wall());
    }
  }

  @Override
  public void buildDoor(Integer roomNo1, Integer roomNo2){
    Room room1 = currentMaze.getRoom(roomNo1);
    Room room2 = currentMaze.getRoom(roomNo2);

    Door door = new Door(room1, room2);

    room1.setSide(commonwall(room1, room2), door);
    room1.setSide(commonwall(room2, room1), door);

  }
}
