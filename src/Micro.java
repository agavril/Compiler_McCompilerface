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
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		prsr.ac.print();
		System.out.println(";RET");
		TinyList newTinyList = new TinyList();
		ListIterator<ACNode> liAC = prsr.ac.listIterator();
		while(liAC.hasNext()){
			newTinyList.addAll(liAC.next().ACToTiny());
		} 
		newTinyList.print();
		System.out.println("sys halt");
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
	public HashMap<Symbol, Integer> register_list = new HashMap<Symbol, Integer>();

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

	public Symbol find(String name) {
		for (Symbol sym : symbol_list) {
			if (name.equals(sym.id)) {
				return(sym);
			}
		}
		if (root == null) {
			return null;
		}
		else {
			return root.find(name);
		}
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

	public void add_register(String name, int register) {
		register_list.put(find(name), new Integer(register));
	}

	public int find_register(String name) {
		Symbol sym = find(name);
		Integer val = (register_list.get(sym));
		if (val == null) {
			return 0;
		}
		else {
			return 1;
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


class ACList extends LinkedList{
    public ACList(){};
    
    public void print(){    //Go through every node and run its print
	System.out.println(";IRCode");
      	ListIterator<ACNode> li = this.listIterator();
	while(li.hasNext()){
	    li.next().print();
	}
    }
}

class ACNode{
    public String opname;
    public String op1;
    public String op2;
    public String dest;	
    public ACNode(String opname, String op1, String op2, String dest){
	    this.opname = opname;
		this.op1 = op1;
		this.op2 = op2;
		this.dest = dest;
	}
    
    public TinyList ACToTiny(){		//Converts an ACNode to a list of TinyNodes
	TinyList newList = new TinyList();
	String tinyOp1 = varToReg(op1);
	String tinyOp2 = varToReg(op2);
	String tinyDest = varToReg(dest);
	//System.out.println(op1 + " " + tinyOp1 + " | " + op2 + " " + tinyOp2 + " | " + dest + " " + tinyDest);
	switch(opname){
	case("var"):
	    newList.addLast(new TinyNode("var", tinyDest, null));
	    break;
	case("ADDI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("addi", tinyOp2, tinyDest));
	    break;
	case("SUBI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("subi", tinyOp2, tinyDest));
	    break;
	case("MULI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("muli", tinyOp2, tinyDest));
	    break;
	case("DIVI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("divi", tinyOp2, tinyDest));
	    break;
	case("ADDF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("addr", tinyOp2, tinyDest));
	    break;
	case("SUBF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("subr", tinyOp2, tinyDest));
	    break;
	case("MULF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("mulr", tinyOp2, tinyDest));
	    break;
	case("DIVF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    newList.addLast(new TinyNode("divr", tinyOp2, tinyDest));
	    break;
	case("STOREI"): case("STOREF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	    break;
	case("READI"):
	    newList.addLast(new TinyNode("sys readi", tinyDest, null));
	    break;
	case("READF"):
	    newList.addLast(new TinyNode("sys readr", tinyDest, null));
	    break;
	case("WRITEI"):
	    newList.addLast(new TinyNode("sys writei", tinyDest, null));
	    break;
	case("WRITEF"):
	    newList.addLast(new TinyNode("sys writer", tinyDest, null));
	    break;
	case("WRITES"):
	    newList.addLast(new TinyNode("sys writef", tinyDest, null));
	    break;
	default:
	    System.out.println("Not a valid IR");
	    newList = null;
	    break;
	}		
	return newList;
    }
    
    public String varToReg(String var){      //Convert the variable number to a register number
	if(var == null){return null;}
	String result;
	if(var.startsWith("!")){
	    result = "r" + var.substring(2,var.length());
	    return result;
	}
	else{return var;}
    }
    
    public void print(){
	String output;
	if(op2 == null && dest == null){
		output = ";" + opname + " " + op1;
	}
	else if(op1 == null && dest == null) {
		output = ";" + opname + " " + op2;
	}
	else if(op1 == null && op2 == null && dest != null) {
		output = ";" + opname + " " + dest;
	}
	else if(op2 == null){
		output = ";" + opname + " " + op1 + " " + dest;
	}
	else{
		output = ";" + opname + " " + op1 + " " + op2 + " "  + dest;
	}
	System.out.println(output);
    }
}

class TinyList extends LinkedList{
    public TinyList(){};
    
    public void print(){       //Go through every node and run its print
	ListIterator<TinyNode> li = this.listIterator();
	while(li.hasNext()){
	    li.next().print();
	}
    }
}

class TinyNode{
    public String opname;
    public String op1;
    public String op2;  
    public TinyNode(String opname, String op1, String op2){
	this.opname = opname;
	this.op1 = op1;
	this.op2 = op2;
    }

    public String extractNum (String reg) {
	if (reg.charAt(0) == '!') {
	    return "r" + reg.replace("!T", "");
	}
	else {
	    return reg;
	}
    }
    
    public void print(){
	String output;
	if(op2 == null){output = opname + " " + extractNum(op1);}
	else{output = opname + " " + extractNum(op1) + " " + extractNum(op2);}
	System.out.println(output);
    }
}

class ASTNode {
	String val;
	ASTNode left;
	ASTNode right;

	public ASTNode(String val, ASTNode left, ASTNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public ASTNode(String val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public void print() {
	    String s = val;
	    if (left != null) {
		s = s + " " + left.val;
	    }
	    if (right != null) {
		s = s + " " + right.val;
	    }
	    System.out.println(s);
	}
}

class AbstractSyntaxTree{
	ASTNode root;
	Stack<ASTNode> operators;
	Stack<ASTNode> expressions;
	ACList ac;
	Symbol ps; // parsed symbol
	int tmp_cnt;
	String type;
	Table table;
	
	public AbstractSyntaxTree(Symbol ps, int ASTreg, Table table) {
		this.ps = ps;
		//System.out.println((ps == null));
		operators = new Stack<ASTNode>();
		expressions = new Stack<ASTNode>();
		ac = new ACList();
		root = null;
		tmp_cnt = ASTreg;
		if (ps.type.equals("FLOAT")){
			this.type = "F";
		}
		else {
			this.type = "I";
		}
		this.table = table;
	}
	
	public void addOperand(String op) {
		ASTNode n = new ASTNode(op);
		expressions.push(n);
	}

	public void addOperator(String op) {
		if (!operators.isEmpty()) {
			while ((!operators.isEmpty()) && (getPemdas(op) <= getPemdas(operators.peek().val))) {
				restack();
			}
		}
		ASTNode n = new ASTNode(op);
		operators.push(n);
	}

	public void restack() {
		String op = operators.pop().val;
		ASTNode right = expressions.pop();
		ASTNode left = expressions.pop();
		ASTNode n = new ASTNode(op, left, right);
		expressions.push(n);
	}

	public void par_start() {
		operators.push(new ASTNode("pstart"));
	}
    
	public void par_end() {
		while (!operators.isEmpty() && !operators.peek().val.equals("pstart")) {
			restack();
		}
		operators.pop();
	}

	public void expr_end() {
		while(!operators.isEmpty()){
			restack();
		}
		if (!expressions.isEmpty()){
			root = expressions.pop();
		}
		post_traversal(root);
		ac.addLast(new ACNode("STORE"+type, root.val, null, ps.id));
		table.add_register(ps.id, tmp_cnt);
	}

	public int getPemdas(String op) {
		int retval = 0;
		if (op.equals("pstart")) {
			retval = 0;
		}
		else if (op.equals("+") || op.equals("-")) {
			retval = 1;
		}
		else if (op.equals("*") || op.equals("/")) {
			retval = 2;
		}
		return retval;
	}
 
	public void post_traversal (ASTNode n) {
		ACNode acnode;
		if (n.left != null) {
			post_traversal(n.left);
		}
		if (n.right != null) {
			post_traversal(n.right);
		}

		if (n.val.equals("+")) {
			tmp_cnt = tmp_cnt + 1;
			acnode = new ACNode("ADD"+type, n.left.val, n.right.val, "!T" + tmp_cnt);
		}
		else if (n.val.equals("-")) {
			tmp_cnt = tmp_cnt + 1;
			acnode = new ACNode("SUB"+type, n.left.val, n.right.val, "!T" + tmp_cnt);
		}
		else if (n.val.equals("*")) {
			tmp_cnt = tmp_cnt + 1;
			acnode = new ACNode("MUL"+type, n.left.val, n.right.val, "!T" + tmp_cnt);
		}
		else if (n.val.equals("/")) {
			tmp_cnt = tmp_cnt + 1;
			acnode = new ACNode("DIV"+type, n.left.val, n.right.val, "!T" + tmp_cnt);
		}
		else {
			if (table.find(n.val) != null) {
				if (table.find_register(n.val) == 1) {
					acnode = null;
				}
				else {
					tmp_cnt = tmp_cnt + 1;
					table.add_register(n.val, tmp_cnt);
					acnode = new ACNode("STORE"+type, n.val, null, "!T" + tmp_cnt);
				}
			}
			else {
				acnode = new ACNode("STORE"+type, n.val, null, "!T" + (++tmp_cnt));
			}
		}

		if (acnode != null) {
			ac.addLast(acnode);
			n.left = null;
			n.right = null;
			n.val = "!T" + tmp_cnt;
		}
	}
}

