package exp.astgen

/**
 * @author nhphung
 */
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import java.io.{PrintWriter,File}
import org.antlr.v4.runtime.ANTLRFileStream
import exp.utils._
import exp.parser._
import scala.collection.JavaConverters._
import org.antlr.v4.runtime.tree._

object TestAst {
  def main(args:Array[String]):Unit = {
      val file = if (args.length > 0) args(0) else "test.txt";
      val infile = new ANTLRFileStream(file)
      val out = if (args.length > 1) args(1) else "output.txt" 
      val outFile = new PrintWriter(new File(out));
      test(infile,outFile)
      outFile.close()
  }
  def test(infile:ANTLRFileStream,outfile:PrintWriter) = {
      val lexer = new ExpLexer(infile);  
      val tokens = new CommonTokenStream(lexer);
      val parser = new ExpParser(tokens);
      val progtree = parser.exp()// muon test cho nao trong g4 thi de cho do
      val astbuild = new ASTGeneration()
      val ast = astbuild.visit(progtree)
      val astTypeCheck=new TypeCheck()
      val ast2=astTypeCheck.visit(ast.asInstanceOf[Exp], null)
      outfile.println(ast)
  }
}