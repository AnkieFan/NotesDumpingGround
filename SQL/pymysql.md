## cursor

### cursor types
Type|Discribe
|---|---|
Cursor|normal cursor, return a tuple
SScursor|cursor without cache
DictCursor| return executing results as a dictionary
SSDictCursor| dictionary without cache

```
class pymysql.cursors.Cursor(connection)
class pymysql.cursors.SSCursor(connection)
```

### Read only
`cursor.description` return cursor status
`cursor.rowcount` changed rows' number of the latest `execute()`

### Close
`cursor.close()`

### Execute
`cursor.execute(query, args=None)`
`query`: str, sql commond
`args`: (tuple, list or dict) used for pass parameters into sql
return int: changed row number

e.g.:
```
str_insert= "INSERT INTO Cu_table (id) VALUES (%s)"# args is a tuple
cursor.execute(str_insert,('123'))
 
arg = {'id':'id'}# args is a dict
str_insert= "INSERT INTO Cu_table (id) VALUES (%(id)s)"
cursor.execute(str_insert,arg)
```

` cursor.excutemany(query, args)` execute many sql commands
`args`: sequence

e.g.:
```
str_insert = "INSERT INTO Cu_table (id) VALUES (%s)"
cursor.executemany(str_insert,['A','B','C','D'])
```

### Get result
`cursor.fetchone()` get next line of results
return: tuple/None
e.g.:
```
str_insert = "SELECT * FROM Cu_table"
cursor.execute(str_insert)
result = cursor.fetchone()
print(result)
```

`cursor.fetchmany(size=None)` get first `size` lines of results, default size:`cursor.arraysize=1`
Return: sequence
实例：
```
str_insert = "SELECT * FROM Cu_table"
cursor.execute(str_insert)
result = cursor.fetchmany(3) #get first 3 lines
print(result)
```

`cursor.fetchall()`: get all the results

### iterate to get results
`cursor .__iter__()` create an iterable object
e.g.:
```
cursor.execute("SELECT * FROM new_futures.m1809")
it=cursor.__iter__()
it.__next__()#get the next line and return a tuple
pd.DataFrame(list(it))
```

## Setting

### Set return types
+ Method 1:
```
db = pymysql.connect(host = "localhost",user = "root",password = "root",database = "new_futures",
    charset = 'utf8',cursorclass = pymysql.cursors.DictCursor
```  

`pd.DataFrame(list(rs))`
`rs` is a tuple：`((1, '豆粕1','m1809',),(2,'豆粕2','m1809',),...,(...))`

+ Method 2:
`cursor = conn.cursor(cursor=pymysql.cursors.DictCursor)`
pd.DataFrame(rs1)
`rs1` is a dictionary: `[{'No': 1,'name': '豆粕1','code': 'm1809'},{...}]`

## Parameter:
### Tuple
'()' must be there. Can only be `(%s)`. Parameter mast be `(str,)`
    
E.g.: 1 parameter
`str_insert= "INSERT INTO m1805 (id) VALUES (%s)"`
`cursor.execute(str_insert,('7')) #must have "()" and must be str`
`con.commit()`
    
e.g.: many parameters
```
str_insert= "INSERT INTO m1805 (id,name) VALUES (%s,%s)"
cursor=con.cursor()
cursor.execute(str_insert,('123','Jim'))
con.commit()
```

### Dictionary
`()` must be there including `,`. Can only be `(%s)`. Parameter mast be dict

e.g.:
```
arg = {'x':'33'}
str_insert= "INSERT INTO m1805 (id) VALUES (%(x)s)"
cursor.execute(str_insert,arg)
con.commit()
```
    
e.g.:
```
arg = {'x':'44','y':'Bob'}
str_insert= "INSERT INTO m1805 (id,name) VALUES (%(x)s,%(y)s)"
cursor.execute(str_insert,arg)
con.commit()  
```

### Variable
#### e.g.1: 传入变量到语句%s+传入数值到(%s) cursor.execute(后面必须加括号)
    
```
table_name='m1805';
id1='id';
name='name';
id_v='55';
name_v='Smith'
str_insert= "INSERT INTO %s (%s,%s) "%(table_name,id1,name)#传入变量
str_insert=str_insert+"VALUES (%s,%s)"# 传入变量的数值；必须分开写，佛则会把变量值当成列或表名寻找，最后报错
cursor.execute(str_insert,(id_v,name_v))#必须加括号必须是字符串
con.commit()
```
    
#### e.g.2: 传入变量到语句%s+传入数值到语句'%d','%s'分开书写
```
table_name='m1805'; id1='id'; name='name'; id_v=66; name_v='Smith'
str_insert= "INSERT INTO %s (%s,%s) "%(table_name,id1,name)
str_insert=str_insert+"VALUES ('%d','%s')"%(id_v,name_v)#注意 ('%d','%s')不同于上面，这样书写会将变量解析为指定的类型
    
cursor.execute(str_insert)
con.commit()
```
    
#### e.g.3：传入变量到语句%s +传入数值到语句'%d','%s'合并书写
```
table_name='m1805';id1='id';name='name';id_v=77;name_v='Smith'
str_insert= "INSERT INTO %s (%s,%s)  VALUES ('%d','%s')"%(table_name,id1,name,id_v,name_v)
    
cursor.execute(str_insert)
con.commit()
```
    
#### e.g.4: 综合运用
```
#日期以字符串形式传入
table_name='m1805';id1='id';name='name';id_v=88;name_v='Smith';
date='2019-1-27';time='12:05:05'
str_insert= "INSERT INTO %s (%s,%s,%s,%s)  VALUES ('%d','%s','%s','%s')"%(
                  table_name,id1,name,'date','time',id_v,name_v,date,time)
    
cursor.execute(str_insert)
con.commit() 
```