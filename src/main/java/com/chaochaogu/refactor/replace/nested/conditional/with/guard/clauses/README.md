#以卫语句取代嵌套条件式
函数中的条件逻辑（conditional logic）使人难以看清正常的执行路径。
使用卫语句（guard clauses）表现所有特殊情况。
```angular2html
double getPayAmount() {
   double result;
   if (_isDead) result = deadAmount();
   else {
       if (_isSeparated) result = separatedAmount();
       else {
           if (_isRetired) result = retiredAmount();
           else result = normalPayAmount();
       };
   }
 return result;
 };
```
==>
```angular2html
double getPayAmount() {
   if (_isDead) return deadAmount();
   if (_isSeparated) return separatedAmount();
   if (_isRetired) return retiredAmount();
   return normalPayAmount();
 };
```