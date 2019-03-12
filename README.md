# Mars_Explorer_Simulator

Mars Explorer Simulator is a simulation of a Mars explorer's movement within a 5 by 5 area. 
You will be placing the explorer, maneuvering the explorer and asking the explorer to report his/her current location. 

There are three action the explorer can take:

- Landing (Placing) the explorer onto Mars
- Maneuvering (Moving) the explorer within the safe area in Mars
- Requesting for rescue (Reporting) from current coordinate
 
 note: explorer will only move vertically or horizontally
 
# How do I use the simulator

## Setting Up

This simulator required to run in command line. There is three simple steps to get it running
1. Run CommandPrompt
2. Change the directory to the Mars_Explorer_Simulator folder
3. Enter `java -jar mars_exploration.jar`

## Using the Simulator

The explorer can be land/move within the 5 by 5 area. that is within 0 to 4 of both X and Y dimension. 

### Landing

The explorer can be landed anywhere within the 5 by 5 area, this is done by entering 

    PLACE X,Y 

where X and Y are the place the explorer is landing onto. 
This command will not give any output unless the input is invalid. 

For example entering `PLACE 1,1` will place the explorer to `(1,1)` and no output will be shown. 
However, if entered `PLACE 50,50`, error message of `Invalid placement` will be shown.

When a new explorer is landed, the old explorer will be abandoned and previous movement and his location will be lost.


### Maneuvering

The explorer can maneuver within the safe area in mars, this is done by entering 

    MOVE X,Y

where the explorer will move X unit on the X dimension and Y unit to the Y dimension. This commend will output how the explorer is moving. 
However, if the X or Y are invalid input such as out of the safe area in Mars, the explorer will ignore the command.

For example

    PLACE 0,0
    MOVE 1,1
        
will ouput the explorer landed on 

    M:(0,0) (1,0) (1,1)

as a shown on how to explorer is moved from `(0,0)` to `(1,1)`

However, if an invalid movement is to be entered. For example,
 
    MOVE 5,5
 is being requested, it will output 
    
    Invalid Movement
    
### Requesting for rescue

The explorer can terminate his exploration by sending explorer's current coordinate. This is done by entering

    REPORT
    
where the explorer's current location will be send and exploration will be terminated. It will shows an
output of 

    P:(X,Y)
where X and Y are the explorer's current location.

--------------------
# Test case
Test case have been added in TestCase.xlsx