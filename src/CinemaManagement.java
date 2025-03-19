//w2053013 - Sachintha chamod Piyathunga

//References
//All lecture notes
//JavaScript Array findIndex()- https://www.w3schools.com/jsref/jsref_findindex.asp
//How do I break out of nested loops in Java - https://www.w3docs.com/snippets/java/how-do-i-break-out-of-nested-loops-in-java.html
//Java Arrays.sort() Method - https://www.w3schools.com/java/ref_arrays_sort.asp
//Arrays.sort() in Java with examples - https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
//java tutorials (CodePRO LK) - https://www.youtube.com/watch?v=q0RFGwMkpMI&list=PL495mke12zYANEM9p7JT5-99Yx8Z7z_ib
//(CodePRO LK) OOP - https://www.youtube.com/watch?v=9taGmQ0EJeE&list=PL495mke12zYANEM9p7JT5-99Yx8Z7z_ib&index=20
//(CodePRO LK) Java Constructors - https://www.youtube.com/watch?v=PgEbTqUyfsc&list=PL495mke12zYANEM9p7JT5-99Yx8Z7z_ib&index=22
//(CodePRO LK) Access Modifiers in Java - https://www.youtube.com/watch?v=03E8XZyLz-o&list=PL495mke12zYANEM9p7JT5-99Yx8Z7z_ib&index=26

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;//add this class to check input provided by the user does not match the expected type
import java.util.Scanner;//add this class to be used for obtaining user input from the keyboard


//main class for manage for seat reservation on a plane
public class CinemaManagement
{

    //define a 2D array to represent the seating plan in the plane
    private static final Seat[][] seatingPlan = {
            {new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat()},
            {new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat()},
            {new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat(), new Seat()}
    };
    private static final Ticket[] tickets = new Ticket[48]; //an array for store all the sold tickets during the process
    private static final Scanner scanner = new Scanner(System.in); //scanner object to get user inputs

    public static void main(String[] args)  //main method to start the program
    {
        //display the welcome message
        System.out.println("\n\n------------------------------------------------------");
        System.out.println("--           Welcome to The London Lumiere          --");
        System.out.println("------------------------------------------------------");

        int option; //variable to store user option
        do //loop until the user choose quit
        {
            System.out.println("\n\n------------------------------------------------------");
            System.out.println("-                  LONDON LUMIERE                    -");
            System.out.println("------------------------------------------------------");
            System.out.println("\n  Please select an option:");
            System.out.println("\n  Please select an option:");
            System.out.println("      1) Buy a ticket");
            System.out.println("      2) Cancel ticket");
            System.out.println("      3) See seating plan");
            System.out.println("      4) Find first seat available");
            System.out.println("      5) Print tickets information and total price");
            System.out.println("      6) Search ticket");
            System.out.println("      7) Sort tickets by price");
            System.out.println("      8) Exit");
            System.out.println("\n------------------------------------------------------");
            System.out.print("\n  Select option :");
            //get user option
            option = acquireoption();
        } while (option < 8); //continue the loop  until user choose to quit

        scanner.close(); //close the scanner object
    }

