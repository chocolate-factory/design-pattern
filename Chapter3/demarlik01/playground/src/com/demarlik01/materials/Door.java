package com.demarlik01.materials;

public class Door implements MapSite{

  Room room1;
  Room room2;

  public Door(Room room1, Room room2) {
    this.room1 = room1;
    this.room2 = room2;
  }

  @Override
  public void enter() {
    System.out.println("Enter Room");
  }
}
