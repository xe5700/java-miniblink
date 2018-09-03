package net.xjboss.jminiblink.natives;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinDef;
import net.xjboss.jminiblink.natives.callbacks.*;
import net.xjboss.jminiblink.natives.wke.wkeProxy;
import net.xjboss.jminiblink.natives.wke.wkeSettings;
import net.xjboss.jminiblink.natives.wke.wkeWindowType;

public interface NativeMiniBlink extends Library {
    int wkeVersion();
    String wkeVersionString();
    void wkeSetWkeDllPath(WString dllPath);
    void wkeGC(Pointer webView, long delayMs);
    boolean wkeIsDocumentReady(Pointer webView);
    void wkeStopLoading(Pointer webView);
    boolean wkeReload(Pointer webView);
    String wkeGetTitle(Pointer webView);
    void wkeResize(Pointer webView, int w, int h);
    int wkeGetWidth(Pointer webView);
    int wkeGetHeight(Pointer webView);
    int wkeGetContentWidth(Pointer webView);
    int wkeGetContentHeight(Pointer webView);
    void wkePaint2(Pointer webView, Pointer bits, int bufWid, int bufHei, int xDst, int yDst, int w, int h, int xSrc, int ySrc, boolean bCopyAlpha);
    void wkePaint(Pointer webView, Pointer bits, int pitch);
    WinDef.HDC wkeGetViewDC(Pointer webView);
    WinDef.HWND wkeGetHostHWND(Pointer webView);
    //boolean wkeCanGoBack(Pointer webView);
    boolean wkeGoBack(Pointer webView);
    //boolean wkeCanGoForward(Pointer webView);
    boolean wkeGoForward(Pointer webView);
    void wkeEditorSelectAll(Pointer webView);
    void wkeEditorUnSelect(Pointer webView);
    void wkeEditorCopy(Pointer webView);
    void wkeEditorCut(Pointer webView);
    void wkeEditorDelete(Pointer webView);
    void wkeEditorUndo(Pointer webView);
    void wkeEditorRedo(Pointer webView);
    String wkeGetCookie(Pointer webView);
    void wkeSetCookie(Pointer webView, String url, String cookie);
    //void wkeVisitAllCookie(Pointer params, wkeCookieVisitor visitor);
    //void wkePerformCookieCommand(wkeCookieCommand command);
    void wkeSetCookieEnabled(Pointer webView, boolean enable);
    boolean wkeIsCookieEnabled(Pointer webView);
    void wkeSetCookieJarPath(Pointer webView, WString path);
    void wkeSetCookieJarFullPath(Pointer webView, WString path);
    void wkeSetLocalStorageFullPath(Pointer webView, WString path);
    void wkeSetMediaVolume(Pointer webView, float volume);
    float wkeGetMediaVolume(Pointer webView);
    boolean wkeFireMouseEvent(Pointer webView, WinDef.UINT message, int x, int y, WinDef.UINT flags);
    boolean wkeFireContextMenuEvent(Pointer webView, int x, int y, WinDef.UINT flags);
    boolean wkeFireMouseWheelEvent(Pointer webView, int x, int y, int delta, WinDef.UINT flags);
    boolean wkeFireKeyUpEvent(Pointer webView, WinDef.UINT virtualKeyCode, WinDef.UINT flags, boolean systemKey);
    boolean wkeFireKeyDownEvent(Pointer webView, WinDef.UINT virtualKeyCode, WinDef.UINT flags, boolean systemKey);
    boolean wkeFireKeyPressEvent(Pointer webView, WinDef.UINT charCode, WinDef.UINT flags, boolean systemKey);
    boolean wkeFireWindowsMessage(Pointer webView, WinDef.HWND hWnd, WinDef.UINT message, WinDef.WPARAM wParam, WinDef.LPARAM lParam, WinDef.LRESULT result);
    void wkeSetFocus(Pointer webView);
    void wkeKillFocus(Pointer webView);
    //wkeRect wkeGetCaretRect(wkeWebView webView);
    //jsValue wkeRunJS(wkeWebView webView, String script);
    //jsValue wkeRunJSW(wkeWebView webView, const wchar_t* script);
    //jsExecState wkeGlobalExec(wkeWebView webView);

