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

        val l=listOf(Holder("juan",12),Holder("pedro",12),Holder("julian",14))
        println(l.groupBy { it.age }
                .values
                .map { it.reduce (Holder::combine ) })
     }
}