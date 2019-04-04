package example

object Hello extends App {

  val someSet:Set[String] = dummyNthSet(4)
  val somePerms:Set[String] = permutations(someSet)

  somePerms.map(x => {
    somePerms.map(y => {
      println("(" + x + ", " + y + "): " + appendDistance(x, y).toString)
    })
  })

  def appendDistance(u:String, v:String): Int = {
    def rAppend(u:String, v:String, acc:Int):Int = {
      if (u == v) acc
      else rAppend(u.tail, v.init, acc + 1)
    }
    rAppend(u, v, 0)
  }

  def superpermutationContraption(s:String): String = {
    def superpermutationContraptionTail(s:String, acc:String): String = {
      if (s.length == 0) acc
      else if (s.length == 1) acc + s
      else if (s.head != s.tail.head) superpermutationContraptionTail(s.tail, acc + s.head)
      else superpermutationContraptionTail(s.tail, acc)
    }
    superpermutationContraptionTail(s, "")
  }

  def bruteForceSuperPermutations(s:Set[String]): Set[String] = {
    permutations(permutations(s))
  }

  def isSuperpermutation(s:String, perms:Set[String]): Boolean = {
    if (perms.isEmpty) true
    else if (s contains perms.head) isSuperpermutation(s, perms - perms.head)
    else false
  }

  def dummyNthSet(n: Int): Set[String] = {
    val letters:String = "ABCDEFGHIJKLMONPQRSTUVXWYZ"
    def setfy(s:String, acc:Set[String]): Set[String] = {
      if (s == "") acc
      else setfy(s.tail, acc + s.head.toString)
    }
    setfy(letters.slice(0, n), Set())
  }

  def permutations(s:Set[String]): Set[String] = {
    if (s.size == 1) s
    else {
      s flatMap (x => {permutations(s-x) map (y => x + y) })
    }
  }

}
