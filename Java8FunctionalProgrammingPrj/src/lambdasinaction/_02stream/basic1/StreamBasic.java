package lambdasinaction._02stream.basic1;

import java.util.*;
import java.util.stream.Collectors;

//import static java.util.Comparator.comparing;
import static java.util.Comparator.*;
//import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.*;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(list -> System.out.println(list));
//        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        
        System.out.println("---");
        System.out.println(getGroupingMenu(Dish.menu));
        
        System.out.println("---");
        System.out.println(getMaxCaloryDish(Dish.menu));
        


    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() <= 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        List<String> lowCaloricLimit3DishesName = new ArrayList<>();
        lowCaloricLimit3DishesName = lowCaloricDishesName.subList(0,3);

        return lowCaloricLimit3DishesName;
    }

    //Java 8
    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
//    	return dishes.stream() // Stream<Dish>
//    			.filter(dish -> dish.getCalories() <= 400) // Stream<Dish>
//    			.sorted(Comparator.comparing(dish -> dish.getCalories())) // Stream<Dish>
//    			.map(dish -> dish.getName()) // Stream<String>
//    			.collect(Collectors.toList()) // List<String>
//    			.subList(0, 3);
    	
    	return dishes.stream() // Stream<Dish>
    			.filter(dish -> dish.getCalories() <= 400) // Stream<Dish>
    			.sorted(comparing(Dish::getCalories)) // Stream<Dish>
    			.map(Dish::getName) // Stream<String>
    			.collect(toList()) // List<String>
    			.subList(0, 3);
    }
    
    //400칼로리 이하인 메뉴를 다이어트로, 아닐 경우 일반으로 그룹핑해라.
    public static Map<String, List<Dish>>  getGroupingMenu(List<Dish> dishes){
    	
    	return dishes.stream()
    			.collect(groupingBy(dish -> {
    				if(dish.getCalories() <= 400) return "diet";
    				else return "normal";
    			}));
 
    }
    
 
    //가장 칼로리가 높은 메뉴를 찾아라
    public static Dish getMaxCaloryDish (List<Dish> dishes) {
    	return dishes.stream() // Stream<Dish>
    			.max(comparingInt(Dish::getCalories)) // Optional<Dish>
    			.get(); // Dish
    }
}
