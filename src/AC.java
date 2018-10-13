import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.util.*;

public class AC{
	
}

class ACList extends LinkedList{
	public ACList(){}
	
	ListIterator<ACNode> li = this.listIterator();
	while(li.hasNext())
		li.next().print();
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
				TinyNode new1 = new TinyNode("var", tinyDest, null);
				newList.addLast(new1);
			case("ADDI"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("addi", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);				
			case("SUBI"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("subi", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);
			case("MULI"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("muli", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);
			case("DIVI"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("divi", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);
			case("ADDF"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("addr", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);
			case("SUBF"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("subr", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);
			case("MULF"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("mulr", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);
			case("DIVF"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyOp2);
				TinyNode new2 = new TinyNode("divr", tinyOp2, tinyDest);
				newList.addLast(new1);
				newList.addLast(new2);
			case("STOREI"): case("STOREF"):
				TinyNode new1 = new TinyNode("move", tinyOp1, tinyDest);
				newList.addLast(new1);
			case("READI"):
				TinyNode new1 = new TinyNode("sys readi", tinyDest, null);
				newList.addLast(new1);
			case("READF"):
				TinyNode new1 = new TinyNode("sys readr", tinyDest, null);
				newList.addLast(new1);
			case("WRITEI"):
				TinyNode new1 = new TinyNode("sys writei", tinyDest, null);
				newList.addLast(new1);
			case("WRITEF"):
				TinyNode new1 = new TinyNode("sys writer", tinyDest, null);
				newList.addLast(new1);
			case("WRITES"):
				TinyNode new1 = new TinyNode("sys writef", tinyDest, null);
				newList.addLast(new1);
			default:
				System.out.println("Not a valid IR");
				return null;
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
}

class TinyList extends LinkedList{
	public TinyList(){}
	
	public void print{
		System.out.println(";IR code");
		ListIterator<TinyNode> li = this.listIterator();
		while(li.hasNext())
			li.next().print();
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