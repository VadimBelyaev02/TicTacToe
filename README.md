# TicTacToe

TicTaoToe.java:

  It's the main class, which contains entry point to the program.

Package 'exception':

  This package contains classes of exceptions that may occur during the program's execution.
  
Package 'game':

   Field.java - it's the game field. All crosses and zeros are added here. 
   
   Figure.java - it's an enumeration with types of game roles (X or 0).
   
   Game.java - this class controls the game process. It initializes both players and game field. Then players play until someone wins.
   
   Move.java - it's class with coords and type of figure. It is used to players can make moves on the field.
   
Package 'player':

   Player.java - it's an interface with three methods for the game.
   
   Person.java - it's an implementation of interface 'Player'. Player is a human.
   
   Machine.java - it's an implementation of interface 'Player'. Player is a bot.
   
  
