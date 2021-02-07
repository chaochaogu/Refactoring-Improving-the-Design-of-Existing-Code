#分解条件式
你有一个复杂的条件（if-then-else）语句。
从if、then、else 三个段落中分别提炼出独立函数。
```angular2html
if (date.before (SUMMER_START) || date.after(SUMMER_END))
         charge = quantity * _winterRate + _winterServiceCharge;
     else charge = quantity * _summerRate;
```
==>
```angular2html
if (notSummer(date))
         charge = winterCharge(quantity);
     else charge = summerCharge (quantity);
```