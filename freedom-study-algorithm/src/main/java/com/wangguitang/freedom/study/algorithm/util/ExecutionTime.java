package com.wangguitang.freedom.study.algorithm.util;

import java.util.Date;

/**
 * 此类用于方便获取执行时间
 * @author freedom wang
 * @date 2018年3月23日下午3:15:58
 * @version 1.0
 */
public class ExecutionTime {
	private Date beginDate;

	public ExecutionTime() {
		beginDate = new Date();
	}
	
	/**
	 * 刷新基准时间
	 * @author freedom wang
	 * @date 2018年3月24日上午9:56:22
	 * @version 1.0
	 */
	public void refreshTime() {
		beginDate = new Date();
	}

	/**
	 * 获取执行时间
	 * @return 执行毫秒数
	 * @author freedom wang
	 * @date 2018年3月23日下午3:23:56
	 * @version 1.0
	 */
	public long getTime() {
		Date currentDate = new Date();
		return currentDate.getTime() - beginDate.getTime();
	}

}
