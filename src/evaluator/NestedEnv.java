package evaluator;

import java.util.HashMap;

public class NestedEnv implements Environment {
    private HashMap<String, Object> env;
    private Environment outer;

    public NestedEnv() {
        this(null);
    }

    public NestedEnv(Environment e) {
        env = new HashMap<String, Object>();
        outer = e;
    }

    public void setOuter(Environment e) {
        outer = e;
    }

    private void addNew(String name, Object value) {
        env.put(name, value);
    }

    @Override
    public void add(String name, Object value) {
        Environment place = where(name);
        if (place == null) place = this;
        ((NestedEnv) place).addNew(name, value);
    }

    private Environment where(String name) {
        if (env.get(name) != null) {
            return this;
        }
        if (outer!=null && outer.get(name) != null) {
            return outer;
        }
        return null;
    }

    @Override
    public Object get(String name) {
        Object v = env.get(name);
        if (v == null && outer != null) {
            return outer.get(name);
        }
        return v;
    }
}
