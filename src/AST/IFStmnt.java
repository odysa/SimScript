package AST;

import evaluator.Environment;

import java.util.List;

public class IFStmnt extends ASTList {
    public IFStmnt(List list) {
        super(list);
    }

    public ASTNode condition() {
        return child(0);
    }

    public ASTNode thenBlock() {
        return child(1);
    }

    public ASTNode elseBlock() {
        return numChildren() > 2 ? child(2) : null;
    }

    @Override
    public String toString() {
        return "(if" + condition() + " " + thenBlock() + " else " + elseBlock() + ")";
    }

    @Override
    public Object eval(Environment env) {
        Object c = (condition()).eval(env);
        if ((boolean) c) {
            return (thenBlock()).eval(env);
        }
        ASTNode b = elseBlock();
        if (b != null) {
            return (b).eval(env);
        }
        return 0;
    }
}
