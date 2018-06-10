package com.seckill.test;

import com.seckill.util.HttpUtil;

/**
 * 初级方案
 * @创建时间：2018年6月10日
 */
public class SeckillTest1 {
	
	
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i <= 2000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					seckill();
				}
			}).start();
		}
		
		System.err.println("=======================" + (System.currentTimeMillis() - startTime) + "==========================");

	}

	public static void seckill() {
		long threadId = Thread.currentThread().getId();

		String str = HttpUtil.doGet("http://localhost:81/seckill?user_id=" + threadId);
		
		System.err.println(str);
	}

}