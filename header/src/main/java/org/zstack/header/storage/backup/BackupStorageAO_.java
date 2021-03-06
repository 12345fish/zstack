package org.zstack.header.storage.backup;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import java.util.Date;

@StaticMetamodel(BackupStorageAO.class)
public class BackupStorageAO_ {
	public static volatile SingularAttribute<BackupStorageAO, String> uuid;
	public static volatile SingularAttribute<BackupStorageAO, String> description;
	public static volatile SingularAttribute<BackupStorageAO, String> name;
	public static volatile SingularAttribute<BackupStorageAO, String> url;
	public static volatile SingularAttribute<BackupStorageAO, String> type;
	public static volatile SingularAttribute<BackupStorageAO, Long> totalCapacity;
	public static volatile SingularAttribute<BackupStorageAO, Long> availableCapacity;
	public static volatile SingularAttribute<BackupStorageAO, BackupStorageState> state;
	public static volatile SingularAttribute<BackupStorageAO, BackupStorageStatus> status;
	public static volatile SingularAttribute<BackupStorageAO, Timestamp> createDate;
	public static volatile SingularAttribute<BackupStorageAO, Timestamp> lastOpDate;
}
