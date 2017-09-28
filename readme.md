# NFA 转 DFA -- JAVA语言实现

## 数据结构说明

### DFA类

* K 所有状态集合
* begin 初态
* end 终态
* charList 字母表
* nodeDFAs 转换函数集

### NFA类

* K 所有状态集合
* begin 初态
* end 终态
* charList 字母表
* nodeNFAs 转换函数集

### NodeDFA类

用于保存所有的弧，也就是转换函数

* start 弧的起点
* rec 弧上的字母
* end 弧的终点

### NodeNFA类

同上

## 转换流程

* 构建NFA（Main类中创建，可从键盘输入或者使用写好的例子）
* 调用NFA的 `transToDFA()`函数，得到DFA