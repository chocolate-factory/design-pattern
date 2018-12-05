import abc

# Abstract Factory
class MazeFactory:
	__metaclass__ = abc.ABCMeta

	def make_maze(self):
		pass

	def make_room(self):
		pass

# A derived class from Abstract Factory
class EnchantedMazeFactory(MazeFactory):
	def make_maze(self):
		# logic about enchanted maze
		pass

	def make_room(self):
		# logic about enchanted room
		pass



# use it
def create_maze(maze_factory)
	maze = maze_factory.make_maze()
	room = maze_factory.make_room()

if __name__ == "__main__":
	maze_factory = EnchantedMazeFactory()
    create_maze(maze_factory)