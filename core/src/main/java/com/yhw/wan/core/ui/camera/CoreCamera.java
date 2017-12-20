package com.yhw.wan.core.ui.camera;

import android.net.Uri;

import com.yhw.wan.core.delegates.PermissionCheckerDelegate;
import com.yhw.wan.core.util.file.FileUtil;


/**
 * Created by 傅令杰
 * 照相机调用类
 */

public class CoreCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }
}
