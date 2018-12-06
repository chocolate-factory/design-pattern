package com.demarlik01.patterns.builder;

import com.demarlik01.materials.Maze;

public class MazeBuilder {
  public void buildMaze(){
  }

  public void buildRoom(Integer room){
  }

  public void buildDoor(Integer roomFrom, Integer roomTo){
  }

  protected MazeBuilder(){
  }

  public Maze getMaze(){
    return new Maze();
  }
}
