# tuple 不可修改 不限类型

添加元素：
tuple = tuple[:n] + 元素（必须是元组，比如('aaa', ） + tuple[n:]
字符串：
Str1 = str1[:6] + '插入的字符串' + str1[6:]

删除整个元组
del temp

可以用count()和index()

元组不需要括号，只用逗号隔开也被视为元组