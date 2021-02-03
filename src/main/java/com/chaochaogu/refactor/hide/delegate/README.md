#隐藏委托关系
客户直接调用其server object（服务对象）的delegate class。
在server端（某个class〕建立客户所需的所有函数，用以隐藏委托关系（delegation）。
![隐藏委托关系](https://img.imgdb.cn/item/601a4c033ffa7d37b3d9ca83.jpg)
```$xslt
class Person {
   Department _department;
   public Department getDepartment() {
       return _department;
   }
   public void setDepartment(Department arg) {
       _department = arg;
   }
 }
 class Department {
   private String _chargeCode;
   private Person _manager;
   public Department (Person manager) {
       _manager = manager;
   }
   public Person getManager() {
       return _manager;
   }
 ...
```
==>
```$xslt
manager = john.getDepartment().getManager();
```
==>
```$xslt
public Person getManager() {
       return _department.getManager();
   }
```
==>
```$xslt
manager = john.getManager();
```