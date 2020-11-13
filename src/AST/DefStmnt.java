package AST;

import evaluator.Environment;
import evaluator.Function;

import java.util.List;

public class DefStmnt extends ASTList {

    public DefStmnt(List list) {
        super(list);
    }

    public String name() {
        return ((ASTLeaf) child(0)).token().getText();
    }

    public ParameterList parameters() {
        return (ParameterList) child(1);
    }

    public BlockStmnt body() {
        return (BlockStmnt) child(2);
    }

    public String toString() {
        return "(def " + name() + " " + parameters() + " " + body() + ")";
    }

    public Object eval(Environment env) {
        env.add(name(), new Function(parameters(), body(), env));
        return name();
    }
}
