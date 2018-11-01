### git 使用规范
### 1. 分支概念
1. `master` 分支，线上代码分支，接受从`hotfix`、`release`分支提交的代码
2. `develop` 分支，开发分支，存储所有开发完成的功能代码，接受从`feature`分支提交的代码
3. `feature` 开发分支，从`develop`分支切出的分支，目前正在开发及已开发的功能代码，完成后合并到`develop`分支
4. `release` 上线分支，当前迭代功能开发完成并测试通过后，从`develop`分支切出，此分支修复的bug会再次合入`develop`分支，最终合并到`master`分支，并在`master`打tag
5. `hotfix` 线上bug修复分支，从`master`分支切出, bug修复后合`入master`及`develop`分支

### 2. 通用分支
保留`master`、`develop`、`feature`分支，功能不变

### 3. 代码提交规范
1. 需求开发时，从`develop`分支切出并建立自己分支，分支命名以TAPD任务卡id为主或者与需求相关，例如`story_1006461`或者`story_6461`，功能开发完毕后合并到`develop`分支，自测，打包转测试进行功能测试
2. 代码提交描述方式
- 使用 `更新`、`修改`、`添加`、`删除`加提交内容的方式进行提交，提交内容言简意赅，便于后期查询，例如`添加 用户详情界面`
- 或者使用TAPD任务卡id加提交内容，例如`story_6521 添加用户详情界面`，此方式便于对同一需求提交历史的查询
3. 对于bug修复，使用`Bug-bugId` 加bug描述进行提交，例如`Bug-1231 修复用户界面按钮异常bug`
4. 本次迭代上线后，`master`打tag，tag命名`release-版本号`，例如`release-4.15.1`

### 4. 问题解答
1. gitflow 简单介绍 
https://juejin.im/entry/5a1f7e096fb9a04527255d1e
2. 使用tag的意义
https://juejin.im/entry/5a24e5796fb9a044fd1197eb
3. 廖雪峰Git教程
https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000

### 5. Facebook RN提交示例及gitflow模型
![git commit](http://phi65bjw7.bkt.clouddn.com/commit%20demo.png)
![glifow](http://phi65bjw7.bkt.clouddn.com/gitflow.jpg)
