# 字符串

参数方括号表示可选
**判断**类：
s.isalnum()  至少有一个字符并且所有字符都是数字或者字母，为真返回 True，否则返回 False。
s.isalpha()   至少有一个字符并且所有字符都是字母，为真返回 True，否则返回 False。
s.isdecimal() 判断字符串中只包含十进制数字
s.isdigit()     所有字符都是数字，为真返回 True，否则返回 False。
s.islower()    所有字符都是小写，为真返回 True，否则返回 False。
s.isupper()   所有字符都是大写，为真返回 True，否则返回 False。
s.istitle()      所有单词都是首字母大写，为真返回 True，否则返回 False。
s.isspace()   所有字符都是空白字符，为真返回 True，否则返回 False。
s.startwith(sub[,start[,end]]) 是否以sub为开头
s.endwith(sub[,start[,end]]) 是否以sub为结尾

**大小写转换**：
str.capitalize() 把字符串的开头改为大写 返回新的字符串
str.casefold() 把所有字符改成小写
str.lower() 转换字符串中所有大写字符为小写
str.upper() 转换字符串中所有小写字符为大写
str.swapcase() 翻转字符串中的大小写
str.title() 返回标题化

**格式**：
str.center(width) 居中 width是参数 用空格填充至width长度
str.ljust(width) 左对齐
str.zfill(width) 右对齐 前面用0填充

在字符串中**查找子字符**串类：
str.count(sub, [ ,start[,end]]) 返回sub在字符串里出现的次数 start和end可选
str.find(sub[,start[,end]]) 查找字符串里是否存在sub 有返回索引值 没有返回-1
str.rfind(sub[,start[,end]])同上 从右开始查找
str.index(sub[,start[,end]]) 和find一样 但没有时产生异常
str.rindex(sub[,start[,end]])同上 从右开始查找
str.endwith(sub[,start[,end]]) 检查字符串是否以sub子字符串结束 返回boolean
str.startwith(sub[,start[,end]]) 检查字符串是否以sub子字符串结束 返回boolean

**空格**：
str.strip([chars]) 默认删除字符串前后的所有空格 chars参数可以指定删除的字符
str.lstrip() 去掉字符串所有的空格
str.rstrip() 去掉字符串末尾的空格

**字符串**替换修改：
str.expandtabs([tabsize = 8]) 把字符串中的tab (\t) 符号转换为空格 不指定参数默认长度为8（包含tab前字符的长度）
str.join(sub) 以sub作为分隔符 插入到字符串所有字符之间
str.replace(old, new [,count]) 把字符串中的old子字符串替换成new子字符串 如果count指定 则替换不超过count次
str.split(sep = None, maxsplit = -1) 自动切片 不带参数默认以空格切片 一个参数str以str为分隔
str.translate(table)  根据table的规则（可以用str.maketrans('x','n')定制 把所有的x转成n） 转换字符串中的字符

str.partition(sub) 找到子字符串sub，把字符串分成一个3元组(pre_sub, sub, fol_sub) 如果不包含sub 则返回('原字符串', '', '')
str.encode(encoding = 'utf-8', errors = 'strict') 以encoding指定方式对字符串进行编码

**format方法**：
位置参数：
str = '{0} love {1}'
str.format('I', 'BB')
输出：I don’t love BB
关键字参数：
str = '{a} love {b}'
str.format(a = 'I', b = 'BB')
综合使用： 位置参数一定要在关键字参数前
str = '{0} love {b}'
str.format( 'I', b = 'BB')

冒号表示格式化符号的开始
str = '{0:.1f} love {1}'

%c 按ACII码转义： '%c' % 97 输出：'a'
%s 格式化字符串 '%s' % 'nnnn' 输出：'ssss'
%d 格式化整数 '%d + %d = %d' % (4,5,4+5) 输出： '4 + 5 = 9'
%o 格式化无符号八进制数
%x 格式化无符号十六进制数
%X 格式化无符号十六进制数(大写）
%f 格式化定点数 可指定小数点精度 默认精确6位小数
%e 用科学计数法格式化定点数 %E改大写
%g 根据值的大小来决定使用%f或%e %G改大写

格式化操作符辅助指令： 加在%后面字母前面
m.n m为显示的最小总宽度 n是小数点后的位数
	- 左对齐
\+ 显示正负号
\# 在八进制数前显示0 在十六进制数前显示0x或0X
0 在显示的数字前填充0取代空格

字符串转义字符含义：
\' 单引号
\" 双引号
\a 发出系统响铃声
\b 退格
\n 换行
\t 横向制表符（tab）
\v 纵向制表符
\r 回车符
\f 换页符
\o 八进制数代表的字符
\x 十六进制代表的字符
\0 表示一个空字符
\\ 反斜杠