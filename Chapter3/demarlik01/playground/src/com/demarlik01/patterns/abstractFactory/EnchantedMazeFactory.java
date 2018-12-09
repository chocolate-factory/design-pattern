package com.demarlik01.patterns.abstractFactory;

import com.demarlik01.materials.Door;
import com.demarlik01.materials.DoorNeedingSpell;
import com.demarlik01.materials.Room;

public class EnchantedMazeFactory extends MazeFactory {

  @Override
  public Room makeRoom(Integer no) {
    return new EnchantedRoom(no, "spell~");
  }

  @Override
  public Door makeDoor(Room r1, Room r2) {
    return new DoorNeedingSpell(r1, r2);
  }
}
