package com.epam.freelancer.util;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentVariablesManager {
	private Properties properties;

	private EnvironmentVariablesManager() {
	}

	private void loadVariables(String path) throws IOException {
		properties = new Properties();

//			properties.load(file);
	}

	private static final class EnvironmentVariablesManagertHolder {
		private static final EnvironmentVariablesManager HOLDER_INSTANCE = new EnvironmentVariablesManager();
		static {
			try {
				HOLDER_INSTANCE
						.loadVariables("/environmentVariables.properties");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static EnvironmentVariablesManager getInstance() {
		return EnvironmentVariablesManagertHolder.HOLDER_INSTANCE;
	}

	public String getVar(String name) {
		return properties.getProperty(name);
	}
}
