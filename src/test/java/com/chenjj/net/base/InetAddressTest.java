package com.chenjj.net.base;

import java.net.InetAddress;

import org.junit.Test;

public class InetAddressTest {

	@Test
	public void test(){
		try {
			InetAddress localInetAddress = InetAddress.getLocalHost();// 本地
			InetAddress remoteInetAddress = InetAddress.getByName("www.baidu.com");// 远程
			System.out.println("本机ip信息:"+localInetAddress.getHostAddress()+"	"+localInetAddress.getHostName());
			System.out.println("远程ip信息:"+remoteInetAddress.getHostAddress()+"	"+remoteInetAddress.getHostName());
			System.out.println("本机是否可达:"+localInetAddress.isReachable(3000));
			System.out.println("远程是否可达:"+remoteInetAddress.isReachable(10000));
			System.out.println(localInetAddress.isAnyLocalAddress()+"	"+localInetAddress.isLinkLocalAddress()+"	"+localInetAddress.isLoopbackAddress());
			System.out.println(remoteInetAddress.isAnyLocalAddress()+"	"+remoteInetAddress.isLinkLocalAddress()+"	"+remoteInetAddress.isLoopbackAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
