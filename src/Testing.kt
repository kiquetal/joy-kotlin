data class Holder(val name:String="",val age:Int=0)


object toTest
{
    @JvmStatic
    fun  main(args:Array<String>) {

        val l=listOf(Holder("juan",12),Holder("pedro",12),Holder("julian",14))
        println(l.groupBy { it.age }
                .values
                .map { it.reduce { acc, holder ->  Holder(holder.name + acc.name,holder.age+acc.age)  } })
     }
}