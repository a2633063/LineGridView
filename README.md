# LineGridView
带分割线的GridView

Android控件,GridView增加显示分割线功能

## 使用方式

project build.gradle文件中增加`maven { url 'https://jitpack.io' }`:
```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```

app build.gradle中增加 implementation 'com.github.a2633063:LineGridView:0.2'
```
dependencies {
  ......
    implementation 'com.github.a2633063:LineGridView:0.2'
}
```

layout的xml文件中增加控件:
```
    <com.zyc.customview.LineGridView
        android:id="@+id/LineGridView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:lineWidth="3"
        app:lineColor="#80ffffff"/>
```

### 参数
```
app:lineWidth="3"   //设置线宽
app:lineColor="#80ffffff" //设置分割线颜色
app:lineShow="true"   //设置是否显示分割线
```
