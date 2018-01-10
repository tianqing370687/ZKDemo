package com.zookeeper.example;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by nicholas.chi on 2017/11/17.
 */
public class ZKCreate {

    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    public static void create(String path,byte[] data) throws KeeperException, InterruptedException {
        zk.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static void main(String[] args){

        String path = "/MyFirstZnode"; // Assign path to znode
        byte[] data = "My first zookeeper app".getBytes();

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("13.124.227.66");
            create(path,data);
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

        System.out.print("end");
    }

}
