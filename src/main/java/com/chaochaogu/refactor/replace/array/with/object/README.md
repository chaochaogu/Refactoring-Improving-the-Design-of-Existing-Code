#以对象取代数组
你有一个数组（array），其中的元素各自代表不同的东西。
以对象替换数组。对于数组中的每个元素，以一个值域表示之。
```$xslt
String[] row = new String[3];
  row [0] = "Liverpool";
  row [1] = "15";
```
==>
```$xslt
Performance row = new Performance();
  row.setName("Liverpool");
  row.setWins("15");
```