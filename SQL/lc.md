+ 619: 找某组里的最大/最小的时候用subquery，先出分组表，再对新表MAX。如果同名记得对结果重命名：在整个query后加AS NewTable

+ 610：IF(条件，条件成立时的值，不成立时的值)

+ 1164：COALESCE(expression1, expression2, ..., expressionN) 从第一个表达式开始检查是否为NULL
    + e.g.: SELECT COALESCE(NULL, NULL, 3, 4, NULL) AS result; -> 3

+ 1341: return the lexicographically if tie appears 按字母顺序排序
  + ORDER BY ..., column

### postgreSQL
+ Single quotes: '' 字符串 `WHERE name = 'John'`
+ Double quotes: database objects 列名、表名 
  + `SELECT name FROM people;`: 查找以name命名的 -> 不加引号时pg会把所有字母转成小写储存 NamE，NAMe都是name
  + `SELECT "name" FROM people;`: case sensitive 不能找到Name这样的

