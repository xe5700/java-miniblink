package net.xjboss.jminiblink.webview;

import com.sun.jna.Pointer;
import net.xjboss.jminiblink.natives.enums.wkeRequestType;

public interface BlinkViewNet {
    void setHTTPHeaderField(String key,String value,boolean response);
    void setMIMEType(String type);
    String getMIMEType(Pointer mine);
    void setData(Pointer jobPtr,byte[] buf,int len);
    void cancelRequest(Pointer jobPtr);
    void holdJobToAsynCommit(Pointer jobPtr);
    wkeRequestType getRequestMethod(Pointer jobPtr);
    Pointer getPostBody(Pointer jobPtr);
    Pointer createPostBodyElements(long length);
    void freePostBodyElements(Pointer elements);
    Pointer createPostBodyElement();
    void freePostBodyElement(Pointer element);
}
