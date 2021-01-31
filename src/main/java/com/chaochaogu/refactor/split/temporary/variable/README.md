#剖解临时变量
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