    void wkeSetZoomFactor(Pointer webView, float factor);
    float wkeGetZoomFactor(Pointer webView);
    void wkeSetEditable(Pointer webView, boolean editable);

    void wkeOnTitleChanged(Pointer webView, wkeTitleChangedCallback callback, Pointer callbackParam);
    void wkeOnMouseOverUrlChanged(Pointer webView, wkeTitleChangedCallback callback, Pointer callbackParam);
    void wkeOnURLChanged(Pointer webView, wkeURLChangedCallback callback, Pointer callbackParam);
    void wkeOnURLChanged2(Pointer webView, wkeURLChangedCallback2 callback, Pointer callbackParam);
    void wkeOnPaintUpdated(Pointer webView, wkePaintUpdatedCallback callback, Pointer callbackParam);
    void wkeOnPaintBitUpdated(Pointer webView, wkePaintBitUpdatedCallback callback, Pointer callbackParam);
    void wkeOnAlertBox(Pointer webView, wkeAlertBoxCallback callback, Pointer callbackParam);
    void wkeOnConfirmBox(Pointer webView, wkeConfirmBoxCallback callback, Pointer callbackParam);
    void wkeOnPromptBox(Pointer webView, wkePromptBoxCallback callback, Pointer callbackParam);
    void wkeOnNavigation(Pointer webView, wkeNavigationCallback callback, Pointer param);
    void wkeOnCreateView(Pointer webView, wkeCreateViewCallback callback, Pointer param);
    void wkeOnDocumentReady(Pointer webView, wkeDocumentReadyCallback callback, Pointer param);
    //void wkeOnDocumentReady2(Pointer webView, wkeDocumentReady2Callback callback, Pointer param);
    void wkeOnDownload(Pointer webView, wkeDownloadCallback callback, Pointer param);
    void wkeNetOnResponse(Pointer webView, wkeNetResponseCallback callback, Pointer param);
    void wkeOnConsole(Pointer webView, wkeConsoleCallback callback, Pointer param);
    void wkeOnLoadUrlBegin(Pointer webView, wkeLoadUrlBeginCallback callback, Pointer callbackParam);
    void wkeOnLoadUrlEnd(Pointer webView, wkeLoadUrlEndCallback callback, Pointer callbackParam);
    void wkeOnDidCreateScriptContext(Pointer webView, wkeDidCreateScriptContextCallback callback, Pointer callbackParam);
    void wkeOnWillReleaseScriptContext(Pointer webView, wkeWillReleaseScriptContextCallback callback, Pointer callbackParam);
    void wkeOnWillMediaLoad(Pointer webView, wkeWillMediaLoadCallback callback, Pointer callbackParam);
    boolean wkeIsMainFrame(Pointer webView, Pointer frameId);
    //wkeWebFrameHandle wkeWebFrameGetMainFrame(wkeWebView webView);
    //jsValue wkeRunJsByFrame(wkeWebView webView, wkeWebFrameHandle frameId, String script, bool isInClosure);
    String wkeGetFrameUrl(Pointer webView, Pointer frameId);
    String wkeGetString(Pointer s);
    void wkeSetString(Pointer string, String str, int len);
    Pointer wkeCreateStringW(WString str,int len);
    void wkeDeleteString(Pointer str);
    int wkeGetCursorInfoType(Pointer webView);
    Pointer wkeCreateWebView();
    Pointer wkeCreateWebWindow(int type, Pointer parent, int x, int y, int width, int height);
    void wkeDestroyWebWindow(Pointer webWindow);
    Pointer wkeGetWindowHandle(Pointer webWindow);
    /*
    获取窗口对应的真实句柄。和wkeGetHostHWND的实现完全相同
    参数：略*/
    void wkeOnWindowClosing(Pointer webWindow, wkeWindowClosingCallback callback, Pointer param);
    /*
    wkeWebView如果是真窗口模式，则在收到WM_CLODE消息时触发此回调。可以通过在回调中返回false拒绝关闭窗口
    参数：略
    */
    void wkeOnWindowDestroy(Pointer webWindow, wkeWindowDestroyCallback callback, Pointer param);
    /*
    窗口即将被销毁时触发回调。不像wkeOnWindowClosing，这个操作无法取消
    参数：略
    */
    void wkeShowWindow(Pointer webWindow, boolean showFlag);
    /*
    略
    参数：略
    */
    void wkeEnableWindow(Pointer webWindow, boolean enableFlag);
    /*
    略
    参数：略
    */
    void wkeMoveWindow(Pointer webWindow, int x, int y, int width, int height);
    /*
    略
    参数：略
    */
    void wkeMoveToCenter(Pointer webWindow);
    /*
    窗口在父窗口或屏幕里居中
    参数：略
    */
    void wkeResizeWindow(Pointer webWindow, int width, int height);
    /*
    resize窗口，和wkeResize效果一样
    参数：略
    */

