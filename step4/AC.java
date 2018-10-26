import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.util.*;

public class AC {}

class ACList extends LinkedList{
    public ACList(){};
    
    public void print(){    //Go through every node and run its print
	System.out.println(";IRCode");
	System.out.println(";LABEL FUNC_main");
	System.out.println(";LINK");
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
	case("str"):
	    newList.addLast(new TinyNode("str", tinyDest, tinyOp1));
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
	    newList.addLast(new TinyNode("sys writes", tinyDest, null));
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
	if(opname.equals("var") | opname.equals("str")){return;};
	
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
