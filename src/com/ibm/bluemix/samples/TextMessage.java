/*
* Copyright IBM Corp. 2014
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.ibm.bluemix.samples;

import static com.ibm.bluemix.samples.TwilioConfig.ACCOUNT_SID;
import static com.ibm.bluemix.samples.TwilioConfig.AUTH_TOKEN;
import static com.ibm.bluemix.samples.TwilioConfig.FROM;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;

import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Path("/sms")
@Produces("application/json")
public class TextMessage {

	@POST
	public String onTextMessageRequest(@FormParam("to") String to, @FormParam("body") String body) throws TwilioRestException {
	
		sendTextMessage(FROM, to, body);

		return "{\"success\":\"true\"}";

	}

	private static final void sendTextMessage(String from, String to, String body) throws TwilioRestException {
	    // Create a rest client
	    final TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

	    // Get the main account (The one we used to authenticate the client)
	    final Account account = client.getAccount();

	    // Create and send an SMS
		MessageFactory messageFactory = account.getMessageFactory();
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("To", to)); 
		params.add(new BasicNameValuePair("From", FROM));
		params.add(new BasicNameValuePair("Body", body));
		Message sms = messageFactory.create(params);			
	}
}