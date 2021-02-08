#构造函数本体上移
你在各个subclass中拥有一些构造函数，它们的本体（代码）几乎完全一致。
在superclass中新建一个构造函数，并在subclass的构造函数中调用它。
```angular2html
class Manager extends Employee...
   public Manager (String name, String id, int grade) {
       _name = name;
       _id = id;
       _grade = grade;
   }
```
==>
```angular2html
public Manager (String name, String id, int grade) {
       super (name, id);
       _grade = grade;
   }
```