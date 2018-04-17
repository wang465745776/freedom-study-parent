package com.wangguitang.freedom.study.design.pattern.proxy;

public class Client {

	public static void main(String[] args) {
		Subject subject = new Proxy(new RealSubject());
		
		subject.request();
	}
}
