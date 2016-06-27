package exp.utils

import com.sun.xml.internal.bind.v2.model.core.ID

/**
 * @author nhphung
 */
trait Visitor {
  def visit(ast: AST, c: Any): Any = ast.accept(this, c)
  def visitProg(ast: Prog, c: Any): Any
  def visitBinExp(ast: BinExp, c: Any): Any
  def visitId(ast: Id, c: Any): Any
  def visitNum(ast: Num, c: Any): Any
  def visitFloat(ast: FloatLit, c: Any): Any
  def visitIfStm(ast: IfStm, c: Any): Any
  def visitAssign(ast: Assign, c: Any): Any
}

class BaseVisitor extends Visitor {
  def visitProg(ast: Prog, c: Any): Any = null
  def visitBinExp(ast: BinExp, c: Any): Any = null
  def visitId(ast: Id, c: Any): Any = null
  def visitNum(ast: Num, c: Any): Any = null
  def visitFloat(ast: FloatLit, c: Any): Any = null
  def visitIfStm(ast: IfStm, c: Any): Any = null
  def visitAssign(ast: Assign, c: Any): Any = null
}

class TypeCheck extends BaseVisitor {
  override def visitFloat(ast: FloatLit, c: Any) = FloatType
  override def visitNum(ast: Num, c: Any) = IntType
  override def visitBinExp(ast: BinExp, c: Any) {
    val leftType = visit(ast.left, c)
    if (leftType == visit(ast.right, c)) {
      leftType
    } else {
      throw Missmath
    }
  }
}