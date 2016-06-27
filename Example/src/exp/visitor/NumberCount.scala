import exp.parser._
import scala.collection.JavaConverters._
import org.antlr.v4.runtime.CommonTokenStream
import java.io.{PrintWriter,File}
import org.antlr.v4.runtime.ANTLRFileStream

object NumberCount {
   
  def test(infile:ANTLRFileStream, outfile:PrintWriter) = {
      val lexer = new ExpLexer(infile);  
      val tokens = new CommonTokenStream(lexer);
      val parser = new ExpParser(tokens);
      val progtree = parser.exps()
      val astbuild = new NumberCount()
      val ast = astbuild.visit(progtree)
      outfile.println(ast)
  }
}
/**
 * @author nhphung
 */
class NumberCount extends ExpBaseVisitor[Int] {
  override def visitFactor(ctx:ExpParser.FactorContext) = if (ctx.ID()!=null) 1 else if (ctx.exp()!=null) visit(ctx.exp()) else 0
}