///
/// This Source Code Form is subject to the terms of the Mozilla Public
/// License, v. 2.0. If a copy of the MPL was not distributed with this
/// file, You can obtain one at http://mozilla.org/MPL/2.0/.
///
package org.mifos.commons.oas.imperative.sdk.fineract.starter;

import lombok.extern.slf4j.Slf4j;
import org.mifos.commons.oas.imperative.rest.sdk.fineract.core.FineractRestSdkProperties;
import org.mifos.commons.oas.imperative.rest.sdk.fineract.implementation.config.HttpInterfacesAbstractConfigurator;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Slf4j
@Configuration
final class FineractRestSdkConfiguration extends HttpInterfacesAbstractConfigurator {
    public FineractRestSdkConfiguration(FineractRestSdkProperties properties, RestClient.Builder builder) {
        super(builder.requestInterceptor((request, body, execution) -> {
                    request.getHeaders().setBearerAuth(properties.token());
                    return execution.execute(request, body);
                })
                .baseUrl(properties.url())
                .build());
    }
}
