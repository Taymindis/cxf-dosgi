/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.dosgi.samples.rest.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.dosgi.common.api.IntentsProvider;
import org.apache.cxf.dosgi.samples.rest.Task;
import org.apache.cxf.dosgi.samples.rest.TaskResource;
import org.osgi.service.component.annotations.Component;

@Component//
(//
    immediate = true, //
    name = "TaskResource", //
    property = //
    { //
      "service.exported.interfaces=*", //
      "service.exported.configs=org.apache.cxf.rs", //
      //"service.exported.intents=jackson", // Only needed when defining jackson as external intent
      "org.apache.cxf.rs.address=/tasks", //
      // By default CXF will favor the default json provider
      "cxf.bus.prop.skip.default.json.provider.registration=true"
    } //
)
public class TaskResourceImpl implements TaskResource, IntentsProvider {
    Map<Integer, Task> taskMap;

    public TaskResourceImpl() {
        taskMap = new HashMap<Integer, Task>();
        Task task = new Task();
        task.setId(1);
        task.setTitle("Buy some coffee");
        task.setDescription("Take the extra strong");
        addOrUpdate(task);
        task = new Task();
        task.setId(2);
        task.setTitle("Finish DOSGi example");
        task.setDescription("");
        addOrUpdate(task);
    }

    @Override
    public Task get(Integer id) {
        return taskMap.get(id);
    }

    @Override
    public void addOrUpdate(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public Task[] getAll() {
        return taskMap.values().toArray(new Task[]{});
    }

    @Override
    public void delete(Integer id) {
        taskMap.remove(id);
    }

    @Override
    public List<?> getIntents() {
        return Arrays.asList(new JacksonJaxbJsonProvider());
    }

}
