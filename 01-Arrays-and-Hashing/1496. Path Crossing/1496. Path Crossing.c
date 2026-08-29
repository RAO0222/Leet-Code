class Solution:
    def isPathCrossing(self, path):
        
        # 1) Using a set to store visited coordinates
        visited = set() 
        x, y = 0, 0  # Initializing the starting point (0,0)

        for c in path:
            visited.add((x, y))  # Mark the current coordinate as visited

            # 2) Update the coordinates based on the direction
            if c == 'N':
                y += 1  # Move north
            elif c == 'S':
                y -= 1  # Move south
            elif c == 'E':
                x += 1  # Move east
            else:
                x -= 1  # Move west

            # 3) Check if the current coordinate has been visited before
            if (x, y) in visited:
                return True  # If visited, there's a crossing

        return False  # No crossing found along the path
