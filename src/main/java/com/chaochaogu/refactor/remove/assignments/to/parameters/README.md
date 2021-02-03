#移除对参数的赋值动作
你的代码对一个参数进行赋值动作。
以一个临时变量取代该参数的位置。
```$xslt
int discount (int inputVal, int quantity, int yearToDate) {
       if (inputVal > 50) inputVal -= 2;
=>

   int discount (int inputVal, int quantity, int yearToDate) {
       int result = inputVal;
       if (inputVal > 50) result -= 2;
```
##Java只有值传递，不存在引用传递。
当一个对象实例作为一个参数被传递到方法中时，参数的值就是该对象引用的一个副本。
指向同一个对象,对象的内容可以在被调用的方法中改变，但对象的引用(不是引用的副本)是永远不会改变的。