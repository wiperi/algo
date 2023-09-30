# Use Redirection

```shell
javac -cp .;./lib/algs4.jar .\PATH\PROGRAM.java
```

`.`表示当前目录

`/`表示路径分隔符，Unix/Linux系统使用`/`，Windows使用`\`作为路径分隔符

`:`或 `;`用来分隔两个地址，例如`.;./lib/algs4.jar;PATH3;PATH4`

`-cp`指定类路径

```shell
java -cp [ClassPath1];[ClassPath2] [Package.ClassName] [Argument1] [Argument2] < [Path of Redirecton file]

# Example
java -cp .;./lib/algs4.jar MyFolder.MySubfolder.MyHelloWorld ARGS0 ARGS1 < ./PATH/FILE.txt
```

`ClassName`是类名，用`.`来表示包的层次结构，一个典型的类名`Java.util.Random`，应确保类路径中包含类名

参考: <https://www.coursera.org/learn/algorithms-part1/discussions/forums/ZKvU1yj1EeaZ8Apto8QB_w/threads/gj4S4gGIEe6fDAqiAmiEGw>
