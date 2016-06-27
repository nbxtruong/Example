

/**
 * @author nhphung
 */
package exp.parser
import org.antlr.v4.runtime.Token
import java.io.{PrintWriter,File}
import org.antlr.v4.runtime.ANTLRFileStream
import scala.collection.JavaConverters._

object TestLexer extends ProcessError {
  
  def main(args:Array[String]):Unit = {
      val file = if (args.length > 0) args(0) else "test.txt";
      val infile = new ANTLRFileStream(file)
      val out = if (args.length > 1) args(1) else "output.txt" 
      val outFile = new PrintWriter(new File(out));
      test(0,infile,outFile)
      outFile.close()
  }
  type Lexer = ExpLexer
  def test(i:Int,infile:ANTLRFileStream,outfile:PrintWriter) = {
      val lexer = new Lexer(infile);
      
      try {
        
        printLexeme(lexer,outfile)
      }
      catch {
        case et:ErrorToken => outfile.println("ErrorToken "+et.s)
        
      }

  }
  
  def printAtt(lexer:Lexer,dev:PrintWriter,prn:Token=>String):Unit = {
      
        val tok = lexer.nextToken()
      if (tok.getType() != Token.EOF) {
        dev.println(prn(tok))
        printAtt(lexer,dev,prn)
      } else dev.print(prn(tok))
    
    
  }
  
  
  def printLexeme(lexer:Lexer,dev:PrintWriter) = printAtt(lexer,dev,_.getText())
  
  def printToken(lexer:Lexer,dev:PrintWriter) = printAtt(lexer,dev,x => lexer.getVocabulary.getSymbolicName(x.getType()))
  
  def printAll(lexer:Lexer,dev:PrintWriter) = printAtt(lexer,dev,x => x.getText() +"\t"+ lexer.getVocabulary.getSymbolicName(x.getType()))
  

}