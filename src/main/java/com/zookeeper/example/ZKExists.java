package com.zookeeper.example;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * Created by nicholas.chi on 2017/11/17.
 */
public class ZKExists {

    private static ZooKeeper zk;
    private static ZooKeeperConnection conn;

    public static Stat znode_exists(String path) throws KeeperException, InterruptedException {
        return zk.exists(path,true);
    }

    public static void main(String[] args){
        String path = "/MyFirstZnode"; // Assign znode to the specified path

        try {
            conn = new ZooKeeperConnection();
            zk = conn.connect("13.124.227.66");
            Stat stat = znode_exists(path); // Stat checks the path of the znode

            if(stat != null) {
                System.out.println("Node exists and the node version is " +
                        stat.getVersion());
            } else {
                System.out.println("Node does not exists");
            }

        } catch(Exception e) {
            System.out.println(e.getMessage()); // Catches error messages
        }
    }

}
