package evaluator;

public class StoneObject {
    public static class AccessException extends Exception {
    }

    protected Environment env;

    public StoneObject(Environment e) {
        env = e;
    }

    @Override
    public String toString() {
        return "<object:" + hashCode() + ">";
    }

    public Object read(String member) throws AccessException {
        return getEnv(member).get(member);
    }

    public void write(String member, Object value) throws AccessException {
        getEnv(member).add(member, value);
    }

    protected Environment getEnv(String member) throws AccessException {
        Environment e = ((NestedEnv) env).where(member);
        if (e != null && e == env)
            return e;
        else
            throw new AccessException();
    }
}