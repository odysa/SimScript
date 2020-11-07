package AST;

import evaluator.Environment;
import parser.StoneException;

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

    @Override
    public Object eval(Environment env) {
        String op = operator();
        if ("=".equals(op)) {
            Object right = ((ASTNode) right()).eval(env);
            return computeAssign(env, right);
        }

        Object left = ((ASTNode) left()).eval(env);
        Object right = ((ASTNode) right()).eval(env);
        return computeOp(left, op, right);
    }

    protected Object computeAssign(Environment env, Object value) {
        ASTNode l = left();
        if (l instanceof Name) {
            env.add(((Name) l).name(), value);
            return value;
        } else {
            throw new StoneException("bad assignment", this);
        }
    }

    protected Object computeNumber(Integer left, String op, Integer right) {
        int a = left;
        int b = right;
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            case "%":
                return a % b;
            case "*":
                return a * b;
            case ">":
                return a > b;
            case "<":
                return a < b;
            case "==":
                return a == b;
            case "<=":
                return a <= b;
            case ">=":
                return a >= b;
            default:
                throw new StoneException("bad operator", this);
        }
    }

    protected Object computeOp(Object left, String op, Object right) {
        if (left instanceof Integer && right instanceof Integer) {
            return computeNumber((Integer) left, op, (Integer) right);
        }
        switch (op) {
            case "+":
                return String.valueOf(left) + String.valueOf(right);
            case "==":
                if (left == null) {
                    return right == null;
                } else {
                    return left.equals(right);
                }
            default:
                throw new StoneException("bad type", this);
        }
    }
}
