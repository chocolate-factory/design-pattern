#include "Initial.h"

class MazeFactory {
public:
	MazeFactory();

	virtual Maze* MakeMaze() const {
		return new Maze;
	}
	virtual Wall* MakeWall() const {
		return new Wall;
	}
	virtual Room* MakeRoom(int n) const {
		return new Room(n);
	}
	virtual Door* MakeDoor(Room* r1, Room* r2) const {
		return new Door(r1, r2);
	}

}

class EnchantedMazeFactory: public MazeFactory {
public:
	EnchantedMazeFactory();

	virtual Room* MakeRoom(int n) const {
		return new EnchantedRoom(n, CastSpell());
	}

	virtual Door* MakeDoor(Room* r1, Room* r2) const {
		return new DoorNeedingSpell(r1, r2);
	}

protected:
	Spell* CastSpell() const;
}


Maze* createMaze(MazeFactory& factory) {
	Maze* aMaze = factory.MakeMaze();
	Room* r1 = factory.MakeRoom(1);
	Room* r2 = factory.MakeRoom(2);
	Door* aDoor = factory.MakeDoor(r1, r2);

	aMaze->AddRoom(r1);
	aMaze->AddRoom(r2);

	r1->SetSide(DIRECTION::NORTH, factory.MakeWall());

	r2->SetSide(DIRECTION::WEST, aDoor);

	return aMaze;
}