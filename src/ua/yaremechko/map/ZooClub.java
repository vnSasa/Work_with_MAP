package ua.yaremechko.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ZooClub {

	public static void main(String[] args) {

		Map<Person, List<Animal>> map = new HashMap<>();
		Set<Entry<Person, List<Animal>>> entrySet = map.entrySet();

		Scanner sc = new Scanner(System.in);

		while (true) {

			menu();

			switch (sc.nextInt()) {

//			ADD MEMBER

			case 1: {
				System.out.println("Add a club member!!!");
				System.out.println();
				System.out.println("Enter name person: ");
				String namePerson = sc.next();
				System.out.println("Enter age person: ");
				int age = sc.nextInt();

				Person person = new Person(namePerson, age);
				map.putIfAbsent(person, new ArrayList<Animal>());
				System.out.println("Member is added!!!");

				break;
			}

//			ADD ANIMAL

			case 2: {
				System.out.println("Add a pet to a club member!!!");
				System.out.println("Enter name of member: ");
				String namePerson = sc.next();
				System.out.println("Enter type animal: ");
				String typeAnimal = sc.next();
				System.out.println("Enter name animal: ");
				String nameAnimal = sc.next();

				Animal animal = new Animal(typeAnimal, nameAnimal);

				for (Entry<Person, List<Animal>> entry : entrySet) {
					if (entry.getKey().getNamePerson().equalsIgnoreCase(namePerson)) {
						entry.getValue().add(animal);
					}
				}
				System.out.println("Pet is added!!!");
				
				break;
			}

//			REMOVE ANIMAL FROM MEMBER

			case 3: {
				System.out.println("Remove the pet from the club member");
				System.out.println("Enter name of member: ");
				String namePerson = sc.next();
				System.out.println("Enter type animal: ");
				String typeAnimal = sc.next();
				System.out.println("Enter name animal: ");
				String nameAnimal = sc.next();

				Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

				while (iterator.hasNext()) {
					Entry<Person, List<Animal>> next = iterator.next();
					if (next.getKey().getNamePerson().equalsIgnoreCase(namePerson)) {
						List<Animal> value = next.getValue();
						Iterator<Animal> iterator2 = value.iterator();
						while (iterator2.hasNext()) {
							Animal next2 = iterator2.next();
							if (next2.getTypeAnimal().equalsIgnoreCase(typeAnimal)) {
								if (next2.getNameAnimal().equalsIgnoreCase(nameAnimal)) {
									iterator2.remove();
								}
							}
						}
					}
				}
				System.out.println("animal removing!!!");
				
				break;
			}

//			REMOVE MEMBER

			case 4: {
				System.out.println("Remove a club member!!!");
				System.out.println("Enter name of member: ");
				String namePerson = sc.next();
				System.out.println("Enter age person: ");
				int age = sc.nextInt();

				Person person = new Person(namePerson, age);
				map.remove(person);
				
				break;
			}

//			REMOVE ANIMAL FROM ALL

			case 5: {
				System.out.println("Enter type Animal: ");
				String typeAnimal = sc.next();

				Iterator<Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

				while (iterator.hasNext()) {
					Entry<Person, List<Animal>> next = iterator.next();

					List<Animal> value = next.getValue();
					Iterator<Animal> iterator2 = value.iterator();
					while (iterator2.hasNext()) {
						Animal next2 = iterator2.next();
						if (next2.getTypeAnimal().equalsIgnoreCase(typeAnimal)) {
							iterator2.remove();

						}
					}

				}
				System.out.println("animal removing!!!");

				break;
			}

//			SHOW ALL

			case 6: {
				for (Entry<Person, List<Animal>> entry : entrySet) {
					System.out.println(entry.getKey() + "___" + entry.getValue());
				}
				break;
			}

//			EXIT

			case 0: {
				System.out.println("GOOD BYE");
				System.exit(0);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + sc.nextInt());
			}

		}

	}

	private static void menu() {
		System.out.println();
		System.out.println("Press 1 - Add a club member");
		System.out.println("Press 2 - Add a pet to a club member");
		System.out.println("Press 3 - Remove the pet from the club member");
		System.out.println("Press 4 - Remove a member from the club");
		System.out.println("Press 5 - Remove a specific pet from all owners");
		System.out.println("Press 6 - Display a zoo club");
		System.out.println("Press 0 - Exit the program");

	}

}
