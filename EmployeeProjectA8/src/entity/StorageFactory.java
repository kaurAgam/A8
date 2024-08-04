package entity;

import service.*;

public class StorageFactory {
    public static Storage getStorage(int code) {
        switch (code) {
            case 1:
                return new StorageFileImpl();  // Original implementation
            case 2:
                return new StorageListImpl();  // Using ArrayList
            case 3:
                return new StorageSortedImpl();  // Using TreeSet
            default:
                return new StorageMapImpl();  // Using HashMap
        }
    }
}
