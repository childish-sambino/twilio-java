/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resource.api.v2010.account.usage.record;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.converter.DateConverter;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.reader.api.v2010.account.usage.record.YesterdayReader;
import com.twilio.sdk.resource.Resource;
import com.twilio.sdk.resource.RestException;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Yesterday extends Resource {
    private static final long serialVersionUID = 99256854755798L;

    public enum Category {
        AUTHY_AUTHENTICATIONS("authy-authentications"),
        AUTHY_CALLS_OUTBOUND("authy-calls-outbound"),
        AUTHY_MONTHLY_FEES("authy-monthly-fees"),
        AUTHY_PHONE_INTELLIGENCE("authy-phone-intelligence"),
        AUTHY_PHONE_VERIFICATIONS("authy-phone-verifications"),
        AUTHY_SMS_OUTBOUND("authy-sms-outbound"),
        CALL_PROGESS_EVENTS("call-progess-events"),
        CALLERIDLOOKUPS("calleridlookups"),
        CALLS("calls"),
        CALLS_CLIENT("calls-client"),
        CALLS_GLOBALCONFERENCE("calls-globalconference"),
        CALLS_INBOUND("calls-inbound"),
        CALLS_INBOUND_LOCAL("calls-inbound-local"),
        CALLS_INBOUND_MOBILE("calls-inbound-mobile"),
        CALLS_INBOUND_TOLLFREE("calls-inbound-tollfree"),
        CALLS_OUTBOUND("calls-outbound"),
        CALLS_RECORDINGS("calls-recordings"),
        CALLS_SIP("calls-sip"),
        CALLS_SIP_INBOUND("calls-sip-inbound"),
        CALLS_SIP_OUTBOUND("calls-sip-outbound"),
        CARRIER_LOOKUPS("carrier-lookups"),
        CONVERSATIONS("conversations"),
        CONVERSATIONS_API_REQUESTS("conversations-api-requests"),
        CONVERSATIONS_CONVERSATION_EVENTS("conversations-conversation-events"),
        CONVERSATIONS_ENDPOINT_CONNECTIVITY("conversations-endpoint-connectivity"),
        CONVERSATIONS_EVENTS("conversations-events"),
        CONVERSATIONS_PARTICIPANT_EVENTS("conversations-participant-events"),
        CONVERSATIONS_PARTICIPANTS("conversations-participants"),
        IP_MESSAGING("ip-messaging"),
        IP_MESSAGING_COMMANDS("ip-messaging-commands"),
        IP_MESSAGING_DATA_STORAGE("ip-messaging-data-storage"),
        IP_MESSAGING_DATA_TRANSFER("ip-messaging-data-transfer"),
        IP_MESSAGING_ENDPOINT_CONNECTIVITY("ip-messaging-endpoint-connectivity"),
        LOOKUPS("lookups"),
        MEDIASTORAGE("mediastorage"),
        MMS("mms"),
        MMS_INBOUND("mms-inbound"),
        MMS_INBOUND_LONGCODE("mms-inbound-longcode"),
        MMS_INBOUND_SHORTCODE("mms-inbound-shortcode"),
        MMS_OUTBOUND("mms-outbound"),
        MMS_OUTBOUND_LONGCODE("mms-outbound-longcode"),
        MMS_OUTBOUND_SHORTCODE("mms-outbound-shortcode"),
        MONITOR_READS("monitor-reads"),
        MONITOR_STORAGE("monitor-storage"),
        MONITOR_WRITES("monitor-writes"),
        NUMBER_FORMAT_LOOKUPS("number-format-lookups"),
        PHONENUMBERS("phonenumbers"),
        PHONENUMBERS_CPS("phonenumbers-cps"),
        PHONENUMBERS_EMERGENCY("phonenumbers-emergency"),
        PHONENUMBERS_LOCAL("phonenumbers-local"),
        PHONENUMBERS_MOBILE("phonenumbers-mobile"),
        PHONENUMBERS_SETUPS("phonenumbers-setups"),
        PHONENUMBERS_TOLLFREE("phonenumbers-tollfree"),
        PREMIUMSUPPORT("premiumsupport"),
        RECORDINGS("recordings"),
        RECORDINGSTORAGE("recordingstorage"),
        SHORTCODES("shortcodes"),
        SHORTCODES_CUSTOMEROWNED("shortcodes-customerowned"),
        SHORTCODES_MMS_ENABLEMENT("shortcodes-mms-enablement"),
        SHORTCODES_MPS("shortcodes-mps"),
        SHORTCODES_RANDOM("shortcodes-random"),
        SHORTCODES_UK("shortcodes-uk"),
        SHORTCODES_VANITY("shortcodes-vanity"),
        SMS("sms"),
        SMS_INBOUND("sms-inbound"),
        SMS_INBOUND_LONGCODE("sms-inbound-longcode"),
        SMS_INBOUND_SHORTCODE("sms-inbound-shortcode"),
        SMS_OUTBOUND("sms-outbound"),
        SMS_OUTBOUND_LONGCODE("sms-outbound-longcode"),
        SMS_OUTBOUND_SHORTCODE("sms-outbound-shortcode"),
        TASKROUTER_TASKS("taskrouter-tasks"),
        TOTALPRICE("totalprice"),
        TRANSCRIPTIONS("transcriptions"),
        TRUNKING_CPS("trunking-cps"),
        TRUNKING_EMERGENCY_CALLS("trunking-emergency-calls"),
        TRUNKING_ORIGINATION("trunking-origination"),
        TRUNKING_ORIGINATION_LOCAL("trunking-origination-local"),
        TRUNKING_ORIGINATION_MOBILE("trunking-origination-mobile"),
        TRUNKING_ORIGINATION_TOLLFREE("trunking-origination-tollfree"),
        TRUNKING_RECORDINGS("trunking-recordings"),
        TRUNKING_SECURE("trunking-secure"),
        TRUNKING_TERMINATION("trunking-termination"),
        TURNMEGABYTES("turnmegabytes"),
        TURNMEGABYTES_AUSTRALIA("turnmegabytes-australia"),
        TURNMEGABYTES_BRASIL("turnmegabytes-brasil"),
        TURNMEGABYTES_IRELAND("turnmegabytes-ireland"),
        TURNMEGABYTES_JAPAN("turnmegabytes-japan"),
        TURNMEGABYTES_SINGAPORE("turnmegabytes-singapore"),
        TURNMEGABYTES_USEAST("turnmegabytes-useast"),
        TURNMEGABYTES_USWEST("turnmegabytes-uswest");
    
        private final String value;
        
        private Category(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        @JsonCreator
        public static Category forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return Category.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a YesterdayReader to execute read.
     * 
     * @param accountSid The account_sid
     * @return YesterdayReader capable of executing the read
     */
    public static YesterdayReader read(final String accountSid) {
        return new YesterdayReader(accountSid);
    }

    /**
     * Converts a JSON String into a Yesterday object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Yesterday object represented by the provided JSON
     */
    public static Yesterday fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Yesterday.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Yesterday object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Yesterday object represented by the provided JSON
     */
    public static Yesterday fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Yesterday.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final Yesterday.Category category;
    private final String count;
    private final String countUnit;
    private final String description;
    private final DateTime endDate;
    private final BigDecimal price;
    private final Currency priceUnit;
    private final DateTime startDate;
    private final Map<String, String> subresourceUris;
    private final String uri;
    private final String usage;
    private final String usageUnit;

    @JsonCreator
    private Yesterday(@JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("api_version")
                      final String apiVersion, 
                      @JsonProperty("category")
                      final Yesterday.Category category, 
                      @JsonProperty("count")
                      final String count, 
                      @JsonProperty("count_unit")
                      final String countUnit, 
                      @JsonProperty("description")
                      final String description, 
                      @JsonProperty("end_date")
                      final String endDate, 
                      @JsonProperty("price")
                      final BigDecimal price, 
                      @JsonProperty("price_unit")
                      @JsonDeserialize(using = com.twilio.sdk.converter.CurrencyDeserializer.class)
                      final Currency priceUnit, 
                      @JsonProperty("start_date")
                      final String startDate, 
                      @JsonProperty("subresource_uris")
                      final Map<String, String> subresourceUris, 
                      @JsonProperty("uri")
                      final String uri, 
                      @JsonProperty("usage")
                      final String usage, 
                      @JsonProperty("usage_unit")
                      final String usageUnit) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.category = category;
        this.count = count;
        this.countUnit = countUnit;
        this.description = description;
        this.endDate = DateConverter.iso8601DateTimeFromString(endDate);
        this.price = price;
        this.priceUnit = priceUnit;
        this.startDate = DateConverter.iso8601DateTimeFromString(startDate);
        this.subresourceUris = subresourceUris;
        this.uri = uri;
        this.usage = usage;
        this.usageUnit = usageUnit;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The api_version.
     * 
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The category.
     * 
     * @return The category
     */
    public final Yesterday.Category getCategory() {
        return this.category;
    }

    /**
     * Returns The The count.
     * 
     * @return The count
     */
    public final String getCount() {
        return this.count;
    }

    /**
     * Returns The The count_unit.
     * 
     * @return The count_unit
     */
    public final String getCountUnit() {
        return this.countUnit;
    }

    /**
     * Returns The The description.
     * 
     * @return The description
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     * Returns The The end_date.
     * 
     * @return The end_date
     */
    public final DateTime getEndDate() {
        return this.endDate;
    }

    /**
     * Returns The The price.
     * 
     * @return The price
     */
    public final BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Returns The The price_unit.
     * 
     * @return The price_unit
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The The start_date.
     * 
     * @return The start_date
     */
    public final DateTime getStartDate() {
        return this.startDate;
    }

    /**
     * Returns The The subresource_uris.
     * 
     * @return The subresource_uris
     */
    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    /**
     * Returns The The uri.
     * 
     * @return The uri
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The The usage.
     * 
     * @return The usage
     */
    public final String getUsage() {
        return this.usage;
    }

    /**
     * Returns The The usage_unit.
     * 
     * @return The usage_unit
     */
    public final String getUsageUnit() {
        return this.usageUnit;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Yesterday other = (Yesterday) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(category, other.category) && 
               Objects.equals(count, other.count) && 
               Objects.equals(countUnit, other.countUnit) && 
               Objects.equals(description, other.description) && 
               Objects.equals(endDate, other.endDate) && 
               Objects.equals(price, other.price) && 
               Objects.equals(priceUnit, other.priceUnit) && 
               Objects.equals(startDate, other.startDate) && 
               Objects.equals(subresourceUris, other.subresourceUris) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(usage, other.usage) && 
               Objects.equals(usageUnit, other.usageUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            category,
                            count,
                            countUnit,
                            description,
                            endDate,
                            price,
                            priceUnit,
                            startDate,
                            subresourceUris,
                            uri,
                            usage,
                            usageUnit);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("category", category)
                          .add("count", count)
                          .add("countUnit", countUnit)
                          .add("description", description)
                          .add("endDate", endDate)
                          .add("price", price)
                          .add("priceUnit", priceUnit)
                          .add("startDate", startDate)
                          .add("subresourceUris", subresourceUris)
                          .add("uri", uri)
                          .add("usage", usage)
                          .add("usageUnit", usageUnit)
                          .toString();
    }
}