## About this project ##

This is the [coursera.org Advanced Data Structures in Java](https://www.coursera.org/learn/advanced-data-structures) published by University of California, San Diego as a part of their Object Oriented Java Programming: Data Structures and Beyond Specialization.  

All course credits belong to course creators: Mia Minnes, Christine Alvarado, Leo Porter, Alec Brickner; and the appropriate project stakeholders. 

You can find original project "readme" in this project under README-original. You can find original licencing conditions under this project as LICENSE.

## For Project Students ##  
The repository is my solution for course problems. It is not most efficient or most optimal solutions. Any constructive comments for code improvement are welcome.

Please also do not copy my work. Try to come with your own ideas and your own way of code(variables, iterations, etc.) Try to spend times over week exercises and try at least few different approaches to the course problems if you stuck. Trust me if I tell you it is even better to leave the course and return to it couple weeks later if you do not know the solutions right away.


## Installation ##
This is project build with Eclipse. Installation is otherwise easy: 

1) Download the repository
2) Import this project into the Eclipse as new Java project 

Feel free to use another IDE or manually compile and run your programs.
If you need help, google is your friend.

## Development & Study Notes ##

### Week 1 ###
The first week focused solely on setting up the project environment. Go according to the tutorial in a course, and you will be fine.

My project miss src/html/index.html while my original contains my Google Maps API key. If you want to run your project, you need to rewrite index-original.html file to index.html and place inside your Google Maps API key instead of [APIKeyHere] string.  

### Week 2 ###
The second week focused on the understanding difference on recording graph data structure in the form of Adjacency List and Adjacency Matrix.

Week 2 files:
* basicgraph.Graph.java
* basicgraph.GraphAdjList.java
* basicgraph.GraphAdjMatrix.java

### Week 3 ###
The third week focused on creating custom help classes and implementing functionality for MapGraph.java file. This week teach Depth First Search (DFS) and Breadth First Search (BFS).

Week 3 files:
* roadgraph/MapGraph.java
* roadgraph/MapNode.java
* roadgraph/MapEdge.java

![picture alt](https://raw.githubusercontent.com/codekopf/Coursera-OOJPDSaB/master/data/images/DFS_vs_BFS.png "DFS vs. BFS")

Help material:
* [What’s the difference between DFS and BFS?](http://www.programmerinterview.com/index.php/data-structures/dfs-vs-bfs/)
* [Graph Traversals - Breadth First and Depth First](https://www.youtube.com/watch?v=bIA8HEEUxZI)


I think the hardest part of this week was to figure out what the creators have meant by "Parent Map". Parent Map should be the data structure which will record the movement of your pivot. It should log all connection from one point (parent) to its neighbours (children). Because by finding the destination (goal) is possible to rebuild a path connecting the dots backwards retrospectively. E.g.: From goal to last starting point (from child to parent); then from the last point to its parent etc.


### Week 4 ###
The fourth week is about implementing Dijkstra's algorithm and A* Search algorithm.

For me personaly was most hardest to understand the idea of obtaining distance. Since I always try to make algorithms as general as possible, I did not realize for a while this is very narrow task. GeographicPoint class contains method for obtainning distance between 2 nodes and therefore there is no need to create something custom. In the end all the data maps use "longitude" and "latitude" as markers and distance in arbitrary units can be compute from it.

#### Dev note ####
This week I decided to rewrite whole program. I've spent several hours debugging my previous solution based on GeographicPoint for establishing nodes in graphs. Problem was in a way the program read data from datasource. My past solution was obeying all the graph edges in data store source after first run loop. I shifted 

Week 3 files:
* roadgraph/MapGraph.java
* roadgraph/MapNode.java
* roadgraph/MapEdge.java

Help material:
* [Greedy Algorithms | Set 7 (Dijkstra’s shortest path algorithm)](http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/)
* [Dijkstra's Algorithm](https://www.youtube.com/watch?v=gdmfOwyQlcI)
* [Introduction to A* (interactive)](http://www.redblobgames.com/pathfinding/a-star/introduction.html)
* [Introduction to A*](http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html)
* [Priority queue in Java](http://stackoverflow.com/questions/683041/java-how-do-i-use-a-priorityqueue)


### Week 5 ###
Fifth week was focuse on understanding several terms in graph theory such as: Traveling Salesperson Problem; P, NP, NP-Hard problem; Hamiltonian or Eulerian graph; and others. 

####Study notes:####
This week is mostly about making notes. If you have already familiar with graph theory, this week videos help you refresh your knowleadge. 

#### Short theory ####
* Traveling Salesperson Problem (TSP) - given n cities with one Hometown and all pairwise distance, plan a tour starting and ending at Hometown that visits every city exactly once and has minimum distance. 
* Solving (optimally or non-optimally) the TSP
** Greedy algorithm: pick best next choice
* Explain the notion of an NP-Hard problem
*Use heuristics to find reasonable solutions to hard problems
*Apply the 2-Opt Heuristic to the TSP
** Constructions:
** Nearest Neighbor (Greedy) 
** Christodides Algorithm
** Iterative:
** k-opt and Lin-Kernighan
** genetic algorithm
* Define a Hamiltonian cycle in a graph - A graph is Hamiltonian if there is a path through the graph which visits each vertex exactly once.
* Define an Eulerian circuit in a graph - A graph is Eulerian if there is a path through the graph which visits each edge exactly once.

### Week 6 ### 
Final week is devoted for creating project extension of your choice.

1) Although side-streets often provide the shortest path based on distance, we rarely use them because speed limits are usually lower than the speed limit on major roads. In this extension, you can either try to pull in speed limit data from another source OR you could just use "roadType" to make assumptions about speed limits. Then modify your Dijkstra and A* algorithms to use a trip duration rather than distance in finding the shortest path. You could go even further and then make predictions about traffic based on road type and time of day (which might again make side-streets a good choice over arterials.)

2) We've talked through a number of algorithms for the Travelling Salesperson Problem. Create a new method which takes a set of vertices and returns a route (not necessarily the best) which visits each vertex and returns back to the start. If you want to go a bit further, you can try multiple solutions we've discussed (e.g., Greedy vs Greedy with 2-opt) and compare the length of path returned. Note: you'll need to use your A* or Dijkstra Algorithm to determine distances between vertices. Also, recognize that in real world map data, the path from one vertex to another might include stopping at another vertex in the set. You could manage that by ignoring the multiple visits to the node or by adding a way to mark that node as visited (if you pick that path).

3) When multiple people search Google Maps, it's likely to have some commonality in the searches. For example, if there's a concert in downtown San Diego on Friday night, there will be a number of people searching for directions to the concert venue on Friday afternoon. Each person probably has a unique starting address, but there's likely commonalities in the paths (e.g., multiple paths to get to the main freeway to downtown, followed by the same path from the freeway to downtown). Rather than redoing the entire search every time, you could store previously found shortest paths between vertices. As a result, the first search downtown may take a while, but when the next person searches, they'll use part of the previous solution in your solution.

4) An extension of your choice!

Ultimately, you'll decide what "counts" as an extension and we'll just ask you to report on what you accomplished. We hope you have fun and pick something which is interesting to you and you'd feel proud showcasing to others!


## TODO ###
+ Improve project based on the Peer-review for the 3rd week. There are some good ideas which I got as a feedback.
+ Explain better Difference between DFS and BFS
+ Add comments for custom class methods
+ How would you implemented street type by enum?
+ More defensive programming - check starter code for some good tips
+ Write more tests for A* (does not look it works ...)
+ TODO 6th week
+ Algorithm pseudocodes
+ Study materials 5th week