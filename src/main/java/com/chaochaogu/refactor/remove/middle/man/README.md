#移除中间人
某个class做了过多的简单委托动作（simple delegation）。
让客户直接调用delegate（受托类）。
![移除中间人](https://img.imgdb.cn/item/601a4de33ffa7d37b3da941c.jpg)
```$xslt
class Person...
   Department _department;        
   public Person getManager() {
       return _department.getManager();
 class Department...
   private Person _manager;
   public Department (Person manager) {
       _manager = manager;
   }
```
==>
```$xslt
manager = john.getManager();
```
==>
```$xslt
class Person...
   public Department getDepartment() {
       return _department;
   }
```
==>
```$xslt
manager = john.getDepartment().getManager();
```