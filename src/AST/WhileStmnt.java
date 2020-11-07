package AST;

import evaluator.Environment;

import java.util.List;

public class WhileStmnt extends ASTList {
    public WhileStmnt(List list) {
        super(list);
    }

    public ASTNode condition() {
        return child(0);
    }

    public ASTNode block() {
        return child(1);
    }

    @Override
    public String toString() {
        return "(while " + condition() + " " + block() + ")";
    }

    @Override
    public Object eval(Environment env) {
        Object result = 0;
        while (true) {
            Object c = condition().eval(env);
            if (!((Boolean) c))
                return result;
            else result = block().eval(env);
        }
    }
}
