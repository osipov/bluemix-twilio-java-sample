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
import static com.ibm.bluemix.samples.TwilioConfig.APP_SID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.twilio.sdk.client.TwilioCapability;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;

@Path("/capability")
@Produces("application/json")
public class Capability {

	@GET
	public String onCapabilityRequest() throws TwilioCapability.DomainException {
		TwilioCapability capability = new TwilioCapability(ACCOUNT_SID, AUTH_TOKEN);
		capability.allowClientOutgoing(APP_SID);
		
		String token = capability.generateToken();

		return String.format("{\"token\":\"%s\"}", token);
	}
}