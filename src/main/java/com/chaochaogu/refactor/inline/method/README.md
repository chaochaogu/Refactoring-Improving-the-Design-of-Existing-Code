#将函数内联化
一个函数，其本体（method body）应该与其名称（method name)同样清楚易懂。
在函数调用点插入函数本体，然后移除该函数。
```
int getRating() {
     return (moreThanFiveLateDeliveries()) ? 2 : 1;
 }
 boolean moreThanFiveLateDeliveries() {
     return _numberOfLateDeliveries > 5;
 }
 
=>

 int getRating() {
     return (_numberOfLateDeliveries > 5) ? 2 : 1;
 }
```