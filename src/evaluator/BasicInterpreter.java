package evaluator;

import parser.*;
import AST.*;

public class BasicInterpreter {
    public static void main(String[] args) throws ParseException {
        run(new BasicParser(), new BasicEnv());
    }

    public static void run(BasicParser bp, Environment env)
            throws ParseException {
        Lexer lexer = new Lexer(new CodeDialog());
        while (lexer.peek(0) != Token.EOF) {
            ASTNode t = bp.parse(lexer);
            if (!(t instanceof NullStmnt)) {
                Object r =  t.eval(env);
                System.out.println("=> " + r);
            }
        }
    }
}