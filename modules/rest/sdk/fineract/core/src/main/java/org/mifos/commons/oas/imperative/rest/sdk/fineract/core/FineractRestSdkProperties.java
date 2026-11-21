///
/// This Source Code Form is subject to the terms of the Mozilla Public
/// License, v. 2.0. If a copy of the MPL was not distributed with this
/// file, You can obtain one at http://mozilla.org/MPL/2.0/.
///
package org.mifos.commons.oas.imperative.rest.sdk.fineract.core;

import static org.mifos.commons.oas.imperative.rest.sdk.fineract.core.FineractRestSdkConstants.MIFOS_COMMONS_OAS_IMPERATIVE_SDK_FINERACT_PROPERTIES_PREFIX;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = MIFOS_COMMONS_OAS_IMPERATIVE_SDK_FINERACT_PROPERTIES_PREFIX)
public record FineractRestSdkProperties(Boolean enabled, String url, String username, String password, String token) {}
