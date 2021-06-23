## 生物信息分析工具
#### 技术
+ SpringBoot
+ mongodb
#### 功能
+ ce-RNA网络图

#### 联系
+ Email:1749748955@qq.com

#### 代码贡献
```
git clone https://github.com/BioinfoFungi/bioinfo_analysis.git
```
#### 迁移后提交
+ 方法有三种
    + 修改命令:git remote origin set-url [url]
    + 先删后加
        + git remote rm origin
        + git remote add origin [url]
    + 直接修改config文件
```
git remote add origin_1 https://github.com/BioinfoFungi/bioinfo_analysis.git
git add .
git commit -m 'XXXX'
git status
git push origin_1 master
```