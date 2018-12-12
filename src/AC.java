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
    
    public void swap(int i, String op) {
	ACNode n = (ACNode) super.remove(i);
	n.dest = op;
	add(i, n);
    }

    public ACList closeMain(){
	ACList newList = new ACList();
	newList.addLast(new ACNode("PUSH", null, null, null));
	newList.addAll(pushRegisters());
	newList.addLast(new ACNode("JSR", null, null, "main"));
	newList.addLast(new ACNode("HALT", null, null, "sys halt"));
	return newList;
    }

    public ACList openFunction(String func){
	ACList newList = new ACList();
	newList.addAll(pushRegisters());
	newList.addLast(new ACNode("JSR", null, null, func));
	newList.addAll(popRegisters());
	return newList;
    }

    public ACList pushRegisters(){
	ACList newList = new ACList();
	for(int i = 0; i < 4; i++){
	    newList.addLast(new ACNode("PUSH", "r"+i, null, null));
	}
	return newList;
    }
    public ACList popRegisters(){
	ACList newList = new ACList();
	for(int i = 0; i < 4; i++){
	    newList.addFirst(new ACNode("POP", "r"+i, null, null));
	}
	return newList;
    }


    public ACNode last() {
	return (ACNode) super.getLast();
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
    
    public TinyList ACToTiny(){		//Converts an ACNode to a list of TinyNodes
	TinyList newList = new TinyList();
	String tinyOp1 = varToReg(op1);
	String tinyOp2 = varToReg(op2);
	String tinyDest = varToReg(dest);
	if(opname.endsWith("I")){      //Integer operations
	    switch(opname){
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
	    case("STOREI"):
		newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
		break;
	    case("READI"):
		newList.addLast(new TinyNode("sys readi", tinyDest, null));
		break;
	    case("WRITEI"):
		newList.addLast(new TinyNode("sys writei", tinyDest, null));
		break;
	    case("GTI"):       //If greater than jump
		newList.addLast(new TinyNode("cmpi", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jgt", tinyDest, null));
		break;
	    case("GEI"):       //If greater than or equal to jump
		newList.addLast(new TinyNode("cmpi", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jge" , tinyDest, null));
		break;
	    case("LTI"):       //If less than jump
		newList.addLast(new TinyNode("cmpi", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jlt", tinyDest, null));
		break;
	    case("LEI"):       //If less than or equal to jump
		newList.addLast(new TinyNode("cmpi", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jle", tinyDest, null));
		break;
	    case("NEI"):       //If not equal jump
		newList.addLast(new TinyNode("cmpi", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jne", tinyDest, null));
		break;
	    case("EQI"):       //If equal jump
		newList.addLast(new TinyNode("cmpi", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jeq", tinyDest, null));
		break;
	    default:
		System.out.println("Not a valid IR");
		newList = null;
		break;
	    }
	}else if(opname.endsWith("F")){      //Float operations
	    switch(opname){
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
	    case("STOREF"):
		newList.addLast(new TinyNode("move", tinyOp1, tinyDest));
		break;
	    case("READF"):
		newList.addLast(new TinyNode("sys readr", tinyDest, null));
		break;
	    case("WRITEF"):
		newList.addLast(new TinyNode("sys writer", tinyDest, null));
		break;
	    case("GTF"):       //If greater than jump
		newList.addLast(new TinyNode("cmpr", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jgt", tinyDest, null));
		break;
	    case("GEF"):       //If greater than or equal to jump
		newList.addLast(new TinyNode("cmpr", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jge" , tinyDest, null));
		break;
	    case("LTF"):       //If less than jump
		newList.addLast(new TinyNode("cmpr", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jlt", tinyDest, null));
		break;
	    case("LEF"):       //If less than or equal to jump
		newList.addLast(new TinyNode("cmpr", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jle", tinyDest, null));
		break;
	    case("NEF"):       //If not equal jump
		newList.addLast(new TinyNode("cmpr", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jne", tinyDest, null));
		break;
	    case("EQF"):       //If equal jump
		newList.addLast(new TinyNode("cmpr", tinyOp1, tinyOp2));
		newList.addLast(new TinyNode("jeq", tinyDest, null));
		break;
	    default:
		System.out.println("Not a valid IR");
		newList = null;
		break;
	    }
	}else{             //Other operations
	    switch(opname){
	    case("var"):
		newList.addLast(new TinyNode("var", tinyDest, null));
		break;
	    case("str"):
		newList.addLast(new TinyNode("str", tinyDest, tinyOp1));
		break;
	    case("WRITES"):
		newList.addLast(new TinyNode("sys writes", tinyDest, null));
		break;
	    case("JUMP"):
		newList.addLast(new TinyNode("jmp", tinyDest, null));
		break;
	    case("LABEL"):
		newList.addLast(new TinyNode("label", tinyDest, null));
		break;
	    case("PUSH"):
		newList.addLast(new TinyNode("push", tinyOp1, null));
		break;
	    case("POP"):
		newList.addLast(new TinyNode("pop", tinyOp1, null));
		break;
	    case("LINK"):
		newList.addLast(new TinyNode("link", tinyDest, null));
		break;
	    case("UNLINK"):
		newList.addLast(new TinyNode("unlnk", tinyDest, null));
		break;
	    case("JSR"):
		newList.addLast(new TinyNode("jsr", tinyDest, null));
		break;
	    case("HALT"):
		newList.addLast(new TinyNode("sys halt", null, null));
		break;
	    default:
		System.out.print(opname);
		System.out.println("Not a valid IR");
		newList = null;
		break;
	    }
	}		
	return newList;
    }

}