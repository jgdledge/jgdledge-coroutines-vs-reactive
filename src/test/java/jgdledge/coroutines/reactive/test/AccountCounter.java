package jgdledge.coroutines.reactive.test;

import io.micronaut.context.annotation.Requires;
import jakarta.inject.Inject;
import jgdledge.coroutines.reactive.data.repository.AccountRepositoryReactive;

@Requires(env = {"tc"})
public class AccountCounter {
    @Inject
    private AccountRepositoryReactive accountRepository;

    public int getNumAccounts(){
        return accountRepository.findAll().collectList().block().size();
    }
}
