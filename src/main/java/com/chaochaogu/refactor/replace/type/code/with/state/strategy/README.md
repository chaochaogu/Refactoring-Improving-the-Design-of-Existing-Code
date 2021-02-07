#以State/Strategy取代型别码
你有一个type code ，它会影响class 的行为，但你无法使用subclassing。
以state object （专门用来描述状态的对象）取代type code 。
![以State/Strategy取代型别码](https://img.imgdb.cn/item/601cbf2a3ffa7d37b3c6adc5.jpg)
````$xslt
class Employee {
   private int _type;
   static final int ENGINEER = 0;
   static final int SALESMAN = 1;
   static final int MANAGER = 2;
   Employee (int type) {
       _type = type;
   }
````
==>
```angular2html
int payAmount() {
       switch (_type) {
           case ENGINEER:
              return _monthlySalary;
           case SALESMAN:
              return _monthlySalary + _commission;
           case MANAGER:
              return _monthlySalary + _bonus;
           default:
              throw new RuntimeException("Incorrect Employee");
       }
   }
```
==>
```angular2html
Employee (int type) {
       setType (type);
   }
   int getType() {
       return _type;
   }
   void setType(int arg) {
       _type = arg;
   }
   int payAmount() {
       switch (getType()) {
           case ENGINEER:
              return _monthlySalary;
           case SALESMAN:
              return _monthlySalary + _commission;
           case MANAGER:
              return _monthlySalary + _bonus;
           default:
              throw new RuntimeException("Incorrect Employee");
       }
   }
```
==>
```angular2html
abstract class EmployeeType {
   abstract int getTypeCode();
 }
```
==>
```angular2html
class Engineer extends EmployeeType {
   int getTypeCode () {
       return Employee.ENGINEER;
   }
 }
class Manager extends EmployeeType {
   int getTypeCode () {
       return Employee.MANAGER;
   }
 }
class Salesman extends EmployeeType {
   int getTypeCode () {
       return Employee.SALESMAN;
   }
 }
```
==>
```angular2html
Employee (int type) {
       setType (type);
   }
   int getType() {
       return _type;
   }
   void setType(int arg) {
       _type = arg;
   }
   int payAmount() {
       switch (getType()) {
           case ENGINEER:
              return _monthlySalary;
           case SALESMAN:
              return _monthlySalary + _commission;
           case MANAGER:
              return _monthlySalary + _bonus;
           default:
              throw new RuntimeException("Incorrect Employee");
       }
   }
```
==>
```angular2html
class Employee...
   void setType(int arg) {
       _type = EmployeeType.newType(arg);
   }
class EmployeeType...
   static EmployeeType newType(int code) {
       switch (code) {
           case ENGINEER:
              return new Engineer();
           case SALESMAN:
              return new Salesman();
           case MANAGER:
              return new Manager();
           default:
              throw new IllegalArgumentException("Incorrect Employee Code");
       }
   }
   static final int ENGINEER = 0;
   static final int SALESMAN = 1;
   static final int MANAGER = 2;
```
==>
```angular2html
class Employee...
   int payAmount() {
       switch (getType()) {
           case EmployeeType.ENGINEER:
              return _monthlySalary;
           case EmployeeType.SALESMAN:
              return _monthlySalary + _commission;
           case EmployeeType.MANAGER:
              return _monthlySalary + _bonus;
           default:
              throw new RuntimeException("Incorrect Employee");
       }
   }
```