    void wkeSetWindowTitle(Pointer webWindow, String title);
    void wkeSetDeviceParameter(Pointer webView, String device,String paramStr, int paramInt, float paramFloat);
    /*
    设置mb模拟的硬件设备环境。主要用在伪装手机设备场景
    参数：
    device：设备的字符串。可取值有：
            "navigator.maxTouchPoints"	此时 paramInt 需要被设置，表示 touch 的点数
"navigator.platform"	此时 paramStr 需要被设置，表示js里获取的 navigator.platform字符串
"navigator.hardwareConcurrency"	此时 paramInt 需要被设置，表示js里获取的 navigator.hardwareConcurrency 整数值
"screen.width"	此时 paramInt 需要被设置，表示js里获取的 screen.width 整数值
"screen.height"	此时 paramInt 需要被设置，表示js里获取的 screen.height 整数值
"screen.availWidth"	此时 paramInt 需要被设置，表示js里获取的 screen.availWidth 整数值
"screen.availHeight"	此时 paramInt 需要被设置，表示js里获取的 screen.availHeight 整数值
"screen.pixelDepth"	此时 paramInt 需要被设置，表示js里获取的 screen.pixelDepth 整数值
"screen.pixelDepth"	目前等价于"screen.pixelDepth"
            "window.devicePixelRatio"	同上
            */
    void wkeInit();
    /*
    初始化整个mb。此句必须在所有mb api前最先调用。并且所有mb api必须和调用wkeInit的线程为同个线程
    参数：略
    */
    void wkeShutdown();
    /*
    关闭整个mb。调用后，所有mb api将不能再被调用，否则会有崩溃
    参数：略
    */
    void wkeInitialize();
    /*
    效果和wkeInit一模一样
    参数：略
    */
    void wkeSetProxy(wkeProxy proxy);
        /*
    设置整个mb的代码。此句是全局生效
    参数：略
    */
    void wkeSetViewProxy(Pointer webView, wkeProxy proxy);
    /*
    设置整个mb的代码。此句是针对特定webview生效
    参数：略
    */
    void wkeConfigure(wkeSettings settings);
    /*
    设置一些配置项
    参数：
    typedef struct { wkeProxy proxy; unsigned int mask; } wkeSettings; mask可以取：
    WKE_SETTING_PROXY：效果和wkeSetProxy一样，通过proxy设置
    WKE_SETTING_PAINTCALLBACK_IN_OTHER_THREAD：这是个高级用法，开启时，on paint回调会在另外个线程（其实就是渲染线程）。
    这个是用来实现多线程上屏功能，性能更快。
    */
    boolean wkeIsInitialize();
    /*
    略
    参数：略
    */
    void wkeFinalize();
    /*
    效果和wkeShutdown一样
    参数：略
    */
    void wkeSetMemoryCacheEnable(Pointer webView, boolean b);
    /*
    开启内存缓存。网页的图片等都会在内存缓存里。关闭后，内存使用会降低一些，但容易引起一些问题，如果不懂怎么用，最好别开
    参数：略
    */
    void wkeSetTouchEnabled(Pointer webView, boolean b);
    /*
    开启触屏模式。开启后，鼠标消息将自动转换成触屏消息
    参数：略
    */
    void wkeSetMouseEnabled(Pointer webView, boolean b);
    /*
    开启关闭鼠标消息，可以在开启触屏后，关闭鼠标消息
    参数：略
    */
    void wkeSetNavigationToNewWindowEnable(Pointer webView, boolean b);
    /*
    关闭后，点a标签将不会弹出新窗口，而是在本窗口跳转
    参数：略
    */
    void wkeSetCspCheckEnable(Pointer webView, boolean b);
    /*
    关闭后，跨域检查将被禁止，此时可以做任何跨域操作，如跨域ajax，跨域设置iframe
    参数：略
    */
    void wkeSetNpapiPluginsEnabled(Pointer webView, boolean b);
    /*
    开启关闭npapi插件，如flash
    参数：略
    */
    void wkeSetHeadlessEnabled(Pointer webView, boolean b);
    /*
    开启无头模式。开启后，将不会渲染页面，提升了网页性能。此功能方便用来实现一些爬虫，或者刷单工具
    参数：略
    */
    void wkeSetDebugConfig(Pointer webView, String debugString, String param);
    /*
    开启一些实验性选项。
    参数：
    debugString：
            "showDevTools"	开启开发者工具，此时param要填写开发者工具的资源路径，如file:///c:/miniblink-release/front_end/inspector.html。注意param此时必须是utf8编码
            "wakeMinInterval"	设置帧率，默认值是10，值越大帧率越低
"drawMinInterval"	设置帧率，默认值是3，值越大帧率越低
"antiAlias"	设置抗锯齿渲染。param必须设置为"1"
            "minimumFontSize"	最小字体
"minimumLogicalFontSize"	最小逻辑字体
"defaultFontSize"	默认字体
"defaultFixedFontSize"	默认fixed字体
    */
    void wkeSetHandle(Pointer webView, Pointer wnd);
    /*
    设置wkeWebView对应的窗口句柄。
    参数：略
    注意：只有在无窗口模式下才能使用。如果是用wkeCreateWebWindow创建的webview，已经自带窗口句柄了。
    */
    void wkeSetHandleOffset(Pointer webView, int x, int y);

