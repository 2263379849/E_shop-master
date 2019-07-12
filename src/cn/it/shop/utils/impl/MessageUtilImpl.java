package cn.it.shop.utils.impl;


import java.io.IOException;

import org.apache.http.testserver.HttpClient;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import cn.it.shop.utils.MessageUtil;


/**
 * @Description: TODO(ʵ�ֶ��ŷ��͹���)
 * @author Ni Shengwu
 *
 */
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {
	
	@Override
	public void sendMessage(String phoneNum, String id) {
		//1. �������
		HttpClient client = new HttpClient();
		//2. ��������ķ�ʽ��get/post
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//3. ��������Ĳ�����Ϣ
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid", "eson_15");
		post.setParameter("Key", "0537729d0b59a7e7358b");
		post.setParameter("smsMob", phoneNum);
		post.setParameter("smsText", "���Ķ���" + id + "�Ѿ����ɣ�");
		//4. �ύ���󲢷���״̬��
		try {
			int code = 0;
			code = client.executeMethod(post);
			System.out.println("http���ص�״̬�룺" + code);
			//5. ��ȡ�������˷��ص�������Ϣ
			String result = post.getResponseBodyAsString();
			System.out.println("���ŷ��ͽ��Ϊ��" + result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			post.releaseConnection();
		}
	}
/*	
	public static void main(String[] args) throws Exception {
		//1. �������
		HttpClient client = new HttpClient();
		//2. ��������ķ�ʽ��get/post
		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn/");
		//3. ��������Ĳ�����Ϣ
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid", "eson_15");
		post.setParameter("Key", "0537729d0b59a7e7358b");
		post.setParameter("smsMob", "15216771570");
		post.setParameter("smsText", "����һ�£�");
		//4. �ύ���󲢷���״̬��
		int code = client.executeMethod(post);
		System.out.println("http���ص�״̬�룺" + code);
		//5. ��ȡ�������˷��ص�������Ϣ
		String result = post.getResponseBodyAsString();
		System.out.println("���ŷ��ͽ��Ϊ��" + result);
			
	}*/
}
