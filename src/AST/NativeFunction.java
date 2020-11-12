package AST;

import parser.StoneException;

import java.lang.reflect.Method;

public class NativeFunction {
    private Method method;
    private int numOfParameters;
    private String name;

    public NativeFunction(String name, Method method) {
        this.name = name;
        this.method = method;
        this.numOfParameters = method.getParameterCount();
    }

    public int numOfParameters() {
        return numOfParameters;
    }

    public Object invoke(Object[] args, ASTNode tree) {
        try {
            return method.invoke(null, args);
        } catch (Exception e) {
            throw new StoneException("invalid native function at ", tree);
        }
    }

    @Override
    public String toString() {
        return "(NativeFunc" + hashCode() + ")";
    }

}
