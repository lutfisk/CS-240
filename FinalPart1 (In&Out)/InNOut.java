/**
  	In-N-Out restaurant items sold, wasted, and customer loss for December month.
 
	@author Lutfi Haji-Cheteh
 */
import java.util.Iterator;
import java.util.Random;

public class InNOut{
	
	private static StackFixedArray<Integer> bun = new StackFixedArray<Integer>(10000);
	private static StackFixedArray<Integer> patty = new StackFixedArray<Integer>(10000);
	private static StackFixedArray<Integer> lettuce = new StackFixedArray<Integer>(10000);
	private static StackFixedArray<Integer> tomato = new StackFixedArray<Integer>(10000);
	private static StackFixedArray<Integer> onion = new StackFixedArray<Integer>(10000);
	private static StackFixedArray<Integer> cheese = new StackFixedArray<Integer>(10000);
	
	private static ListFixedArray<StackFixedArray<Integer>> itemOne = new ListFixedArray<StackFixedArray<Integer>>(5);
	private static ListFixedArray<StackFixedArray<Integer>> itemTwo = new ListFixedArray<StackFixedArray<Integer>>(6);
	private static ListFixedArray<StackFixedArray<Integer>> itemThree = new ListFixedArray<StackFixedArray<Integer>>(4);
	private static ListFixedArray<StackFixedArray<Integer>> itemFour = new ListFixedArray<StackFixedArray<Integer>>(4);
	private static ListFixedArray<StackFixedArray<Integer>> itemFive = new ListFixedArray<StackFixedArray<Integer>>(5);
	private static ListFixedArray<StackFixedArray<Integer>> itemSix = new ListFixedArray<StackFixedArray<Integer>>(4);
	
	public static ListFixedArray<StackFixedArray<Integer>> menu(int order){
		switch(order){
			case 1: return itemOne;
			case 2: return itemTwo;
			case 3: return itemThree;
			case 4: return itemFour;
			case 5: return itemFive;
			case 6: return itemSix;
			default: return null;
		}
	}
	
