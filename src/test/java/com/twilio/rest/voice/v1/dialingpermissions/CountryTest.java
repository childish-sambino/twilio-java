/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.voice.v1.dialingpermissions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class CountryTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VOICE.toString(),
                                          "/v1/DialingPermissions/Countries/US");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Country.fetcher("US").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"iso_code\": \"US\",\"name\": \"United States/Canada\",\"country_codes\": [\"+1\"],\"continent\": \"NORTH_AMERICA\",\"low_risk_numbers_enabled\": false,\"high_risk_special_numbers_enabled\": false,\"high_risk_tollfraud_numbers_enabled\": false,\"url\": \"https://voice.twilio.com/v1/DialingPermissions/Countries/US\",\"links\": {\"highrisk_special_prefixes\": \"https://voice.twilio.com/v1/DialingPermissions/Countries/US/HighRiskSpecialPrefixes\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Country.fetcher("US").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VOICE.toString(),
                                          "/v1/DialingPermissions/Countries");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Country.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadUsResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"content\": [{\"iso_code\": \"US\",\"name\": \"United States/Canada\",\"country_codes\": [\"+1\"],\"continent\": \"NORTH_AMERICA\",\"low_risk_numbers_enabled\": false,\"high_risk_special_numbers_enabled\": false,\"high_risk_tollfraud_numbers_enabled\": false,\"url\": \"https://voice.twilio.com/v1/DialingPermissions/Countries/US\",\"links\": {\"highrisk_special_prefixes\": \"https://voice.twilio.com/v1/DialingPermissions/Countries/US/HighRiskSpecialPrefixes\"}}],\"meta\": {\"first_page_url\": \"https://voice.twilio.com/v1/DialingPermissions/Countries?PageSize=50&Page=0\",\"key\": \"content\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://voice.twilio.com/v1/DialingPermissions/Countries?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Country.reader().read());
    }
}