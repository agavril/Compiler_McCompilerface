import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.util.*;

public class AC{
    
}

class ACList extends LinkedList{
    public ACList(){};
    
    public void print(){
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
	switch(opname){
	case("var"):
	    newList.addLast(new TinyNode("var", tinyDest, null));
	case("ADDI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("addi", tinyOp2, tinyDest));
	case("SUBI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("subi", tinyOp2, tinyDest));
	case("MULI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("muli", tinyOp2, tinyDest));
	case("DIVI"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("divi", tinyOp2, tinyDest));
	case("ADDF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("addr", tinyOp2, tinyDest));
	case("SUBF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("subr", tinyOp2, tinyDest));
	case("MULF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("mulr", tinyOp2, tinyDest));
	case("DIVF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyOp2));
	    newList.addLast(new TinyNode("divr", tinyOp2, tinyDest));
	case("STOREI"): case("STOREF"):
	    newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
	case("READI"):
	    newList.addLast(new TinyNode("sys readi", tinyDest, null));
	case("READF"):
	    newList.addLast(new TinyNode("sys readr", tinyDest, null));
	case("WRITEI"):
	    newList.addLast(new TinyNode("sys writei", tinyDest, null));
	case("WRITEF"):
	    newList.addLast(new TinyNode("sys writer", tinyDest, null));
	case("WRITES"):
	    newList.addLast(new TinyNode("sys writef", tinyDest, null));
	default:
	    System.out.println("Not a valid IR");
	    newList = null;
	}		
	return newList;
    }
    
    public String varToReg(String var){
	if(var == null){return null;}
	String result;
	if(var.startsWith("!")){
	    result = "r" + (Integer.parseInt(var.substring(1,var.length()-1))-1);
	    return result;
	}
	else{return var;}
    }
    
    public void print(){
	String output;
	if(op2 == null){output = ";" + opname + " " + op1 + " " + dest;}
	else{output = ";" + opname + " " + op1 + " " + op2 + " "  + dest;}
	System.out.println(output);
    }
}

class TinyList extends LinkedList{
    public TinyList(){};
    
    public void print(){
	System.out.println(";IR code");
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
    
    public void print(){
	String output;
	if(op2 == null){output = opname + " " + op1 + " " + op2;}
	else{output = opname + " " + op1 + " " + op2;}
	System.out.println(output);
    }
}
