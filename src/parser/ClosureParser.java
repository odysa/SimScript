package parser;

import AST.Fun;

public class ClosureParser extends FuncParser {
    public ClosureParser() {
        primary.insertChoice(Parser.rule(Fun.class).sep("fun").ast(paramList).ast(block));
    }
}
