package AST;

import evaluator.Environment;
import evaluator.Function;

import java.util.List;

public class Fun extends ASTList {

    public Fun(List list) {
        super(list);
    }

    public ParameterList parameters() {
        return (ParameterList) child(0);
    }

    public BlockStmnt body() {
        return (BlockStmnt) child(1);
    }

    public Object eval(Environment env) {
        return new Function(parameters(), body(), env);
    }

    @Override
    public String toString() {
        return "(func" + parameters() + body() + ")";
    }
}
