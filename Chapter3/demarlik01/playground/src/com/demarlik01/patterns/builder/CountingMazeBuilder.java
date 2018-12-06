package com.demarlik01.patterns.builder;

import java.util.HashMap;
import java.util.Map;

public class CountingMazeBuilder extends MazeBuilder {
  private Integer doors;
  private Integer rooms;

  public CountingMazeBuilder(){
    doors = 0;
    rooms = 0;
  }

  @Override
  public void buildRoom(Integer room) {
    rooms ++;
  }

  @Override
  public void buildDoor(Integer roomFrom, Integer roomTo) {
    doors++;
  }

  public Map<String, Integer> getCounts(){
    Map<String, Integer> map = new HashMap<>();
    map.put("room", rooms);
    map.put("doors", doors);
    return map;
  }
}
