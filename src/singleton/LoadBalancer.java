package singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    private static LoadBalancer instance = null;
    private List serverList = null;

    private LoadBalancer() {
        serverList = new ArrayList();
    }

    public static LoadBalancer getLoadBalancer() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    public void addServer(String server) {
        serverList.add(server);
    }

    public void removeServer(String server) {
        serverList.remove(server);
    }

    public String getRandomServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String)serverList.get(i);
    }
}

class Client {
    public static void main(String[] args) {
        LoadBalancer balancer1, balancer2, balancer3, balancer4;
        balancer1 = LoadBalancer.getLoadBalancer();
        balancer2 = LoadBalancer.getLoadBalancer();
        balancer3 = LoadBalancer.getLoadBalancer();
        balancer4 = LoadBalancer.getLoadBalancer();

        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4) {
            System.out.println("LoadBalancer instance is unique.");
        }

        balancer1.addServer("Server 1");
        balancer1.addServer("Server 2");
        balancer2.addServer("Server 3");
        balancer4.addServer("Server 4");

        for (int i = 0; i < 10; i++) {
            String server = balancer1.getRandomServer();
            System.out.println("Request is dispatched to server: " + server);
        }
    }
}
