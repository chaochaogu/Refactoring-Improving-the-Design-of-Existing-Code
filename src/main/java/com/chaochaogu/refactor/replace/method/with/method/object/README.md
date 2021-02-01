#以函数对象取代函数
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







































