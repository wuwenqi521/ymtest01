/**
 * Copyright (c) 2012 Trusted Software and Mobile Computing(TSMC)
 * All right reserved.
 *
 * Created on Apr 24, 2012 12:42:24 PM
 * http://jarg.iteye.com/
 * Author: Jarg Yee <yeshaoting@gmail.com>
 */
package com.iteye.jarg.monitor.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import com.ice.jni.registry.RegDWordValue;
import com.ice.jni.registry.Registry;
import com.ice.jni.registry.RegistryKey;
import com.ice.jni.registry.RegistryValue;

/**
 * TODO 使用Internet代理服务器工具类
 * 2012-04-25 11:49
 */
public class InternetUtil
{

	/** 获取系统配置句柄 */
	private static final Properties prop = System.getProperties();

	/** 注册表中Internet表项位置 */
	private static final String Internet = "Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings";


	/** 初始化代理 from Internet Settings */
	public static void initProxy()
	{

		try
		{
			// 注册表表项值
			RegistryKey registryKey = Registry.openSubkey(Registry.HKEY_CURRENT_USER, Internet, RegistryKey.ACCESS_READ);

			// 注册表表项键
			RegistryValue registryValue = registryKey.getValue("ProxyEnable");
			boolean proxyEnable = ((RegDWordValue) registryValue).getData() != 0;	// 代理设置是否开启
//			System.out.println("IE 是否启用了代理设置: " + proxyEnable);

			if (proxyEnable == true)	// 开启了Internet代理
			{
				registryValue = registryKey.getValue("ProxyServer");
				String proxyServer = new String(registryValue.getByteData());
				ProxyUtil.initProxy(proxyServer);
				System.out.println("使用IE代理服务器.");
			}
		}
		catch (Exception e)
		{
			System.out.println("ERROR:操作Windows注册表失败.");
//			e.printStackTrace();
		}
	}

}