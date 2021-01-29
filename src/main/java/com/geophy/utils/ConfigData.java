package com.geophy.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class ConfigData {
    static EnvironmentVariables environmentVariables = Injectors.getInjector().getInstance(EnvironmentVariables.class);

    static String validUsername = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("valid.username");
    static String validPassword = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("valid.password");
    static String invalidUsername = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("invalid.username");
    static String invalidPassword = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("invalid.password");
    static String validSearchAddress = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("valid.search.address");
    static String invalidSearchAddress = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("invalid.search.address");

    public static String getValidUsername() {
        return validUsername;
    }

    public static String getValidPassword() {
        return validPassword;
    }

    public static String getInvalidUsername() {
        return invalidUsername;
    }

    public static String getInvalidPassword() {
        return invalidPassword;
    }

    public static String getValidSearchAddress() {
        return validSearchAddress;
    }

    public static String getInvalidSearchAddress() {
        return invalidSearchAddress;
    }
}
