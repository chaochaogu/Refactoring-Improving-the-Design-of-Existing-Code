#剖解临时变量
你的程序有某个临时变量被赋值超过一次，它既不是循环变量，也不是一个集用临时变量（collecting temporary variable）。
针对每次赋值，创造一个独立的、对应的临时变量。
```$xslt
double temp = 2 * (_height + _width);
    System.out.println (temp);
    temp = _height * _width;
    System.out.println (temp);
=>

    final double perimeter = 2 * (_height + _width);
    System.out.println (perimeter);
    final double area = _height * _width;
    System.out.println (area);
```