package lambdasinaction._02stream.basic2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice{
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1100),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
		// filter, sorted, forEach
		transactions.stream()
		.filter(tx -> tx.getYear() == 2011)
		.sorted(comparingInt(Transaction::getValue))
		.forEach(System.out::println);

		System.out.println("-----------");
		// Query 2: What are all the unique cities where the traders work?
		// map, distinct, forEach
		transactions.stream() // Stream<Transaction>
		.map(tx -> tx.getTrader().getCity())//Stream<Trader> --> Stream<String>
		.distinct()
		.forEach(System.out::println);
		
		System.out.println("-----------");
        // Query 3: Find all traders from Cambridge and sort them by name.
		transactions.stream()
		.map(tx -> tx.getTrader())
		.filter(tr -> tr.getCity().equals("Cambridge"))
		.distinct()
		.sorted(comparing(Trader::getName))
		.forEach(System.out::println);

		System.out.println("-----------");
		// Query 4: Return a string of all traders names sorted alphabetically.
		String names = transactions.stream()
								.map(tx -> tx.getTrader().getName()) // Stream<String>
								.distinct()
								.sorted()
								.reduce("", (s1, s2) -> s1+s2);
		System.out.println(names);
        
		System.out.println("-----------");
        // Query 5: Are there any trader based in Milan?
		boolean milanBased = transactions.stream()
					.anyMatch(tx -> tx.getTrader().getCity().equals("Milan"));
		System.out.println("milanBased=" + milanBased);
        
		System.out.println("-----------");
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
		transactions.stream()
					.map(tx -> tx.getTrader())
					.filter(tr -> tr.getCity().equals("Milan"))
					.forEach(tr -> tr.setCity("Cambridge"));
		
		System.out.println(transactions);

        // Query 7: What's the highest value in all the transactions?
		int highValue= transactions.stream()
						.mapToInt(tx -> tx.getValue()) // IntStream
						.max() // OptionalInt
						.getAsInt();
		System.out.println("highValue=" + highValue);
    }
}