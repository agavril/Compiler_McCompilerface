import java.util.*;
import java.lang.*;

class func {
  public ArrayList<Symbol> input_syms;
  public ArrayList<Symbol> local_syms;
  public int regs;
  public int inputs;
  public int locals;
  public int retval;

  public func () {
    input_syms = new ArrayList<Symbol>();
    local_syms = new ArrayList<Symbol>();
    regs = 0;
    inputs = 0;
  }

  public void addParam(String label, String type) {
    inputs++;
    input_syms.add(new Symbol(label, type, ""));
    retval = inputs + 6;
  }

  public void assign_values() {
    short i;
    for (i = 0; i < inputs; i++) {
      input_syms.get(i).value = "!" + (5+inputs-i);
    }
  }

  public void addVar(Symbol sym) {
    locals++;
    sym.value = "$-" + (locals);
    local_syms.add(sym);
  }

  public String returnReg() {
    return "$" + retval;
  }

  public Symbol findInput(String name) {
    for (Symbol sym : input_syms) {
      if (name.equals(sym.id)) {
	return sym;
      }
    }
    return null;
  }

  public Symbol findVar(String name) {
    for (Symbol sym : local_syms) {
      if (name.equals(sym.id)) {
	return sym;
      }
    }
    return null;
  }
}