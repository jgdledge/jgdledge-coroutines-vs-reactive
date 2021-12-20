package jgdledge.coroutines.reactive.data.repository;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import jgdledge.coroutines.reactive.data.entity.Account;
import jgdledge.coroutines.reactive.test.AccountCounter;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@MicronautTest(environments = {"tc"})
public class AccountRepositoryReactiveTest {
    private final int BATCH_SIZE = 100;

    @Inject
    private AccountRepositoryReactive accountRepository;

    @Inject
    private AccountCounter accountCounter;



    @Test
    public void testItWorks(){
        UUID id = UUID.randomUUID();
        assertNull(accountRepository.findById(id).block());
        accountRepository.save(new Account(id, "Jacob", "Ledgerwood", "jacob@bunch.live")).block();
        assertNotNull(accountRepository.findById(id).block());
    }

    /* Reactor (avg = 9.3782168s)
    9.874485s
    8.848389s
    10.812232s
    8.201291s
    9.719242s
    8.695582s
    10.002803s
    8.508437s
    10.25811s
    8.861597s
     */
    @Test
    @Ignore
    public void testCreate5000AccountsReactiveStaticBatched(){
        int numAccounts = 5000;
        testLargeNumberBatched(numAccounts);
        assertEquals(numAccounts, accountCounter.getNumAccounts());
    }


    private void testLargeNumberBatched(int numAccounts) {
        Instant start = Instant.now();
        int numCreated = 0;
        while(numCreated < numAccounts){
            int toCreate = Math.min(BATCH_SIZE, numAccounts - numCreated);
            testLargeNumberBatch(toCreate);
            numCreated += toCreate;
        }
        Instant end = Instant.now();

        Duration timeBetween = Duration.between(start, end);
        System.out.println("Java project reactor runtime: " + timeBetween.toString());
    }

    private void testLargeNumberBatch(int numAccounts){
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < numAccounts; i++){
            nums.add(i);
        }
        Flux.fromIterable(nums)
                .flatMap(num -> Mono.just(UUID.randomUUID()))
                .flatMap(id -> accountRepository.save(new Account(id, "Jacob", "Ledgerwood", "jacob@bunch.live")))
                .collectList()
                .block();
    }
}
