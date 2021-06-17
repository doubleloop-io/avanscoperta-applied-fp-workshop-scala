# Enanched Mars Rover Kata

You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet.
Implement an application that simulates the movement of a rover on a planet with data provided by user.

NOTE: for each version try to first model all functions signatures (use ??? marker) and then implement them.
The idea is to get a quick and cheap responsibility distribution phase.

For a full kata explanation see: https://kata-log.rocks/mars-rover-kata

## V1 - Focus on the center (pure domain logic)

Develop an API (types and functions) that executes single commands:

- The planet is divided into a grid with x (width) and y (height) size.
- The rover has a position expressed as x, y co-ordinates and an orientation (North, Est, West, South).
- The rover can handle four commands: turn left or right, move forward or backward.
- Implement wrapping from one edge of the grid to another (pacman effect).

## V2 - More domain logic (effect in domain logic)

Extend the API to handle many commands and obstacle:

- Commands are sent in batch (like an array) and executed sequentially. Report only the final position.
- There are many obstacles on the planet. An obstacle has a position expressed as x, y co-ordinates.
- If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point and aborts the sequence.

## V3 - Focus on boundaries (from primitive types to domain types and viceversa)

Our domain is declared with rich types but inputs/outputs are primitives

- Write a parser for the planet (grid) size: "5x4"
- Write a parser for a list of obstacles: "1,2 0,0 3,4"
- Write a parser for rover initial state: "1,3:W"
- Render result as string: 
  - normal: "positionX:positionY:direction"
  - when hit obstacle "O:positionX:positionY:direction"

## V4 - Focus on infrastructure (compose I/O operations)

Extend the "pure" way of work also to the infrastructural layer

- Lift strings (initial state) into IO monads and execute commands
- Read planet.txt from file into IO (size and obstacles)
- Read rover.txt from file into IO (position and direction)
- Read commands from file into IO (char array)
- After commands execution:
  - Print final output to the console
  - Handle, safely, any unhandled exception and log them