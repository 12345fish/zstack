package org.zstack.test.tag;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.zstack.core.cloudbus.CloudBus;
import org.zstack.core.componentloader.ComponentLoader;
import org.zstack.core.db.DatabaseFacade;
import org.zstack.header.query.QueryOp;
import org.zstack.header.tag.*;
import org.zstack.header.zone.APIQueryZoneMsg;
import org.zstack.header.zone.APIQueryZoneReply;
import org.zstack.header.zone.ZoneInventory;
import org.zstack.header.zone.ZoneVO;
import org.zstack.tag.SystemTag;
import org.zstack.tag.TagSubQueryExtension;
import org.zstack.test.Api;
import org.zstack.test.ApiSenderException;
import org.zstack.test.DBUtil;
import org.zstack.test.deployer.Deployer;

import java.util.List;

/**
 * test lifecycle listener
 */
public class TestSystemTag2 {
    Deployer deployer;
    Api api;
    ComponentLoader loader;
    CloudBus bus;
    DatabaseFacade dbf;
    boolean deleteCalled = false;
    boolean createCalled = false;

    @TagDefinition
    public static class TestSystemTags {
        public static SystemTag big = new SystemTag("big", ZoneVO.class);
    }

    @Before
    public void setUp() throws Exception {
        DBUtil.reDeployDB();
        deployer = new Deployer("deployerXml/tag/TestUserTag.xml");
        deployer.build();
        api = deployer.getApi();
        loader = deployer.getComponentLoader();
        bus = loader.getComponent(CloudBus.class);
        dbf = loader.getComponent(DatabaseFacade.class);
    }

    @Test
    public void test() throws ApiSenderException {
        TestSystemTags.big.installLifeCycleListener(new SystemTagLifeCycleListener() {
            @Override
            public void tagCreated(SystemTagInventory tag) {
                if (tag.getTag().equals(TestSystemTags.big.getTagFormat())) {
                    createCalled = true;
                }
            }

            @Override
            public void tagDeleted(SystemTagInventory tag) {
                if (tag.getTag().equals(TestSystemTags.big.getTagFormat())) {
                    deleteCalled = true;
                }
            }

            @Override
            public void tagUpdated(SystemTagInventory old, SystemTagInventory newTag) {

            }
        });
        ZoneInventory zone1 = deployer.zones.get("Zone1");
        TagInventory inv =  api.createSystemTag(zone1.getUuid(), "big", ZoneVO.class);

        api.deleteTag(inv.getUuid());

        SystemTagVO tvo = dbf.findByUuid(inv.getUuid(), SystemTagVO.class);
        Assert.assertNull(tvo);

        Assert.assertTrue(createCalled);
        Assert.assertTrue(deleteCalled);
    }
}
