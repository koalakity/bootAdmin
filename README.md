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
git clone https://github.com/koalakity/bootAdmin.git
cd bootAdmin
mvn archetype:create-from-project -Darchetype.filteredExtensions=java
cd target/generated-sources/archetype/
mvn install
mvn archetype:generate -DarchetypeCatalog=local
根据提示选择 archetype 填写groupId artifactId 生成项目骨架 项目名称即所填写的 artifactid 包含3个module  domain，service，console
数据库使用内存数据库，eclipse 导入生成的maven项目后可直接运行

## 在线演示
