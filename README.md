# Gomoku Game in Java-Swing

This is a Gomoku (also known as 'Five in a row') game developed using Java and the Swing GUI toolkit as a project for the Object-Oriented Programming (OOP) course, for the 2025.1 semester of Computer Science.

---

## Features
- Player vs Player mode
- Player vs Bot mode
- Scoreboard
- Graphical interface built with Swing
- 15x15 game board (standard size)
- Visual indication of current player's turn
- Win detection (horizontal, vertical, and both diagonals)

---

## Project Structure

```
Gomoku-ProjetoPOO/
│
├── src/
│   ├── controllers/
│   │   
│   ├── models/
│       └── enums
│           └── PieceColorsEnum.java
│           └── PlayerTypesEnum.java
│       └── game
│           └── Board.java
│           └── Match.java
│           └── Piece.java
│       └── player
│           └── BotPlayer.java
│           └── HumanPlayer.java
│           └── Player.java
│   ├── views/
│       └── assets/
│       └── BackgroundPanel.java
│       └── MainFrame.java
│       └── MenuScreen.java
│
├── README.md
└── .gitignore
```

---

## How to Run

#### Pre-requisites:
- An IDE capable of running Java files (VSCode, Eclipse, etc)
> (Note that, to use VSCode, you will have to set it up to run Java. You can find instructions for that [here](https://code.visualstudio.com/docs/languages/java#:~:text=In%20order%20to%20run%20Java,Amazon%20Corretto)).

</br>

**1.** Clone the repository:
```bash
git clone https://github.com/beaalmeidas/Gomoku-ProjetoPOO.git
```
**2.** Open the project in your chosen IDE and compile the code with this comand:
```bash
./build.bat
```
**3.** Run the game:
```bash
java -cp bin src.views.MainFrame
```

---


## Authors
Beatriz Almeida de Souza Silva
José Carlos de Oliveira Neto
