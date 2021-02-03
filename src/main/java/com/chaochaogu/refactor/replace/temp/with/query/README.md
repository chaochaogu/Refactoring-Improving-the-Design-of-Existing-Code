#以查询取代临时变量
你的程序以一个临时变量（temp）保存某一表达式的运算结果。
将这个表达式提炼到一个独立函数（译注：所谓查询式，query）中。
将这个临时变量的所有「被引用点」替换为「对新函数的调用」。
新函数可被其他函数使用。
```$xslt
double basePrice = _quantity * _itemPrice;
    if (basePrice > 1000)
        return basePrice * 0.95;
    else
        return basePrice * 0.98;
=>

    if (basePrice() > 1000)
        return basePrice() * 0.95;
    else
        return basePrice() * 0.98;
...
  double basePrice() {
      return _quantity * _itemPrice;
  }
```