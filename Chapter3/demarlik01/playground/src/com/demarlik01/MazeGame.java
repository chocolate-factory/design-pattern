package com.demarlik01;

import com.demarlik01.materials.Direction;
import com.demarlik01.materials.Door;
import com.demarlik01.materials.Maze;
import com.demarlik01.materials.Room;
import com.demarlik01.patterns.abstractFactory.MazeFactory;
import com.demarlik01.patterns.builder.CountingMazeBuilder;
import com.demarlik01.patterns.builder.MazeBuilder;

public class MazeGame {
  public Maze createMaze(MazeFactory factory){
    Maze maze = factory.makeMaze();
    Room room1 = factory.makeRoom(1);
    Room room2 = factory.makeRoom(2);
    Door door = factory.makeDoor(room1, room2);

    maze.addRoom(room1);
    maze.addRoom(room2);

    room1.setSide(Direction.EAST, factory.makeWall());
    room1.setSide(Direction.WEST, door);
    room1.setSide(Direction.NORTH, factory.makeWall());
    room1.setSide(Direction.SOUTH, factory.makeWall());

    room2.setSide(Direction.EAST, door);
    room2.setSide(Direction.WEST, factory.makeWall());
    room2.setSide(Direction.NORTH, factory.makeWall());
    room2.setSide(Direction.SOUTH, factory.makeWall());

    return maze;
  }

  public Maze createMaze(MazeBuilder builder){
    return builder.getMaze();
  }

  public Maze createMazeCount(CountingMazeBuilder builder){
    builder.buildRoom(100);
    builder.buildRoom(101);
    builder.buildDoor(100, 101);
    System.out.println(builder.getCounts());
    return builder.getMaze();
  }

  public Maze createComplexMaze(MazeBuilder builder){
    builder.buildRoom(1);
    builder.buildRoom(2);
    builder.buildRoom(1001);
    return builder.getMaze();
  }
}
