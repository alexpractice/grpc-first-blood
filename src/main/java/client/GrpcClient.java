package client;

import com.alexpractice.grpcFirstBlood.AccountListResponse;
import com.alexpractice.grpcFirstBlood.AccountServiceGrpc;
import com.alexpractice.grpcFirstBlood.AddAccountRequest;
import com.alexpractice.grpcFirstBlood.EmptyModel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 1551)
                .usePlaintext()
                .build();

        AccountServiceGrpc.AccountServiceBlockingStub stub
                = AccountServiceGrpc.newBlockingStub(channel);

        AccountListResponse response1 = stub.list(EmptyModel.newBuilder().build());
        System.out.println(String.join(", ", response1.getAccountsList()));

        EmptyModel emptyModel = stub.add(AddAccountRequest.newBuilder()
                .setLogin("aLex")
                .build());

        AccountListResponse response2 = stub.list(EmptyModel.newBuilder().build());
        System.out.println(String.join(", ", response2.getAccountsList()));

        channel.shutdown();
    }
}
