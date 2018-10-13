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
	    // System.out.println("Accepted");
	} catch (Exception e) {
	    // System.out.println("Not Accepted");
	}

        ACList newACList = new ACList();
        newACList.addLast(new ACNode("STOREI", "20", null, "!T0"));
	newACList.addLast(new ACNode("MULI", "a", "b", "!T3"));
	newACList.addLast(new ACNode("WRITEI", "a", null, null));
	newACList.print();
	TinyList newTinyList = new TinyList();
	ListIterator<ACNode> liAC = newACList.listIterator();
	while(liAC.hasNext()){
	    newTinyList.addAll(liAC.next().ACToTiny());
	}
	newTinyList.print();
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
	    System.out.println("name " + this.id + " type " + this.type + " value " + this.value);
	}
	else {
	    System.out.println("name " + this.id + " type " + this.type);
	}
    }
}

class Table{
    String name; // name of scope
    int level; // block level
    Table root; // for 'END' statements
    private ArrayList<Symbol> symbol_list = new ArrayList<Symbol>();
    private ArrayList<Table> nested = new ArrayList<Table>(); // tables for all nested blocks
    private ArrayList<String> duplicates = new ArrayList<String>(); // records all duplicate declarations
    
    public Table(String name, Table root, int level) { // constructor
	this.name = name;
	this.level = level;
	this.root = root;
    }
    
    public void add(Symbol s){ // add symbol
	for (Symbol y : symbol_list){ // check if symbol already exists in this scope
	    if (s.id.equals(y.id)) {
		this.duplicates.add(s.id);
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
	if (!duplicates.isEmpty()) {doop_report.addAll(duplicates);} // add top level first
	for (Table t : nested) {
	    ArrayList<String> next_doop = t.getDoops(); //  add nested duplicates with recursion
	    if (!next_doop.isEmpty()) {doop_report.addAll(next_doop);}
	}
	return(doop_report);
    }
    
    public void print() {
	if (this.level == 0) { // print top level scopes (global, functions)
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
    
    public Tree() { // constructor
	this.global = new Table("GLOBAL", this.global, 0);
	this.scope = this.global;
    }
    
    public void down(String name, int level) { // add new scope as leaf 
	Table t = new Table(name, this.scope, level); // new scope, new table
	this.scope.add(t); // add new table to the current table
	this.scope = t; // move current scope
    }
    
    public void up() { // return to the previous scope
	this.scope = this.scope.root;
    }
    
    public void print() { // check for errors then print
	ArrayList<String> e = global.getDoops(); 
	if (e.isEmpty()) {
	    global.print();
	}
	else { // print the error message as instructed
	    System.out.println("DECLARATION ERROR " + e.get(0));
	}
    }
}
