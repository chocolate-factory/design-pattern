#include "Initial.h"

class MazePrototypeFactory: public MazeFactory {
public:
	MazePrototypeFactory(Maze* m, Wall* w, Room* r, Door* d) {
		_prototypeMaze = m;
		_prototypeRoom = r;
		_prototypeWall = w;
		_prototypeDoor = d;
	}

	virtual Maze* MakeMaze() const { /* ... */ }
	virtual Room* MakeRoom(int) const { /* ... */ }
	virtual Wall* MakeWall() const {
		return _prototypeWall->Clone();
	}
	virtual Door* MakeDoor(Room* r1, Room* r2) const {
		Door* door = _prototypeDoor->Clone();
		door->Initialize(r2, r2);
		return door;
	}

private:
	Maze* _prototypeMaze;
	Room* _prototypeRoom;
	Wall* _prototypeWall;
	Door* _prototypeDoor;
}

MazePrototypeFactory simpleMazeFactory(
	new Maze, new Wall, new Room, new Door
);

Maze* maze = createMaze(simpleMazeFactory);
