package AST;

import evaluator.Environment;

import java.util.List;

public abstract class Postfix extends ASTList{
    public Postfix(List<ASTNode> c) { super(c); }
    public abstract Object eval(Environment env, Object value);
}
