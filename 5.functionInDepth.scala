import java.nio.file.{Files, Paths}
import java.time.LocalDateTime
import java.util.Date
import scala.annotation.tailrec
//scala中函数是一等公民,函数可以赋值给一个变量，可以作为一个函数的参数被传入，甚至可以作为函数的返回值返回
//使用def定义一个函数方法
//Unit等于java中的void

//下划线的意思是将一个线程的函数或者方法复制给一个变量
//此时calcVar也具备calc的能力
def func(a:String,b:String): String ={
  a+b
}
val funcVar = func _

//或者直接在变量声明时就定义好它是一个函数类型的变量，类型是 input.type=>output.type 实际参数是a 与 a+"xx"
val funcDirect : (String,String)=>String = (a,b)=>a+b

println(funcVar("input","a"))
println(funcDirect("input","a"))

//**实战** 实现java中的try with close，资源回收
//[T<:AutoCloseable,R]意思是入参泛型数组，<符号规定T类型是AutoClosable类型或其子类
// 第一个参数名为res，第二个参数名为func，是一个函数类型变量
def using[T<:AutoCloseable,R](res:T)(func:T=>R):R={
  try{
    func(res)
  }finally {
    if(res!=null)
      res.close()
  }
}
//实现AutoCloseable接口的一般是资源类，形如T=>R的函数是我们的处理函数
//处理逻辑被传给using函数代执行
val allLine = using(Files.newBufferedReader(Paths.get("/etc/hosts"))) { reader =>
  @tailrec
  def readAll(buffer: StringBuilder, line: String): String = {
    if (line == null) buffer.toString
    else {
      buffer.append(line).append('\n')
      readAll(buffer, reader.readLine())
    }
  }
  readAll(new StringBuilder(), reader.readLine())
}
println(allLine)

//match case's greatness
//同时完成校验变量类型并完成类型转换
for{
  x<- Seq(321,"x",new Date(),LocalDateTime.now())
}{
  x match {
    case number:Int=>println(s"is number:$number")
    case str:String=>println(s"is string:$str")
    case date: Date=>println(s"is date:$date")
    case localDateTime: LocalDateTime=>println(s"is localdatetime:$localDateTime")
  }
}
