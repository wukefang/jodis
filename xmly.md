## 简介


代码fork 自 jodis github 源码，代码地址` https://github.com/qiankunli/jodis`，基于0.5.2 版本

扩展

1. 公司内pika支持了一个ehash 数据结构，对应的jedis 是 jedis-xmly-ext
2. 改动仅是 将依赖的jedis 改为 jedis-xmly-ext


## 发布方式


1. 本地打包`mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dgpg.skip=true`，然后上传到 artifactory 中
