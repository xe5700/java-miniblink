package net.xjboss.jminiblink.webview;

import com.sun.jna.Pointer;
import com.sun.jna.WString;
import lombok.Getter;
import lombok.val;
import net.xjboss.jminiblink.BlinkBrowser;
import net.xjboss.jminiblink.events.box.BlinkAlertBoxEvent;
import net.xjboss.jminiblink.events.box.BlinkConfirmBoxEvent;
import net.xjboss.jminiblink.events.box.BlinkPromptBoxEvent;
import net.xjboss.jminiblink.events.job.BlinkOnLoadUrlBeginEvent;
import net.xjboss.jminiblink.events.job.BlinkOnLoadUrlEndEvent;
import net.xjboss.jminiblink.events.net.*;
import net.xjboss.jminiblink.events.paint.BlinkOnPaintBitUpdatedEvent;
import net.xjboss.jminiblink.events.paint.BlinkOnPaintUpdatedEvent;
import net.xjboss.jminiblink.events.window.BlinkOnWindowClosingEvent;
import net.xjboss.jminiblink.events.window.BlinkOnWindowDestroyEvent;
import net.xjboss.jminiblink.natives.NativeMiniBlink;
import net.xjboss.jminiblink.natives.enums.wkeNavigationType;
import net.xjboss.jminiblink.natives.enums.wkeRequestType;
import net.xjboss.jminiblink.objects.AObj;

import static com.sun.jna.Pointer.NULL;

public class BlinkView {
    protected final NativeMiniBlink fNative;
    @Getter
    protected final Pointer fBWebView;
    protected final BlinkBrowser fBrowser;

    public BlinkView(NativeMiniBlink mNative, Pointer mBWebView, BlinkBrowser mBrowser) {
        this.fNative = mNative;
        this.fBWebView = mBWebView;
        this.fBrowser = mBrowser;
        init();
    }
    private void init(){
        fNative.wkeOnDownload(fBWebView,((webView, param, url) -> fBrowser.getListenerManager().callEvent(new BlinkDownloadEvent(this,url))),NULL);
        fNative.wkeOnDocumentReady(fBWebView,((webView, param, url, buf) -> fBrowser.getListenerManager().callEvent(new BlinkOnDocumentReadyEvent(this,url,buf))),NULL);
        fNative.wkeOnTitleChanged(fBWebView,((webView, param, title) -> fBrowser.getListenerManager().callEvent(new BlinkOnTitleChangedEvent(this,fNative.wkeGetString(title)))),NULL);
        fNative.wkeOnAlertBox(fBWebView,((webView, param, buffer, msg) -> fBrowser.getListenerManager().callEvent(new BlinkAlertBoxEvent(this,fNative.wkeGetString(msg)))),NULL);
        fNative.wkeOnConfirmBox(fBWebView,(((webView, param, buffer, msg) ->fBrowser.getListenerManager().callEvent(new BlinkConfirmBoxEvent(this,fNative.wkeGetString(msg))))),NULL);
        fNative.wkeOnPromptBox(fBWebView,((webView, param, buffer, msg, defaultResult, result) -> fBrowser.getListenerManager().callEvent(new BlinkPromptBoxEvent(this,fNative.wkeGetString(msg),fNative.wkeGetString(defaultResult),fNative.wkeGetString(result)))),NULL);
        //fNative.wkeOnConsole(fBWebView,(((webView, param, level, message, sourceName, sourceLine, stackTrace) -> fBrowser.getListenerManager().callEvent(new Blink))));
        //fNative.wkeOnCreateView(fBWebView,(((webView, param, buffer, navigationType, url, windowFeatures) -> fBrowser.getListenerManager().callEvent(new BlinkOnC))));

        fNative.wkeOnLoadUrlBegin(fBWebView,(((webView, param, url, job) ->
            !fBrowser.getListenerManager().callEvent(new BlinkOnLoadUrlBeginEvent(this,url,job))
        )),NULL);

        fNative.wkeOnMouseOverUrlChanged(fBWebView,((webView, param, title) -> fBrowser.getListenerManager().callEvent(new BlinkOnMouseOverUrlChangedEvent(this,fNative.wkeGetString(title)))),NULL);
        fNative.wkeOnLoadUrlEnd(fBWebView,(((webView, param, url, job,buf,len) -> !fBrowser.getListenerManager().callEvent(new BlinkOnLoadUrlEndEvent(this,url,job,buf.getByteArray(0,len))))),NULL);
        fNative.wkeOnPaintBitUpdated(fBWebView,((webView, param, buffer, r, width, height) -> fBrowser.getListenerManager().callEvent(new BlinkOnPaintBitUpdatedEvent(this,buffer.getByteArray(0,width*height),r,width,height))),NULL);
        fNative.wkeOnPaintUpdated(fBWebView,(((webView, param, hdc, x, y, cx, cy) -> fBrowser.getListenerManager().callEvent(new BlinkOnPaintUpdatedEvent(this,hdc,x,y,cx,cy)))),NULL);
        fNative.wkeOnNavigation(fBWebView,((webView, param, navigationType, url) -> fBrowser.getListenerManager().callEvent(new BlinkOnNavigationEvent(this,wkeNavigationType.values()[navigationType],fNative.wkeGetString(url)))),NULL);
        //fNative.wkeOnURLChanged2(fBWebView,((webView, param, title, frameId, url) -> fBrowser.getListenerManager().callEvent(new BlinkURLChangedEvent(this,fNative.wkeGetString(url),frameId))),NULL);
        //fNative.wkeOnWillMediaLoad();
        //fNative.wkeOnWillReleaseScriptContext();
        fNative.wkeOnWindowClosing(fBWebView,((webView, param) -> fBrowser.getListenerManager().callEvent(new BlinkOnWindowClosingEvent(this))),NULL);
        fNative.wkeOnWindowDestroy(fBWebView,((webView, param) -> fBrowser.getListenerManager().callEvent(new BlinkOnWindowDestroyEvent(this))),NULL);
    }

