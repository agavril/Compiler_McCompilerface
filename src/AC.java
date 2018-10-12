import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.util.*;

public class AC{
	
}

class ACNode{
	public String opname;
	public String src1;
	public String src2;
	public String dest;	
	public ACNode(String opname, String src1, String src2, String dest){
		this.opname = opname;
		this.src1 = src1;
		this.src2 = src2;
		this.dest = dest;
	}
	
	public String ACToTiny(){
		String tinySrc1 = varToReg(src1);
		String tinySrc2 = varToReg(src2);
		String tinyDest = varToReg(dest);
		switch(opname){
			case("ADDI"):
			
			case("SUBI"):
			
			case("MULI"):
		
			case("DIVI"):
			
			case("ADDF"):
			
			case("SUBF"):
			
			case("MULF"):
			
			case("DIVF"):
			
			case("STOREI"):
			
			case("STOREF"):
			
			case("READI"):
			
			case("READF"):
			
			case("WRITEI"):
			
			case("WRITEF"):
			
			case("WRITES"):
		
		}
		ADDI  OP1 OP2 RESULT (Integer add; RESULT = OP1 + OP2)
		SUBI  OP1 OP2 RESULT (Integer sub; RESULT = OP1 - OP2)
		MULI  OP1 OP2 RESULT (Integer mul; RESULT = OP1 * OP2)
		DIVI  OP1 OP2 RESULT (Integer div; RESULT = OP1 / OP2)

		ADDF  OP1 OP2 RESULT (Floating point add; RESULT = OP1 + OP2)
		SUBF  OP1 OP2 RESULT (Floating point sub; RESULT = OP1 - OP2)
		MULF  OP1 OP2 RESULT (Floating point mul; RESULT = OP1 * OP2)
		DIVF  OP1 OP2 RESULT (Floating point div; RESULT = OP1 / OP2)

		STOREI OP1 RESULT (Integer store; store OP1 in RESULT)
		STOREF OP1 RESULT (Floating point store; store OP1 in RESULT)

		READI RESULT (Read integer from console; store in RESULT)
		READF RESULT (Read float from console; store in RESULT)

		WRITEI OP1 (Write integer OP1 to console)
		WRITEF OP1 (Write float OP1 to console)
		WRITES OP1 (Write string OP1 to console)		
		
		
		return null;
	}
	
	public String varToReg(String var){
		if(var == null){return null;}
		String result;
		if(var.startsWith("!")){
			result = "r" + Integer.parseInt(var.substring(1,var.length()-1));
			return result;
		}
		else{return var;}
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
}