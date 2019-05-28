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
package org.apache.cxf.dosgi.dsw.decorator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator implements BundleActivator {
    private static final Logger LOG = LoggerFactory.getLogger(Activator.class);
    private ServiceDecoratorBundleListener bundleListener;

    @Override
    public void start(BundleContext context) {
        ServiceDecoratorImpl serviceDecorator = new ServiceDecoratorImpl();
        bundleListener = new ServiceDecoratorBundleListener(serviceDecorator);
        context.addBundleListener(bundleListener);
        context.registerService(ServiceDecorator.class.getName(), serviceDecorator, null);
    }

    @Override
    public void stop(BundleContext context) {
        LOG.debug("RemoteServiceAdmin Implementation is shutting down now");
        if (bundleListener != null) {
            context.removeBundleListener(bundleListener);
            bundleListener = null;
        }
    }

}
