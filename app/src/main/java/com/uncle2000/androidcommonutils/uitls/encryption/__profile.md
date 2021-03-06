各种加密对比
==
>http://blog.csdn.net/jiht594/article/details/6954155

对称加密算法(加解密密钥相同)
--

名称|密钥长度|运算速度|安全性|资源消耗
---|---|---|---|---
DES |56位|较快|低|中
3DES|112位或168位|慢|中|高
AES |128、192、256位|快|高|低

非对称算法(加密密钥和解密密钥不同)
--

名称|成熟度|安全性(取决于密钥长度)|运算速度|资源消耗
---|---|---|---|---
RSA|高|高|慢|高
DSA|高|高|慢|只能用于数字签名
ECC|低|高|快|低(计算量小,存储空间占用小,带宽要求低)

散列算法比较
--
名称|安全性|速度|
---|---|---
SHA-1|高|慢
MD5|中|快

散列算法比较
--
名称|密钥管理|安全性|速度
---|---|---|---
对称算法|比较难,不适合互联网,一般用于内部系统|中|快好几个数量级(软件加解密速度至少快100倍,每秒可以加解密数M比特数据),适合大数据量的加解密处理|
非对称算法|密钥容易管理|高|慢,适合小数据量加解密或数据签名|

算法选择(从性能和安全性综合)
--

**对称加密: AES(128位)**

**非对称加密: ECC(160位)或RSA(1024)**

**消息摘要: MD5**

**数字签名:DSA**