#以查询取代临时变量
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