    private final BlinkViewController fController =new BlinkViewController() {
        public boolean back(){
            val obj=new AObj<Boolean>();
            
            fBrowser.autoRunTask(()->obj.setObj(fNative.wkeGoBack(fBWebView)));
            return obj.getObj();
        }

        public boolean forward(){
            val obj=new AObj<Boolean>();
            
            fBrowser.autoRunTask(()->obj.setObj(fNative.wkeGoForward(fBWebView)));
            return obj.getObj();
        }

        public void stop(){
            fBrowser.autoRunTask(()->fNative.wkeStopLoading(fBWebView));
        }
        public boolean reload(){
            val obj=new AObj<Boolean>();
            fBrowser.autoRunTask(()->obj.setObj(fNative.wkeReload(fBWebView)));
            return obj.getObj();
        }

        public void loadURL(String url) {
            fBrowser.autoRunTask(()->fNative.wkeLoadURL(fBWebView,url));
        }

        public void loadHTML(String html) {
            fBrowser.autoRunTask(()->fNative.wkeLoadHTML(fBWebView,html));
        }

        public void loadHTMLWithBaseUrl(String html, String baseUrl) {
            fBrowser.autoRunTask(()->fNative.wkeLoadHtmlWithBaseUrl(fBWebView,html,baseUrl));
        }

        public void loadFile(String filename) {
            fBrowser.autoRunTask(()->fNative.wkeLoadFile(fBWebView,filename));
        }
    };
    private final BlinkViewEditor fEditor =new BlinkViewEditor() {
        public void selectAll() {
            fBrowser.autoRunTask(()->fNative.wkeEditorSelectAll(fBWebView));
        }

        public void unselect() {
            fBrowser.autoRunTask(()->fNative.wkeEditorUnSelect(fBWebView));
        }

        public void copy() {
            fBrowser.autoRunTask(()->fNative.wkeEditorCopy(fBWebView));
        }

        public void delete() {
            fBrowser.autoRunTask(()->fNative.wkeEditorDelete(fBWebView));
        }

        public void undo() {
            fBrowser.autoRunTask(()->fNative.wkeEditorUndo(fBWebView));
        }

        public void redo() {
            fBrowser.autoRunTask(()->fNative.wkeEditorRedo(fBWebView));
        }

        public void cut() {
            fBrowser.autoRunTask(()->fNative.wkeEditorCut(fBWebView));
        }
    };

