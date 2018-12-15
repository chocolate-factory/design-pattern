package com.demarlik01.materials;

public class Door implements MapSite{

  Room room1;
  Room room2;

  public Door(Room room1, Room room2) {
    this.room1 = room1;
    this.room2 = room2;
  }

  // clone 생성자
  public Door(Door door){
    this.room1 = door.room1;
    this.room2 = door.room2;
  }

  public void initialize(Room room1, Room room2){
    this.room1 = room1;
    this.room2 = room2;
  }

  public Door clone(){
    return new Door(this);
  }

  @Override
  public void enter() {
    System.out.println("Enter Room");
  }
}
