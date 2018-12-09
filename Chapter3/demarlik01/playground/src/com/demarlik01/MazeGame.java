package com.demarlik01;

import com.demarlik01.materials.*;
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

  public Maze makeMaze(){
    return new Maze();
  }

  public Room makeRoom(Integer n){
    return new Room(n);
  }

  public Wall makeWall(){
    return new Wall();
  }

  public Door makeDoor(Room r1, Room r2){
    return new Door(r1, r2);
  }

  public Maze createMaze(){
    Maze maze = makeMaze();

    Room r1 = makeRoom(1);
    Room r2 = makeRoom(2);
    Door door = makeDoor(r1, r2);

    maze.addRoom(r1);
    maze.addRoom(r2);

    r1.setSide(Direction.NORTH, makeWall());
    r1.setSide(Direction.EAST, door);
    r1.setSide(Direction.WEST, makeWall());
    r1.setSide(Direction.SOUTH, makeWall());

    r2.setSide(Direction.NORTH, makeWall());
    r2.setSide(Direction.EAST, makeWall());
    r2.setSide(Direction.WEST, makeWall());
    r2.setSide(Direction.SOUTH, door);

    return maze;
  }

}
