package exp.utils

/**
 * @author nhphung
 */
trait AST {
  def accept(v: Visitor, param: Any) = v.visit(this, param)
}
object IntType
object FloatType
object StringType
object Missmath extends Exception
case class Prog(explist: List[Stm]) extends AST {
  override def toString = "Program(" + explist.mkString("[", ",", "]") + ")"
  override def accept(v: Visitor, param: Any) = v.visitProg(this, param)
}
trait Exp extends AST
case class BinExp(operator: String, left: Exp, right: Exp) extends Exp {
  override def toString = "(" + left + operator + right + ")"
  override def accept(v: Visitor, param: Any) = v.visitBinExp(this, param)
}
case class Id(name: String) extends Exp {
  override def toString = name
  override def accept(v: Visitor, param: Any) = v.visitId(this, param)
}
case class Num(value: Int) extends Exp {
  override def toString = value.toString
  override def accept(v: Visitor, param: Any) = v.visitNum(this, param)
}
case class FloatLit(value: Float) extends Exp {
  override def toString = value.toString
  override def accept(v: Visitor, param: Any) = v.visitFloat(this, param)
}
trait Stm extends Exp
case class IfStm(e: Exp, s1: Stm, s2: Stm) extends Stm {
  override def toString = "IF " + e + "THEN" + s1 + "ELSE" + s2
  override def accept(v: Visitor, param: Any) = v.visitIfStm(this, param)
}
case class Assign(lhs: String, rhs: Exp) extends Stm {
  override def toString = "Assign" + lhs + " = " + rhs
  override def accept(v: Visitor, param: Any) = v.visitAssign(this, param)
}