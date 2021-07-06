//List为一个不可变列表集合，注意是不可变的
//::操作符作用就是将一个元素和列表链接起来并把元素放到列表的开头
val list1 = List(1,2,3,4,5);
val list2 = 3::4::5::6::Nil

//List头总是-1，scala中的第一个元素就是index为1的元素，这个与java不一样
println("head pointer: "+list1.indexOf(0))
println("indexOf: "+list1.indexOf(3));
0::list1;
println("unshift: "+list1.indexOf(1));
println("filter: "+list1.filter(item=>item<=3));
//反转操作的调用也要注意，scala的函数调用没有后面的括号
println(list1.reverse)
//List是不可变集合，所以一切操作都不是对原list操作
//intersect为取交集的操作
println(list1.intersect(list2))
//union为取并集的操作
println(list1.union(list2))
//diff为取左补集，从当前list中去除括号内list出现的对象
println(list1.diff(list2))
println(list2.diff(list1))

//Tuple元组最多支持22个元素，即Tuple0到Tuple22这样的类，用小括号来定义元组,用下划线来访问元素
val tuple3 = (1,2,3)
val tuple4 = ("a","b","c",2);
println(tuple3._3);
println(tuple4._4);

//Set是一个不重复无序集合,同样是immutable的
val set = Set(
    "jack","tom","jim"
)
val addedSet = set.+("tim")
println(addedSet);

//Map默认就是一个HashMap，特性与java版的HashMap基本一致，是immutable的
val map=Map(1->"a",2->"b",3->"C");
val changedMap = map.+(4->"kigt")
//观察一下任意集合的.+方法，实际上就是toString了
val word = map.+("kigt");
println(word);
println(changedMap);

//Map的entry其实是一个Tuple2，所以我们得知->是一种定义Tuple2的简洁方式
val tuples = 3->"e"
println(tuples._1)

//scala中也有mutable集合，除非性能极好否则不要使用（会和老集合共存）