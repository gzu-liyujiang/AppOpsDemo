package cn.qqtheme.appopsdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
* 经测试，部分手机（如华为mate7、华为x1）无法识别出定位是否被禁用，禁用后总是识别为已允许，暂无解决方案。
*/
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onOpCheck(View view) {
        String msg = "";
        if (AppOpsUtils.allowNotification(this)) {
            msg += "允许：显示通知到通知栏\n";
        } else {
            msg += "禁止：显示通知到通知栏\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_FINE_LOCATION)) {
            msg += "允许：OP_FINE_LOCATION\n";
        } else {
            msg += "禁止：OP_FINE_LOCATION\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_COARSE_LOCATION)) {
            msg += "允许：OP_COARSE_LOCATION\n";
        } else {
            msg += "禁止：OP_COARSE_LOCATION\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_GPS)) {
            msg += "允许：OP_GPS\n";
        } else {
            msg += "禁止：OP_GPS\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_MONITOR_LOCATION)) {
            msg += "允许：OP_MONITOR_LOCATION\n";
        } else {
            msg += "禁止：OP_MONITOR_LOCATION\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_MONITOR_HIGH_POWER_LOCATION)) {
            msg += "允许：OP_MONITOR_HIGH_POWER_LOCATION\n";
        } else {
            msg += "禁止：OP_MONITOR_HIGH_POWER_LOCATION\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_READ_PHONE_STATE)) {
            msg += "允许：OP_READ_PHONE_STATE\n";
        } else {
            msg += "禁止：OP_READ_PHONE_STATE\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_READ_EXTERNAL_STORAGE)) {
            msg += "允许：OP_READ_EXTERNAL_STORAGE\n";
        } else {
            msg += "禁止：OP_READ_EXTERNAL_STORAGE\n";
        }
        if (AppOpsUtils.isAllowed(this, AppOpsUtils.OP_WRITE_EXTERNAL_STORAGE)) {
            msg += "允许：OP_WRITE_EXTERNAL_STORAGE\n";
        } else {
            msg += "禁止：OP_WRITE_EXTERNAL_STORAGE\n";
        }
        showAlert(msg);
    }

    private void showAlert(String msg) {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setMessage(msg);
        dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
