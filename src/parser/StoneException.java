package parser;

import AST.ASTNode;

public class StoneException extends RuntimeException {
    public StoneException(String m) { super(m); }
    public StoneException(String m, ASTNode t) {
        super(m + " " + t.location());
    }

}
