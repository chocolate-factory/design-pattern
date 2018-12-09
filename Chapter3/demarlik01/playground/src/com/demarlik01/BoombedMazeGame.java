package com.demarlik01;

import com.demarlik01.materials.BombedRoom;
import com.demarlik01.materials.BombedWall;
import com.demarlik01.materials.Room;
import com.demarlik01.materials.Wall;

public class BoombedMazeGame extends MazeGame {

    @Override
    public Wall makeWall() {
        return new BombedWall();
    }

    @Override
    public Room makeRoom(Integer n) {
        return new BombedRoom(n);
    }
}
