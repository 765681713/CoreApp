package com.yhw.wan.core.utils;

/**
 * Created by BYDeXL on 2017/12/29.
 */

public class Utils {
    /*
     ActivityUtils.java

     isActivityExists               : 判断 Activity 是否存在
     startActivity                  : 启动 Activity
     startActivities                : 启动多个 Activity
     startHomeActivity              : 回到桌面
     getActivityList                : 获取 Activity 栈链表
     getLauncherActivity            : 获取启动项 Activity
     getTopActivity                 : 获取栈顶 Activity
     isActivityExistsInStack        : 判断 Activity 是否存在栈中
     finishActivity                 : 结束 Activity
     finishToActivity               : 结束到指定 Activity
     finishOtherActivities          : 结束所有其他类型的 Activity
     finishAllActivities            : 结束所有 Activity
     finishAllActivitiesExceptNewest: 结束除最新之外的所有 Activity
     */

    /*
    * AppUtils.java
    *
    *   isInstallApp         : 判断 App 是否安装
        installApp           : 安装 App（支持 8.0）
        installAppSilent     : 静默安装 App
        uninstallApp         : 卸载 App
        uninstallAppSilent   : 静默卸载 App
        isAppRoot            : 判断 App 是否有 root 权限
        launchApp            : 打开 App
        exitApp              : 关闭应用
        getAppPackageName    : 获取 App 包名
        getAppDetailsSettings: 获取 App 具体设置
        getAppName           : 获取 App 名称
        getAppIcon           : 获取 App 图标
        getAppPath           : 获取 App 路径
        getAppVersionName    : 获取 App 版本号
        getAppVersionCode    : 获取 App 版本码
        isSystemApp          : 判断 App 是否是系统应用
        isAppDebug           : 判断 App 是否是 Debug 版本
        getAppSignature      : 获取 App 签名
        getAppSignatureSHA1  : 获取应用签名的的 SHA1 值
        isAppForeground      : 判断 App 是否处于前台
        getForegroundApp     : 获取前台应用包名
        getAppInfo           : 获取 App 信息
        getAppsInfo          : 获取所有已安装 App 信息
        cleanAppData         : 清除 App 所有数据
    */

    /*
     * BarUtils.java
     *
     *  getStatusBarHeight                   : 获取状态栏高度（px）
        setStatusBarVisibility               : 设置状态栏是否可见
        isStatusBarVisible                   : 判断状态栏是否可见
        addMarginTopEqualStatusBarHeight     : 为 view 增加 MarginTop 为状态栏高度
        subtractMarginTopEqualStatusBarHeight: 为 view 减少 MarginTop 为状态栏高度
        setStatusBarColor                    : 设置状态栏颜色
        setStatusBarAlpha                    : 设置状态栏透明度
        setStatusBarColor4Drawer             : 为 DrawerLayout 设置状态栏颜色
        setStatusBarAlpha4Drawer             : 为 DrawerLayout 设置状态栏透明度
        getActionBarHeight                   : 获取 ActionBar 高度
        setNotificationBarVisibility         : 设置通知栏是否可见
        getNavBarHeight                      : 获取导航栏高度
        setNavBarVisibility                  : 设置导航栏是否可见
        setNavBarImmersive                   : 设置导航栏沉浸式
        isNavBarVisible                      : 判断导航栏是否可见
     *  */

    /*
     * CacheUtils.java
     *
     *  getInstance    : 获取缓存实例
        put            : 缓存中写入数据
        getBytes       : 缓存中读取字节数组
        getString      : 缓存中读取 String
        getJSONObject  : 缓存中读取 JSONObject
        getJSONArray   : 缓存中读取 JSONArray
        getBitmap      : 缓存中读取 Bitmap
        getDrawable    : 缓存中读取 Drawable
        getParcelable  : 缓存中读取 Parcelable
        getSerializable: 缓存中读取 Serializable
        getCacheSize   : 获取缓存大小
        getCacheCount  : 获取缓存个数
        remove         : 根据键值移除缓存
        clear          : 清除所有缓存
     *  */

