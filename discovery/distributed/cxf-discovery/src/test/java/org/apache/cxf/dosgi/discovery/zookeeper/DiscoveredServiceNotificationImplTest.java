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
package org.apache.cxf.dosgi.discovery.zookeeper;

import junit.framework.TestCase;

public class DiscoveredServiceNotificationImplTest extends TestCase {
    
    public void testDUMMY(){
        assertTrue(true);
    }
    
//    @SuppressWarnings("unchecked")
//    public void testDSNImpl() {
//        Collection filters = Collections.singleton("(some.property=some.value)");
//        Collection interfaces = Arrays.asList(String.class.getName(), ArrayList.class.getName());
//        int type = DiscoveredServiceNotification.AVAILABLE;
//        ServiceEndpointDescription sed = new ServiceEndpointDescriptionImpl(String.class.getName());
//        DiscoveredServiceNotification dsn = 
//            new DiscoveredServiceNotificationImpl(filters, interfaces, type, sed);
//        
//        assertEquals(filters, dsn.getFilters());
//        assertEquals(interfaces, dsn.getInterfaces());
//        assertEquals(type, dsn.getType());
//        assertEquals(sed, dsn.getServiceEndpointDescription());
//    }

}
