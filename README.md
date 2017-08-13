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
basicgraph.Graph.java
basicgraph.GraphAdjList.java
basicgraph.GraphAdjMatrix.java

### Week 3 ###
The third week focused on creating custom help classes and implementing functionality for MapGraph.java file. This week teach Depth First Search (DFS) and Breadth First Search (BFS).

Week 2 files:
roadgraph/MapGraph.java
roadgraph/MapNode.java
roadgraph/MapEdge.java

Markup : ![picture alt](https://raw.githubusercontent.com/codekopf/Coursera-OOJPDSaB/master/data/images/DFS_vs_BFS.png "DFS vs. BFS")

I think the hardest part of this week was to figure out what the creators have meant by "Parent Map". Parent Map should be the data structure which will record the movement of your pivot. It should log all connection from one point (parent) to its neighbours (children). Because by finding the destination (goal) is possible to rebuild a path connecting the dots backwards retrospectively. E.g.: From goal to last starting point (from child to parent); then from the last point to its parent etc.   
