package com.wangguitang.freedom.study.design.pattern.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Proxy implements Subject {

	private Logger logger = LoggerFactory.getLogger(Proxy.class);

	private Subject subject;

	public Proxy(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void request() {
		try {
			logger.info("before request");
			subject.request();
			logger.info("after request");
		} catch (Exception e) {
			logger.error("exception request");
			throw e;
		} finally {
			logger.info("finally request");
		}
	}

}
