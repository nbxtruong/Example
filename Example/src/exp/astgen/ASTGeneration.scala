package exp.astgen

import exp.parser._
import exp.utils._
import scala.collection.JavaConverters._
import org.antlr.v4.runtime.tree._

/**
 * @author nhphung
 */
class ASTGeneration extends ExpBaseVisitor[Any] {
  override def visitExps(ctx: ExpParser.ExpsContext) = Prog(ctx.stm().asScala.map(visit).toList.asInstanceOf[List[Stm]])
  override def visitExp(ctx: ExpParser.ExpContext) =
    if (ctx.exp() != null)
      BinExp(ctx.ADDOP().getText(), visit(ctx.exp()).asInstanceOf[Exp], visit(ctx.exp1()).asInstanceOf[Exp])
    else
      visit(ctx.exp1())
  override def visitExp1(ctx: ExpParser.Exp1Context) =
    if (ctx.exp1() != null)
      BinExp(ctx.MULOP().getText(), visit(ctx.exp1()).asInstanceOf[Exp], visit(ctx.factor()).asInstanceOf[Exp])
    else
      visit(ctx.factor())
  override def visitFactor(ctx: ExpParser.FactorContext) =
    if (ctx.ID() != null)
      Id(ctx.ID().getText)
    else if (ctx.INT() != null)
      Num(ctx.INT().getText.toInt)
    else if (ctx.exp() != null)
      visit(ctx.exp())
    else if (ctx.FLOAT() != null)
      FloatLit(ctx.FLOAT().getText.toFloat)
  override def visitStm(ctx: ExpParser.StmContext) =
    if (ctx.ID() != null)
      Assign(ctx.ID().toString(), visit(ctx.exp()).asInstanceOf[Exp])
    else
      IfStm(visit(ctx.exp()).asInstanceOf[Exp], visit(ctx.stm(0)).asInstanceOf[Stm], visit(ctx.stm(1)).asInstanceOf[Stm])
}