package StringUtilities;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

public class StringUtils {

	public static String getName() {

		String name = RandomStringUtils.randomAlphabetic(8);
		return "AutomationName " + name;
	}

	public static String getEmail() {
		String name = RandomStringUtils.randomAlphabetic(10);
		return name + "@testautomation.com";
	}

	public static String randomPrgCodeGenerator() {
		return "prgcode" + RandomStringUtils.randomNumeric(6);
	}

	public static String randomProgramNamegenerator() {
		Faker faker = new Faker();
		String name = faker.educator().course();
		return name + RandomStringUtils.randomAlphabetic(8);
	}

	public static String randomCourseCodeGenerator() {
		return "Coursecode" + RandomStringUtils.randomNumeric(6);
	}

	public static String randomCourseNamegenerator() {
		Faker faker = new Faker();
		String name = faker.educator().course();
		return name + RandomStringUtils.randomAlphabetic(6);
	}
	
	
	public static String randomBatchGenerator() {

		Faker faker = new Faker();
		String name = faker.animal().name();
		return "batch"+ name + RandomStringUtils.randomAlphanumeric(4);

	}

}
