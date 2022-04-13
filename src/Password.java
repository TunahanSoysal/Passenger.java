import java.util.Random;
import java.util.Scanner;

public class Password {
    private int password;
    public Password(int password){
        Random rnd = new Random();
        if (!isStrongPassword(password)) {
            while (!isStrongPassword(password)) {
                password = (int) (rnd.nextDouble() * 1000000);
            }
            System.out.println("Your password was not a strong one, your new password is: "+ password);
        }

        this.password = password;



    }

    private  boolean isStrongPassword(int newpassword){
        String newpasswordS = String.valueOf(newpassword);
        if (newpasswordS.length()!=6){

            return false;
        }
        for (int i =0;i<5;i++){
            for (int j = i+1;j<6;j++){
                if (newpasswordS.charAt(i) == newpasswordS.charAt(j)){
                   return false;
                }
            }

        }
        return  true;
    }

    public void resetPassword(){
        Scanner scn = new Scanner(System.in);
        int newpassword = scn.nextInt();
        if (isStrongPassword(newpassword)){
            password = newpassword;
        }else{
            resetPassword();
        }


    }

    public boolean checkPassword(int passwordCheck){
        return passwordCheck == password;

    }
}
