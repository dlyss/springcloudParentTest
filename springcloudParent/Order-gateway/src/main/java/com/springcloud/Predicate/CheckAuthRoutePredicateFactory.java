package com.springcloud.Predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {
    public static final String PARAM_KEY = "param";
    public static final String REGEXP_KEY = "regexp";

    public CheckAuthRoutePredicateFactory() {
        super(CheckAuthRoutePredicateFactory.Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList("param", "regexp");
    }

    public Predicate<ServerWebExchange> apply(CheckAuthRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            public boolean test(ServerWebExchange exchange) {
                if (!StringUtils.hasText(config.regexp)) {
                    return exchange.getRequest().getQueryParams().containsKey(config.param);
                } else {
                    List<String> values = (List)exchange.getRequest().getQueryParams().get(config.param);
                    if (values == null) {
                        return false;
                    } else {
                        Iterator var3 = values.iterator();

                        String value;
                        do {
                            if (!var3.hasNext()) {
                                return false;
                            }

                            value = (String)var3.next();
                        } while(value == null || !value.matches(config.regexp));

                        return true;
                    }
                }
            }

            public String toString() {
                return String.format("Query: param=%s regexp=%s", config.getParam(), config.getRegexp());
            }
        };
    }

    @Validated
    public static class Config {
        @NotEmpty
        private String param;
        private String regexp;

        public Config() {
        }

        public String getParam() {
            return this.param;
        }

        public CheckAuthRoutePredicateFactory.Config setParam(String param) {
            this.param = param;
            return this;
        }

        public String getRegexp() {
            return this.regexp;
        }

        public CheckAuthRoutePredicateFactory.Config setRegexp(String regexp) {
            this.regexp = regexp;
            return this;
        }
    }
}
