/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
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

package ${groupId}.${rootArtifactId}.plugin.impl;

import ${groupId}.${rootArtifactId}.plugin.constants.DeviceTypeConstants;
import org.wso2.carbon.device.mgt.common.DeviceManagementException;
import org.wso2.carbon.device.mgt.common.DeviceManager;
import org.wso2.carbon.device.mgt.common.DeviceStatusTaskPluginConfig;
import org.wso2.carbon.device.mgt.common.InitialOperationConfig;
import org.wso2.carbon.device.mgt.common.OperationMonitoringTaskConfig;
import org.wso2.carbon.device.mgt.common.ProvisioningConfig;
import org.wso2.carbon.device.mgt.common.app.mgt.ApplicationManager;
import org.wso2.carbon.device.mgt.common.policy.mgt.PolicyMonitoringManager;
import org.wso2.carbon.device.mgt.common.pull.notification.PullNotificationSubscriber;
import org.wso2.carbon.device.mgt.common.push.notification.PushNotificationConfig;
import org.wso2.carbon.device.mgt.common.spi.DeviceManagementService;
import java.util.HashMap;
import java.util.Map;

/**
 * This represents the ${rootArtifactId} implementation of DeviceTypeManagerService
 */
public class DeviceTypeManagerService implements DeviceManagementService {
    private DeviceManager deviceManager;
    private OperationMonitoringTaskConfig operationMonitoringTaskConfig;

    @Override
    public String getType() {
        return DeviceTypeConstants.DEVICE_TYPE;
    }

    @Override
    public void init() throws DeviceManagementException {
        this.deviceManager = new DeviceTypeManager();
        this.operationMonitoringTaskConfig = new OperationMonitoringTaskConfig();
    }

    @Override
    public DeviceManager getDeviceManager() {
        return deviceManager;
    }

    @Override
    public ApplicationManager getApplicationManager() {
        return null;
    }

    @Override
    public ProvisioningConfig getProvisioningConfig() {
        return new ProvisioningConfig(DeviceTypeConstants.DEVICE_TYPE_PROVIDER_DOMAIN, false);
    }

    @Override
    public OperationMonitoringTaskConfig getOperationMonitoringConfig() {
        return operationMonitoringTaskConfig;
    }

    @Override
    public PushNotificationConfig getPushNotificationConfig() {

        Map<String, String> properties = new HashMap<>();
        properties.put("mqttAdapterName", "${rootArtifactId}_mqtt");
        properties.put("username", "admin");
        properties.put("password", "admin");
        properties.put("qos", "0");
        properties.put("clearSession", "true");
        properties.put("scopes", "");
        return new PushNotificationConfig("MQTT",false, properties);
    }

    @Override
    public PolicyMonitoringManager getPolicyMonitoringManager() {
        return null;
    }

    @Override
    public InitialOperationConfig getInitialOperationConfig() {
        return null;
    }

    @Override
    public PullNotificationSubscriber getPullNotificationSubscriber() {
        return null;
    }

    @Override
    public DeviceStatusTaskPluginConfig getDeviceStatusTaskPluginConfig() {
        return null;
    }


}
