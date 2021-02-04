#复制被监视数据
你有一些domain class置身于GUI控件中，而domain method需要访问之。
将该笔数据拷贝到一个domain object中。建立一个Observer模式，用以对domain object和GUI object内的重复数据进行同步控制（sync.）。
![复制被监视数据](https://img.imgdb.cn/item/601b9cfc3ffa7d37b353b777.jpg)
