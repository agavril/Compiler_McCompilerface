import org.antlr.v4.runtime.*;

public class Symbol{
	String name;
	String type;
	String value;
}
	
public class Semantics{
	public String scope;
	ArrayList<Symbol> symbols = new ArrayList<Symbol>();
}