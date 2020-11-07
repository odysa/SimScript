package AST;

import java.util.List;

public class BinaryExpr extends ASTList {
    public BinaryExpr(List list) {
        super(list);
    }

    public ASTNode left() {
        return child(0);
    }

    public String operator() {
        return ((ASTLeaf) child(1)).token().getText();
    }

    public ASTNode right() {
        return child(2);
    }
}
