package ru.training.at.hw5.context;

import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public final class TestContext {

    public static final String WEB_DRIVER = "driver";

    private static TestContext instance;
    private Map<String, Object> context = new HashMap<>();

    public void setTestObject(String key, Object ob) {
        context.put(key, ob);
    }

    public void cleanContext() {
        context.clear();
    }

    public <T> T getTestObject(String key) {
        return (T) context.get(key);
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