    /*
     *CleanUtils.java
     *
     *  cleanInternalCache   : 清除内部缓存
        cleanInternalFiles   : 清除内部文件
        cleanInternalDbs     : 清除内部数据库
        cleanInternalDbByName: 根据名称清除数据库
        cleanInternalSP      : 清除内部 SP
        cleanExternalCache   : 清除外部缓存
        cleanCustomCache     : 清除自定义目录下的文件
     *  */

    /*
     *ConvertUtils.java
     *
     *  bytes2HexString, hexString2Bytes        : byteArr 与 hexString 互转
        chars2Bytes, bytes2Chars                : charArr 与 byteArr 互转
        memorySize2Byte, byte2MemorySize        : 以 unit 为单位的内存大小与字节数互转
        byte2FitMemorySize                      : 字节数转合适内存大小
        timeSpan2Millis, millis2TimeSpan        : 以 unit 为单位的时间长度与毫秒时间戳互转
        millis2FitTimeSpan                      : 毫秒时间戳转合适时间长度
        bytes2Bits, bits2Bytes                  : bytes 与 bits 互转
        input2OutputStream, output2InputStream  : inputStream 与 outputStream 互转
        inputStream2Bytes, bytes2InputStream    : inputStream 与 byteArr 互转
        outputStream2Bytes, bytes2OutputStream  : outputStream 与 byteArr 互转
        inputStream2String, string2InputStream  : inputStream 与 string 按编码互转
        outputStream2String, string2OutputStream: outputStream 与 string 按编码互转
        bitmap2Bytes, bytes2Bitmap              : bitmap 与 byteArr 互转
        drawable2Bitmap, bitmap2Drawable        : drawable 与 bitmap 互转
        drawable2Bytes, bytes2Drawable          : drawable 与 byteArr 互转
        view2Bitmap                             : view 转 Bitmap
        dp2px, px2dp                            : dp 与 px 互转
        sp2px, px2sp                            : sp 与 px 互转
     *  */

    /*
     *CrashUtils.java
     *
     * init: 初始化
     *  */

    /*
     * DeviceUtils.java
     *
     *  isDeviceRooted   : 判断设备是否 rooted
        getSDKVersion    : 获取设备系统版本号
        getAndroidID     : 获取设备 AndroidID
        getMacAddress    : 获取设备 MAC 地址
        getManufacturer  : 获取设备厂商
        getModel         : 获取设备型号
        shutdown         : 关机
        reboot           : 重启
        reboot2Recovery  : 重启到 recovery
        reboot2Bootloader: 重启到 bootloader
     *
     *  */

    /*
     * EmptyUtils.java
     *
     *  isEmpty   : 判断对象是否为空
        isNotEmpty: 判断对象是否非空
     *  */

    /*
     *EncodeUtils.java
     *
     *  urlEncode          : URL 编码
        urlDecode          : URL 解码
        base64Encode       : Base64 编码
        base64Encode2String: Base64 编码
        base64Decode       : Base64 解码
        base64UrlSafeEncode: Base64URL 安全编码
        htmlEncode         : Html 编码
        htmlDecode         : Html 解码
     *  */

    /*
     *EncryptUtils.java
     *
     *  encryptMD2, encryptMD2ToString                        : MD2 加密
        encryptMD5, encryptMD5ToString                        : MD5 加密
        encryptMD5File, encryptMD5File2String                 : MD5 加密文件
        encryptSHA1, encryptSHA1ToString                      : SHA1 加密
        encryptSHA224, encryptSHA224ToString                  : SHA224 加密
        encryptSHA256, encryptSHA256ToString                  : SHA256 加密
        encryptSHA384, encryptSHA384ToString                  : SHA384 加密
        encryptSHA512, encryptSHA512ToString                  : SHA512 加密
        encryptHmacMD5, encryptHmacMD5ToString                : HmacMD5 加密
        encryptHmacSHA1, encryptHmacSHA1ToString              : HmacSHA1 加密
        encryptHmacSHA224, encryptHmacSHA224ToString          : HmacSHA224 加密
        encryptHmacSHA256, encryptHmacSHA256ToString          : HmacSHA256 加密
        encryptHmacSHA384, encryptHmacSHA384ToString          : HmacSHA384 加密
        encryptHmacSHA512, encryptHmacSHA512ToString          : HmacSHA512 加密
        encryptDES, encryptDES2HexString, encryptDES2Base64   : DES 加密
        decryptDES, decryptHexStringDES, decryptBase64DES     : DES 解密
        encrypt3DES, encrypt3DES2HexString, encrypt3DES2Base64: 3DES 加密
        decrypt3DES, decryptHexString3DES, decryptBase64_3DES : 3DES 解密
        encryptAES, encryptAES2HexString, encryptAES2Base64   : AES 加密
        decryptAES, decryptHexStringAES, decryptBase64AES     : AES 解密
     *  */

