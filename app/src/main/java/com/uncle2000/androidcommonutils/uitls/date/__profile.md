类及类方法简介
==
>>注意lunar包内还未整理 主要放的是农历 农历也叫月亮历


类简介
--
类名|类简介
---|---
_DateConstant|包内的常量类
ConverDate|日期转换相关的类
DateUtil|Date工具类
GetDate|Date的简易get类

_DateConstant.class
--
>无方法

ConverDate.class
--
>
1. **任意字符串转换成任意格式**
1. **String->Date**
1. **String->Calendar**
1. **Calendar->String**
1. **Date->String**
1. **~~string->long~~**
1. **date->long**
1. **cadlendar->long**
1. **long->formatStr**
1. **已过去时间距现在多久**

DateUtil.class
--
>
1. **获得当前时间戳**
1. **get当前日期对象**
1. **更改为第一天为星期一**
1. **通过传入的星期几 返回中国式的星期几的Date对象**
1. **判断原日期是否在目标日期之前**
1. **判断原日期是否在目标日期之后**
1. **判断两日期是否相同**
1. **判断某个日期是否在某个日期范围**
1. **比较时间大小**
1. **获得天数差**
1. **~~秒->大概是多少个最少单位~~**

GetDate.class
--
>
1. **当前日期calendar会自动省略0**
1. **当前日期Date不会自动省略0**
1. **获得年份**
1. **获得月份**
1. **获得星期**
1. **获得日期**
1. **get Chinese当年第几月**
1. **get Chinese当前月份中的第几天**
1. **get Chinese当前星期的第几天**
1. **get Chinese当年中的第几天**
1. **get Chinese当前月的第一天**
1. **et Chinese当前月的最后一天**
1. **获得Chinese周五日期**
1. **获得Chinese周六日期**
1. **获得Chinese周日日期**
