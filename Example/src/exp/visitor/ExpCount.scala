package exp.visitor


import scala.collection.JavaConverters._
import org.antlr.v4.runtime.CommonTokenStream
import java.io.{PrintWriter,File}
import org.antlr.v4.runtime.ANTLRFileStream


import exp.parser._
import exp.parser.ExpParser._

/**
 * @author nhphung
 */
object ExpCount {
  def test(infile:ANTLRFileStream, outfile:PrintWriter) = {
      val lexer = new ExpLexer(infile);  
      val tokens = new CommonTokenStream(lexer);
      val parser = new ExpParser(tokens);
      val progtree = parser.exps()
      val astbuild = new ExpCount()
      val ast = astbuild.visit(progtree)
      outfile.println(ast)
  }
}

class ExpCount extends ExpBaseVisitor[Int] {
  
  //override def visitExps(ctx:ExpsContext) = ctx.exp().size()
  
}