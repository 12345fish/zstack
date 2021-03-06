package org.zstack.header.storage.primary;

import org.zstack.header.message.APIEvent;

/**
 *@apiResult
 *
 * api event for message :ref:`APIChangePrimaryStorageStateMsg`
 *
 *@since 0.1.0
 *
 *@example
 *
 * {
"org.zstack.header.storage.primary.APIChangePrimaryStorageStateEvent": {
"inventory": {
"uuid": "e330607585a54a99a0dd7c1351e3ae73",
"zoneUuid": "1a1659a5c1e848eb89598dacc09e6330",
"name": "SimulatorPrimaryStorage-0",
"url": "nfs://simulator/primary/-0",
"description": "Test Primary Storage",
"totalCapacity": 10995116277760,
"availableCapacity": 10995116277760,
"type": "SimulatorPrimaryStorage",
"state": "Enabled",
"mountPath": "/primarystoragesimulator/e330607585a54a99a0dd7c1351e3ae73",
"createDate": "May 1, 2014 2:30:12 PM",
"lastOpDate": "May 1, 2014 2:30:12 PM",
"attachedClusterUuids": []
},
"success": true
}
}
 */
public class APIChangePrimaryStorageStateEvent extends APIEvent {
    /**
     * @desc
     *
     * see :ref:`PrimaryStorageInventory`
     */
	private PrimaryStorageInventory inventory;
	
	public APIChangePrimaryStorageStateEvent(String apiId) {
	    super(apiId);
    }

	public APIChangePrimaryStorageStateEvent() {
		super(null);
	}

	public PrimaryStorageInventory getInventory() {
    	return inventory;
    }

	public void setInventory(PrimaryStorageInventory inventory) {
    	this.inventory = inventory;
    }
}
