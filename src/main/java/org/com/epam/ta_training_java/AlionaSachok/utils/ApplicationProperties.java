package org.com.epam.ta_training_java.AlionaSachok.utils;

enum ApplicationProperties {
    BASE_URL("base.url"),
    BROWSER_NAME("browser.name"),
    USER_NAME("user.name"),
    USER_PASSWORD("user.password");
    private String propertyName;

    private ApplicationProperties(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String toString() {
        return propertyName;
    }
}
