#塑造模板函数
你有一些subclasses ，其中相应的某些函数以相同顺序执行类似的措施，但各措施实际上有所不同。
将各个措施分别放进独立函数中，并保持它们都有相同的签名式（signature），
于是原函数也就变得相同了。然后将原函数上移至superclass 。
![塑造模板函数](https://img.imgdb.cn/item/6020d24f3ffa7d37b38061e3.jpg)