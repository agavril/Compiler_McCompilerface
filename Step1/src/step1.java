import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class step1 {
	public static void main(String[] args) throws Exception {
		ANTLRFileStream stream = new ANTLRFileStream(args[0]);
		step1Lexer lex = new step1Lexer(stream);
		Token t = lex.nextToken();
		while(t.getType() != Token.EOF) {
			if (t.getType() == step1Lexer.KEYWORD) {
				System.out.println("Token Type: KEYWORD");
			}
			else if (t.getType() == step1Lexer.IDENTIFIER) {
				System.out.println("Token Type: IDENTIFIER");
			}
			else if (t.getType() == step1Lexer.INTLITERAL) {
				System.out.println("Token Type: INTLITERAL");
			}
			else if (t.getType() == step1Lexer.FLOATLITERAL) {
				System.out.println("Token Type: FLOATLITERAL");
			}
			else if (t.getType() == step1Lexer.OPERATOR) {
				System.out.println("Token Type: OPERATOR");
			}
			else if (t.getType() == step1Lexer.STRINGLITERAL) {
				System.out.println("Token Type: STRINGLITERAL");
			}
			
			System.out.println("Value: " + t.getText());
			t = lex.nextToken();
		}
	}
}
