package com.yhw.wan.core.ui.camera;

import android.net.Uri;

import com.yhw.wan.core.delegates.PermissionDelegate;
import com.yhw.wan.core.utils.FileUtil;


/**
 * Created by 刘世波
 * 照相机调用类
 */

public class CoreCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }
}
