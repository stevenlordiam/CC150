/** 
 * Chapter 3-Stacks and Queues
 * Question 3-7
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. 
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select 
 * whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select 
 * which specificanimal they would like. Create the data structures to maintain this system and implement operations such as \
 * enqueue, dequeueAny, dequeueDog and dequeueCat. You mayusethe built-in LinkedList data structure.
 */

public class StacksAndQueues_7 {

	public abstract class Animal{
		private int order;
		protected String name;
		public Animal(String n){
			name = n;
		}

		public void setOrder(int ord){
			order = ord;
		}

		public int getOrder(){
			return order;
		}

		public boolean isOrderThan(Animal a){
			return this.order < a.getOrder
		}
	}

	public class AnimalQueue{
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		private int order = 0; 			// act as timestamp

		public void enqueue(Animal a){
			a.setOrder(order);
			order++;
			if(a instanceof Dog) dogs.addLast((Dog) a); 		// enqueue: LinkedList.addLast(E e) - append the specified element to the end of the list
			else if (a instanceof Cat) cats.addLast((Cat)a);
		}

		public Animal dequequeAny(){
			if(dogs.size()==0){
				return dequeueCat();
			} else if (cats.size()==0){
				return dequeueDog();
			}

			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if(dog.isOrderThan(cat)){
				return dequeueDog();
			}else{
				return dequeueCat();
			}
		}

		public Dog dequeueDog(){
			return dogs.poll();			// dequeue: LinkedList.poll() - retrieve and remove the head (first element) of the list
		}

		public Cat dequeueCat(){
			return cats.poll();
		}
	}

	public class Dog extends Animal{
		public Dog(String n){			
			super(n);
		}
	}

	public class Cat extends Animal{
		public Cat(String n){
			super(n);
		}
	}

}

/*

  key: 
  * use a wrapper class(THIS IS IMPORTANT!!!)
  * use a timestamp to compare the insertion order of a dog to a cat
  * use the two method to implemet a queue using LinkedList:
  	enqueue: LinkedList.addLast(E e) - append the specified element to the end of the list
  	dequeue: LinkedList.poll() - retrieve and remove the head of the list
*/