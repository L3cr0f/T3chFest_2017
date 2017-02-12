# T3chFest_2017
Programming challenge of T3chFest 2017


<b><h3>1st Challenge</h3></b>
Consisted in developing a program that recognizes when a number in binary format has a period and what its value is, if it has not period the program should return -1.</br>
For example:</br>
  - 100100 = 3
  - 1101 = -1
  - 111 = 1
  - 1011011 = 3
  - 10101 = 2
  - 10100 = -1

<b><h3>2nd Challenge</h3></b>
Consisted in developing a program based on battleship game. The goal is to determine for a given input the number of sunk ships and the number of hit ships, but not sunk (separated by a comma).</br>
Input format:</br>
  (dimensions of the map, ships divided by commas and their coordinates divided by a blank space (the first coordinate points out the left-top corner and the second the left-bottom corner of the ship), shots coordinates divided by blank spaces)</br>
For example:</br>
  - (4, "1B 2C,2D 4D", "1B 1C 2B 2C 2D 4D 4A") = 1,1
  - (12, "1A 2A,12A 12A", "12A") = 1,0
  - (3, "1A 1B,2C 4C", "1B") = 0,1
  - (5, "1A 1A,5C 5C", "1B") = 0,0

<b><h3>3rd Challenge</h3></b>
Consisted in developing a program that counts the number distance (in hops) from one city to the capital.</br>
Input format:</br>
  - Array whose size means the number of cities.
  - Each position means the ID of the city (eg: A[2] = 2nd city).
  - Each position points out to the nearest city from the capital (eg: A[2] = 1, the nearest city from the capital is the 1st).
  - If the value of a position matches with the position, this city is the capital (eg: A[2] = 2).

Output format:</br>
  - An array (size = number of cities - 1) in which each position points out the number of cities from that distance to the capital (eg: {1, 3, 0, 0} = there is one city with a distance equal to 1, three cities with distance equal to 2 and there is no any city with a distance equal to three).
  
For example:</br>
  - {9, 1, 4, 9, 0, 4, 8, 9, 0, 1} = {1, 3, 2, 3, 0, 0, 0, 0, 0}
  - {0, 0, 0, 0, 1} = {3, 1, 0, 0}

<b><h3>4th Challenge</h3></b>


<b><h3>5th Challenge</h3></b>


<b><h3>6th Challenge</h3></b>
