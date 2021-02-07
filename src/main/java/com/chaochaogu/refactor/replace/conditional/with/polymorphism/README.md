#以多态取代条件式
你手上有个条件式，它根据对象型别的不同而选择不同的行为。
将这个条件式的每个分支放进一个subclass 内的覆写函数中，然后将原始函数声明为抽象函数（abstract method）。
![以多态取代条件式](https://img.imgdb.cn/item/601d02f13ffa7d37b3e3b4b2.jpg)
```angular2html
double getSpeed() {
      switch (_type) {
          case EUROPEAN:
             return getBaseSpeed();
          case AFRICAN:
             return getBaseSpeed() - getLoadFactor() * _numberOfCoconuts;
          case NORWEGIAN_BLUE:
             return (_isNailed) ? 0 : getBaseSpeed(_voltage);
      }
      throw new RuntimeException ("Should be unreachable");
  }
```