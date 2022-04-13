import java.util.ArrayList;
import java.util.List;

public class Passenger {
    String name, address;
    int phoneNumber;
    Password password;
    List<Reservation> reservations = new ArrayList<>();
    int accountId;

    public Passenger(String name, String address, int phoneNumber, int password) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = new Password(password);
        accountId = TestClass.passengers.size()+1001;
        System.out.println("your accountID is: "+accountId);

    }

    public boolean Login(String password){
        return this.password.checkPassword(Integer.parseInt(password));


    }

    public int addReservation(int numOfSeats, String typeOfSeats){
        if ((typeOfSeats.equals("Normal")& numOfSeats<Reservation.normalSeats)){
            int reservationCode = Integer.parseInt(String.valueOf(accountId)+(1001+reservations.size()));
            reservations.add(new Reservation("June 13,2021",typeOfSeats,reservationCode,numOfSeats));
            return reservationCode;
        }else if ((typeOfSeats.equals("FirstClass")&numOfSeats<Reservation.firstClassSeats)){
            int reservationCode = Integer.parseInt(String.valueOf(accountId)+(1001+reservations.size()));
            reservations.add(new Reservation("June 13,2021",typeOfSeats,reservationCode,numOfSeats));
            return reservationCode;
        }else{
            return 0;
        }



    }

    public void displayReservation(int givenReservationCode){
        for (Reservation reservation:reservations) {
            if (reservation.getReservationCode()==givenReservationCode){
                System.out.println(reservation);
                break;
            }
        }
    }

    public void cancelReservation(int givenReservationCode){
        for (Reservation reservation:reservations) {
            if (reservation.getReservationCode()==givenReservationCode){
                reservation.cancelMe();
                reservations.remove(reservation);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}

