import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class step1 {
	public static void main(String[] args) throws Exception {
		ANTLRFileStream stream = new ANTLRFileStream("sqrt.micro");
		step1Lexer lex = new step1Lexer(stream);
		Token t = lex.nextToken();
		while(t.getType() != Token.EOF) {
			if (t.getType() == step1Lexer.KEYWORD) {
				System.out.print("KEYWORD");
			}
			else if (t.getType() == step1Lexer.IDENTIFIER) {
				System.out.print("IDENTIFIER");
			}
			else if (t.getType() == step1Lexer.INTLITERAL) {
				System.out.print("INTLITERAL");
			}
			else if (t.getType() == step1Lexer.FLOATLITERAL) {
				System.out.print("FLOATLITERAL");
			}
			else if (t.getType() == step1Lexer.OPERATOR) {
				System.out.print("OPERATOR");
			}
			else if (t.getType() == step1Lexer.STRINGLITERAL) {
				System.out.print("STRINGLITERAL");
			}
			
			System.out.println(" (Value = \"" + t.getText() + "\")");
			t = lex.nextToken();
		}
	}
}