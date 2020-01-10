package com.imf.utils;

import com.siemens.ct.its.smap.common.constants.ReturnCode;
import com.siemens.ct.its.smap.common.exception.SmapAuthenticateTypeNotSatisfied;
import com.siemens.ct.its.smap.common.exception.SmapAuthenticateUserBySessionIdException;
import com.siemens.ct.its.smap.common.exception.SmapTicketException;
import com.siemens.ct.its.smap.common.exception.SmapUserException;
import com.siemens.ct.its.smap.sso2.common.model.SessionDataBall;
import com.siemens.ct.its.smap.sso2.common.model.TicketBall;
import com.siemens.ct.its.smap2.client.XSmap2Client;
import com.siemens.ct.its.smap2.client.XSmap2ClientFactory;
import org.testng.Assert;

public class ExampleAll {
	static String localAppId = "party@hq.cmcc";
	static String authenticateUrls = "xmis://10.1.55.251:11000";

	/**
	 * SSO 接收方： 认证会话数据，并获取用户uid
	 * @param sessionData
	 * @return SSO UID
	 * @throws SmapAuthenticateUserBySessionIdException
	 * @throws SmapAuthenticateTypeNotSatisfied
	 */
	public String userLoginBySessionData(String sessionData) throws SmapAuthenticateUserBySessionIdException,
			SmapAuthenticateTypeNotSatisfied {
		XSmap2Client client = XSmap2ClientFactory.getInstance(localAppId, authenticateUrls);
		if (client != null) {
			System.out.println("-------accessApplication: " + sessionData);
			TicketBall tb = client.accessApplication(sessionData);

			String uid = tb.getTicket().getUid().toLowerCase();
			// GET MORE INFO OF THE USER IN THE TICKET
			// tb.getTicket().getDisplayName()
			// .....

			return uid;
		} else {
			return "Client Init Error";
		}
	}

	/**
	 * 通过静态密码出发动态密码
	 * @param uid
	 * @param password
	 * @return
	 */
	public String triggerOtpByPassword(String uid, String password) {
		XSmap2Client client = XSmap2ClientFactory.getInstance(localAppId, authenticateUrls);
		int result = client.triggerOtpByPassword(uid, password);
		return "TriggerOtp return Message:" + ReturnCode.translate(result);
	}

	/**
	 * 动态／静态密码认证
	 * @param uid
	 * @param password
	 *            [password | otp(动态密码)]
	 * @param authType
	 *            [static(静态密码) | dynamic(动态密码)]
	 * @return
	 */
	public String userLoginByPassword(String uid, String password, String authType) {
		XSmap2Client client = XSmap2ClientFactory.getInstance(localAppId, authenticateUrls);
		int result = -1;
		if (client != null) {
			if (authType.equalsIgnoreCase("static"))
				result = client.authenticateUserByPassword(uid, password);
			else
				result = client.authenticateUserByOtp(uid, password);
		}
		if (result == ReturnCode.OK) {
			return "Auth User Error,Error Message" + ReturnCode.translate(result);
		}
		return "Client Init Error";
	}

	/**
	 * SSO发起方，获取会话数据
	 * @param uid
	 * @param remoteAppId
	 *            [remote application]
	 * @return SSO SESSION DATA, post/get the session data to the remote
	 *         application.
	 */
	public static  String getSSOSessionData(String uid, String remoteAppId) {
		XSmap2Client client = XSmap2ClientFactory.getInstance(localAppId, authenticateUrls , true , 500);
		byte[] ticket = null;
		SessionDataBall sessionData = null;
		try {
			ticket = client.acquireTicketByUid(uid);
		} catch (SmapUserException e) {
			e.printStackTrace();
		}
		Assert.assertNotNull(ticket);
		try {
			sessionData = client.acquireSessionDataTicket(ticket, remoteAppId);
		} catch (SmapTicketException e) {
			e.printStackTrace();
		}
		System.out.println(sessionData.getSessionData());
		return sessionData.getSessionData();
	}
	
	/**
	 * 获取用户数据(手机号）
	 * 
	 * @param uid
	 * 
	 * @return user information, post/get the user data.
	 */
//	public String getUserMobile(String uid) {
//		XSmap2Client client = getClient();
//		try {
//			byte[] ticketBytes = null;
//			ticketBytes = client.acquireTicketByUid(uid);
//			Assert.assertNotNull(ticketBytes);
//			Ticket ticket = client.deserilizationTicket(ticketBytes);
//			// GET MORE INFO OF THE USER IN THE TICKET
//			// ticket.getDisplayName()
//			// .....
//			return ticket.getMobile();
//		} catch (SmapUserException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	public static void main(String[] args) {
		String ssoSessionData = getSSOSessionData("99999901", "CMUONLINE@HQ.CMCC");
		System.out.println("获取的数据 ：" +ssoSessionData);
	}

}
