[![Build Status](https://travis-ci.org/koalakity/bootAdmin.svg?branch=master)](https://travis-ci.org/koalakity/bootAdmin)
## bootAdmin
spring boot+adminlte种子项目,可用作企业管理应用系统初始模板。

## 技术栈
spring boot 微服务框架
thymeleaf   模板引擎
adminlte    后台管理界面模板
bootstart   ui框架
datatables  后台js框架

## 使用说明
1.克隆项目到本地
```bash
git clone https://github.com/koalakity/bootAdmin.git
```
2.打开项目执行命令创建项目结构
```bash
cd bootAdmin
mvn archetype:create-from-project -Darchetype.filteredExtensions=java
```
3.打开生成目录 安装到本地
```bash
cd target/generated-sources/archetype/
mvn install
```
4.使用安装好的项目骨架创建 项目
```bash
mvn archetype:generate -DarchetypeCatalog=local<br/>
```
根据提示选择 archetype 填写groupId artifactId 生成项目骨架 项目名称即所填写的 artifactid 包含3个module  domain，service，console
数据库使用内存数据库，eclipse 导入生成的maven项目后可直接运行

## 在线演示
