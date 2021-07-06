/**
 * 定义一个class在scala中与java不同，scala默认类是public，且类属性与方法默认也是public的
 * scala没有java一样的构造方法所以属性变量都会在类创建后初始化
 * 定义的属性默认是private，加val或者var则会使其可见性变为public
 * @param name
 * @param age
 */
class Person(name:String,val age:Int){
  override def toString: String = s"name:$name,age:$age"
}
val James = new Person("James",24);
println(James.age)




trait Human
/**
 * case class的特性：
 * 1. 不需要new创建，直接类名（想一下List是不是）
 * 2. 默认变量都是public final，可制定var、private但是不推荐
 * 3. 自动实现equals hashcode toString函数
 * 4. 自动实现Serializable接口
 * 5. 可用于模式匹配match case中
 * 6. 自带一个copy方法，可以方便根据某个case class类实例来生成新的实例
 * @param name
 * @param age
 */
case class Man(name:String,age:Int)extends Human
case class Woman(name:String,age:Int)extends Human

val man1 = Man("Tim",44)
val woman1 = Woman("Lucy",23)
val man2 = man1.copy(age = 34)
//由于immutable的概念，copy方法提供了复制、修改的功能，而不必重新调用构造函数
println(man2)


//scala中没有static静态变量和静态作用域的概念，取而代之的是object
//除了实现static的功能，同时还是一个线程安全的单例类
class IntPair(val x:Int,val y:Int)
object IntPair{
  import math.Ordering
  implicit def ipord:Ordering[IntPair] = Ordering.by(ip=>(ip.x,ip.y))
}
