package AST;

import parser.Token;

import java.util.List;

public class IFStmnt extends ASTList {
    public IFStmnt(List list) {
        super(list);
    }

    public ASTNode condition() {
        return child(0);
    }

    public ASTNode thenBlock() {
        return child(1);
    }

    public ASTNode elseBlock() {
        return numChildren() > 2 ? child(2) : null;
    }

    @Override
    public String toString() {
        return "(if" + condition() + " " + thenBlock() + " else " + elseBlock() + ")";
    }
}
