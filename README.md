# NumberGuessingGame-Java

## Description
This Java program implements a simple number guessing game using Swing for the graphical user interface. The game prompts the player to guess a number between 1 and 100 and provides feedback based on the correctness of the guess.

## Features
- **Graphical User Interface (GUI)**:
   - Utilizes Swing components to create an interactive GUI.
   - Features a window with text fields, buttons, and labels for user input and feedback.

- **Game Mechanics**:
   - The player is prompted to input a number guess between 1 and 100.
   - Upon submitting a guess, the game provides feedback indicating whether the guess is too high, too low, or correct.
   - Tracks the number of attempts made by the player.
   - Disables the guess button after a correct guess.

- **Visual Effects**:
   - Animates the size change of the guess button when hovered over by the mouse.
   - Utilizes color transition effects to enhance the appearance of feedback messages.

## Components
- **NumberGuessingGame.java**:
  - Contains the main logic and GUI components of the number guessing game.
  - Implements event listeners for button clicks and mouse hover events.
  - Provides methods for initializing the game, checking guesses, and displaying feedback.

## Instructions
1. **Compilation**:
   - Compile the `NumberGuessingGame.java` file using a Java compiler.

2. **Execution**:
   - Run the compiled bytecode to launch the game.
   - Upon execution, the game window will appear, prompting the player to input their guesses.

3. **Gameplay**:
   - Enter a numerical guess between 1 and 100 into the text field.
   - Click the "Guess" button to submit the guess.
   - Receive feedback indicating whether the guess is too high, too low, or correct.
   - Continue guessing until the correct number is found.

4. **End Game**:
   - After guessing the correct number, the guess button will be disabled, and the game will display the number of attempts made.

## Notes
- Ensure that Java Development Kit (JDK) is installed on your system to compile and run the program.
- This game serves as a basic example of a number guessing game and can be extended or modified to include additional features as desired.
