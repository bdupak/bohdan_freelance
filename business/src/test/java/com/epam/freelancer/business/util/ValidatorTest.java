package com.epam.freelancer.business.util;

import org.junit.Test;

import com.epam.freelancer.business.util.ValidationParametersBuilder.Parameters;

import junit.framework.TestCase;

public class ValidatorTest extends TestCase {

	@Test
	public void testValidateNumb() throws Exception {
		Parameters parameters = ValidationParametersBuilder.createParameters(
				false).pattern("[0-9].*");
		assertTrue(Validator.validate(parameters, "446456", "565"));

		Parameters parameters2 = ValidationParametersBuilder.createParameters(
				false).pattern("[0-9]*");
		assertTrue(Validator.validate(parameters2, "", "", ""));

		Parameters parameters3 = ValidationParametersBuilder
				.createParameters(true).isInteger(false).max(54.0).min(40.0);
		assertFalse(Validator.validate(parameters3, "fdsg"));
	}

	@Test
	public void testValidateStr() throws Exception {
		Parameters parameters = ValidationParametersBuilder
				.createParameters(false).maxLength(10).minLength(5)
				.notEmptyString(true);
		assertFalse(Validator.validate(parameters, "asf", "asfsfsdg"));
		assertFalse(Validator.validate(parameters, "", "dsgdd"));
		assertFalse(Validator.validate(parameters, "adasffsfdfsdfddddddddddd",
				"asfsdgd"));

		assertTrue(Validator.validate(parameters, new String[] {}));
		assertTrue(Validator.validate(parameters, "446456", "sdgdg"));
		assertTrue(Validator.validate(parameters, "1234567890"));
	}

	@Test
	public void testValidateEmail() throws Exception {
		Parameters parameters = ValidationParametersBuilder
				.createParameters(false)
				.pattern(
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]+)")
				.maxLength(50).minLength(5);

		assertTrue(Validator.validate(parameters, "bsdfsdgsaf@ssdfsdg.asfsdf",
				"bsdfsdgsaf@ssdfsdg.asfsdf"));
		assertFalse(Validator.validate(parameters, "bsdfsdgsaf@ssdfsdg.asfsdf",
				"bsdfsdgsadfgfsdf"));
		assertFalse(Validator.validate(parameters, "sdfdsadsafsf"));
	}

	@Test
	public void testValidateDouble() throws Exception {
		Parameters parameters = ValidationParametersBuilder
				.createParameters(true).max(50.0).min(25.0).isInteger(false);

		assertTrue(Validator.validate(parameters, "49.5", "25.0", "28.5"));
		assertFalse(Validator.validate(parameters, "-49.5", "25.0", "28.5"));
		assertFalse(Validator.validate(parameters, "49.5", "24.9", "28.5"));
	}

	@Test
	public void testValidateInteger() throws Exception {
		Parameters parameters = ValidationParametersBuilder
				.createParameters(true).max(50.0).min(25.0);

		assertTrue(Validator.validate(parameters, "49", "25", "28"));
		assertFalse(Validator.validate(parameters, "-49", "25", "28"));
		assertFalse(Validator.validate(parameters, "49", "24", "28"));
	}
}
