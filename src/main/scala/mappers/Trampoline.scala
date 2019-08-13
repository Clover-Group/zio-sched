package Trampoline

sealed abstract class Bounce[A]
final case class Done[A](res: A)                 extends Bounce[A]
final case class Call[A](thunk: () => Bounce[A]) extends Bounce[A]

final object ops {

  def trampoline[A](bounce: Bounce[A]): A = bounce match {
    case Call(thunk) => trampoline(thunk())
    case Done(x)     => x
  }

}
