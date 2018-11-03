# AppOpsDemo
AppOpsManager的应用。判断应用程序的某些操作是否被禁用，如：是否禁止在通知栏显示通知、是否禁止显示悬浮窗。   
   
经测试，android6.0以下版本的手机（如华为mate7、华为x1）无法识别出位置信息权限是否被禁用，禁用后总是识别为已允许，暂无解决方案，android6.0+版本的手机可以用：  
```java
android.support.v4.app.NotificationManagerCompat.from(context).areNotificationsEnabled()
```
```java
android.support.v4.content.PermissionChecker.checkSelfPermission(context, permission)
```
   
判断定位是否被关闭：   
```java
    public static boolean isLocationDisable(Context context) {
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnable = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean networkEnable = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        return !gpsEnable || !networkEnable;
    }
```
   
# Screenshots
![禁用项](/screenshots/1.jpg)   
![效果图](/screenshots/2.jpg)
