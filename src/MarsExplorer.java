import java.util.Scanner;
import java.util.ArrayList;
public class MarsExplorer {
    public static void main(String[] args) {
        System.out.println("Welcome to Mars!");

        ArrayList<int[]> movement = new ArrayList<int[]>();
        Scanner movementScanner = new Scanner(System.in);
        String command = movementScanner.nextLine().toUpperCase();

        while(!command.equals("REPORT")){
            try {
                //Identify inputted method and X,Y coordinate input
                String firstWord = command.substring(0, command.indexOf(" "));
                int X = Integer.parseInt(command.substring(command.indexOf(" ") + 1, command.indexOf(",")));
                int Y = Integer.parseInt(command.substring(command.indexOf(",") + 1));

                if (firstWord.equals("PLACE")) {
                    //Validating coordinate
                    if (X >= 0 && Y >= 0 && X <= 4 && Y <= 4) {
                        //Clearing previous movement and placing explorer location
                        int[] placedLocation = new int[]{X, Y};
                        movement.clear();
                        movement.add(0, placedLocation);
                    } else {
                        System.out.println("Invalid placement");
                    }
                } else if (firstWord.equals("MOVE")) {
                    //Check whether explorer have been placed
                    if (!movement.isEmpty()) {
                        //Set Current Explorer Location
                        int[] location = new int[]{movement.get(movement.size() - 1)[0], movement.get(movement.size() - 1)[1]};

                        //Check whether input is valid or off the table
                        if (location[0] + X <= 4 && location[1] + Y <= 4 && location[0] + X >= 0 && location[1] + Y >= 0) {

                            //move block by block until reaches inputted number and storing each movement
                            if (X<0){
                                for (int i = 0; i > X; i--) {
                                    location[0]--;
                                    int[] tempLocation = new int[]{location[0], location[1]};
                                    movement.add(tempLocation);
                                }
                            }else if(X>0){
                                for (int i = 0; i < X; i++) {
                                    location[0]++;
                                    int[] tempLocation = new int[]{location[0], location[1]};
                                    movement.add(tempLocation);
                                }
                            }
                            if (Y<0){
                                for (int i = 0; i > Y; i--) {
                                    location[1]--;
                                    int[] tempLocation = new int[]{location[0], location[1]};
                                    movement.add(tempLocation);
                                }
                            }else if(Y>0){
                                for (int i = 0; i < Y; i++) {
                                    location[1]++;
                                    int[] tempLocation = new int[]{location[0], location[1]};
                                    movement.add(tempLocation);
                                }
                            }


                            //Output movement
                            System.out.print("M: ");
                            for (int[] tempMovement : movement) {
                                System.out.print("(" + tempMovement[0] + "," + tempMovement[1] + ") ");
                            }
                            System.out.println();

                        } else {
                            System.out.println("Invalid Movement");
                        }
                    } else {
                        System.out.println("Explorer have not been placed");
                    }
                }else{
                    System.out.println("Invalid command");
                }
            } catch(Exception e){
                System.out.println("Invalid Input");    //Any error will leads to Invalid Input
            }
            //Next Input
            command = movementScanner.nextLine().toUpperCase();
        }
        //If input Report, output latest location
        if(!movement.isEmpty()) {
            System.out.println("P:(" + movement.get(movement.size() - 1)[0] + "," + movement.get(movement.size() - 1)[1] + ")");
        }else{
            System.out.println("Explorer have not been placed");
        }
    }
}
