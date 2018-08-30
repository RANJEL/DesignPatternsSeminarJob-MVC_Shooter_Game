## About
This is my seminar job that I created, when I was learning Architecture and Design Patterns in CTU Prague.

## Requirements
- MVC game
- Usage of following design patterns: 
MVC, 
Strategy, 
Proxy, 
State, 
Visitor, 
Observer, 
Command, 
Memento, 
Abstract factory,
Singleton

- player can change the force and the angle of the shot
- in game gravity can be changed
- score calculation
- ability to shoot more shots on one keydown
- ability to control game model using commands
- ability to rollback to previous game state

## Installation
You need maven to build my game.

$ mvn clean install

Then start game from CLI. Navigate to folder target/ and type

$ java -jar mvc_shooter_assign-1.0.jar realistic

## Game Controls
 - Space:       Fire from cannon
 - F:              Move cannon up
 - V:              Move cannon down
 - Right arrow:    Increase force of shot
 - Left arrow:     Decrease force of shot
 - Arrow up:       Increase angle of shot
 - Arrow down:     Decrease angle of shot
 - +:              Increase in game gravity
 - -:              Decrease in game gravity
 - SHIFT:          Switch cannon to single/multiple shots mode
 - Z:              Use rollback to get previous game state
