#include "Initial.h"

class MazeBuilder {
public:
	virtual void BuildMaze() {}
	virtual void BuildRoom(int roomNo) {}
	virtual void BuildDoor(int roomFrom, int roomTo) {}

	virtual Maze* GetMaze() { return 0; }

protected:
	MazeBuilder();
}

class StandardMazeBuilder: public MazeBuilder {
public:
	StandardMazeBuilder();

	virtual void BuildMaze() { /* ... */ }
	virtual void BuildRoom(int roomNo) { /* ... */ }
	virtual void BuildDoor(int roomFrom, int roomTo) { /* ... */ }

	virtual Maze* GetMaze() { return 0; }

private:
	Maze* _currentMaze;
	/* ... */
}

Maze* createMaze(MazeBuilder& builder) {
	builder.BuildMaze();

	builder.BuildRoom(1);
	builder.BuildRoom(2);
	builder.BuildDoor(1, 2);

	return builder.GetMaze();
}

Maze* createComplexMaze(MazeBuilder& builder) {
	builder.BuildMaze();

	builder.BuildRoom(1);
	builder.BuildRoom(2);
	builder.BuildRoom(3);
	builder.BuildRoom(4);
	builder.BuildRoom(5);
	builder.BuildRoom(6);

	builder.BuildDoor(1, 2);
	builder.BuildDoor(3, 4);
	builder.BuildDoor(4, 5);
	builder.BuildDoor(5, 6);
	builder.BuildDoor(6, 2);

	return builder.GetMaze();
}