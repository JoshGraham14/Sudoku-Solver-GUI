# Sudoku-Solver-GUI
A Sudoku solver using the Backtracking algorithm and displayed using JavaFX.

Pictures of the program running are at the bottom of the README, if you don't want to clone and run this yourself.

## Requirements
- JavaFX version 14 installed
- e(fx)clipse installed from the eclipse marketplace

## How to run
There are a few things that you are going to need to edit within eclipse to get this all up and running.

### First - Adding the JavaFX 14 Library
- Right click the project name
- Select "Add Libraries"
- Choose "User Library"
- Click on "Next >"
- Check on "JavaFX 14"
- Click "Finish"

### Second - Adding VM Arguments to the run configuration
- Attempt to run the project (This will not work and will give errors, but it is important that you do this!)
  - This creates a run configuration which we will be editing
- Right click the project name
- Select "Properties" at the bottom of the list
- Choose "Run/Debug Settings"
- In the box you should see "Main" listed as a launch configuration, click this
- Click "Edit", this is found on the right side of the window
![Edit run configurations](/example-images/howto1.png)
- Select the "Arguments" tab in the new window, under where you name the configuration
- Click in the box under "VM Arguments"
- paste this into the box `--module-path C:\javafx-sdk-14\lib --add-modules=javafx.controls,javafx.fxml`
  - You will most likely need to edit the path in this line depending on where you installed JavaFX
- Click "Apply"
- Click "OK"
![VM Arguments](/example-images/howto2.png)
- You can now close all windows other than the main eclipse window

## You should now be able to run The Sudoku Solving program properly

When running the program, you start by filling in the Sudoku board with the numbers that are supplied for the game.

![Unsolved Sudoku Board](/example-images/unsolved-sudoku.png)

After clicking the "Solve" button, the program should look like this.

![Solved Sudoku Board](/example-images/solved-sudoku.png)

I hope you like this repository and find it useful!
