//List为一个不可变列表集合，注意是不可变的
//::操作符作用就是将一个元素和列表链接起来并把元素放到列表的开头
val list1 = List(1,2,3,4,5);
val list2 = 1::2::3::4::5::Nil

//List头总是-1，scala中的第一个元素就是index为1的元素，这个与java不一样
println("head pointer: "+list1.indexOf(0))
println("indexOf: "+list1.indexOf(3));
0::list1;
println("unshift: "+list1.indexOf(1));
println("filter: "+list1.filter(item=>item<=3));
//反转操作的调用也要注意，scala的函数调用没有后面的括号
println(list1.reverse)
