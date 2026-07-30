///
/// This Source Code Form is subject to the terms of the Mozilla Public
/// License, v. 2.0. If a copy of the MPL was not distributed with this
/// file, You can obtain one at http://mozilla.org/MPL/2.0/.
///
package org.mifos.commons.oas.imperative.sdk.fineract.implementation.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mifos.commons.oas.imperative.rest.sdk.fineract.core.FineractRestSdkProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Slf4j
@RequiredArgsConstructor
@Configuration
class FineractRestSdkConfiguration {
    private final FineractRestSdkProperties properties;

    @Bean
    RestClient fineractRestClient(RestClient.Builder builder) {
        return builder.requestInterceptor((request, body, execution) -> {
                    request.getHeaders().setBearerAuth(properties.getToken());
                    return execution.execute(request, body);
                })
                .build();
    }
}
