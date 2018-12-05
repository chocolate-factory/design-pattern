import abc

# Builder
class MazeBuilder:
	__metaclass__ = abc.ABCMeta

	def build_maze(self):
		pass

	def build_room(self):
		pass

# A derived class from Builder
class StandardMazeBuilder(MazeBuilder):
	def build_maze(self):
		# logic about enchanted maze
		pass

	def build_room(self):
		# logic about enchanted room
		pass



# use it
def create_maze(maze_bulider)
	maze = maze_bulider.build_maze()
	room = maze_bulider.build_room()

if __name__ == "__main__":
	maze_bulider = EnchantedMazeFactory()
    create_maze(maze_bulider)