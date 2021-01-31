#将临时变量内联化
```$xslt
double basePrice = anOrder.basePrice();
    return (basePrice > 1000)
=>

return (anOrder.basePrice() > 1000)
```