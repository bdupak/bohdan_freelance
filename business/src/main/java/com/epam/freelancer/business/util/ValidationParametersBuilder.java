package com.epam.freelancer.business.util;

public abstract class ValidationParametersBuilder {

	public static Parameters createParameters(boolean isNumber) {
		return new Parameters(isNumber);
	}

	public static class Parameters {
		private boolean isNumber = false;

		private Boolean isInteger;
		private Double max;
		private Double min;

		private Integer maxLength;
		private Integer minLength;
		private String pattern;
		private Boolean notEmptyString;

		private Parameters(boolean isNumber) {
			this.isNumber = isNumber;
		}

		public ValidationParametersBuilder.Parameters maxLength(int maxLength) {
			this.maxLength = maxLength;
			return this;
		}

		public ValidationParametersBuilder.Parameters minLength(int minLength) {
			this.minLength = minLength;
			return this;
		}

		public ValidationParametersBuilder.Parameters pattern(String pattern) {
			this.pattern = pattern;
			return this;
		}

		public ValidationParametersBuilder.Parameters notEmptyString(
				boolean notEmptyString)
		{
			this.notEmptyString = notEmptyString;
			return this;
		}

		public Integer getMaxLength() {
			return maxLength;
		}

		public Integer getMinLength() {
			return minLength;
		}

		public String getPattern() {
			return pattern;
		}

		public Boolean getNotEmptyString() {
			return notEmptyString;
		}

		public boolean isNumber() {
			return isNumber;
		}

		public Boolean getIsInteger() {
			return isInteger;
		}

		public Double getMax() {
			return max;
		}

		public Double getMin() {
			return min;
		}

		public ValidationParametersBuilder.Parameters isInteger(Boolean isInteger) {
			this.isInteger = isInteger;
			return this;
		}

		public ValidationParametersBuilder.Parameters max(Double max) {
			this.max = max;
			return this;
		}

		public ValidationParametersBuilder.Parameters min(Double min) {
			this.min = min;
			return this;
		}
	}
}
