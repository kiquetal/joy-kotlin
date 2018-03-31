import chapter2.FunList.Cons
import chapter2.FunList.Nil
object chapter2
{

     @JvmStatic
     fun main(args:Array<String>):Unit {




         val funList= inListOf(1,2,3,4,5)
        println("La lista es $funList")
        funList.forEach { println(it*2) }
     }

    fun inListOf(vararg numbers:Int):FunList<Int>{
        return if (numbers.isEmpty()){
            Nil
        }
        else {
            Cons(numbers.first(), inListOf(* numbers.drop(1).toIntArray()))
        }
    }


    sealed class FunList<out T> {

        object Nil: FunList<Nothing>()
        data class Cons<out T>(val head:T,val tail:FunList<T>):FunList<T>()

        fun forEach(f:(T)->Unit) {
            tailrec fun go(list:FunList<T>,f:(T)->Unit)
            {
                when (list)
                {
                    is Nil -> Unit
                    is Cons-> {
                        f(list.head)
                        go(list.tail, f)
                    }
                }
            }
            go(this,f)
        }

    }

    open class Parent { fun alto():String="hola"}
    class MyClass:Parent()
    {
        open fun bajo():String= "bajo"
    }
    interface Bag<T> {
        fun get():T
        fun use(t:T):Boolean
    }
    class BagImpl:Bag<Parent> {
        override fun get(): Parent =Parent()

        override fun use(t: Parent): Boolean =true
    }
    fun useBag(bag:Bag<in MyClass>):Boolean
    {
        bag.get()
        return true
    }
    val bag3=useBag(BagImpl())


}





