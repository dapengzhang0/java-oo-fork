package javaoo.eclipse;

import java.io.PrintWriter;

import org.eclipse.jdt.core.compiler.batch.BatchCompiler;

public class AspectTest {
	public static void compile(String clas) throws Exception {
		compile(clas, "../examples/");
	}
	public static void compile(String clas, String dir) throws Exception {
		String file = dir + clas + ".java";
		System.out.print("Compiling " + file + ": ");
		boolean res = BatchCompiler.compile(file + " -source 1.7 -d bin", new PrintWriter(System.out), new PrintWriter(System.err), null);
		res &= (Boolean)Class.forName(clas).getDeclaredMethod("test").invoke(null);
		System.out.println(res ? "ok" : "fail");
	}
	public static void main(String[] args) throws Exception {
		compile("Math");
        compile("Cmp");
        compile("ListIndexGet");
        compile("ListIndexSet");
        compile("MapIndex");
        compile("CompAssBug", "test/");
    }
}