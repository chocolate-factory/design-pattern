package com.demarlik01;

import com.demarlik01.materials.Door;
import com.demarlik01.materials.Maze;
import com.demarlik01.materials.Room;
import com.demarlik01.materials.Wall;
import com.demarlik01.patterns.abstractFactory.EnchantedMazeFactory;
import com.demarlik01.patterns.abstractFactory.MazeFactory;
import com.demarlik01.patterns.builder.CountingMazeBuilder;
import com.demarlik01.patterns.builder.StandardMazeBuilder;
import com.demarlik01.patterns.prototype.MazePrototypeFactory;

public class Main {
  public static void main(String[] args) {
    // Abstract factory
    // 손쉽게 제품군을 대체 할 수 있다. 하지만 정말 시그니쳐가 같아야 함.
    // abstract factory는 정말 abstract 하게 혹은 interface로 강제해야 하는것인가 생각..
    MazeGame game1 = new MazeGame();
    game1.createMaze(new EnchantedMazeFactory());

    MazeGame game2 = new MazeGame();
    game2.createMaze(new MazeFactory());

    // Builder
    //
    MazeGame game3 = new MazeGame();
    game3.createMaze(new StandardMazeBuilder());

    MazeGame game4 = new MazeGame();
    game4.createMaze(new CountingMazeBuilder());

    //Factory method
    MazeGame game5 = new BoombedMazeGame();
    game5.createMaze();

    MazeGame game6 = new MazeGame();
    game6.createMaze(new MazePrototypeFactory(
        new Maze(), new Wall(), new Room(123), new Door(new Room(123), new Room(124))
    ));

  }
}
