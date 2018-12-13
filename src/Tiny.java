import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.util.*;

public class Tiny {}

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
