package org.zstack.header.storage.primary;

import org.zstack.header.message.APIDeleteMessage;
import org.zstack.header.message.APIParam;

/**
 * @api
 *
 * delete a primary storage
 *
 * @since 0.1.0
 *
 * @cli
 *
 * @httpMsg
 *{
"org.zstack.header.storage.primary.APIDeletePrimaryStorageMsg": {
"uuid": "cf8221cc94594739af786e6122bc9241",
"deleteMode": "Permissive",
"session": {
"uuid": "21ca99bb5b5b46f0a7d31271feb3ecbb"
}
}
}
 * @msg
 *{
"org.zstack.header.storage.primary.APIDeletePrimaryStorageMsg": {
"uuid": "cf8221cc94594739af786e6122bc9241",
"deleteMode": "Permissive",
"session": {
"uuid": "21ca99bb5b5b46f0a7d31271feb3ecbb"
},
"timeout": 1800000,
"id": "5f7169effde44928b1f0c06e54fad3b0",
"serviceId": "api.portal"
}
}
 * @result
 *
 * see :ref:`APIDetachPrimaryStorageEvent`
 */
public class APIDeletePrimaryStorageMsg extends APIDeleteMessage implements PrimaryStorageMessage {
    /**
     * @desc
     * primary storage uuid
     */
	@APIParam
	private String uuid;

	public APIDeletePrimaryStorageMsg() {
	}
	
	public APIDeletePrimaryStorageMsg(String uuid) {
		this.uuid = uuid;
	}
    @Override
    public String getPrimaryStorageUuid() {
        return getUuid();
    }
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
