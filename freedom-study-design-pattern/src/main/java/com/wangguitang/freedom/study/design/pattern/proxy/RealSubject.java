package com.wangguitang.freedom.study.design.pattern.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealSubject implements Subject{
	
	private Logger logger = LoggerFactory.getLogger(RealSubject.class);

	@Override
	public void request() {
		logger.info("RealSubject#request is invoke");
	}

}
