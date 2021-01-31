#将函数内联化
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