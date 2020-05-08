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
package org.flyte.api.v1;

import com.google.auto.value.AutoValue;
import java.util.List;

/**
 * Structure that encapsulates task, branch and subworkflow nodes to form a statically analyzable,
 * directed acyclic graph.
 */
@AutoValue
public abstract class WorkflowTemplate {

  public abstract List<Node> nodes();

  public abstract WorkflowMetadata metadata();

  public static Builder builder() {
    return new AutoValue_WorkflowTemplate.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder nodes(List<Node> nodes);

    public abstract Builder metadata(WorkflowMetadata metadata);

    public abstract WorkflowTemplate build();
  }
}
