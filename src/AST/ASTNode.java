package AST;

import evaluator.Environment;
import parser.Token;

import java.util.Iterator;

public abstract class ASTNode implements Iterable<ASTNode> {

    public abstract ASTNode child(int i);

    public abstract int numChildren();

    public abstract String location();

    public abstract Iterator<ASTNode> children();
    public abstract Object eval(Environment env);
    public Iterator<ASTNode> iterator() {
        return children();
    }

}
