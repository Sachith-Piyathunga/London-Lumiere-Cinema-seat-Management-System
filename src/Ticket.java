//w2053013 - Sachintha  chamod Piyathunga

//define a class as Ticket to represent a Ticket for a seat
class Ticket {
    //declare variables to store the ticket information
    private char row; //row of the seat
    private int seat; //get seat number
    private int price; //price of the ticket
    private Person person; //person that get the ticket

    //method for initializing ticket information
    Ticket(char row, int seat, Person person) {
        this.row = row;
        this.seat = seat;
        this.person = person;

        //decide the price of the ticket based on the seat number
        if (row == '1') {
            price = 12;
        } else if (row == '2') {
            price = 10;
        } else {
            price = 8;
        }
    }

    //add method to access private member variable
    public char getRow()
    {
        return row;
    }

    public void setRow(char row)
    {
        this.row = row;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
    //set method to modify private member variable

    public int getSeat()
    {
        return seat;
    }

    public void setSeat(int seat)
    {
        this.seat = seat;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    //method for print ticket information
    void printTicketInfo() {
        System.out.println("\n\n\n------------------------------------------------------");
        System.out.println("            Ticket Booking Information");
        System.out.println("------------------------------------------------------");
        System.out.println("           Row: " + row);
        System.out.println("           Seat: " + seat);
        System.out.println("           Price: " + price);
        System.out.println("\n         My Information:");
        person.printPersonInfo();
        System.out.println("------------------------------------------------------");
    }
}