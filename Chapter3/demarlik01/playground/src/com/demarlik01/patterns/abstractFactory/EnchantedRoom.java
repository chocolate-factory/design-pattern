package com.demarlik01.patterns.abstractFactory;

import com.demarlik01.materials.Room;

public class EnchantedRoom extends Room {

  private String spell;

  public EnchantedRoom(Integer no, String spell) {
    super(no);
    this.spell = spell;
  }

}