    private final BlinkViewNet fNet=new BlinkViewNet() {
        @Override
        public void setHTTPHeaderField(String key,String value,boolean response){
            fBrowser.autoRunTask(()-> fNative.wkeNetSetHTTPHeaderField(fBWebView,new WString(key),new WString(value),response));
        }

        @Override
        public void setMIMEType(String type){
            fBrowser.autoRunTask(()-> fNative.wkeNetSetMIMEType(fBWebView,type));
        }

        @Override
        public String getMIMEType(Pointer mine){
            val aobj=new AObj<String>();
            fBrowser.autoRunTask(()->aobj.setObj(fNative.wkeNetGetMIMEType(fBWebView,mine)));
            return aobj.getObj();
        }

        @Override
        public void setData(Pointer jobPtr,byte[] buf,int len){
            val p=Pointer.createConstant(buf.length);
            int i=0;
            for(byte b:buf){
                p.setByte(i++,b);
            }
            fBrowser.autoRunTask(()->fNative.wkeNetSetData(jobPtr,p,len));
        }

        @Override
        public void cancelRequest(Pointer jobPtr){
            fBrowser.autoRunTask(()->fNative.wkeNetCancelRequest(jobPtr));
        }

        @Override
        public void holdJobToAsynCommit(Pointer jobPtr){
            fBrowser.autoRunTask(()->fNative.wkeNetHoldJobToAsynCommit(jobPtr));
        }

        @Override
        public wkeRequestType getRequestMethod(Pointer jobPtr){
            val obj=new AObj<wkeRequestType>();
            fBrowser.autoRunTask(()->obj.setObj(wkeRequestType.values()[fNative.wkeNetGetRequestMethod(jobPtr)]));
            return obj.getObj();
        }

        @Override
        public Pointer getPostBody(Pointer jobPtr){
            throw new UnsupportedOperationException();
        }

        @Override
        public Pointer createPostBodyElements(long length){
            throw new UnsupportedOperationException();
        }

        @Override
        public void freePostBodyElements(Pointer elements) {
            throw new UnsupportedOperationException();

        }

        @Override
        public Pointer createPostBodyElement() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void freePostBodyElement(Pointer element) {
            throw new UnsupportedOperationException();
        }
    };

    public BlinkViewController control(){
        return fController;
    }

    public BlinkViewEditor editor(){return fEditor;}

    public BlinkViewNet net(){
        return fNet;
    }

    public boolean isReady(){
        val obj=new AObj<Boolean>();
        fBrowser.autoRunTask(()->obj.setObj(fNative.wkeIsDocumentReady(fBWebView)));
        return obj.getObj();
    }

    public String getTitle(){
        val obj=new AObj<String>();
        fBrowser.autoRunTask(()->obj.setObj(fNative.wkeGetTitle(fBWebView)));
        return obj.getObj();
    }

    public String getCookie(){
        val obj=new AObj<String>();
        fBrowser.autoRunTask(()->obj.setObj(fNative.wkeGetCookie(fBWebView)));
        return obj.getObj();
    }

    public void setCookie(String url,String cookie){
        fBrowser.autoRunTask(()->fNative.wkeSetCookie(fBWebView,url,cookie));
    }

    public void setCookieEnabled(boolean enable){
        fBrowser.autoRunTask(()->fNative.wkeSetCookieEnabled(fBWebView,enable));
    }

    public String getURL(){
        val obj=new AObj<String>();
        fBrowser.autoRunTask(()->obj.setObj(fNative.wkeGetURL(fBWebView)));
        return obj.getObj();
    }
    public void setNavigationToNewWindowEnable(boolean b){
        fNative.wkeSetNavigationToNewWindowEnable(fBWebView,b);
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        fNative.wkeDestroyWebWindow(fBWebView);
    }
}