    /*
    * FileIOUtils.java
    *
    *   writeFileFromIS            : 将输入流写入文件
        writeFileFromBytesByStream : 将字节数组写入文件
        writeFileFromBytesByChannel: 将字节数组写入文件
        writeFileFromBytesByMap    : 将字节数组写入文件
        writeFileFromString        : 将字符串写入文件
        readFile2List              : 读取文件到字符串链表中
        readFile2String            : 读取文件到字符串中
        readFile2BytesByStream     : 读取文件到字节数组中
        readFile2BytesByChannel    : 读取文件到字节数组中
        readFile2BytesByMap        : 读取文件到字节数组中
        setBufferSize              : 设置缓冲区尺寸
    * */

    /*
       *FileUtils.java
       *
       *getFileByPath             : 根据文件路径获取文件
        isFileExists              : 判断文件是否存在
        rename                    : 重命名文件
        isDir                     : 判断是否是目录
        isFile                    : 判断是否是文件
        createOrExistsDir         : 判断目录是否存在，不存在则判断是否创建成功
        createOrExistsFile        : 判断文件是否存在，不存在则判断是否创建成功
        createFileByDeleteOldFile : 判断文件是否存在，存在则在创建之前删除
        copyDir                   : 复制目录
        copyFile                  : 复制文件
        moveDir                   : 移动目录
        moveFile                  : 移动文件
        deleteDir                 : 删除目录
        deleteFile                : 删除文件
        deleteAllInDir            : 删除目录下所有东西
        deleteFilesInDir          : 删除目录下所有文件
        deleteFilesInDirWithFilter: 删除目录下所有过滤的文件
        listFilesInDir            : 获取目录下所有文件
        listFilesInDirWithFilter  : 获取目录下所有过滤的文件
        getFileLastModified       : 获取文件最后修改的毫秒时间戳
        getFileCharsetSimple      : 简单获取文件编码格式
        getFileLines              : 获取文件行数
        getDirSize                : 获取目录大小
        getFileSize               : 获取文件大小
        getDirLength              : 获取目录长度
        getFileLength             : 获取文件长度
        getFileMD5                : 获取文件的 MD5 校验码
        getFileMD5ToString        : 获取文件的 MD5 校验码
        getDirName                : 根据全路径获取最长目录
        getFileName               : 根据全路径获取文件名
        getFileNameNoExtension    : 根据全路径获取文件名不带拓展名
        getFileExtension          : 根据全路径获取文件拓展名
       * */

    /*
       *FragmentUtils.java
       *
       *add                   : 新增 fragment
        show                  : 显示 fragment
        hide                  : 隐藏 fragment
        showHide              : 先显示后隐藏 fragment
        replace               : 替换 fragment
        pop                   : 出栈 fragment
        popTo                 : 出栈到指定 fragment
        popAll                : 出栈所有 fragment
        remove                : 移除 fragment
        removeTo              : 移除到指定 fragment
        removeAll             : 移除所有 fragment
        getTop                : 获取顶部 fragment
        getTopInStack         : 获取栈中顶部 fragment
        getTopShow            : 获取顶部可见 fragment
        getTopShowInStack     : 获取栈中顶部可见 fragment
        getFragments          : 获取同级别的 fragment
        getFragmentsInStack   : 获取同级别栈中的 fragment
        getAllFragments       : 获取所有 fragment
        getAllFragmentsInStack: 获取栈中所有 fragment
        findFragment          : 查找 fragment
        dispatchBackPress     : 处理 fragment 回退键
        setBackgroundColor    : 设置背景色
        setBackgroundResource : 设置背景资源
        setBackground         : 设置背景
       * */

