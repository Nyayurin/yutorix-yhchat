<div align="center">

# Yutorix-Satori

Yutori 的云湖扩展模块

| Module                 | Platforms                                                                                                                                  |
|------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| yutorix-yhchat-core    | JVM(17), Android(17), JS(Browser, Node), WasmJS(Browser, Node), IOS(x64, Arm64, SimulatorArm64), MacOS(x64, Arm64), Linux(x64), Mingw(x64) |
| yutorix-yhchat-adapter | JVM(17), Android(17), IOS(x64, Arm64, SimulatorArm64), MacOS(x64, Arm64), Linux(x64)                                                       |

</div>

## 如何使用

### 从 Kotlin 项目开始

添加仓库

build.gradle.kts

```kotlin
maven {
    url = uri("https://maven.pkg.github.com/Nyayurin/yutorix-yhchat")
    credentials {
        username = project.findProperty("gpr.actor") as String? ?: System.getenv("GITHUB_ACTOR")
        password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
    } 
}
```

settings.gradle.kts

```kotlin
maven {     
    url = uri("https://maven.pkg.github.com/Nyayurin/yutorix-yhchat")
    credentials {
        username = providers.gradleProperty("gpr.actor").orNull ?: System.getenv("GITHUB_ACTOR")
        password = providers.gradleProperty("gpr.token").orNull ?: System.getenv("GITHUB_TOKEN")
    }
}
```

引入依赖

```kotlin
implementation(libs.yutorix.yhchat.core)
implementation(libs.yutorix.yhchat.adapter)
```

```toml
[versions]
yutorix-yhchat = "version"

[libraries]
yutorix-yhchat-core = { module = "cn.yurin.yutorix:yutorix-yhchat-core", version.ref = "yutorix-yhchat" }
yutorix-yhchat-adapter = { module = "cn.yurin.yutorix:yutorix-yhchat-adapter", version.ref = "yutorix-yhchat" }
```

请从 [Github Packages](https://github.com/Nyayurin?tab=packages&repo_name=yutorix-yhchat) 获取版本<br>
对于稳定版, 它的版本号应该和 Release 中的 tag 一致<br>
对于开发板, 它的版本号应该和 Commit 的完整 SHA 值一致<br>
要获取一个 Commit 的完整 SHA 值, 请在 Commits 页面对应 Commit 处点击 Commit ID 右侧的复制按钮(Copy full SHA for *******)

安装模块

```kotlin
install(Adapter.yhchat()) {
    host = "0.0.0.0"
    port = 8080
    token = "token"
    userId = "userId"
}
```