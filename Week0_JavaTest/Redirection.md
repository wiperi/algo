# Use Redirection

`.:`或 `.;`表示将当前目录添加到系统的环境变量 PATH 中，以便在终端中直接运行当前目录下的可执行文件

`.`表示当前目录

`/`表示路径分隔符，Unix/Linux系统使用`/`，Windows使用`\`作为路径分隔符。

```shell
javac -cp .;./lib/algs4.jar .\PATH\PROGRAM.java
```

```shell
java -cp .;./lib/algs4.jar FILE ./FILE.txt < ./PATH/FILE.txt
java -cp .;./lib/algs4.jar FILE ARGS0 ARGS1 < ./PATH/FILE.txt
```

参考: <https://www.coursera.org/learn/algorithms-part1/discussions/forums/ZKvU1yj1EeaZ8Apto8QB_w/threads/gj4S4gGIEe6fDAqiAmiEGw>