    /*
    设置无窗口模式下的绘制偏移。在某些情况下（主要是离屏模式），绘制的地方不在真窗口的(0, 0)处，就需要手动调用此接口
    参数：略
    */
    //void wkeSetViewSettings(wkeWebView webView, wkeViewSettings settings);
    /*
    设置一些webview相关的设置.目前只有背景颜色可以设置
    参数：略
    */
    void wkeSetTransparent(Pointer webView, boolean transparent);
    /*
    通知无窗口模式下，webview开启透明模式。
    参数：略
    */
    boolean wkeIsTransparent(Pointer webView);
    /*
    判断窗口是否是分层窗口（layer window）
    参数：略
    */
    void wkeSetUserAgent(Pointer webView, String userAgent);
    /*
    设置webview的UA
    参数：略
    */
    String wkeGetUserAgent(Pointer webView);
    /*
    获取webview的UA
    参数：略
    */
    void wkeLoadURL(Pointer webView, String url);
    /*
    加载url。url必须是网络路径，如"http://qq.com/"
    参数：略
    */
    void wkeLoadHTML(Pointer webView, String html);
    /*
    加载一段html
    参数：略
    注意：如果html里有相对路径，则是相对exe所在目录的路径
    */
    void wkeLoadHtmlWithBaseUrl(Pointer webView, String html, String baseUrl);
    /*
    加载一段html，但可以指定baseURL，也就是相对于哪个目录的url
    参数：略
    */
    void wkeLoadFile(Pointer webView, String filename);
    /*
    略
    参数：略
    */
    String wkeGetURL(Pointer webView);
    /*
    获取webview主frame的url
    参数：略
    */
    void wkeNetSetHTTPHeaderField(Pointer jobPtr, WString key, WString value, boolean response);
    /*
    在wkeOnLoadUrlBegin回调里调用，表示设置http请求（或者file:///协议）的 http header field。response一直要被设置成false
    参数：略
    */
    void wkeNetSetMIMEType(Pointer jobPtr, String type);
    /*
    在wkeOnLoadUrlBegin回调里调用，表示设置http请求的MIME type
    参数：略
    */
    String wkeNetGetMIMEType(Pointer jobPtr, Pointer mime);
    /*
    略
    参数：第2个参数可以传nullptr
    */
    void wkeNetSetData(Pointer jobPtr, Pointer buf, int len);
    /*
    在wkeOnLoadUrlEnd里被调用，表示设置hook后缓存的数据
    参数：略
    */
    void wkeNetCancelRequest(Pointer jobPtr);
    /*
    在wkeOnLoadUrlBegin回调里调用，设置后，此请求将被取消。
    参数：略
    */
    int wkeNetGetFavicon(Pointer webView, wkeOnNetGetFaviconCallback callback, Pointer param);
    /*
    获取favicon。
    参数：略
    注意：此接口必须在wkeOnLoadingFinish回调里调用。可以用下面方式来判断是否是主frame的LoadingFinish:

    wkeTempCallbackInfo* temInfo = wkeGetTempCallbackInfo(webView);
			    if (::wkeIsMainFrame(webView, temInfo->frame)) {
			        ::wkeNetGetFavicon(webView, HandleFaviconReceived, divaram);
    }
    */
    void wkeNetHoldJobToAsynCommit(Pointer jobPtr);
    /*
    高级用法。在wkeOnLoadUrlBegin回调里调用。 有时候，wkeOnLoadUrlBegin里拦截到一个请求后，不能马上判断出结果。此时可以调用本接口，然后在 异步的某个时刻，调用wkeNetContinueJob来让此请求继续进行
    参数：略
    */
    int wkeNetGetRequestMethod(Pointer jobPtr);
    /*
    获取此请求的method，如post还是get
    参数：略
    */
    //wkePostBodyElements wkeNetGetPostBody(Pointer jobPtr);
    /*
    获取此请求中的post数据。只有当请求是post时才有效果
    参数：略
    */
    //wkePostBodyElements wkeNetCreatePostBodyElements(Pointer webView, int length);
    /*
    略
    参数：略
    */
    //void wkeNetFreePostBodyElements(wkePostBodyElements elements);
    /*
    略
    参数：略
    */
    //void wkeNetFreePostBodyElements(wkePostBodyElements elements);
    /*
    略
    参数：略
    */
    //wkePostBodyElement wkeNetCreatePostBodyElement(Pointer webView);
    /*
    略
    参数：略
    */
    //void wkeNetFreePostBodyElement(wkePostBodyElement element);
    /*
    这四个接口要结合起来使用。 当wkeOnLoadUrlBegin里判断是post时，可以通过wkeNetCreatePostBodyElements来创建一个新的post数据包。 然后wkeNetFreePostBodyElements来释放原post数据。
    参数：略
    int jsArgCount(jsExecState es)
    获取es里存的参数个数。一般是在绑定的js调用c++回调里使用，判断js传递了多少参数给c++
    参数：略
    jsType jsArgType(jsExecState es, int argIdx)
    判断第argIdx个参数的参数类型。argIdx从是个0开始计数的值。如果超出jsArgCount返回的值，将发生崩溃
    参数：略
    jsValue jsArg(jsExecState es, int argIdx)
    获取第argIdx对应的参数的jsValue值。
    参数：略
    jsType jsTypeOf(jsValue v)
    获取v对应的类型。
    参数：略
    bool jsIsNumber(jsValue v)
    判断v是否为数字
    参数：略
    bool jsIsString(jsValue v)
    略
    参数：略
    bool jsIsBoolean(jsValue v)
    略
    参数：略
    bool jsIsObject(jsValue v)
    当v不是数字、字符串、undefined、null、函数的时候，此接口返回true
    参数：略
    bool jsIsTrue(jsValue v)
    如果v本身是个布尔值，返回对应的true或者false；如果是个对象（JSTYPE_OBJECT），返回false（这里注意）
    参数：略
    bool jsIsFalse(jsValue v)
    等价于!jsIsTrue(v)
    参数：略
    int jsToInt(jsExecState es, jsValue v)
    如果v是个整形或者浮点，返回相应值（如果是浮点，返回取整后的值）。如果是其他类型，返回0（这里注意）
    参数：略
    double jsToDouble(jsExecState es, jsValue v)
    如果v是个浮点形，返回相应值。如果是其他类型，返回0.0（这里注意）
    参数：略
const wchar_t* jsToTempStringW(jsExecState es, jsValue v)
    如果v是个字符串，返回相应值。如果是其他类型，返回L""（这里注意） 另外，返回的字符串不需要外部释放。mb会在下一帧自动释放
    参数：略
const utf8* jsToTempString(jsExecState es, jsValue v)
    同上
    参数：略
const utf8* jsToString(jsExecState es, jsValue v)
    同上，只是返回的是utf8编码
    参数：略
const wchar_t* jsToStringW(jsExecState es, jsValue v)
    略
    参数：略
    jsValue jsInt(int n)
    创建建一个int型的jsValue，注意是创建
    参数：略
    jsValue jsString(jsExecState es, const utf8* str)
    构建一个utf8编码的字符串的的jsValue。str会在内部拷贝保存，注意是创建
    参数：略
    jsValue jsArrayBuffer(jsExecState es, char * buffer, size_t size)
    构建一个js的arraybuffer类型的jaValue。主要用来处理一些二进制数据，注意是创建
    参数：略
    wkeMemBuf* jsGetArrayBuffer(jsExecState es, jsValue value)
    获取一个js的arraybuffer类型的数据。主要用来处理一些二进制数据
    参数：略
    jsValue jsEmptyObject(jsExecState es)
    构建一个临时js object的jsValue，注意是创建
    参数：略
    jsValue jsEvalW(jsExecState es, const wchar_t* str)
    执行一段js，并返回值。
    参数：略
    注意：str的代码会在mb内部自动被包裹在一个function(){}中。所以使用的变量会被隔离 注意：要获取返回值，请写return。这和wke不太一样。wke不需要写retrun
    jsValue jsEvalExW(jsExecState es, const wchar_t* str, bool isInClosure)
    和上述接口的区别是，isInClosure表示是否要包裹一层function(){}。jsEvalW相当于jsEvalExW(es, str, false)
    参数：略
    注意：如果需要返回值，在isInClosure为true时，需要写return，为false则不用
    jsValue jsCall(jsExecState es, jsValue func, jsValue thisValue, jsValue* args, int argCount)
    调用一个func对应的js函数。如果此js函数是成员函数，则需要填thisValue。 否则可以传jsUndefined。args是个数组，个数由argCount控制。 func可以是从js里取的，也可以是自行构造的。
    参数：略
    jsValue jsCallGlobal(jsExecState es, jsValue func, jsValue* args, int argCount)
    调用window上的全局函数
    参数：略
    jsValue jsGet(jsExecState es, jsValue object, const char* prop)
    如果object是个js的object，则获取prop指定的属性。如果object不是js object类型，则返回jsUndefined
    参数：略
    void jsSet(jsExecState es, jsValue object, const char* prop, jsValue value)
    设置object的属性
    参数：略
    jsValue jsGetGlobal(jsExecState es, const char* prop)
    获取window上的属性
    参数：略
    void jsSetGlobal(jsExecState es, const char* prop, jsValue v)
    设置window上的属性
    参数：略
    jsValue jsGetAt(jsExecState es, jsValue object, int index)
    设置js arrary的第index个成员的值，object必须是js array才有用，否则会返回jsUndefined
    参数：略
    void jsSetAt(jsExecState es, jsValue object, int index, jsValue value)
    设置js arrary的第index个成员的值，object必须是js array才有用。
    参数：略
    jsKeys* jsGetKeys(jsExecState es, jsValue object)
    获取object有哪些key
    参数：略
    int jsGetLength(jsExecState es, jsValue object)
    获取js arrary的长度，object必须是js array才有用。
    参数：略
    void jsSetLength(jsExecState es, jsValue object, int length)
    设置js arrary的长度，object必须是js array才有用。
    参数：略
    wkeWebView jsGetWebView(jsExecState es)
    获取es对应的webview
    参数：略
    void jsGC()
    强制垃圾回收
    参数：略
    void fastcall jsBindFunction(const char* name, jsNativeFunction fn, unsigned int argCount)
    绑定一个全局函数到主frame的window上。
    参数：略
    注意：此接口只能绑定主frame，并且特别需要注意的是，因为历史原因，此接口是fastcall调用约定！（但wkeJsBindFunction不是）
    另外此接口和wkeJsBindFunction必须在webview创建前调用
    使用示例：
    c++里：
            --------
    jsValue JS_CALL onNativeFunction(jsExecState es) {
        jsValue v = jsArg(es, 0);
			    const wchar_t* str = jsToTemdivStringW(es, v);
        OutdivutdebugStringW(str);
    }
    jsBindFunction("testCall", onNativeFunction， 1);

    js里：
            --------
            window.testCall('testStrt');
    void jsBindGetter(const char* name, jsNativeFunction fn);
    */
    /*
    对js winows绑定一个属性访问器，在js里windows.XXX这种形式调用时，fn会被调用
    参数：略
    示例：jsBindGetter("XXX")
    */
    //void jsBindSetter(String name, jsNativeFunction fn);
    //void wkeJsBindFunction(String name, wkeJsNativeFunction fn, void* param, unsigned int argCount);
    /*
    和jsBindFunction功能类似，但更方便一点，可以传一个param做自定义数据。
    参数：略
            此接口和wkeJsBindFunction必须在webview创建前调用
    */
    //jsValue jsObject(jsExecState es, jsData* data)
    /*
    构建一个js Objcet，可以传递给js使用。
    参数：*/
    /*
    typedef jsValue(*jsGetPropertyCallback)(jsExecState es, jsValue object, const char* propertyName);
    //属性访问器。在js里XXX.yyy这样调用时，jsGetPropertyCallback会被触发，并且propertyName的值为yyy
    typedef bool(*jsSetPropertyCallback)(jsExecState es, jsValue object, const char* propertyName, jsValue value);
    //属性设置器。在js里XXX.yyy=1这样调用时，jsSetPropertyCallback会被触发，并且propertyName的值为yyy，value的值是字符串类型。可以通过之前提到的字符串操作接口来获取
    typedef jsValue(*jsCallAsFunctionCallback)(jsExecState es, jsValue object, jsValue* args, int argCount);
    //在js里XXX()这样调用时会触发。
    typedef void(*jsFinalizeCallback)(struct tagjsData* data);
    */
    /*
    在js里没人引用，且垃圾回收时会触发
    */
    //jsValue jsFunction(jsExecState es, jsData* data)
    /*
    创建一个主frame的全局函数。jsData的用法如上。js调用：XXX() 此时jsData的callAsFunction触发。 其实jsFunction和jsObject功能基本类似。且jsObject的功能更强大一些
    参数：略
     */
    //jsData* jsGetData(jsExecState es, jsValue value)
    /*
    获取jsObject或jsFunction创建的jsValue对应的jsData指针。
    参数：略
     */
    //jsExceptionInfo* jsGetLastErrorIfException(jsExecState es);
    /*
    当wkeRunJs、jsCall等接口调用时，如果执行的js代码有异常，此接口将获取到异常信息。否则返回nullptr。
    参数：略
    */
}
