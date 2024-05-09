package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	public String getFakeFirstName() {

		Faker faker = new Faker();  

		String firstName = faker.name().firstName();
		return firstName;

	}
	public String getFakeSecondName() {

		Faker faker = new Faker();
 
		String lastName = faker.name().lastName(); 
		return lastName;

	}

}
