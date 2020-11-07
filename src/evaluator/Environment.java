package evaluator;

public interface Environment {
    void add(String name, Object value);

    Object get(String name);
}