    /*
       *ImageUtils.java
       *
       *bitmap2Bytes, bytes2Bitmap      : bitmap 与 byteArr 互转
        drawable2Bitmap, bitmap2Drawable: drawable 与 bitmap 互转
        drawable2Bytes, bytes2Drawable  : drawable 与 byteArr 互转
        view2Bitmap                     : view 转 bitmap
        getBitmap                       : 获取 bitmap
        scale                           : 缩放图片
        clip                            : 裁剪图片
        skew                            : 倾斜图片
        rotate                          : 旋转图片
        getRotateDegree                 : 获取图片旋转角度
        toRound                         : 转为圆形图片
        toRoundCorner                   : 转为圆角图片
        addCornerBorder                 : 添加圆角边框
        addCircleBorder                 : 添加圆形边框
        addReflection                   : 添加倒影
        addTextWatermark                : 添加文字水印
        addImageWatermark               : 添加图片水印
        toAlpha                         : 转为 alpha 位图
        toGray                          : 转为灰度图片
        fastBlur                        : 快速模糊
        renderScriptBlur                : renderScript 模糊图片
        stackBlur                       : stack 模糊图片
        save                            : 保存图片
        isImage                         : 根据文件名判断文件是否为图片
        getImageType                    : 获取图片类型
        compressByScale                 : 按缩放压缩
        compressByQuality               : 按质量压缩
        compressBySampleSize            : 按采样大小压缩
       * */

    /*
       *IntentUtils.java
       *
       *
       *getInstallAppIntent        : 获取安装 App（支持 6.0）的意图
        getUninstallAppIntent      : 获取卸载 App 的意图
        getLaunchAppIntent         : 获取打开 App 的意图
        getAppDetailsSettingsIntent: 获取 App 具体设置的意图
        getShareTextIntent         : 获取分享文本的意图
        getShareImageIntent        : 获取分享图片的意图
        getComponentIntent         : 获取其他应用组件的意图
        getShutdownIntent          : 获取关机的意图
        getCaptureIntent           : 获取拍照的意图
       * */

    /*
       *KeyboardUtils.java
       *
       *showSoftInput                   : 动态显示软键盘
        hideSoftInput                   : 动态隐藏软键盘
        toggleSoftInput                 : 切换键盘显示与否状态
        isSoftInputVisible              : 判断软键盘是否可见
        registerSoftInputChangedListener: 注册软键盘改变监听器
        clickBlankArea2HideSoftInput    : 点击屏幕空白区域隐藏软键盘
       * */

    /*
       *NetworkUtils.java
       *
       *openWirelessSettings  : 打开网络设置界面
        isConnected           : 判断网络是否连接
        isAvailableByPing     : 判断网络是否可用
        getMobileDataEnabled  : 判断移动数据是否打开
        setMobileDataEnabled  : 打开或关闭移动数据
        isMobileData          : 判断网络是否是移动数据
        is4G                  : 判断网络是否是 4G
        getWifiEnabled        : 判断 wifi 是否打开
        setWifiEnabled        : 打开或关闭 wifi
        isWifiConnected       : 判断 wifi 是否连接状态
        isWifiAvailable       : 判断 wifi 数据是否可用
        getNetworkOperatorName: 获取移动网络运营商名称
        getNetworkType        : 获取当前网络类型
        getIPAddress          : 获取 IP 地址
        getDomainAddress      : 获取域名 ip 地址
       * */

    /*
    * PhoneUtils.java
    *
        isPhone            : 判断设备是否是手机
        getIMEI            : 获取 IMEI 码
        getIMSI            : 获取 IMSI 码
        getPhoneType       : 获取移动终端类型
        isSimCardReady     : 判断 sim 卡是否准备好
        getSimOperatorName : 获取 Sim 卡运营商名称
        getSimOperatorByMnc: 获取 Sim 卡运营商名称
        getPhoneStatus     : 获取手机状态信息
        dial               : 跳至拨号界面
        call               : 拨打 phoneNumber
        sendSms            : 跳至发送短信界面
        sendSmsSilent      : 发送短信
        getAllContactInfo  : 获取手机联系人
        getContactNum      : 打开手机联系人界面点击联系人后便获取该号码
        getAllSMS          : 获取手机短信并保存到 xml 中
    * */

