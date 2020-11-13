package evaluator;

import AST.ClassBody;
import AST.ClassStmnt;
import parser.StoneException;

public class ClassInfo {
    private Environment environment;
    private ClassStmnt definition;
    private ClassInfo superClass;

    public ClassInfo(ClassStmnt definition, Environment environment) {
        this.environment = environment;
        this.definition = definition;
        Object obj = definition.superClass();
        if (obj == null) this.superClass = null;
        else if (obj instanceof ClassInfo) this.superClass = (ClassInfo) obj;
        else throw new StoneException("unknown super class" + definition.superClass(), definition);
    }

    public ClassInfo superClass() {
        return superClass;
    }

    public ClassBody body() {
        return definition.body();
    }

    public Environment environment() {
        return environment;
    }
}
