/*
 * Copyright 2020 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.flyte.examples;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.service.AutoService;
import com.google.auto.value.AutoValue;
import org.flyte.flytekit.SdkBindingData;
import org.flyte.flytekit.SdkRunnableTask;
import org.flyte.flytekit.SdkTransform;
import org.flyte.flytekit.jackson.JacksonSdkType;

@AutoService(SdkRunnableTask.class)
public class SumTask extends SdkRunnableTask<SumTask.SumInput, SumTask.SumOutput> {
  public SumTask() {
    super(JacksonSdkType.of(SumInput.class), JacksonSdkType.of(SumOutput.class));
  }

  public static SdkTransform of(SdkBindingData a, SdkBindingData b) {
    return new SumTask().withInput("a", a).withInput("b", b);
  }

  @AutoValue
  public abstract static class SumInput {
    @JsonProperty
    public abstract long a();

    @JsonProperty
    public abstract long b();
  }

  @AutoValue
  public abstract static class SumOutput {
    @JsonProperty
    public abstract long c();

    public static SumOutput create(long c) {
      return new AutoValue_SumTask_SumOutput(c);
    }
  }

  @Override
  public SumOutput run(SumInput input) {
    return SumOutput.create(input.a() + input.b());
  }
}
