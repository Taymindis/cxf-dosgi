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
package org.apache.cxf.dosgi.samples.rest.client;

import org.apache.cxf.dosgi.samples.rest.Task;
import org.apache.cxf.dosgi.samples.rest.TaskResource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component//
(//
    service = TaskResourceCommand.class,
    property = //
    {
     "osgi.command.scope=task", //
     "osgi.command.function=list", //
     "osgi.command.function=add", //
     "osgi.command.function=delete"
    }//
)
public class TaskResourceCommand {

    private TaskResource taskService;

    public void list() {
        System.out.println("Open tasks:");
        Task[] tasks = taskService.getAll();
        for (Task task : tasks) {
            String line = String.format("%d %s", task.getId(), task.getTitle());
            System.out.println(line);
        }
    }

    public void add(Integer id, String title) {
        Task task = new Task(id, title, "");
        taskService.add(task);
    }

    public void delete(Integer id) {
        taskService.delete(id);
    }

    @Reference
    public void setTaskService(TaskResource taskService) {
        this.taskService = taskService;
    }
}
