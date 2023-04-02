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
        double premuimOne =  rohanInsurancePhone.CalculatePremium(rohanInsurancePhone.purchasePrice,rohanInsurancePhone.premium);
//        double premiumTwo = rohanPhoneInsuranceTwo.CalculatePremium(300,0.01);
        System.out.println(premuimOne);
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
            String decesion = "NO";


            for (int i = 0; i < users.users.size(); i++) {
                if (UserEmail.equals(users.users.get(i).email)) {
                    decesion = "YES";
                    //System.out.println(decesion);
                }
            }

                    switch (decesion) {

                        case "NO":
                            System.out.println("user not found");
                             start(users);
                            break;
                        case "YES":
                            System.out.println("User found");
                            for (int j = 0; j < users.users.get(j).insurances.size(); j++) {

                                ArrayList insurances = users.users.get(j).insurances;

                                for ( int k=0; k<insurances.size();k++ ){

                                    Insurance insurance = users.users.get(j).insurances.get(k);
                                    System.out.println(insurance);
                                    //System.out.println(insurance.Premium());
                                }


                                start(users);


                            }
                            break;

                }




        }
        else if(choice.equals("3")) {
            System.out.println("Please enter your email");
            List<Double> premiumsList = new ArrayList<Double>();
            Scanner readlineEmailChecker = new Scanner(System.in);
            String UserEmail = readlineEmailChecker.nextLine();
            String decesion = "NO";


            for (int i = 0; i < users.users.size(); i++) {
                if (UserEmail.equals(users.users.get(i).email)) {
                    decesion = "YES";
                    //System.out.println(decesion);
                }
            }

            switch (decesion) {

                case "NO":
                    System.out.println("user not found");
                    start(users);
                    break;
                case "YES":
                    System.out.println("User found");

                    for (int j = 0; j < users.users.get(j).insurances.size(); j++) {
                        //this is the potenital solution to the problem, I just don't know how it will handle multiple insurances
                        ArrayList insurances = users.users.get(j).insurances;
                        System.out.println("Your insurances are: ");
                        System.out.println(insurances);

                        for(int x =0; x<users.users.get(j).insurances.size();x++){



                            premiumsList.add(users.users.get(j).insurances.get(x).CalculatePremium(users.users.get(j).insurances.get(x).purchasePrice,users.users.get(j).insurances.get(x).premium));
                            //System.out.println(premiumsList);




                        }
                        double sum = 0.0;
                        for(double element : premiumsList){
                            sum +=element;
                        }
                        //System.out.println(premiumsList);
                        System.out.println("your premium is "+ sum);




                        start(users);


                    }
                    break;

            }
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


        switch(UserChoice){
            case 1:
                System.out.println("Please enter your email");
                Scanner readlineEmailChecker = new Scanner(System.in);
                String UserEmail = readlineEmailChecker.nextLine();
//                System.out.println(users.users.size());
                //System.out.println(users.users.getClass()); it is an arrayList

                for (int i=0; i<users.users.size(); i++) {
                    if(UserEmail.equals(users.users.get(i).email)) {
                        System.out.println("User found");
                        //checked with debugger, it works
                        users.users.get(i).addInsurance(userInsurance);
                        System.out.println("Insurace added!");
                    }
                    else{
                        System.out.println("user not found");
                        break;
                    }


                }
                start(users);
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
