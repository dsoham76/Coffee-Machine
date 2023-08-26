import java.util.Scanner;

public class CoffeeMachineApp{
    public static void main(String[] args){
        CoffeeMachine coffeeMachine=new CoffeeMachine();
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("Options");
            System.out.println("1. Buy Coffee");
            System.out.println("2. Fill Ingredients");
            System.out.println("3. Take Money");
            System.out.println("4. Show Ingredients");
            System.out.println("5. Show Analytics");
            System.out.println("6. Exit");

            System.out.println("Enter your choice");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter coffeeType(Espresso/Latte/Cappuccino)");
                    String coffeeType=sc.nextLine();
                    coffeeMachine.buyCoffee(coffeeType);
                    break;
                case 2:
                    System.out.println("Enter amount of water to fill");
                    int water=sc.nextInt();
                    System.out.println("Enter amount of milk to fill");
                    int milk=sc.nextInt();
                    System.out.println("Enter amount of beans to fill");
                    int beans=sc.nextInt();
                    coffeeMachine.fillIngredients(water,milk,beans);
                    break;
                case 3:
                    coffeeMachine.takeMoney();
                    break;
                case 4:
                    coffeeMachine.showIngredients();
                    break;
                case 5:
                    coffeeMachine.showAnalytics();
                    break;
                case 6:
                    System.out.println("Thank you");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid input");


            }

        }

    }
}