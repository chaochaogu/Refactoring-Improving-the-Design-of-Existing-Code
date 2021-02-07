#以值域取代子类
你的各个subclasses 的惟一差别只在「返回常量数据」的函数身上。
修改这些函数，使它们返回superclass 中的某个（新增）值域，然后销毁subclasses 。
![以值域取代子类](https://img.imgdb.cn/item/601cdf613ffa7d37b3d30659.jpg)
```angular2html
abstract class Person {
   abstract boolean isMale();
   abstract char getCode();
 ...
 class Male extends Person {
   boolean isMale() {
       return true;
   }
   char getCode() {
       return 'M';
   }
 }
 class Female extends Person {
   boolean isMale() {
       return false;
   }
   char getCode() {
       return 'F';
   }
 }
```
==>
```angular2html
class Person...
   static Person createMale(){
       return new Male();
   }
   static Person createFemale() {
       return new Female();
   }
```
==>
```angular2html
Person kent = new Male();
```
==>
```angular2html
Person kent = Person.createMale();
```
==>
```angular2html
class Person...
   private final boolean _isMale;
   private final char _code;
```
==>
```angular2html
class Person...
   protected Person (boolean isMale, char code) {
       _isMale = isMale;
       _code = code;
   }
```
==>
```angular2html
class Male...
   Male() {
       super (true, 'M');
   }
 class Female...
   Female() {
       super (false, 'F');
   }
```
==>
```angular2html
class Person...
   boolean isMale() {
       return _isMale;
   }
 class Male...
   boolean isMale() {
       return true;
   }
```
==>
```angular2html
class Person
   static Person createMale(){
       return new Person(true, 'M');
   }
```