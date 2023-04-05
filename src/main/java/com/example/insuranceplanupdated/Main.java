package com.example.insuranceplanupdated;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main{
    //public Scanner readline = new Scanner(System.in);
    public static void main(String[] args){
        UserStorage users = new UserStorage();
        User rohan = new User("rohan@rohan", "rohan kale", "1243242" );
        Insurance rohanInsurancePhone = new PhoneInsurance(200);
        Insurance rohanInsuranceHouse = new HouseInsurance(300000);
        Insurance rohanInsuranceCar = new CarInsurance(300000);
       rohan.addInsurance(rohanInsurancePhone);



//        Insurance rohanPhoneInsuranceTwo = new PhoneInsurance(300);
        //double premuimOne =  rohanInsurancePhone.CalculatePremium(rohanInsurancePhone.purchasePrice,rohanInsurancePhone.premium);
//        double premiumTwo = rohanPhoneInsuranceTwo.CalculatePremium(300,0.01);
   //     System.out.println(premuimOne);
//        System.out.println(premiumTwo);

        rohan.addInsurance(rohanInsuranceHouse);
        rohan.addInsurance(rohanInsuranceCar);
        users.addUser(rohan);

        start(users);
    }

    public static void start(UserStorage users){
        System.out.println("Welcome to Star insurance");
        System.out.println("What would you like to do");
        System.out.println("1. Add a new Insurance");
        System.out.println("2. View Insurances");
        System.out.println("3. Calculate Premium");


        Scanner readLine = new Scanner(System.in);
        String choice = readLine.nextLine();
        System.out.println(choice);
        if(choice.equals("1")){
            addInsurance(users);
        }

        else if(choice.equals("2")) {
            System.out.println("Please enter your email");

            Scanner readlineEmailChecker = new Scanner(System.in);
            String UserEmail = readlineEmailChecker.nextLine();
            User foundUser = users.findByEmail(UserEmail);
            if (foundUser==null){
                System.out.println("user not found");
                start(users);
            }
            else {
                ArrayList insurances = foundUser.insurances;
                System.out.println("your insurances are: ");
                for(int i =0; i<insurances.size(); i++){
                    System.out.println(insurances.get(i));
                }
                start(users);

            }


        }
        else if(choice.equals("3")) {
            System.out.println("Please enter your email");
            Scanner readlineEmailChecker = new Scanner(System.in);
            String UserEmail = readlineEmailChecker.nextLine();
            User foundUser = users.findByEmail(UserEmail);
            //System.out.println(foundUser);

            //Early exit
            if (foundUser==null){
                System.out.println("user not found");
                start(users);
                return;
            }
            System.out.println("your insurances are "+foundUser.insurances);
            double premiumAmount = foundUser.calculateTotalPremium();
            System.out.println("Your total premium is "+ premiumAmount);

            start(users);


        }

        else {
            System.out.println("Command not recognized");
            start(users);
        }
    }



    public static void addInsurance(UserStorage users){
        System.out.println("Next step");
        String[] insuranceTypes = new String[] {"House", "Car", "Phone"};
        System.out.println("What type of insurance do you want");
        for (int i = 0; i < insuranceTypes.length; i++) {
            System.out.println((i +1)+ " "+ insuranceTypes[i]);
        }
        Scanner readLine = new Scanner(System.in);
        int choice = Integer.parseInt(readLine.nextLine());
        System.out.println("What was the purchase price?");
        int purchasePriceEuro = Integer.parseInt(readLine.nextLine());
        System.out.println(purchasePriceEuro);

        Insurance userInsurance = null;
        switch(choice){
            case 1:
                System.out.println(insuranceTypes[choice-1]);
                userInsurance= new HouseInsurance(purchasePriceEuro);
                break;
            case 2:
                System.out.println(insuranceTypes[choice-1]);
                userInsurance= new CarInsurance(purchasePriceEuro);
                break;
            case 3:
                System.out.println(insuranceTypes[choice-1]);
                userInsurance= new PhoneInsurance(purchasePriceEuro);
                break;
            default:
                System.out.println("Command not recognized");
                addInsurance(users);

        }

        System.out.println("Do you already have an insurance with Star, if yes enter 1 or enter 2");
        Scanner readlineUserChecker = new Scanner(System.in);
        int UserChoice = Integer.parseInt(readlineUserChecker.nextLine());
        String decesion = "NO";



        switch(UserChoice){
            case 1:
                System.out.println("Please enter your email");
                Scanner readlineEmailChecker = new Scanner(System.in);
                String UserEmail = readlineEmailChecker.nextLine();
//                System.out.println(users.users.size());
                //System.out.println(users.users.getClass()); it is an arrayList

//                //not finding the user correctly
//                for (int i=0; i<users.users.size(); i++) {
//                    //either this if is incorrect or something else is wrong
//                    if(UserEmail.equals(users.users.get(i).email)) {

                for (int i = 0; i < users.users.size(); i++) {
                    if (users.users.get(i).email.contains(UserEmail)) {
                       // System.out.println("User found");
                        decesion = "YES";
                    }
                }
                switch(decesion) {

                    case "NO":
                        System.out.println("user not found");
                        start(users);
                        break;

                    case "YES":
                        for (int j = 0; j < users.users.size(); j++) {
                           // System.out.println(UserEmail);
                            //if statement is not getting implemented
                              if (users.users.get(j).email.equals(UserEmail)) {
                                    System.out.println("User found");
                                    //checked with debugger, it works
                                    users.users.get(j).addInsurance(userInsurance);
                                  System.out.println("Insurace added!");

                            }



                        }
                        start(users);
                        break;
                }


//                        for (int i = 0; i < users.users.size(); i++) {
//                            if(users.users.get(i).email.contains(UserEmail)){
//                        System.out.println("User found");
//                        //checked with debugger, it works
//                        users.users.get(i).addInsurance(userInsurance);
//                        System.out.println("Insurace added!");
//                    }
//                    else{
//                        System.out.println("user not found");
//                        break;
//                    }


                break;

            case 2:
                System.out.println("Please enter details as they appear");
                User user = createUser();
                user.addInsurance(userInsurance);
                users.addUser(user);
                start(users);

        }

        }
    public static User createUser(){
        Scanner readLine = new Scanner(System.in);
        System.out.println("What is your email");
        String email = readLine.nextLine();
        System.out.println("What is your name");
        String name = readLine.nextLine();
        System.out.println("What is your IBAN");
        String IBAN = readLine.nextLine();
        User user = new User(email, name, IBAN);
        System.out.println("check");
        return user;
    }
}
