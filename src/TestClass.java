import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {
    public static List<Passenger> passengers = new ArrayList<>();
    static Passenger loggedInPassenger = null;


    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);


        menu:
        while (true) {
            System.out.println("""
                    a. Add a new passenger
                    b. Add a reservation for an existing passenger
                    c. Display reservation
                    d. Cancel a reservation
                    e. Quit
                    """);
            String entry = scn.next();
            switch (entry) {
                case "a":
                    AddPassenger(scn);
                    System.out.println("Press enter to continue...");
                    scn.nextLine();
                    scn.nextLine();

                    break;
                case "b":
                    AddReservation(scn);
                    System.out.println("Press enter to continue...");
                    scn.nextLine();
                    scn.nextLine();
                    break;
                case "c":
                    DisplayReservation(scn);
                    System.out.println("Press enter to continue...");
                    scn.nextLine();
                    scn.nextLine();
                    break;
                case "d":
                    CancelReservation(scn);
                    System.out.println("Press enter to continue...");
                    scn.nextLine();
                    scn.nextLine();
                    break;
                case "e":
                    break menu;
                default:
                    System.out.println("Please enter a valid letter! (a-e)");
                    break;
            }


        }
    }
    public static void AddPassenger(Scanner scn){
        System.out.println("Please enter your name:");
        String name = scn.next();
        System.out.println("Please enter your phone:");
        int phone = scn.nextInt();
        System.out.println("Please enter your address:");
        String address = scn.next();
        System.out.println("Please enter your password:");
        int password = scn.nextInt();
        passengers.add(new Passenger(name,address,phone,password));
    }
    public static void AddReservation(Scanner scn){

        if (loggedInPassenger == null){
            Login(scn);
            AddReservation(scn);

        }else{
            System.out.println("Please enter number of seats:");
            int seats = scn.nextInt();
            System.out.println("Please enter type of seats(Normal,FirstClass):");
            String type = scn.next();
            int rCode =loggedInPassenger.addReservation(seats,type);
            if (rCode==0){
                System.out.println("Sorry we don't have enough seats for your reservation..");
            }else{
                System.out.println("Your reservation has succesfully completed\n" +
                        "your reservation code is: "+rCode);
            }

        }
    }
    public static void Login(Scanner scn){
        System.out.println("Please first log in to add a new reservation.\n" +
                "Please enter your account ID");
        int accountID =scn.nextInt();
        for (Passenger pssngr:passengers) {
            if (pssngr.accountId == accountID){
                System.out.println("please enter your password:");
                String password =scn.next();
                if(pssngr.Login(password)){
                    loggedInPassenger = pssngr;
                }else{
                    System.out.println("your password is wrong!\n" +
                            "press enter to continue");
                }
            }else System.out.println("please enter valid account ID!");

        }
    }
    public static void DisplayReservation(Scanner scn){
        if (loggedInPassenger == null){
            Login(scn);
            DisplayReservation(scn);
        }else{
            System.out.println("please enter your reservation code:");
            int reservationcode =scn.nextInt();
            loggedInPassenger.displayReservation(reservationcode);
        }
    }
    public static void CancelReservation(Scanner scn){
        if (loggedInPassenger == null){
            Login(scn);
            CancelReservation(scn);
        }else{
            System.out.println("please enter your reservation code:");
            int reservationcode =scn.nextInt();
            loggedInPassenger.cancelReservation(reservationcode);
        }
    }
}

