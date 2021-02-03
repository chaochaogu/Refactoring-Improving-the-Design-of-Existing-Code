#引入解释性变量
你有一个复杂的表达式。
将该表达式（或其中一部分）的结果放进一个临时变量，以此变量名称来解释表达式用途。
```$xslt
if ( (platform.toUpperCase().indexOf("MAC") > -1) &&
     (browser.toUpperCase().indexOf("IE") > -1) &&
      wasInitialized() && resize > 0 )
{
     // do something
}
=>

   final boolean isMacOs     = platform.toUpperCase().indexOf("MAC") > -1;
   final boolean isIEBrowser = browser.toUpperCase().indexOf("IE")  > -1;
   final boolean wasResized  = resize > 0;
   if (isMacOs && isIEBrowser && wasInitialized() && wasResized) {
       // do something
   }
```

##examples
```$xslt
double price() {
   // price is base price - quantity discount + shipping
   return _quantity * _itemPrice -
       Math.max(0, _quantity - 500) * _itemPrice * 0.05 +
       Math.min(_quantity * _itemPrice * 0.1, 100.0);
   }
```
==>
```$xslt
double price() {
       return basePrice() - quantityDiscount() + shipping();
   }
   private double quantityDiscount() {
       return Math.max(0, _quantity - 500) * _itemPrice * 0.05;
   }
   private double shipping() {
       return Math.min(basePrice() * 0.1, 100.0);
   }
   private double basePrice() {
       return _quantity * _itemPrice;
   }
```