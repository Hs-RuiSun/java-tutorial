package com.ruby.sun.jclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String URL_REGEX = "\"url\":\"(.*?)\"";
    public static final String TIME_REGEX = "\"receiveHeadersEnd\":[0-9]*.?[0-9]+";
    public static void main(String[] args) {
        String message = "{\"message\":{\"method\":\"Network.responseReceived\",\"params\":{\"frameId\":\"FEA6ACBA90707728C6F1C96511B674A6\",\"loaderId\":\"C747846D4EC97731A81EC0E8AC0CC655\",\"requestId\":\"1000001784.69\",\"response\":{\"connectionId\":139,\"connectionReused\":true,\"encodedDataLength\":262,\"fromDiskCache\":false,\"fromServiceWorker\":false,\"headers\":{\"Cache-Control\":\"max-age=3, public\",\"Content-Type\":\"application/json;charset=UTF-8\",\"Date\":\"Wed, 29 Aug 2018 18:30:47 GMT\",\"Transfer-Encoding\":\"chunked\",\"X-Application-Context\":\"AirFlight:demo:8080\",\"X-Content-Type-Options\":\"nosniff\",\"X-Frame-Options\":\"DENY\"},\"headersText\":\"HTTP/1.1 200\\r\\nX-Content-Type-Options: nosniff\\r\\nX-Frame-Options: DENY\\r\\nX-Application-Context: AirFlight:demo:8080\\r\\nCache-Control: max-age=3, public\\r\\nContent-Type: application/json;charset=UTF-8\\r\\nTransfer-Encoding: chunked\\r\\nDate: Wed, 29 Aug 2018 18:30:47 GMT\\r\\n\\r\\n\",\"mimeType\":\"application/json\",\"protocol\":\"http/1.1\",\"remoteIPAddress\":\"192.168.1.138\",\"remotePort\":2020,\"requestHeaders\":{\"Accept\":\"*/*\",\"Accept-Encoding\":\"gzip, deflate\",\"Accept-Language\":\"en-GB,en-US;q=0.9,en;q=0.8\",\"Connection\":\"keep-alive\",\"Cookie\":\"SHSESSIONID=2021849C25B3913D733B0B7A4A1F2829\",\"Host\":\"192.168.1.138:2020\",\"Referer\":\"http://192.168.1.138:2020/\",\"User-Agent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\"},\"requestHeadersText\":\"GET /v1/customer/4/aircraft-flight? HTTP/1.1\\r\\nHost: 192.168.1.138:2020\\r\\nConnection: keep-alive\\r\\nUser-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\\r\\nAccept: */*\\r\\nReferer: http://192.168.1.138:2020/\\r\\nAccept-Encoding: gzip, deflate\\r\\nAccept-Language: en-GB,en-US;q=0.9,en;q=0.8\\r\\nCookie: SHSESSIONID=2021849C25B3913D733B0B7A4A1F2829\\r\\n\",\"securityState\":\"neutral\",\"status\":200,\"statusText\":\"\",\"timing\":{\"connectEnd\":-1,\"connectStart\":-1,\"dnsEnd\":-1,\"dnsStart\":-1,\"proxyEnd\":2.9,\"proxyStart\":0.651,\"pushEnd\":0,\"pushStart\":0,\"receiveHeadersEnd\":20.433,\"requestTime\":629121.753514,\"sendEnd\":3.257,\"sendStart\":3.095,\"sslEnd\":-1,\"sslStart\":-1,\"workerReady\":-1,\"workerStart\":-1},\"url\":\"http://192.168.1.138:2020/v1/customer/4/aircraft-flight?\"},\"timestamp\":629121.774452,\"type\":\"Fetch\"}},\"webview\":\"FEA6ACBA90707728C6F1C96511B674A6\"}";
        System.out.println(extractStringUsingRegex(message, URL_REGEX));
        System.out.println(extractStringUsingRegex(message, TIME_REGEX));
    }
    
    public static String extractStringUsingRegex(String json, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(json);
        String matchedString = null;
        if(matcher.find()) {
            matchedString = matcher.group();
        }
        return matchedString;
    }
}
