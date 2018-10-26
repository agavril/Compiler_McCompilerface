import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;
import java.util.*;

public class AST {}

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
