data class Holder(val name:String="",val age:Int=0){

    fun combine(acc: Holder): Holder =
            if (age == acc.age)
                Holder(acc.name + "-" +name ,age+acc.age)
            else
                throw IllegalStateException("Age don't match.")



}


object toTest
{ 
    @JvmStatic
    fun  main(args:Array<String>) {

    /*    val l=listOf(Holder("juan",12),Holder("pedro",12),Holder("julian",14))
        println(l.groupBy { it.age }
                .values
                .map { it.reduce (Holder::combine ) })


        val def= sumFactors();

*/
        useMachine(5,object :Machine<Int>{
            override fun process(t: Int) {
                println(t)

                            }
        })
        match("ast",{ d-> println("quien soy $d")})
     }



    private val cache=mapOf<Int,Int>()
    private fun isFactor(num:Int, potencial:Int) = num % potencial ==0
    private fun factorsOf(num:Int)=(1..num).filter { isFactor(num,it) }

    fun sumFactors():(Int)->Int = { num:Int ->

        val sum = cache.getOrElse(num, { factorsOf(num).reduce { acc, i -> acc + i } })
        println("Factors of $sum")
         sum


    }

}


//For annotations MD1
// Out is for Producers (read only)
interface TypeVariant<out T>
{
    fun  next():T
}
fun test(dam:TypeVariant<String>) {

    val t:TypeVariant<Any> = dam

}
interface ContraVariant<in T>
{

    fun add(t: T): Unit
}
fun test2(d1:ContraVariant<Double>,m1:ContraVariant<Any>)
{
 d1.add(8.6)


    val m:ContraVariant<Double> = m1

}
open class Parent

class Child:Parent()

class CoParent<out T>
{
    fun dame(): T? {
        val m: T?=null
        return m
    }
}

fun esto(t1:CoParent<Child>):Unit {
    val t:CoParent<Parent> =t1
}




interface Machine<T> {
    fun process(product: T)}
fun <T> useMachine(t: T, machine: Machine<T>) {
        machine.process(t)}
class PrintMachine<T> : Machine<T> {
    override fun process(t: T) {
        println(t)
    }}

typealias dank<T> = (T)->Unit
fun <T> match(t:T,d:dank<T>) {
    d(t)
}