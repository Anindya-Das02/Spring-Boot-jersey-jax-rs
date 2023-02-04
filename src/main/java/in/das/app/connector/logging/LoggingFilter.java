package in.das.app.connector.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class LoggingFilter implements ExchangeFilterFunction {
    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        String url = request.url().toString();
        Map<String,String> requestHeaders = new HashMap<>();
        request.headers().forEach((k,v) -> requestHeaders.put(k,v.get(0)));
        log.info("Request url={} headers={} body={}", request.url(), requestHeaders, request.body());
        Instant requestSendTime = Instant.now();
        return next.exchange(request)
                .doOnSuccess(clientResponse -> {
                    Map<String,String> responseHeaders = new HashMap<>();
                    clientResponse.headers().asHttpHeaders().forEach((k,v) -> responseHeaders.put(k,v.get(0)));
                    long timeTaken = Duration.between(requestSendTime, Instant.now()).toMillis();
                    clientResponse.bodyToMono(String.class);
                    log.info("Response from url=\"{}\" status=\"{}\" headers=\"{}\" timeTaken=\"{} ms\"", url,clientResponse.statusCode(), responseHeaders, timeTaken);
                })
                .doOnError(response -> {
                    long timeTaken = Duration.between(requestSendTime, Instant.now()).toMillis();
                    log.error("[ERROR] An error occurred while invoking url=\"{}\" message=\"{}\" timeTaken=\"{} ms\"", url,response.getMessage(),timeTaken);
                });
    }
}