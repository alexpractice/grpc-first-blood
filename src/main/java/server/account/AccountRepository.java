package server.account;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountRepository {
    private static final Set<String> accounts;

    static {
        accounts = new HashSet<>();
        accounts.add("root");
        accounts.add("vasya");
        accounts.add("kolya");
        accounts.add("vova");
    }

    public static void addAccount(String name) {
        String lowerName = name.toLowerCase();
        if (accounts.contains(lowerName)) {
            throw new AccountExistsException();
        }
        accounts.add(lowerName);
    }

    public static List<String> getAccounts() {
        return new ArrayList<>(accounts);
    }
}
