package AST;

import parser.Token;

import java.util.ArrayList;
import java.util.Iterator;


public class ASTLeaf extends ASTNode {
    private Token token;

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