	public static void main(String[] args){
		
		Random num = new Random();
		
		DictionarySortedLinked<Integer, Integer> orders = new DictionarySortedLinked<Integer, Integer>();
		QueueFixedArray<Integer> line = new QueueFixedArray<Integer>(50);		
		
		itemOne.add(bun); itemOne.add(patty); itemOne.add(lettuce); itemOne.add(tomato); itemOne.add(onion);
		itemTwo.add(cheese); itemTwo.add(bun); itemTwo.add(patty); itemTwo.add(lettuce); itemTwo.add(tomato); itemTwo.add(onion);
		itemThree.add(lettuce); itemThree.add(lettuce); itemThree.add(tomato); itemThree.add(onion); 
		itemFour.add(bun); itemFour.add(patty); itemFour.add(lettuce); itemFour.add(tomato);
		itemFive.add(cheese); itemFive.add(bun); itemFive.add(patty); itemFive.add(lettuce); itemFive.add(tomato);
		itemSix.add(bun); itemSix.add(patty); itemSix.add(lettuce); itemSix.add(onion);
	
		int shipment = 0;
		int lostCustomerDay, totalCustomers;
		int wasteBun, wastePatty, wasteLettuce, wasteTomato, wasteOnion, wasteCheese;
		int countItemOne, countItemTwo, countItemThree, countItemFour, countItemFive, countItemSix;
		int dec = 12;
		
		for (int day=1; day<=30; day++){
			int today = dec*100 + day;
			lostCustomerDay = totalCustomers = wasteBun = wastePatty = wasteLettuce = wasteTomato = wasteOnion = wasteCheese = 0;
			countItemOne = countItemTwo = countItemThree = countItemFour = countItemFive = countItemSix = 0;
			orders.clear();
			
			for (int hour=9; hour<=21; hour++){
				if (hour == 9 && shipment == 0){
					System.out.println("SHIPMENT ARRIVING THIS DAY");
					int shipmentItems = (1000 - num.nextInt(301));
					for (int i=shipmentItems; i>0; i--){
						int items = num.nextInt(6);
						switch(items){
							case 0: bun.push(today);
								break;
							case 1: patty.push(today);
								break;
							case 2: lettuce.push(today);
								break;
							case 3: tomato.push(today);
								break;
							case 4: onion.push(today);
								break;
							case 5: cheese.push(today);
								break;
						}
					}
					shipment += 6 - num.nextInt(4);
				}
				
				else if (hour >= 10 && hour <= 19){
					int customers = num.nextInt(100) + 1;
					if (customers > 50){
						lostCustomerDay += (customers - 50);
						customers = 50;
					}
					for (int i=1; i<customers; i++){
						int customerNum = day*10000 + i;
						line.enqueue(customerNum);
					}
					for (int i=1; i<customers; i++){
						int order = num.nextInt(6) + 1;
						
						if (!line.isEmpty()){
							int customerNum = line.dequeue();
								for (int j=0; j<menu(order).getLength(); j++){
								}
								switch (order){
									case 1: if(!bun.isEmpty() || !patty.isEmpty() || !lettuce.isEmpty() || !tomato.isEmpty() || !onion.isEmpty()){
												countItemOne++;
												totalCustomers++;
											}
											else{
												lostCustomerDay++;
											}
											break;
									case 2: if(!bun.isEmpty() || !patty.isEmpty() || !lettuce.isEmpty() || !tomato.isEmpty() || !onion.isEmpty() || !cheese.isEmpty()){
												countItemTwo++;
												totalCustomers++;
											}
											else{
												lostCustomerDay++;
											}
											break;
									case 3: if(!lettuce.isEmpty() || !tomato.isEmpty() || !onion.isEmpty()){
												countItemThree++;
												totalCustomers++;
											}
											else{
												lostCustomerDay++;
											}
											break;
									case 4: if(!bun.isEmpty() || !patty.isEmpty() || !lettuce.isEmpty() || !tomato.isEmpty()){
												countItemFour++;
												totalCustomers++;
											}
											else{
												lostCustomerDay++;
											}
											break;
									case 5: if(!bun.isEmpty() || !patty.isEmpty() || !lettuce.isEmpty() || !tomato.isEmpty() || !cheese.isEmpty()){
												countItemFive++;
												totalCustomers++;
											}
											else{
												lostCustomerDay++;
											}
											break;
									case 6: if(!bun.isEmpty() || !patty.isEmpty() || !lettuce.isEmpty() || !onion.isEmpty()){
												countItemSix++;
												totalCustomers++;
											}
											else{
												lostCustomerDay++;
											}
											break;
								}
								orders.add(customerNum, order);
							}
					}
				}
				else if (hour == 21){
					
					/**SelectionSortFixed.sort(bun.toArray(), 0, bun.getSize()-1);
					SelectionSortFixed.sort(lettuce.toArray(), 0, lettuce.getSize()-1);
					SelectionSortFixed.sort(patty.toArray(), 0, patty.getSize()-1);
					SelectionSortFixed.sort(tomato.toArray(), 0, tomato.getSize()-1);
					SelectionSortFixed.sort(onion.toArray(), 0, onion.getSize()-1);
					SelectionSortFixed.sort(cheese.toArray(), 0, cheese.getSize()-1);**/
					
					while (!bun.isEmpty() && (today - bun.peek()) > 5){
						bun.pop();
						wasteBun++;
					}
					while (!patty.isEmpty() && (today - patty.peek()) > 4){
						patty.pop();
						wastePatty++;
					}
					while (!lettuce.isEmpty() && (today - lettuce.peek()) > 3){
						lettuce.pop();
						wasteLettuce++;
					}
					while (!tomato.isEmpty() && (today - tomato.peek()) > 3){
						tomato.pop();
						wasteTomato++;
					}
					while (!onion.isEmpty() && (today - onion.peek()) > 5){
						onion.pop();
						wasteOnion++;
					}
					while (!cheese.isEmpty() && (today - cheese.peek()) > 2){
						cheese.pop();
						wasteCheese++;
					}
					
				}
			}
			shipment--;
			
			System.out.printf("December %d%n", day);
			System.out.printf("Amount of Customers Lost: %d%n", lostCustomerDay);
			System.out.printf("Wasted items: %d buns, %d patties, %d lettuces, %d tomatoes, %d onions, and %d cheeses%n", 
					wasteBun, wastePatty, wasteLettuce, wasteTomato, wasteOnion, wasteCheese);
			System.out.printf("No. of first items ordered: %d%n", countItemOne);
			System.out.printf("No. of second items ordered: %d%n", countItemTwo);
			System.out.printf("No. of third items ordered: %d%n", countItemThree);
			System.out.printf("No. of fourth items ordered: %d%n", countItemFour);
			System.out.printf("No. of fifth items ordered: %d%n", countItemFive);
			System.out.printf("No. of sixth items ordered: %d%n", countItemSix);
			System.out.printf("Total of Customers this day: %d%n", totalCustomers);
			
			if (!orders.isEmpty()){
				Iterator<Integer> customerNumber = orders.getKeyIterator();
				Iterator<Integer> customerOrder = orders.getValueIterator();
				
				while (customerNumber.hasNext()){
					System.out.printf("Customer #%d ordered item #%d%n", customerNumber.next(), customerOrder.next());
				}
				System.out.printf("%n");
			}
		}
	}
}





