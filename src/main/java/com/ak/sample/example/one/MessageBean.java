package com.ak.sample.example.one;

public class MessageBean {
	String msg;

	public MessageBean(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MessageBean [msg=" + msg + "]";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
