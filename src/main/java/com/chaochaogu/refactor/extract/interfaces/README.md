#提炼接口
若干客户使用class接口中的同一子集；或者，两个classes的接口有部分相同。
将相同的子集提炼到一个独立接口中。
![提炼接口](https://img.imgdb.cn/item/6020ce5c3ffa7d37b37e7d2e.jpg)
```angular2html
double charge(Employee emp, int days) {
       int base =  emp.getRate() * days;
       if (emp.hasSpecialSkill())
           return base * 1.05;
       else return base;
   }
```
==>
```angular2html
interface Billable {
   public int getRate();
   public boolean hasSpecialSkill();
 }
```
==>
```angular2html
 class Employee implements Billable ...
```
==>
```angular2html
double charge(Billable emp, int days) {
       int base =  emp.getRate() * days;
       if (emp.hasSpecialSkill())
           return base * 1.05;
       else return base;
   }
```