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

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONObject;

public class TwilioConfig {

	public static final String FROM = "";
	public static final String ACCOUNT_SID = getAccountSid() == null ? "" : getAccountSid();
	public static final String AUTH_TOKEN = getAuthToken() == null ? "" : getAuthToken(); 
	public static final String APP_SID = "";

	public static String getAccountSid() {
		return VCAP_SERVICES.get("user-provided", "0", "credentials", "accountSID");
	}
	public static String getAuthToken() {
		return VCAP_SERVICES.get("user-provided", "0", "credentials", "authToken");
	}
}