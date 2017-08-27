## About this project ##

This is the [coursera.org Advanced Data Structures in Java](https://www.coursera.org/learn/advanced-data-structures) published by University of California, San Diego as a part of their Object Oriented Java Programming: Data Structures and Beyond Specialization.  

All course credits belong to course creators: Mia Minnes, Christine Alvarado, Leo Porter, Alec Brickner; and the appropriate project stakeholders. 

You can find original project "readme" in this project under README-original. You can find original licencing conditions under this project as LICENSE.

## Index ##
* For project students
* Installation
* Development & Study notes
	* Week 1
	* Week 2
	* Week 3
	* Week 4
	* Week 5
	* Week 6
* End note
* TODO

[This project GitHub link](https://github.com/codekopf/Coursera-OOJPDSaB)

## For project students ##  
The repository is my solution for course problems. It is not most efficient or most optimal solutions. Any constructive comments for code improvement are welcome.

Please also do not copy my work. Try to come with your own ideas and your custom code(variables, iterations, etc.) Try to spend times over week exercises and try at least few different approaches to the course problems if you stuck. Trust me if I tell you it is even better to leave the course and return to it couple weeks later if you do not know the solutions right away.


## Installation ##
The project is build with Eclipse. Installation is otherwise easy: 

1) Download the repository
2) Import this project into the Eclipse as new Java project 

Feel free to use another IDE or manually compile and run your programs.
If you need help, google is your friend.


## Development & Study notes ##

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

![picture alt](https://raw.githubusercontent.com/codekopf/Coursera-OOJPDSaB/master/content/DFS_vs_BFS.png "DFS vs. BFS")

Help material:
* [What’s the difference between DFS and BFS?](http://www.programmerinterview.com/index.php/data-structures/dfs-vs-bfs/)
* [Graph Traversals - Breadth First and Depth First](https://www.youtube.com/watch?v=bIA8HEEUxZI)


I think the hardest part of this week was to figure out what the creators have meant by "Parent Map". Parent Map should be the data structure which will record the movement of your pivot. It should log all connection from one point (parent) to its neighbours (children). Because by finding the destination (goal) is possible to rebuild a path connecting the dots backwards retrospectively. E.g.: From goal to last starting point (from child to parent); then from the last point to its parent etc.


### Week 4 ###
The fourth week is about implementing Dijkstra's algorithm and A* search algorithm.

For me personally, the hardest part to understand was the idea of obtaining a distance to the source. Since I always try to make algorithms as general as possible, I did not realise for a while this is a very narrow task. The GeographicPoint class contains the method for obtaining the distance between 2 nodes, and therefore there is no need to create a custom solution. In the end, all the data maps use "longitude" and "latitude" as markers and distance in arbitrary units can be computed from it.

#### Dev note ####
This week I decided to rewrite the whole program. I've spent several hours debugging my previous solution based on GeographicPoint for establishing nodes in graphs. The problem was in a way the program read data from data source. My past solution was obeying all the graph edges in data store source after the first run loop. 

I shifted to the more robust solution where I build two custom collections: map of all object nodes where the key objects GeographicPoint location (unique for every MapNode) and set of all edges (every MapEdge has directions from start to end).  

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
The fifth week focused on understanding several terms in graph theory such as Traveling Salesperson Problem; P, NP, NP-Hard problem; Hamiltonian or Eulerian graph; and others. 

#### Study notes: ####
This week is mostly about making notes. If you are already familiar with the Graph theory, this week videos help you to refresh your knowledge.

#### Short theory ####
* Traveling Salesperson Problem (TSP) - given n cities with one Hometown and all pairwise distance, plan a tour starting and ending at Hometown that visits every city exactly once and has the minimum distance. 
* Solving (optimally or non-optimally) the TSP
** Greedy algorithm: pick best next choice
* Explain the notion of a NP-Hard problem
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
The final week is devoted to creating project extension of your choice.

I have decided to slightly implement the first option from courses ideas (check notes below). Every map data source contains additional information about a name of the street (edge) and its type. So far I have counted eight different road types (motorway, motorway_link, primary, residential, secondary, tertiary, trunk, unclassified). 

I have implemented queue comparison based on the type of the road which leads to the neighbour. Highways and motorways are privileged over country and dirt roads.

I have the feeling that my solution is not bulletproof in few ways. In a mash of similar routes, it does not have much advantage in search than BFS algorithm. On the other hand, I believe that in the mash of different routes, where ending point ends close to the highway offers significant improvement. 

#### Dev note ####
During the 6th week I rode with my friend for a wedding. We stuck unfortunately in a traffic jam. We decided to get out and selected the fastest path and at the first possible moment went sideways. After few kilometres, we unexpectedly hit a river ferry...

As I was thinking, for finding an ideal path between starting and ending point should be used a metric which would be a combination of several factors such as road type, distance from the source, road blocks (traffic jams, constructions), drive cost (toll), etc. Therefore simple metric such as air-distance from source is not in praxis enough.

To check solution, uncomment code in compareTo method in MapNode.java and comment existing code.

Week 3 files
* roadgraph/MapNode.java


Here are some ideas course brought for implementation


1) Although side-streets often provide the shortest path based on distance, we rarely use them because speed limits are usually lower than the speed limit on the main roads. In this extension, you can either try to pull in speed limit data from another source OR you could just use "roadType" to make assumptions about speed limits. Then modify your Dijkstra and A* algorithms to use a trip duration rather than distance in finding the shortest path. You could go even further and then make predictions about traffic based on road type and time of day (which might again make side-streets a good choice over arterials.


2) We've talked through a number of algorithms for the Travelling Salesperson Problem. Create a new method which takes a set of vertices and returns a route (not necessarily the best) which visits each vertex and returns back to the start. If you want to go a bit further, you can try multiple solutions we've discussed (e.g., Greedy vs Greedy with 2-opt) and compare the length of path returned. Note: you'll need to use your A* or Dijkstra Algorithm to determine distances between vertices. Also, recognise that in real world map data, the path from one vertex to another might include stopping at another vertex in the set. You could manage that by ignoring the multiple visits to the node or by adding a way to mark that node as visited (if you pick that path)


3) When multiple people search Google Maps, it's likely to have some commonality in the searches. For example, if there's a concert in downtown San Diego on Friday night, there will be a number of people searching for directions to the concert venue on Friday afternoon. Each person probably has a unique starting address, but there are likely commonalities in the paths (e.g., multiple paths to get to the main freeway to downtown, followed by the same path from the freeway to downtown). Rather than redoing the entire search every time, you could store previously found shortest paths between vertices. As a result, the first search downtown may take a while, but when the next person searches, they'll use part of the previous solution in your solution


4) An extension of your choice
Ultimately, you'll decide what "counts" as an extension and we'll just ask you to report on what you accomplished. We hope you have fun and pick something which is interesting to you and you'd feel proud showcasing to others


## End note ##
I have finished this course, and it was great fun. I really like a possibility actually to visualise the path search for different algorithms.



## TODO ##

Here are several ideas for the improvement which can I can work on more but are not necessary anymore:

+ Improve project based on the Peer-review for the 3rd week. There are some good ideas which I got as a feedback
+ Explain better Difference between DFS and BF
+ How would you implemented street type by enum
+ More defensive programming - check starter code for some good tip
+ Write more tests for A* (does not look it works ...
+ Study materials for 5th week and make more notes here
+ Rewrite custom compareTo algorithm over switch and then compare the roads.
+ While building path backwards, compute the speed limit and made assumption about spped limit