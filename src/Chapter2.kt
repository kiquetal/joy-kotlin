
object chapter2
{

     @JvmStatic
     fun main(args:Array<String>):Unit {


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





