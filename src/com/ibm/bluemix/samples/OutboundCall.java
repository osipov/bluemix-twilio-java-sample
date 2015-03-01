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

import static com.ibm.bluemix.samples.TwilioConfig.FROM;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;

import com.twilio.sdk.verbs.Dial;
import com.twilio.sdk.verbs.Number;
import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.TwiMLException;

@Path("/outbound")
@Produces("application/xml")
public class OutboundCall {

	@POST
	public String onOutboundCallRequest(@FormParam("to") String to) throws TwiMLException {
		TwiMLResponse twiml = new TwiMLResponse();
		Dial dial = new Dial();
		dial.append(new Number(to));
		dial.setCallerId(FROM);
		twiml.append(dial);
		return twiml.toXML();
	}
}