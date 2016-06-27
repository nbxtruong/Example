

/**
 * @author nhphung

 */
package exp

import java.io.{PrintWriter,File}
import java.lang.RuntimeException
import java.util.concurrent.{Executors,TimeUnit,TimeoutException}
import org.antlr.v4.runtime.ANTLRFileStream
import exp.parser._
import exp.astgen._
import exp.visitor._

trait Timed {
  def timeoutAfter(timeout: Long)(codeToTest: => Unit): Unit = {
    val executor = Executors.newSingleThreadExecutor
    val future = executor.submit(new Runnable {
      def run = codeToTest
    })

    try {
      future.get(timeout, TimeUnit.MILLISECONDS)
    }
    finally {
      executor.shutdown()
    }
  }
}

object Main extends  Timed {
  
  val sepa = "/" // dung cho linux
  
  val test1 = "testlexer"
  val test2 = "testparser"
  val test3 = "testvisitor1"
  val test4 = "testvisitor2"
  val test5 = "testast"
  
  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      val option = args(0).drop(1)
      
      
      
      val startlexer = 1
      val endlexer = 3
      val indirlexer = "lexertestcases"
      val outdirlexer = "lexersolutions"
      
      val startparser = 1
      val endparser = 3
      val indirparser = "recogtestcases"
      val outdirparser = "recogsolutions"
      
      val startvisitor1 = 1
      val endvisitor1 = 1
      val indirvisitor1 = "visitor1testcases"
      val outdirvisitor1 = "visitor1solutions"
      
      val startvisitor2 = 1
      val endvisitor2 = 1
      val indirvisitor2 = "visitor1testcases"
      val outdirvisitor2 = "visitor1solutions"
       
      val startast = 1
      val endast = 1
      val indirast = "asttestcases"
      val outdirast = "astsolutions"
      
      option match {
        
        case u if u == test1 => runTest(option,startlexer,endlexer,indirlexer,outdirlexer)
        case v if v == test2 => {
            runTest("testlexer",startlexer,endlexer,indirlexer,outdirlexer)
            runTest(option,startparser,endparser,indirparser,outdirparser)
        }
        case t if t == test3 => runTest(option,startvisitor1,endvisitor1,indirvisitor1,outdirvisitor1)
        case t if t == test4 => runTest(option,startvisitor2,endvisitor2,indirvisitor2,outdirvisitor2)
        case t if t == test5 => runTest(option, startast, endast, indirast, outdirast)
        case _ => throw new ClassCastException
      }
    }
    else  println("Usage: scala Main -option ")
  }
  
  def runTest(opt:String,start:Int,end:Int,indir:String,outdir:String) = {
    
    for (i <- start to end) {
      
      println("Test "+i)
      
      
      val source = new ANTLRFileStream(s"$indir$sepa$i.txt")
      val dest = new PrintWriter(new File(s"$outdir$sepa$i.txt"))
      
      try 
      {
        timeoutAfter(1000)  
        {
            opt match {
              case u if u == test1 => TestLexer.test(i,source,dest) 
              case v if v == test2 => TestParser.test(source,dest) 
              case t if t == test4 => IdentifierCount.test(source,dest)
              case t if t == test3 => ExpCount.test(source,dest)
              case t if t == test5 => TestAst.test(source, dest)
              case _ => throw new ClassCastException
          }
        }
      } 
      catch 
      {
        case te: TimeoutException => dest.println("Test runs timeout")
        case re: RuntimeException => dest.println(re.getMessage())
        //case e : Exception => dest.println(e)
      } 
      finally 
      {
        //source.close()
        dest.close()

      }
    }
  } 
}
