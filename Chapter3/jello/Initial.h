#ifndef __INITIAL_H__
#define __INITIAL_H__


namespace DIRECTION {
	enum {
		NORTH, SOUTH, EAST, WEST
	};
}

class MapSite {
public:
	// Pure virtual function
	virtual void Enter() = 0;
};


class Room: public MapSite {
public:
	Room(int RoomNo);

	MapSite* GetSide(Direction) const;
	void SetSide(Direction, MapSite*);

	virtual void Enter();

private:
	MapSite* _sides[4];
	int _roomNumber;
};


class Wall: public MapSite {
public:
	Wall();

	virtual void Enter();
};


class Door: public MapSite {
public:
	Door(Room* = 0, Room* = 0);

	virtual void Enter();
	Room* OhterSideFrom(Room*);

private:
	Room* _room1;
	Room* _room2;
	bool _isOpen;
};


class Maze {
public:
	Maze();

	void AddRoom(Room*);
	Room* RoomNo(int) const;
};


class MazeGame {
public:
	MazeGame();

	Maze* CreateMaze()
};
