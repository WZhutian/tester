## 注意事项
1. 运行 mainTest 测试主要流程
2. 运行 timerTest 轮询联动记录
## 使用时需要修改
1. applicationContext.xml中的路径
2. 从链码部署位置复制ca.crt到项目/src并覆盖
3. 导入exampleLibs中的包
4. timerTest中需要修改联动规则合约地址 linkageRuleAddr 为运行 mainTest 后获得的地址

