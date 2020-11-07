package AST;
import evaluator.Environment;

import java.util.List;

public class BlockStmnt extends ASTList {
    public BlockStmnt(List<ASTNode> c) { super(c); }
    @Override
    public Object eval(Environment env) {
        Object result = 0;
        for (ASTNode node : nodes) {
            if (!(node instanceof NullStmnt))
                result = ((ASTNode) node).eval(env);
        }
        return result;
    }
}
