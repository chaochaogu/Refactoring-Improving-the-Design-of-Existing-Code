#将临时变量内联化
你有一个临时变量，只被一个简单表达式赋值一次，而它妨碍了其他重构手法。
将所有对该变量的引用动作，替换为对它赋值的那个表达式本身。
```$xslt
double basePrice = anOrder.basePrice();
    return (basePrice > 1000)
=>

return (anOrder.basePrice() > 1000)
```