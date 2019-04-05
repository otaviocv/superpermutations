package experiments
import basics.Basics._


object Simple extends App {
  println("""
This a simple script to demonstrate what superpermutations are and how we are
going to use the basic tools. This is also an exercise to learn how scala
manages packages, files and modules. 

Let's begin!
    """
    )
  val someSet:Set[String] = dummyNthSet(3)
  val somePerms:Set[String] = permutations(someSet)
  println("Given a set of symbols:")
  println(someSet.mkString(" "))

  println("We can construct their permutations:")
  println(somePerms.mkString(" "))

  println("""
We can then look for the append distances i.e. the ammount of characteres we
have to append to the permutation i to get to the permutation j. Look below to
some examples.
    """)
  somePerms.map(x => {
    somePerms.map(y => {
      println("(" + x + ", " + y + "): " + appendDistance(x, y).toString)
    })
  })

  println("""
We can note that the append distance for the pairs which the source and target
permutations are the same are 0! This makes sense since we don't have to make
any modifications to get the same string.

Now we are insterested in the problem of finding the minimal superpermutations.
To get that correct we must check every order of elements present in the
permutations set, this is taking all permutations of the permutations set.

But this gives us a complexity of O(N!!) to explore all the space and find all
possible solutions. So to do this we will take some more inteligent approaches.
    """
   )
}
