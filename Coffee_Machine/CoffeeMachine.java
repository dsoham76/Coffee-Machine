import java.util.HashMap;

public class CoffeeMachine {

    private int moneyBox=0;
    private HashMap<String,Integer> ingredients;
    private HashMap<String,HashMap<String,Integer>> coffeeDetails;
    private HashMap<String,Integer> coffeeSold;

    public CoffeeMachine(){
        moneyBox=0;
        ingredients=new HashMap<>();
        coffeeDetails=new HashMap<>();
        coffeeSold=new HashMap<>();

        ingredients.put("water",0);
        ingredients.put("milk",0);
        ingredients.put("beans",0);

        HashMap<String,Integer> espressoDetails=new HashMap<>();
        espressoDetails.put("price",4);
        espressoDetails.put("water",250);
        espressoDetails.put("milk",0);
        espressoDetails.put("beans",16);
        coffeeDetails.put("Espresso", espressoDetails);


        HashMap<String,Integer> latteDetails=new HashMap<>();
        latteDetails.put("price",7);
        latteDetails.put("water",350);
        latteDetails.put("milk",75);
        latteDetails.put("beans",20);
        coffeeDetails.put("Latte", latteDetails);

        HashMap<String,Integer> cappuccinoDetails=new HashMap<>();
        cappuccinoDetails.put("price",6);
        cappuccinoDetails.put("water",200);
        cappuccinoDetails.put("milk",100);
        cappuccinoDetails.put("beans",12);
        coffeeDetails.put("Cappuccino", cappuccinoDetails);



    }

    public void buyCoffee(String coffeeType) {
        if(!coffeeDetails.containsKey(coffeeType)){
            System.out.println("Enter vaild coffee type");
            return;
        }
        
        int price=coffeeDetails.get(coffeeType).get("price");

        if(hasEnoughIngredients(coffeeType)){
            System.out.println("Despening "+coffeeType);
            moneyBox+=price;
            diductIngredients(coffeeType);
            coffeeSold.put(coffeeType,coffeeSold.getOrDefault(coffeeType, 0)+1);            
        }else{
            System.out.println("No enough ingredients to make coffee");
        }
    }


    private boolean hasEnoughIngredients(String coffeeType){
        return ingredients.get("water")>=coffeeDetails.get(coffeeType).get("water") && 
                ingredients.get("milk")>=coffeeDetails.get(coffeeType).get("milk") &&
                ingredients.get("beans")>=coffeeDetails.get(coffeeType).get("beans");
    }

    private void diductIngredients(String coffeeType){
        ingredients.put("water",ingredients.get("water")-coffeeDetails.get(coffeeType).get("water"));
        ingredients.put("milk",ingredients.get("milk")-coffeeDetails.get(coffeeType).get("milk"));
        ingredients.put("beans",ingredients.get("beans")-coffeeDetails.get(coffeeType).get("beans"));

    }

    public void fillIngredients(int water, int milk, int beans) {
        ingredients.put("water",ingredients.get("water")+water);
        ingredients.put("milk",ingredients.get("milk")+milk);
        ingredients.put("beans",ingredients.get("beans")+beans);
    }

    public void takeMoney() {
        System.out.println("Taking money "+moneyBox+" from Money Box");
        moneyBox=0;
    }

    public void showIngredients() {
        System.out.println("Water "+ingredients.get("water")+ " ml");
        System.out.println("Milk "+ingredients.get("milk")+" ml");
        System.out.println("Beans "+ingredients.get("beans"));
    }

    public void showAnalytics() {
        System.out.println("Coffee Sold");
        for(String I: coffeeSold.keySet()){
            System.out.println(I+" "+coffeeSold.get(I));
        }
        System.out.println("Total Earning Rs."+ moneyBox);
        System.out.println("Ingredients Left");
        showIngredients();
    }

    
}