    /*
    *  RegexUtils.java
    *
    *   isMobileSimple : 验证手机号（简单）
        isMobileExact  : 验证手机号（精确）
        isTel          : 验证电话号码
        isIDCard15     : 验证身份证号码 15 位
        isIDCard18     : 验证身份证号码 18 位
        isEmail        : 验证邮箱
        isURL          : 验证 URL
        isZh           : 验证汉字
        isUsername     : 验证用户名
        isDate         : 验证 yyyy-MM-dd 格式的日期校验，已考虑平闰年
        isIP           : 验证 IP 地址
        isMatch        : 判断是否匹配正则
        getMatches     : 获取正则匹配的部分
        getSplits      : 获取正则匹配分组
        getReplaceFirst: 替换正则匹配的第一部分
        getReplaceAll  : 替换所有正则匹配的部分
    * */

    /*
    *  ScreenUtils.java
    *
    *   getScreenWidth     : 获取屏幕的宽度（单位：px）
        getScreenHeight    : 获取屏幕的高度（单位：px）
        getScreenDensity   : 获取屏幕密度
        getScreenDensityDpi: 获取屏幕密度 DPI
        setFullScreen      : 设置屏幕为全屏
        setLandscape       : 设置屏幕为横屏
        setPortrait        : 设置屏幕为竖屏
        isLandscape        : 判断是否横屏
        isPortrait         : 判断是否竖屏
        getScreenRotation  : 获取屏幕旋转角度
        screenShot         : 截屏
        isScreenLock       : 判断是否锁屏
        setSleepDuration   : 设置进入休眠时长
        getSleepDuration   : 获取进入休眠时长
        isTablet           : 判断是否是平板
    * */

    /*
    *>  SDCardUtils.java
    *
    *   isSDCardEnable: 判断 SD 卡是否可用
        getSDCardPaths: 获取 SD 卡路径
    * */

    /*
    *  ServiceUtils.java
    *
    *   getAllRunningService: 获取所有运行的服务
        startService        : 启动服务
        stopService         : 停止服务
        bindService         : 绑定服务
        unbindService       : 解绑服务
        isServiceRunning    : 判断服务是否运行
    * */

    /*
    *  SnackbarUtils.java
    *
    *   with           : 设置 snackbar 依赖 view
        setMessage     : 设置消息
        setMessageColor: 设置消息颜色
        setBgColor     : 设置背景色
        setBgResource  : 设置背景资源
        setDuration    : 设置显示时长
        setAction      : 设置行为
        setBottomMargin: 设置底边距
        show           : 显示 snackbar
        showSuccess    : 显示预设成功的 snackbar
        showWarning    : 显示预设警告的 snackbar
        showError      : 显示预设错误的 snackbar
        dismiss        : 消失 snackbar
        getView        : 获取 snackbar 视图
        addView        : 添加 snackbar 视图
    * */

    /*
    *  SpanUtils.java
    *
    *   setFlag           : 设置标识
        setForegroundColor: 设置前景色
        setBackgroundColor: 设置背景色
        setLineHeight     : 设置行高
        setQuoteColor     : 设置引用线的颜色
        setLeadingMargin  : 设置缩进
        setBullet         : 设置列表标记
        setIconMargin     : 设置图标
        setFontSize       : 设置字体尺寸
        setFontProportion : 设置字体比例
        setFontXProportion: 设置字体横向比例
        setStrikethrough  : 设置删除线
        setUnderline      : 设置下划线
        setSuperscript    : 设置上标
        setSubscript      : 设置下标
        setBold           : 设置粗体
        setItalic         : 设置斜体
        setBoldItalic     : 设置粗斜体
        setFontFamily     : 设置字体系列
        setTypeface       : 设置字体
        setAlign          : 设置对齐
        setClickSpan      : 设置点击事件
        setUrl            : 设置超链接
        setBlur           : 设置模糊
        setShader         : 设置着色器
        setShadow         : 设置阴影
        setSpans          : 设置样式
        append            : 追加样式字符串
        appendLine        : 追加一行样式字符串
        appendImage       : 追加图片
        appendSpace       : 追加空白
        create            : 创建样式字符串
    * */

