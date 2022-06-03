# ImoyaAndroidLog library

`android.util.Log` に対し、下記機能を追加したラッパーとユーティリティを提供します。

* 指定レベル以上のログのみ出力する機能
* 出力しないログのメッセージ文字列生成ロジックを実行させないことを目的とした、メッセージ文字列にコールバック関数を設定するインターフェースの追加
* 出力ログレベル指定をアプリケーションリソースで行う `android.util.Log` 互換の基底クラス(`StaticLogTemplate`)およびデフォルト実装(`Log`)

## Installation

### For GitHub users using Android Studio (using GitHub packages) (recommended)

* This solution is highly recommended as it allows you to view documents and use code completion.
* You can see [ImoyaAndroidUtil](https://github.com/IceImo-P/ImoyaAndroidUtil) as a typical implementation.

1. Prepare a GitHub personal access token with `read:packages` permission.
   * If you do not have such a token, please create one by referring to the following page: [Creating a personal access token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)
2. Create file named `github.properties` in Your project root directory.
3. Set the following content in `github.properties`:

    ```text
    gpr.user=[Your GitHub user ID]
    gpr.token=[Your personal access token]
    ```

4. Add GitHub Packages repository to:
    * `settings.gradle` in Your project root directory:

        ```groovy
        dependencyResolutionManagement {
            // other settings

            repositories {
                // other dependency such as google(), mavenCentral(), etc.

                def githubProperties = new Properties()
                githubProperties.load(new FileInputStream(file("github.properties")))
                maven {
                    name = "GitHubPackages-ImoyaAndroidLog"
                    url = uri("https://maven.pkg.github.com/IceImo-P/ImoyaAndroidLog")
                    credentials {
                        username = githubProperties.getProperty("gpr.user") ?: System.getenv("GPR_USER")
                        password = githubProperties.getProperty("gpr.token") ?: System.getenv("GPR_TOKEN")
                    }
                }
            }
        }
        ```

    * or `build.gradle` in Your project root directory:

        ```groovy
        allprojects {
            repositories {
                // other dependency such as google(), mavenCentral(), etc.

                def githubProperties = new Properties()
                githubProperties.load(new FileInputStream(rootProject.file("github.properties")))
                maven {
                    name = "GitHubPackages-ImoyaAndroidLog"
                    url = uri("https://maven.pkg.github.com/IceImo-P/ImoyaAndroidLog")
                    credentials {
                        username = githubProperties.getProperty("gpr.user") ?: System.getenv("GPR_USER")
                        password = githubProperties.getProperty("gpr.token") ?: System.getenv("GPR_TOKEN")
                    }
                }
            }

            // other settings
        }
        ```

5. Add dependencies to your module's `build.gradle`:

    ```groovy
    dependencies {
        // (other dependencies)
        implementation 'net.imoya.android.log:imoya-android-log:[version]'
        // (other dependencies)
    }
    ```

6. Sync project with Gradle.

### For non-GitHub users, Android application with Android Studio (using aar)

1. Download `imoya-android-log-release-[version].aar` from [Releases](https://github.com/IceImo-P/ImoyaAndroidLog/releases) page.
2. Place `imoya-android-log-release-[version].aar` in `libs` subdirectory of your app module.
3. Add dependencies to your app module's `build.gradle`:

    ```groovy
    dependencies {
        // (other dependencies)
        implementation files('libs/imoya-android-log-release-[version].aar')
        // (other dependencies)
    }
    ```

4. Sync project with Gradle.

### For non-GitHub users, Android library with Android Studio (using aar)

1. Download `imoya-android-log-release-[version].aar` from [Releases](https://github.com/IceImo-P/ImoyaAndroidLog/releases) page.
2. Create `imoya-android-log` subdirectory in your project's root directory.
3. Place `imoya-android-log-release-[version].aar` in `imoya-android-log` directory.
4. Create `build.gradle` file in `imoya-android-log` directory and set content as below:

    ```text
    configurations.maybeCreate("default")
    artifacts.add("default", file('imoya-android-log-release-[version].aar'))
    ```

5. Add the following line to the `settings.gradle` file in your project's root directory:

    ```text
    include ':imoya-android-log'
    ```

6. Add dependencies to your library module's `build.gradle`.

    ```groovy
    dependencies {
        // (other dependencies)
        implementation project(':imoya-android-log')
        // (other dependencies)
    }
    ```

7. Sync project with Gradle.

## Usage

### `net.imoya.android.log.Log` class

1. Make string resource `imoya_log_level` for setup minimum output log level.

    ```xml
    <resources>
        <!-- (other resources) -->

        <string name="imoya_log_level" translatable="false">info</string>

        <!-- (other resources) -->
    </resources>
    ```

    * The values and meanings are shown in the following table:
        | value | meanings |
        | --- | --- |
        | `none` | Output nothing |
        | `all` | Output all log |
        | `v` or `verbose` | Output VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT log |
        | `d` or `debug` | Output DEBUG, INFO, WARN, ERROR, ASSERT log |
        | `i` or `info` | Output INFO, WARN, ERROR, ASSERT log |
        | `w` or `warn` | Output WARN, ERROR, ASSERT log |
        | `e` or `error` | Output ERROR, ASSERT log |
        | `assert` | Output ASSERT log |
2. Call `net.imoya.android.log.Log.init` method at starting your application or Activity.
    * Sample(Kotlin):

        ```kotlin
        import android.app.Application
        import net.imoya.android.log.Log
        
        class MyApplication : Application() {
            override fun onCreate() {
                super.onCreate()
             
                Log.init(getApplicationContext())
             
                // ...
            }

            // ...
        }
        ```

    * Sample(Java):

        ```java
        import android.app.Application;
        import net.imoya.android.log.Log;
        
        public class MyApplication extends Application {
            @Override
            public void onCreate() {
                super.onCreate();
             
                Log.init(this.getApplicationContext());
             
                // ...
            }

            // ...
        }
        ```

3. Use static methods at `net.imoya.android.log.Log` class(Kotlin object) as you would `android.util.Log`. (methods and constants are compatible)

### `net.imoya.android.log.LogWrapper` class

`LogWrapper` class implements *instance* methods compatible with `v`, `d`, `i`, `w`, `e`, `wtf` and `println` at `android.util.Log`.

1. Create an instance of `LogWrapper` at any time. (`Activity#onCreate`, etc.)
    * Sample(Kotlin):

        ```kotlin
        import android.app.Activity
        import net.imoya.android.log.LogLevel
        import net.imoya.android.log.LogWrapper

        class MyActivity : Activity() {
            private lateinit var log: LogWrapper

            override fun onCreate(savedInstanceState: Bundle) {
                super.onCreate(savedInstanceState)

                log = new LogWrapper(LogLevel.ALL)

                // ...
            }

            // ...
        }
        ```

    * Sample(Java):

        ```java
        import android.app.Activity;
        import net.imoya.android.log.LogLevel;
        import net.imoya.android.log.LogWrapper;
        
        public class MyActivity extends Activity {
            private LogWrapper log;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                this.log = new LogWrapper(LogLevel.ALL);

                // ...
            }

            // ...
        }
        ```

2. Use instance method as you would `android.util.Log`.

## Customization

最小出力ログレベルの指定に他の文字列リソースを使いたい、あるいはリソースを使いたくない場合は、 `net.imoya.android.log.Log` クラスのソースファイル `Log.kt` をご自身の package へコピーし、中身を改変するなどしてカスタマイズしてください。

* リソースIDを変更する例

    ```text
        fun init(context: Context) {
    -       super.init(context, R.string.imoya_log_level)
    +       super.init(context, R.string.your_resource_id)
        }
    ```

* リソースを使用せず、最小出力ログレベルを固定する例
    * デフォルト値を変更し、アプリケーションや Activity 開始時に `Log.init` をコールしないようにします。

    ```text
    -   object Log : StaticLogTemplate(LogLevel.NONE) {
    +   object Log : StaticLogTemplate(LogLevel.WARN) { // デフォルトの最小出力ログレベルを WARN へ変更
    ```

## License

Apache license 2.0
