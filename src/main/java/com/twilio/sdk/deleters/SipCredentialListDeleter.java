package com.twilio.sdk.deleters;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.SipCredentialList;

public class SipCredentialListDeleter extends Deleter<SipCredentialList> {

    private final String sid;

    public SipCredentialListDeleter(final String sid) {
        this.sid = sid;
    }

    public SipCredentialListDeleter(final SipCredentialList target) {
        this(target.getSid());
    }

    @Override
    public void execute(final TwilioRestClient client)  {
        Request request = new Request(HttpMethod.DELETE, "/SIP/CredentialLists/" + sid + ".json");
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SipCredentialList delete failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_NO_CONTENT) {
            throw new ApiException("SipCredentialList delete failed: [" + response.getStatusCode() + "] " + response.getContent());
        }
    }
}