package Objetos;
/**
 * 
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SMS {
	
	public static void EnviarSMS(String Texto, String Numero) {
		String ACCOUNT_SID = "AC50730ef47ec50d1b61a4eeddafc95677";
		String AUTH_TOKEN = "2acce06d287bebd64a9fc1ae1d6e9e36 ";
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber("+506"+Numero), // to
				new PhoneNumber("+12057843165"), // from
				Texto).create();

		System.out.println(message.getSid());
	}
	

}
