import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Compiler {
	public static void main(String[] args) throws Exception {
		ANTLRFileStream stream = new ANTLRFileStream(args[0]);
		step2Lexer lex = new step2Lexer(stream);
		CommonTokenStream ts = new CommonTokenStream(lex);
		step2Parser prsr = new step2Parser(ts);
		ANTLRErrorStrategy err = new step2ErrorStrategy();
		prsr.setErrorHandler(err);
  
		try {
			prsr.program();
			System.out.println("Accepted");
		} catch (Exception e) {
			System.out.println("Not Accepted");
		}
	}
}


class CompilerErrorStrategy extends DefaultErrorStrategy{
	public CompilerErrorStrategy(){
	}

	@Override
	public void reportError(Parser recognizer, RecognitionException e){
		throw e;
	}
}
