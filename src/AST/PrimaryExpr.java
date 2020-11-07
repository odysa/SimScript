package AST;
import java.util.List;

public class PrimaryExpr extends ASTList {
    public PrimaryExpr(List<ASTNode> c) { super(c); }
    public static ASTNode create(List<ASTNode> c) {
        return c.size() == 1 ? c.get(0) : new PrimaryExpr(c);
    }
}