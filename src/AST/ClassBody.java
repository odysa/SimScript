package AST;

import evaluator.Environment;

import java.util.List;

public class ClassBody extends ASTList {
    public ClassBody(List list) {
        super(list);
    }

    public Object eval(Environment env) {
        for (ASTNode node : nodes) {
            node.eval(env);
        }
        return null;
    }
}
