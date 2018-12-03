package com.demarlik01.materials;

import java.util.HashMap;
import java.util.Map;

public class Room implements MapSite {

  private Integer no;
  private Map<Direction,MapSite> sites = new HashMap<>();

  public Room(Integer no) {
    this.no = no;
  }

  @Override
  public void enter() {
    System.out.println("Room Entered");
  }

  public void setSide(Direction direction, MapSite mapSite) {
    this.sites.put(direction, mapSite);
  }

}
