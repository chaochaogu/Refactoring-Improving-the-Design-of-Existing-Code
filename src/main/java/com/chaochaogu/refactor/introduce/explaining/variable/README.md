#引入解释性变量
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