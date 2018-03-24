## Android开发遇到的坑汇总

> Toolbar去除标题与返回键间的间距

给toolbar加上以下属性：

    app:navigationIcon="@drawable/icon_back" //这是设置返回键图标，这是必不可少的。 
    app:contentInsetStartWithNavigation="0dp"


为了保险起见，建议加上这两个属性：

    app:contentInsetLeft="0dp"
    app:contentInsetStart="0dp"

完整的示范如下：

	<android.support.v7.widget.Toolbar xmlns:app="http://schemas.android.com/apk/res-auto" 
		android:id="@+id/title_tool_bar" 
		android:layout_width="match_parent" 
		android:layout_height="?attr/actionBarSize" 
		android:background="@color/colorTheme" 
		app:contentInsetLeft="0dp" 
		app:contentInsetStart="0dp" 
		app:contentInsetStartWithNavigation="0dp" 
		app:layout_scrollFlags="enterAlways|scroll" 
		app:navigationIcon="@drawable/icon_back" 
		app:popupTheme="@style/ThemeOverlay.AppCompat.Light" 
		app:theme="@style/ToolbarStyle" 
		app:title="标题" 
		app:titleTextColor="@color/colorWhite">