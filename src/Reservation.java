public class Reservation {
    final String from ="A";
    final String to = "B";
    final String dateOfTravel = "June 13, 2021; 16:00:00";
    private String reservationDate;
    private int numberOfSeats;
    String typeOfSeats;
    private int reservationCode;
    static  int firstClassSeats = 50;
    static  int normalSeats = 500;




    public Reservation(String reservationDate, String typeOfSeats, int reservationCode, int numberOfSeats) {
        this.reservationDate = reservationDate;
        this.typeOfSeats = typeOfSeats;
        this.reservationCode = reservationCode;
        this.numberOfSeats = numberOfSeats;
    }





    public String getFrom() {
        return from;
    }


    public String getTo() {
        return to;
    }


    public String getDateOfTravel() {
        return dateOfTravel;
    }


    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getTypeOfSeats() {
        return typeOfSeats;
    }

    public int getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(int reservationCode) {
        this.reservationCode = reservationCode;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    private void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void cancelMe(){
        if (this.typeOfSeats.equals("Normal")){
            normalSeats += this.numberOfSeats;
        }else{
            firstClassSeats += this.numberOfSeats;
        }


    }
    @Override
    public String toString(){
        return "["+dateOfTravel+"] From:"+from+" To:"+to+" "+numberOfSeats+" seats of "+typeOfSeats;
    }



   }






