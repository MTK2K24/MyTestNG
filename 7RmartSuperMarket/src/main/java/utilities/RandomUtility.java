package utilities;

import com.github.javafaker.Faker;

public class RandomUtility {
	private Faker faker;

	public RandomUtility() {
		this.faker = new Faker();
	}

	public String generateRandomCategoryName() {
		return faker.food().ingredient();
	}

	public String generateRandomSubCategoryName() {
		return faker.food().spice();
	}
}
