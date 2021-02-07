#合并重复的条件片段
在条件式的每个分支上有着相同的一段代码。
将这段重复代码搬移到条件式之外。
```angular2html
if (isSpecialDeal()) {
         total = price * 0.95;
         send();
     }
     else {
         total = price * 0.98;
         send();
     }
```
==>
```angular2html
if (isSpecialDeal())
         total = price * 0.95;
     else
         total = price * 0.98;
     send();
```