## 未使用 git add 缓存代码时
git checkout -- <filename>
## 撤回暂存区所有文件
git reset HEAD .
撤回暂存区指定的文件
git reset HEAD filename
## 撤销commit
git reset --hard HEAD^ 
git reset --hard commit_id

## 分支
https://blog.csdn.net/csflvcxx/article/details/81612336
创建新分支：git branch branchName
切换到新分支：git checkout branchName
上面两个命令也可以合成为一个命令：
git checkout -b branchName