    /*
    *  SPUtils.java
    *
    *   getInstance: 获取 SP 实例
        put        : SP 中写入数据
        getString  : SP 中读取 String
        getInt     : SP 中读取 int
        getLong    : SP 中读取 long
        getFloat   : SP 中读取 float
        getBoolean : SP 中读取 boolean
        getAll     : SP 中获取所有键值对
        contains   : SP 中是否存在该 key
        remove     : SP 中移除该 key
        clear      : SP 中清除所有数据
    * */

    /*
    *  StringUtils.java
    *
    *   isEmpty         : 判断字符串是否为 null 或长度为 0
        isTrimEmpty     : 判断字符串是否为 null 或全为空格
        isSpace         : 判断字符串是否为 null 或全为空白字符
        equals          : 判断两字符串是否相等
        equalsIgnoreCase: 判断两字符串忽略大小写是否相等
        null2Length0    : null 转为长度为 0 的字符串
        length          : 返回字符串长度
        upperFirstLetter: 首字母大写
        lowerFirstLetter: 首字母小写
        reverse         : 反转字符串
        toDBC           : 转化为半角字符
        toSBC           : 转化为全角字符
    * */

    /*
    *  TimeUtils.java
    *
    *   millis2String           : 将时间戳转为时间字符串
        string2Millis           : 将时间字符串转为时间戳
        string2Date             : 将时间字符串转为 Date 类型
        date2String             : 将 Date 类型转为时间字符串
        date2Millis             : 将 Date 类型转为时间戳
        millis2Date             : 将时间戳转为 Date 类型
        getTimeSpan             : 获取两个时间差（单位：unit）
        getFitTimeSpan          : 获取合适型两个时间差
        getNowMills             : 获取当前毫秒时间戳
        getNowString            : 获取当前时间字符串
        getNowDate              : 获取当前 Date
        getTimeSpanByNow        : 获取与当前时间的差（单位：unit）
        getFitTimeSpanByNow     : 获取合适型与当前时间的差
        getFriendlyTimeSpanByNow: 获取友好型与当前时间的差
        getMillis               : 获取与给定时间等于时间差的时间戳
        getString               : 获取与给定时间等于时间差的时间字符串
        getDate                 : 获取与给定时间等于时间差的 Date
        getMillisByNow          : 获取与当前时间等于时间差的时间戳
        getStringByNow          : 获取与当前时间等于时间差的时间字符串
        getDateByNow            : 获取与当前时间等于时间差的 Date
        isToday                 : 判断是否今天
        isLeapYear              : 判断是否闰年
        getChineseWeek          : 获取中式星期
        getUSWeek               : 获取美式式星期
        getWeekIndex            : 获取星期索引
        getWeekOfMonth          : 获取月份中的第几周
        getWeekOfYear           : 获取年份中的第几周
        getChineseZodiac        : 获取生肖
        getZodiac               : 获取星座
    * */

    /*
    *  ToastUtils.java
    *
    *   setGravity     : 设置吐司位置
        setBgColor     : 设置背景颜色
        setBgResource  : 设置背景资源
        setMessageColor: 设置消息颜色
        showShort      : 显示短时吐司
        showLong       : 显示长时吐司
        showCustomShort: 显示短时自定义吐司
        showCustomLong : 显示长时自定义吐司
        cancel         : 取消吐司显示
    * */

    /*
    *  ZipUtils.java
    *
    *   zipFile           : 压缩文件
        unzipFile         : 解压文件
        unzipFileByKeyword: 解压带有关键字的文件
        getFilesPath      : 获取压缩文件中的文件路径链表
        getComments       : 获取压缩文件中的注释链表
    * */

}
