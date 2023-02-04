package in.das.app.connector.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class WebClientLoggingFilter  {

    public ExchangeFilterFunction logRequest(){
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            var method = clientRequest.method().toString();
            var url = clientRequest.url().toString();
            var body = clientRequest.body().toString();
            var headers = clientRequest.headers().toString();
            log.info("Sending Request to method=\"{}\" url=\"{}\" headers=\"{}\" request-payload=\"{}\"", method, url, headers, body);
            return Mono.just(clientRequest);
        });
    }

    public ExchangeFilterFunction logResponse(){
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            var statusCode = clientResponse.statusCode().toString();
            var headers = clientResponse.headers().toString();
            log.info("Response status={} headers={}",statusCode,headers);
            return Mono.just(clientResponse);
        });
    }
}
