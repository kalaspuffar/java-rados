package org.ea;

import com.ceph.rados.Rados;
import com.ceph.rados.exceptions.RadosException;

import java.io.File;

public class TestCephRados {
    public static void main(String[] args) {
        try {
            Rados cluster = new Rados("admin");
            System.out.println("Created cluster handle.");

            File f = new File("ceph.conf");
            cluster.confReadFile(f);
            System.out.println("Read the configuration file.");

            cluster.connect();
            System.out.println("Connected to the cluster.");

        } catch (RadosException e) {
            System.out.println(e.getMessage() + ": " + e.getReturnValue());
        }
    }
}
