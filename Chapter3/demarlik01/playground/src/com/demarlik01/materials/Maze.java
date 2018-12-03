package com.demarlik01.materials;

import java.util.ArrayList;
import java.util.List;

public class Maze {

  private List<Room> rooms = new ArrayList<Room>();

  public void addRoom(Room room) {
    this.rooms.add(room);
  }

  public List<Room> getRooms() {
    return this.rooms;
  }
}
