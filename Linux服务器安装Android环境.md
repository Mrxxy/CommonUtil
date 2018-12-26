# Linux服务器安装Android环境
##### 1. 从Android官网下载sdk-tools-linux 压缩包 使用SFTP上传至 任意目录中，本文中使用 `wget`命令进行下载,存放在`/home`目录下
```shell
# 此下载地址为官网最新地址
cd /home
sudo wget https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip
```
##### 2. 解压第一步中下载的zip文件
检查当前环境是否有zip命令
```shell
zip
```
- 若存在此命名，在`/home`新建`android-sdk-linux`文件夹，将文件解压到此目录
```shell
sudo mkdir android-sdk-linux
sudo unzip -o -d ./andorid-sdk-linux sdk-tools-linux-4333796.zip
```
- 若不存在，使用`brew install unzip`进行安装，之后重复上述步骤

##### 3. 配置环境变量
```shell
sudo vi /etc/profile
```
在最后两行添加
```
export ANDROID_HOME=/home/android-sdk-linux 
export PATH=$ANDROID_HOME/tools:$PATH
```
其中`/home/android-sdk-linux`为`android-sdk-linux`解压目录，之后使用`source /etc/profile`刷新配置

##### 4. 检验环境是否配置成功
```shell
android
```
如果提示权限问题，使用`sudo chmod -R 777 /home/android-sdk-linux`

##### 5. 使用Android命令配置打包环境
https://developer.android.google.cn/studio/command-line/sdkmanager
```shell
# SDK 25之后，官方建议使用sdkmanager命令进行sdk管理
cd /home/android-sdk-linux/tools/bin
./sdkmanager "build-tools;28.0.3"
```

###### 6. 打包
以上配置没有问题后，就可以愉快的打包了
```shell
cd /home/workspace/project-xxx
# 此命令会自动下载gradle环境，服务器一般不存在翻墙、难下载的问题
./gradlew build
```

