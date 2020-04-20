package server.account;

import com.alexpractice.grpcFirstBlood.AccountListResponse;
import com.alexpractice.grpcFirstBlood.AccountServiceGrpc;
import com.alexpractice.grpcFirstBlood.AddAccountRequest;
import com.alexpractice.grpcFirstBlood.EmptyModel;
import io.grpc.stub.StreamObserver;

public class AccountServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {
    @Override
    public void add(AddAccountRequest request, StreamObserver<EmptyModel> responseObserver) {
        AccountRepository.addAccount(request.getLogin());
        responseObserver.onNext(EmptyModel.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void list(EmptyModel request, StreamObserver<AccountListResponse> responseObserver) {
        AccountListResponse response = AccountListResponse.newBuilder()
                .addAllAccounts(AccountRepository.getAccounts()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
