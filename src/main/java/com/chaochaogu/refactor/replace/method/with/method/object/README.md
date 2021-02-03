#以函数对象取代函数
你有一个大型函数，其中对局部变量的使用，使你无法釆用 Extract Method。
将这个函数放进一个单独对象中，如此一来局部变量就成了对象内的值域（field）,
然后你可以在同一个对象中将这个大型函数分解为数个小型函数。
```$xslt
class Order...
   double price() {
   double primaryBasePrice;
       double secondaryBasePrice;
       double tertiaryBasePrice;
       // long computation;
       ...
   }
```
==>
![以函数对象取代函数](https://img.imgdb.cn/item/6017b5ef3ffa7d37b3cd4f39.gif)

##examples
```$xslt
Class Account
   int gamma (int inputVal, int quantity, int yearToDate) {
       int importantValue1 = (inputVal * quantity) + delta();
       int importantValue2 = (inputVal * yearToDate) + 100;
       if ((yearToDate - importantValue1) > 100)
           importantValue2 -= 20;
       int importantValue3 = importantValue2 * 7;
       // and so on.
       return importantValue3 - 2 * importantValue1;
   }
```
==>
```$xslt
class Gamma...
   private final Account _account;
   private int inputVal;
   private int quantity;
   private int yearToDate;
   private int importantValue1;
   private int importantValue2;
   private int importantValue3;
```
==>
```$xslt
Gamma (Account source, int inputValArg, int quantityArg, int yearToDateArg) {
       _account = source;
       inputVal = inputValArg;
       quantity = quantityArg;
       yearToDate = yearToDateArg;
   }
```
==>
```$xslt
int compute () {
       importantValue1 = (inputVal * quantity) + _account.delta();
       importantValue2 = (inputVal * yearToDate) + 100;
       if ((yearToDate - importantValue1) > 100)
           importantValue2 -= 20;
       int importantValue3 = importantValue2 * 7;
       // and so on.
       return importantValue3 - 2 * importantValue1;
   }
```
==>
```$xslt
int gamma (int inputVal, int quantity, int yearToDate) {
       return new Gamma(this, inputVal, quantity, yearToDate).compute();
   }
```
==>
```$xslt
int compute () {
      importantValue1 = (inputVal * quantity) + _account.delta();
      importantValue2 = (inputVal * yearToDate) + 100;
      importantThing();
      int importantValue3 = importantValue2 * 7;
      // and so on.
      return importantValue3 - 2 * importantValue1;
  }
  void importantThing() {
      if ((yearToDate - importantValue1) > 100)
           importantValue2 -= 20;
  }
```