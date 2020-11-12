package evaluator;

import java.util.HashMap;

public class BasicEnv implements Environment {
    private HashMap<String, Object> env;

    public BasicEnv() {
        env = new HashMap<String, Object>();
    }

    @Override
    public void add(String name, Object value) {
        env.put(name, value);
    }

    @Override
    public Object get(String name) {
        return env.get(name);
    }


    @Override
    public void setOuter(Environment e) {

    }
}
