package server;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import server.account.AccountServiceImpl;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server is starting...");
        Server server = ServerBuilder
                .forPort(1551)
                .addService(new AccountServiceImpl()).build();

        server.start();
        System.out.println("Server started...");
        server.awaitTermination();
    }
}
