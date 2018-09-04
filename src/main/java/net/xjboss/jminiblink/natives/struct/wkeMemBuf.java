package net.xjboss.jminiblink.natives.struct;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class wkeMemBuf extends Structure {
	public int size;
	/** C type : void* */
	public Pointer data;
	public int length;
	public wkeMemBuf() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("size", "data", "length");
	}
	/** @param data C type : void* */
	public wkeMemBuf(int size, Pointer data, int length) {
		super();
		this.size = size;
		this.data = data;
		this.length = length;
	}
	public wkeMemBuf(Pointer peer) {
		super(peer);
	}
	protected ByReference newByReference() { return new ByReference(); }
	protected ByValue newByValue() { return new ByValue(); }
	protected wkeMemBuf newInstance() { return new wkeMemBuf(); }
	public static class ByReference extends wkeMemBuf implements Structure.ByReference {
		
	};
	public static class ByValue extends wkeMemBuf implements Structure.ByValue {
		
	};
}
