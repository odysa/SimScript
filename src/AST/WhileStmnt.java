package AST;

import java.util.List;

public class WhileStmnt extends ASTList {
    public WhileStmnt(List list) {
        super(list);
    }

    public ASTNode condition() {
        return child(0);
    }

    public ASTNode block() {
        return child(1);
    }

    @Override
    public String toString() {
        return "(while " + condition() + " " + block() + ")";
    }
}
