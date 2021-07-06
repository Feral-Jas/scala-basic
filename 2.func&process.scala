//if 在scala中是有返回值的，函数式语言的一大特性就是表达式，表达式的特性是会有一个值
//所有像java中的三元运算符都可以使用if来解决
//因为else语句的缺失，Scala编译器就按最大化类型来推导，而Any类型是Scala中的根类型
//()在Scala中是Unit类型的实例，可以看做是Java中的Void
val res = if(true) "things are true" else "things are false"
println(res)
val first = if(false)"bad res"
println(first)

//scala 中的while没啥可说的

while(first =="bad res"){
    println("lets go")
}

//scala for 功能很强大
val list = List(1,2,3,4,5)
for(item<-list){
    println(item)
}
//yield关键字将集合映射成另一个集合
val listPlus = for(item<-list)yield item +1;
println(listPlus)
//还可以在表达式中做判断
for(item<-listPlus if item==4){
    println(item)
}
//还可以将二维数组摊平
//第一个l是便利元素，第二个item是操作对象
//yield意为产生、产出，从本意理解即可，能在一步做完是因为其返回值的设计
val flatList = List(List(1,2,3),List(3,2,5),List(8,4,1))
val modTwoList = 
    for{ 
        l <- flatList
        item <- l if item%2==0
    }yield item
//但是注意，yield也只能产出原始元素而不能创造新的元素（如果使用此类for用法）
val extendList = 
    for {
        list <-flatList
        item <- list
    }yield item
println(modTwoList)
println(extendList)

//注意到scala中没有fori的语法，但是可以通过Range的概念来完成，这个range的括号可写可不写
//0 until x = int i=0;i<x;i++   until是到不了
//0 to x = int i=0;i<=x;i++     to是能到
for(i<- 0 until 10)
    print(i +" ")

println

for(i<- 0 to 10)
    print(" "+i)

//控制步长用by
for(i<- 2 to 20 by 3)
    println(" "+i)
for(i<- 2 until 30 by 2)
    println(" "+i)

//match case 比命令式语言中的switch更好
//match case不需要类似switch的break来告知终止，他是默认break的，一个匹配就会终止其他的比较
def level(s:Int) = s match{
    case n if n>90 => "A"
    case n if n>80 => "B"
    case n if n>70 => "C"
    case n if n>60 => "D"
}
println(level(88))
