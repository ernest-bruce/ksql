/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License; you may not use this file
 * except in compliance with the License.  You may obtain a copy of the License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.version.metrics.collector;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import io.confluent.support.metrics.validate.KSqlValidModuleType;
import io.confluent.support.metrics.validate.MetricsValidation;
import java.util.Arrays;
import org.junit.Test;

public class KsqlModuleTypeTest {

  /**
   * If you make changes to the {@link KsqlModuleType} enum then you will likely need to make
   * changes to the {@link KSqlValidModuleType} enum in support-metrics-common.
   *
   * <p>The former enum contains the current list of valid module types, while the latter contains the
   * complete list of valid module types that have ever been valid.
   */
  @Test
  public void shouldBeValidModuleType() {
    Arrays.stream(KsqlModuleType.values())
        .map(Object::toString).forEach(
        type -> assertThat(type, MetricsValidation.isValidKsqlModuleType(type), is(true))
    );
  }
}