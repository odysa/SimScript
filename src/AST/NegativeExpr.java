package AST;

import evaluator.Environment;
import parser.StoneException;

import java.util.List;

public class NegativeExpr extends ASTList {
    public NegativeExpr(List<ASTNode> c) {
        super(c);
    }

    public ASTNode operand() {
        return child(0);
    }

    public String toString() {
        return "-" + operand();
    }

    @Override
    public Object eval(Environment env) {
        Object v = operand().eval(env);
        if (v instanceof Integer)
            return -((Integer) v).intValue();
        else
            throw new StoneException("bad type for -", this);
    }
}