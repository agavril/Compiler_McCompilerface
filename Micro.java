import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.util.*;

public class Micro {
	public static void main(String[] args) throws Exception {
		ANTLRFileStream stream = new ANTLRFileStream(args[0]); // input file into ANTLRStream
		MicroLexer lex = new MicroLexer(stream); // construct lexer
		CommonTokenStream ts = new CommonTokenStream(lex); // construct token stream from lexer
		MicroParser prsr = new MicroParser(ts); // construct parser from token stream
		ANTLRErrorStrategy err = new MicroErrorStrategy(); // set error handler
		prsr.setErrorHandler(err);
  
		try { // attempt to compile
			prsr.program();
			System.out.println("Accepted");
		} catch (Exception e) {
			System.out.println("Not Accepted");
		}
	}
}


class MicroErrorStrategy extends DefaultErrorStrategy{
	public MicroErrorStrategy(){
	}

	@Override
	public void reportError(Parser recognizer, RecognitionException e){
		throw e;
	}
}

class Symbol{
	String id; // id of symbol
	String type; // data type
	String value; // value to be stored
	
	public Symbol(String id, String type, String val){ // constructor
		this.id = id;
		this.type = type;
		this.value = val;
	}

	public void print (){
		if (this.type == "STRING") {
			System.out.println("name " + this.id + " type " + this.type);
		}
		else {
			System.out.println("name " + this.id + " type " + this.type + " value \"" + this.value + "\"");
		}
	}
}

class Table{
	String name; // name of scope
	int level; // block level
	private ArrayList<Symbol> symbol_list = new ArrayList<Symbol>();
	private ArrayList<Table> nested = new ArrayList<Table>(); // tables for all nested blocks
	private ArrayList<Symbol> duplicates = new ArrayList<Symbol>(); // records all duplicate declarations

	public Table(String name, int level) { // constructor
		this.name = name;
		this.level = level;
	}

	public void add(Symbol s){ // add symbol
		for (Symbol y : symbol_list){ // check if symbol already exists in this scope
			if (s.name.equals(y.name) {
				this.duplicates.add(s);
				break; // break is necessary so each duplicate is only added once
			}
		}
		this.symbol_list.add(s); // go ahead and add everything to table, if there are duplicates, nothing will be printed
	}

	public void add(Table t) { // add nested table
		this.nested.add(t);
	}

	public ArrayList<String> getDoops() { // build list of all duplicates (to be called from global scope)
		ArrayList<String> doop_report = new ArrayList<String>();
		doop_report.addAll(duplicates); // add top level first
		for (Table t : nested) {
			ArrayList<String> next_doop = t.getDoops(); //  add nested duplicates with recursion
			doop_report.addAll(next_doop);
		}
		return(doop_report);
	}

	public void print() {
		if (this.level == 0 | this.level == 1) { // print top level scopes (global, functions)
			System.out.println("Symbol table " + this.name);
		}
		else { // print nested blocks as "BLOCK #"
			System.out.println("Symbol table BLOCK " + this.level);
		}
		for (Symbol s : this.symbol_list) {
			s.print(); // print each symbol in current scope
		}
		for (Table t : this.nested) {
			System.out.print("\n"); // new line for formatting
			t.print(); // recursively print each nested table
		}
	}
}

class Tree{
	Table global; // root of program, will always be global
	Table scope;  // current scope
	
	public Tree() {
		this.global = new Table("GLOBAL", 0);
		this.scope = this.global;
	}
	
	public leaf(String name, int level) { // add new scope as leaf 
		Table t = new Table(name, level);
		this.scope.add(t);
		this.scope = t;
	}

	
}