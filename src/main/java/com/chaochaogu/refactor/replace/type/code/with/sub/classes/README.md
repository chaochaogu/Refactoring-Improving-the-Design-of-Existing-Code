#以子类取代型别码
你有一个不可变的（immutable）type code ，它会影响class 的行为。
以一个subclass 取代这个type code。
![以子类取代型别码](https://img.imgdb.cn/item/601bc7a13ffa7d37b36abadc.jpg)
```$xslt
class Employee...
   private int _type;
   static final int ENGINEER = 0;
   static final int SALESMAN = 1;
   static final int MANAGER = 2;
   Employee (int type) {
       _type = type;
   }
```
==>
```$xslt
int getType() {
       return _type;
   }
```
==>
```$xslt
static Employee create(int type) {
       return new Employee(type);
   }
   private Employee (int type) {
       _type = type;
   }
```
==>
```$xslt
class Engineer extends Employee {
   int getType() {
       return Employee.ENGINEER;
   }
 }
```
==>
```$xslt
class Employee
   static Employee create(int type) {
       if (type == ENGINEER) return new Engineer();
       else return new Employee(type);
   }
```
==>
```$xslt
abstract int getType();
   static Employee create(int type) {
       switch (type) {
           case ENGINEER:
              return new Engineer();
           case SALESMAN:
              return new Salesman();
           case MANAGER:
              return new Manager();
           default:
              throw new IllegalArgumentException("Incorrect type code value");
       }
   }
```