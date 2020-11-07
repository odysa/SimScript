package AST;

import evaluator.Environment;
import parser.StoneException;
import parser.Token;

import java.util.ArrayList;
import java.util.Iterator;


public class ASTLeaf extends ASTNode {
    protected Token token;

    public ASTLeaf(Token token) {
        this.token = token;
    }

    public Token token() {
        return token;
    }

    @Override
    public String toString() {
        return token.getText();
    }

    @Override
    public Object eval(Environment env) {
        throw new StoneException("cannot eval: " + toString(), this);
    }


    @Override
    public ASTNode child(int i) {
        return null;
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public String location() {
        return "at line" + token.getLineNumber();
    }

    @Override
    public Iterator<ASTNode> children() {
        return new ArrayList<ASTNode>().iterator();
    }
}
