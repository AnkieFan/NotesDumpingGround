# list 可修改 不限类型

**函数**：
len(list) 长度
max(list) 最大值
min(list) 最小值
list(seq) 将tuple转换成list

**方法**：
list.append(element) 在list尾部添加一个element
list.extend(anotherList) 合并链表（加到尾部）
list.insert(position, element)
list.remove(element itself)
del list[n] n为索引值
del list    删除整个列表
list.pop() 删除最后一个元素并返回元素
list.pop(n) n为索引值

**分片**：
list[start: end: 步长] 左闭右开 返回索引值为start到end的元素 start默认为0 end默认为length 步长默认为1，可以是负数，从后往前走
如果start为负数 从后往前左闭右开
可以用分片来复制链表 复制后不会跟随原链表改动 newList = list[:]
list *= 3: 把列表里的元素按原来的顺序搞三遍
123 in list:返回TRUE/FALSE 判断123是否在list中
索引list中的list中的元素 list[1][1]
dir(list) 列出list的内置函数
list.count(element) 数element在list中出现了多少次
list.index(element或者element,start, end) 返回element所在的位置
list.reverse():将列表反转
list.sort(func,key,reverse = False(默认，可以改成True就是从大到小)):用指定方式对列表排序 默认从小到大 func:算法 key:关键字
例如
```
list1 = [x**2 for x in range(10)]
list1
[0, 1, 4, 9, 16, 25, 36, 49, 64, 81]
```
list.copy() 返回复制后的新列表 类似于list[:]
list.clear() 无参数无返回值 清空list中所有元素