    private static int acquireoption() //method to get user option
    {
        int option = 0;
        try {
            //try to get user input
            option = scanner.nextInt(); //Consume newline character
            scanner.nextLine();
            //process for user option
            switch (option)
            {
                case 1:
                    buy_a_ticket();
                    break;
                case 2:
                    cancel_ticket();
                    break;
                case 4:
                    find_first_seat_available();
                    break;
                case 3:
                    see_seating_plan();
                    break;
                case 5:
                    print_tickts_info();
                    break;
                case 6:
                    search_ticket();
                    break;
                case 7:
                    sort_tickets();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } catch (InputMismatchException e)
        {
            //handling invalid inputs exception
            System.out.println("Invalid option. Please try again.");
            scanner.nextLine();
            option = 1; //set default option to buy a seat
        }
        return option;
    }


    //method to add a ticket to the  array of tickets
    private static void addTicket(Ticket ticket)
    {
        for (int i = 0; i < tickets.length; i++)
        {
            if (tickets[i] == null)
            {
                tickets[i] = ticket;
                break;
            }
        }
    }

    //method tho remove a ticket from the array of tickets
    private static void removeTicket(char row, int seatNumber)
    {
        for (int i = 0; i < tickets.length; i++)
        {
            if (tickets[i] != null && tickets[i].getRow() == row && tickets[i].getSeat() == seatNumber)
            {
                tickets[i] = null;
                break;
            }
        }
    }

    //method to check if a string contains only non-integer characters
    private static boolean nonIntegerStringCorrect(String str)
    {
        if (str.isEmpty())
        {
            return false;
        } else return str.matches("[a-zA-Z1-3]+");
    }

    //method to check if roe character is correct
    private static boolean rowCorrect(char row)
    {
        return switch (row) {
            case '1', '2', '3' -> true;
            default -> false;
        };
    }

    //method to get row index based on the roe character
    private static int getRowIndex(char row)
    {
        return switch (row)
        {
            case '1' -> 0;
            case '2' -> 1;
            case '3' -> 2;
            default -> -1;
        };
    }

    //method to check if a seat number is correct for a given roe
    private static boolean seatNumberCorrect(int seatNumber)
    {
        return seatNumber >= 1 && seatNumber <= 16;
    }

    //method to get the row from the user
    private static char acquireRow()
    {
        System.out.print("Enter row (1-3): ");
        String rowStr = scanner.nextLine().toUpperCase();
        char row = rowStr.charAt(0);
        if (!rowCorrect(row))
        {
            System.out.println("row cannot be identified");
            return 0;
        }
        return row;
    }

    //method to get the seat number from user
    private static int acquireSeat()
    {
        try
        {
            System.out.print("Enter seat number: ");
            int seat = scanner.nextInt();
            if (!seatNumberCorrect(seat)) {
                System.out.println("seat cannot be identified");
                return -1;
            }
            scanner.nextLine();
            return seat;
        } catch (Exception e)
        {
            scanner.nextLine();
            return -1;
        }
    }

    //method to get a string input from the user for various purposes
    private static String acquireStr(String enterWhat)
    {
        System.out.print("Enter your " + enterWhat + " : ");
        String str = scanner.nextLine();
        if (!nonIntegerStringCorrect(str))
        {
            System.out.println(enterWhat + " cannot be empty or have numbers");
            return null;
        }
        return str;
    }

    //method to get an email from user (email format)
    private static String acquireEmail()
    {
        System.out.print("Enter your email : ");
        String str = scanner.nextLine();
        if (!str.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zAZ]{2,6}$"))
        {
            System.out.println("email cannot be identified");
            return null;
        }
        return str;
    }

    //method to handle the process of buying seat
    private static void buy_a_ticket()
    {
        char row = acquireRow();
        if (row == 0)
        {
            return;
        }
        int rowIndex = getRowIndex(row);
        int seat = acquireSeat();
        if (seat == -1)
        {
            return;
        }

        Seat chosenSeat = seatingPlan[rowIndex][seat - 1];
        if (chosenSeat.isAvailable())
        {
            String name = acquireStr("name");
            if (name == null)
            {
                return;
            }
            String surname = acquireStr("surname");
            if (surname == null)
            {
                return;
            }
            String email = acquireEmail();
            if (email == null)
            {
                return;
            }
            Person person = new Person(name, surname, email);
            chosenSeat.sellSeat();
            Ticket ticket = new Ticket(row, seat, person);
            addTicket(ticket);
            System.out.println("Ticket bought successfully!");
        } else
        {
            System.out.println("Ticket already sold or invalid ticket.");
        }
    }

    //method to handle the process of  canceling a seat
    private static void cancel_ticket()
    {
        char row = acquireRow();
        if (row == 0)
        {
            return;
        }
        int rowIndex = getRowIndex(row);
        int seat = acquireSeat();
        if (seat == -1)
        {
            return;
        }

        if (!seatingPlan[rowIndex][seat - 1].isAvailable())
        {
            removeTicket(row, seat);
            seatingPlan[rowIndex][seat - 1].freeSeat();
            System.out.println("Ticket cancelled successfully!");
        } else
        {
            System.out.println("Seat already available or invalid seat.");
        }
    }

    //method to find first available seat
    private static void find_first_seat_available()
    {
        for (int row = 0; row < seatingPlan.length; row++)
        {
            for (int seat = 0; seat < seatingPlan[row].length; seat++)
            {
                if (seatingPlan[row][seat].isAvailable())
                {
                    System.out.println("First available seat: Row " + (char) ('1' + row) + ", Seat " + (seat + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    //method to display the seating plan
    private static void see_seating_plan()
    {
        System.out.println("\nSeating Plan:");
        System.out.print("      ");
        for (int i = 1; i <= seatingPlan[1].length; i++)
        {
            System.out.printf("%-3d", i);
        }
        System.out.println();
        for (int row = 0; row < seatingPlan.length; row++)
        {
            System.out.print("Row " + (char) ('1' + row) + " ");
            for (Seat seat : seatingPlan[row])
            {
                System.out.printf("%-3s", seat.value == 0 ? "O" : "X");
            }
            System.out.println();
        }
    }

    //method to print ticket information
    private static void print_tickts_info()
    {
        // This method is already implemented in Part B
        int totalAcquiredTicketPrices = 0;
        for (Ticket ticket : tickets)
        {
            if (ticket == null)
            {
                continue;
            }
            ticket.printTicketInfo();
            System.out.println();
            totalAcquiredTicketPrices += ticket.getPrice();
        }
        System.out.println("Total ticket prices : " + totalAcquiredTicketPrices);
    }

    //method to search for a ticket
    private static void search_ticket()
    {
        // This method is already implemented in Part B
        char row = acquireRow();
        if (row == 0)
        {
            return;
        }
        int rowIndex = getRowIndex(row);
        int seat = acquireSeat();
        if (seat == -1)
        {
            return;
        }

        if (seatingPlan[rowIndex][seat - 1].isAvailable())
        {
            System.out.println("Seat available");
            return;
        }

        for (Ticket ticket : tickets)
        {
            if (ticket == null)
            {
                continue;
            }
            if (ticket.getRow() == row && ticket.getSeat() == seat) {
                ticket.printTicketInfo();
                break;
            }
        }
    }

    //method to sort for a tickets
    private static void sort_tickets()
    {
        Ticket[] sortedTickets = Arrays.stream(tickets)
                .filter(ticket -> ticket != null)
                .sorted(Comparator.comparingInt(Ticket::getPrice))
                .toArray(Ticket[]::new);

        System.out.println("Tickets sorted by price:");
        for (Ticket ticket : sortedTickets)
        {
            ticket.printTicketInfo();
            System.out.println();
        }
    }

}