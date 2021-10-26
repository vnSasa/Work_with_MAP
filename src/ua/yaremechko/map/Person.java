package ua.yaremechko.map;

public class Person implements Comparable<Person> {

	private String namePerson;
	private int age;

	public Person(String namePerson, int age) {
		super();
		this.namePerson = namePerson;
		this.age = age;
	}

	public String getNamePerson() {
		return namePerson;
	}

	public void setNamePerson(String namePerson) {
		this.namePerson = namePerson;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((namePerson == null) ? 0 : namePerson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (namePerson == null) {
			if (other.namePerson != null)
				return false;
		} else if (!namePerson.equals(other.namePerson))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [namePerson=" + namePerson + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {

		return this.namePerson.compareTo(getNamePerson());
	}

}
