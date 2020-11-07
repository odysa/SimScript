package AST;
import java.util.List;

public class NegativeExpr extends ASTList {
    public NegativeExpr(List<ASTNode> c) { super(c); }
    public ASTNode operand() { return child(0); }
    public String toString() {
        return "-" + operand();
    }
}